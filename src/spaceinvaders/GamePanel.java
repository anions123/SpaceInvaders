package spaceinvaders;

import spaceinvaders.aliengrid.BaseAlienColumn;
import spaceinvaders.objects.BaseAlien;
import spaceinvaders.objects.Player;
import spaceinvaders.scenes.BaseLevel;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    BaseLevel level;
    Player player;
    int score;
    int livesLeft;

    public GamePanel(BaseLevel level, Player player){
        super.setBackground(Color.BLACK);
        this.level = level;
        this.player = player;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        for(BaseAlienColumn bac : level.getAlienGrid().getGrid()){
            for(BaseAlien ba : bac.getColumn()){
                g.drawImage(ba.getSprite(),ba.getPosition().getX(), ba.getPosition().getY(), null);
            }
        }

        g.drawImage(player.getSprite(), player.getPosition().getX(),player.getPosition().getY(), null);
        g.setColor(Color.GREEN);
        g.setFont( g.getFont().deriveFont( 20.0f ));
        g.drawString("Score: "+score, 10,70);
        g.drawString("Lives: "+livesLeft, 200,70);
    }
}
