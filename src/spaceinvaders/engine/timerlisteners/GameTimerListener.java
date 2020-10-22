package spaceinvaders.engine.timerlisteners;

import spaceinvaders.GameSettings;
import spaceinvaders.resources.objects.player.PlayerControls;
import spaceinvaders.window.panels.InfoPanel;
import spaceinvaders.engine.GameRules;
import spaceinvaders.engine.misc.TimerController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameTimerListener implements ActionListener {
    private JFrame f_main;
    private InfoPanel p_info;
    private GameRules gameRules;
    private GameSettings gameSettings;
    private PlayerControls playerControls;

    public GameTimerListener(JFrame f_main, InfoPanel p_info){
        this.f_main = f_main;
        this.p_info = p_info;
        gameRules = GameRules.getInstance();
        gameSettings = GameSettings.getInstance();
        playerControls = PlayerControls.getInstance();
    }

    private void endGamePopUp(ActionEvent e){
        int result = JOptionPane.showConfirmDialog(f_main, "Your score: "+gameRules.getScore()+"\nYou have lost, you want to restart ?", "End of game",
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
            endGamePopUp(e);

        }
        else{
            TimerController.getInstance().removeExpired();
            playerControls.execute();
            f_main.repaint();
            p_info.updateValues();
        }

    }
}
