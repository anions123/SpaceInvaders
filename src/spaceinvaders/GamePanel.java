package spaceinvaders;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel{

    public GamePanel(){
        super.setBackground(GameSettings.backgroundColor);
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        GameRules.getInstance().renderLevel(g);
    }
}
