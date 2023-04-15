import { ERR_EXISTED_USER, UserController } from "database";
import { WebsocketRouter } from "../utils/type";
import z from "zod";
import { getAPIG } from "../APIGateway";
import { ERR_BAD_REQUEST } from "../utils/ErrorMessages";
import { connectionAuthorizedMessage } from "../utils/WebsocketReponses";
import { authEvent } from "../events/authEvent";

const bodyValdiation = z.object({
  username: z.string(),
});

/**
 *
 * @description Authenticate the connection and make a new user document
 *
 * @param event
 * @param context
 * @returns
 */
export const authRouter: WebsocketRouter = async (event, context) => {
  const { send, connectionId } = getAPIG(event, context);

  const json = JSON.parse(event.body!);

  if (bodyValdiation.safeParse(json).success === false) {
    return await send({
      status: "REQUEST_ERROR",
      error: ERR_BAD_REQUEST,
    });
  }

  const body = bodyValdiation.parse(json);

  const { username } = body;

  return await authEvent(event, context, { username });
};