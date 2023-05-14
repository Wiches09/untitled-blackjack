package UI.PH_Gameplay.Display;

import Main.MainRunner;
import UI.Controller.UIController;
import lombok.Getter;

public class GamePlayController {
    private UIController uiController;
    @Getter
    private GamePlayDisplayGUI ui = new GamePlayDisplayGUI(this);

    public GamePlayController(UIController uiController){
        this.uiController = uiController;
    }
    //    update status Button
    public void updateStatusButton(){

        if (MainRunner.getGameContext().getPlayers()[1].getPlayer().getUsername().equals(MainRunner.getGameContext().getGame().getGame().getTurnOwner())) {
            ui.getHitButtonPlayerOne().setEnabled(false);
            ui.getStandButtonPlayerOne().setEnabled(false);
        } else if (MainRunner.getGameContext().getPlayers()[0].getPlayer().getUsername().equals(MainRunner.getGameContext().getGame().getGame().getTurnOwner())){
            ui.getHitButtonPlayerOne().setEnabled(true);
            ui.getStandButtonPlayerOne().setEnabled(true);
        }

    }
}
