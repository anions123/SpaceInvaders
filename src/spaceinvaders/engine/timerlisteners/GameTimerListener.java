package spaceinvaders.engine.timerlisteners;

import spaceinvaders.resources.objects.player.PlayerControls;
import spaceinvaders.window.panels.InfoPanel;
import spaceinvaders.engine.GameRules;
import spaceinvaders.engine.misc.TimerController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameTimerListener implements ActionListener {
    private JFrame fMain;
    private InfoPanel pInfo;
    private GameRules gameRules;
    private PlayerControls playerControls;

    public GameTimerListener(JFrame fMain, InfoPanel pInfo){
        this.fMain = fMain;
        this.pInfo = pInfo;
        gameRules = GameRules.getInstance();
        playerControls = PlayerControls.getInstance();
    }

    private void endGamePopUp(){
        int result = JOptionPane.showConfirmDialog(fMain, "Your score: "+gameRules.getScore()+"\nYou have lost, you want to restart ?", "End of game",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.YES_NO_OPTION){
            gameRules.resetGame();
        }
        else if(result == JOptionPane.NO_OPTION){
            System.exit(0);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!gameRules.isGameOn()){
            TimerController.getInstance().stopAllTimers();
            endGamePopUp();

        }
        else{
            TimerController.getInstance().removeExpired();
            playerControls.execute();
            fMain.repaint();
            pInfo.updateValues();
        }

    }
}
