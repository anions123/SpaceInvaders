package spaceinvaders.window.panels;

import spaceinvaders.GameSettings;
import spaceinvaders.engine.GameRules;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel{

    private GameRules gameRules;
    private GameSettings gameSettings;

    public GamePanel(){
        gameSettings = GameSettings.getInstance();
        setBackground(gameSettings.getBackgroundColor());
        gameRules = GameRules.getInstance();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        gameRules.renderLevel(g);
    }
}
