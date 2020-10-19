package spaceinvaders.resources.timerlisteners;

import spaceinvaders.GameSettings;
import spaceinvaders.window.panels.InfoPanel;
import spaceinvaders.GameRunner;
import spaceinvaders.engine.GameRules;
import spaceinvaders.engine.misc.TimerController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GameTimerListener implements ActionListener {
    private JFrame f_main;
    private InfoPanel p_info;
    private GameRules gameRules;
    private TimerController timerController;
    private GameSettings gameSettings;

    public GameTimerListener(JFrame f_main, InfoPanel p_info){
        this.f_main = f_main;
        this.p_info = p_info;
        gameRules = GameRules.getInstance();
        gameSettings = GameSettings.getInstance();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(!gameRules.isGameOn()){
            int result = JOptionPane.showConfirmDialog(f_main, "Your score: "+gameRules.getScore()+"\nYou have lost, you want to restart ?", "End of game",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if(result == JOptionPane.YES_NO_OPTION){
                gameRules.resetGame();
            }
            else if(result == JOptionPane.NO_OPTION){
                ((Timer)e.getSource()).stop();
            }
        }
        else{
            timerController = TimerController.getInstance();
            timerController.removeExpired();


            if(f_main != null && f_main.isDisplayable()){
                if(GameRunner.LEFT || GameRunner.RIGHT){
                    int left = GameRunner.LEFT ? 1 : 0;
                    int right = GameRunner.RIGHT ? 1 : 0;
                    gameRules.translatePlayerPosition(-gameSettings.getPlayerSpeed()* left +
                            gameSettings.getPlayerSpeed()*right, 0);
                    if(gameRules.getPlayerPosition_X()< 0)
                        gameRules.setPlayerPosition_X(0);
                    if(gameRules.getPlayerPosition_X() + gameRules.getPlayerSprite_Height() > gameSettings.getWindowWidth()){
                        gameRules.setPlayerPosition_X(gameSettings.getWindowWidth() - gameRules.getPlayerSprite_Width());
                    }

                }
                if(GameRunner.SHOOTING){
                    try {
                        gameRules.shootAsPlayer();
                    } catch (IOException ioException) {
                        ioException.printStackTrace();
                    }

                }
                GameRunner.SHOOTING = false;
                f_main.repaint();
                p_info.updateValues();
            }
            else{
                ((Timer)e.getSource()).stop();
            }
        }

    }
}
