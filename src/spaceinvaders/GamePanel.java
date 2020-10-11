package spaceinvaders;

import spaceinvaders.scenes.BaseLevel;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel{

    BaseLevel level;

    public GamePanel(BaseLevel level){
        super.setBackground(GameSettings.backgroundColor);
        this.level = level;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        level.render(g);
    }
}
