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

    public GameTimerListener(JFrame f_main, InfoPanel p_info){
        this.f_main = f_main;
        this.p_info = p_info;
        gameRules = GameRules.getInstance();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        timerController = TimerController.getInstance();
        timerController.removeExpired();
        if(f_main != null && f_main.isDisplayable() && gameRules.isGameOn()){
            if(GameRunner.LEFT || GameRunner.RIGHT){
                int left = GameRunner.LEFT ? 1 : 0;
                int right = GameRunner.RIGHT ? 1 : 0;
                gameRules.translatePlayerPosition(-GameSettings.playerSpeed* left +
                        GameSettings.playerSpeed*right, 0);
                if(gameRules.getPlayerPosition_X()< 0)
                    gameRules.setPlayerPosition_X(0);
                if(gameRules.getPlayerPosition_X() + gameRules.getPlayerSprite_Height() > GameSettings.windowWidth){
                    gameRules.setPlayerPosition_X(GameSettings.windowWidth - gameRules.getPlayerSprite_Width());
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
