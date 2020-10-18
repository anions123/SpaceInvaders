package spaceinvaders.window.panels;

import spaceinvaders.GameSettings;
import spaceinvaders.engine.GameRules;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel{

    private GameRules gameRules;

    public GamePanel(){
        super.setBackground(GameSettings.backgroundColor);
        gameRules = GameRules.getInstance();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        gameRules.renderLevel(g);
    }
}
