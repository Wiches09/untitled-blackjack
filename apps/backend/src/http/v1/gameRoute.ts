import { GameController, UserController } from "database";
import {
  ERR_EXISTED_GAME,
  ERR_ILLEGAL_OPERATION,
  ERR_INVALID_CONNECTION_ID,
  ERR_INVALID_PASSCODE,
} from "database/src/utils/Error";
import { FastifyInstance } from "fastify";
import {
  ERR_BAD_REQUEST,
  ERR_GAME_FULL,
} from "../../websocket/utils/ErrorMessages";

const gameRouter = (app: FastifyInstance, prefix: string) => {
  return app.register(
    function (api, opts, done) {
      /**
       * Initialize a new game instance
       * The user creating the game must be authorized
       */
      api.post<{
        Body: { connectionId: string; passcode: string };
      }>("/create", async (request, reply) => {
        const { connectionId, passcode } = request.body;
        const [user, isError] = await UserController.getUserMeta({
          connectionId,
        });

        if (isError) {
          return reply.status(500).send(isError);
        } else if (!passcode) {
          return reply.status(400).send(ERR_INVALID_PASSCODE);
        } else {
          // Check if there is already an active game with the same passcode or user inside
          const [existGame] = await GameController.getGame({
            passcode,
            players: [user.id],
          });

          if (existGame) {
            return reply.status(400).send(ERR_EXISTED_GAME);
          }

          // Create the game
          const [game, error] = await GameController.createGame(
            [user._id],
            passcode
          );

          if (error) {
            reply.status(500).send(error);
          }

          return game;
        }
      });

      /**
       * Check does the game exist
       */
      api.get<{
        Params: {
          passcode: string;
        };
      }>("/check/:passcode", async (request, reply) => {
        const { passcode } = request.params;
        const [game, err] = await GameController.getGame({ passcode });
        if (err) {
          return reply.status(500).send(err);
        }
        // Send the game back
        return game;
      });

      /**
       * Join the game
       */
      api.post<{
        Body: { passcode: string; connectionId: string; gameId: string };
      }>("/join", async (request, reply) => {
        const { connectionId, passcode } = request.body;

        if (!connectionId)
          return reply.status(400).send(ERR_INVALID_CONNECTION_ID);

        const [user, isError] = await UserController.getUserMeta({
          connectionId,
        });

        if (isError) {
          return reply.status(500).send(isError);
        } else if (!passcode) {
          return reply.status(400).send(ERR_INVALID_PASSCODE);
        } else {
          const [existGame, err] = await GameController.getGame({ passcode });

          if (err) {
            return reply.status(500).send(err);
          }

          if (existGame?.players.find((p) => p.username === user.username))
            return reply.status(400).send(ERR_ILLEGAL_OPERATION);

          // Check if the game is full or already active?
          if (
            existGame.players.length >= 2 ||
            existGame.gameState !== "notStarted"
          ) {
            return reply.status(400).send(ERR_GAME_FULL);
          }

          // Join the game
          const [game, error] = await GameController.joinGame(
            existGame.id,
            user._id
          );

          if (error) {
            reply.status(500).send(error);
          }

          // Send the game back
          return game;
        }
      });

      /**
       * Leave the game
       */
      api.post<{
        Body: { connectionId: string; gameId: string };
      }>("/leave", async (request, reply) => {
        const { connectionId, gameId } = request.body;

        if (!connectionId)
          return reply.status(400).send(ERR_INVALID_CONNECTION_ID);

        const [user, isError] = await UserController.getUserMeta({
          connectionId,
        });

        if (isError) {
          return reply.status(500).send(isError);
        } else if (!gameId) {
          return reply.status(400).send(ERR_BAD_REQUEST);
        }

        const [existGame, err] = await GameController.getGame({ gameId });

        if (err) return reply.status(500).send(err);

        // Check if the user is in the game
        if (!existGame.players.find((p) => p.username === user.username)) {
          return reply.status(400).send(ERR_ILLEGAL_OPERATION);
        }

        // Leave the game
        const [game, error] = await GameController.leaveGame(
          connectionId,
          gameId
        );

        if (error) {
          reply.status(500).send(error);
        }

        return game;
      });

      done();
    },

    { prefix }
  );
};

export { gameRouter };