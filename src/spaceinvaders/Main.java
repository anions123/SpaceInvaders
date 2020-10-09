package spaceinvaders;

import spaceinvaders.aliengrid.BaseAlienColumn;
import spaceinvaders.objects.BaseAlien;
import spaceinvaders.objects.Player;
import spaceinvaders.objects.aliens.BigAlien;
import spaceinvaders.scenes.BaseLevel;
import spaceinvaders.scenes.levels.*;
import spaceinvaders.misc.Position;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main implements GameRules{

    private JFrame f_main;
    private JPanel p_game;


    private boolean gameOn;
    private int tmrDelay;
    private Timer tmr;
    private Player player;
    private BaseLevel level;
    private int directionChangesLeft;

    public Main() throws IOException {
        player = new Player(new Position(100, 600));
        level = new Level0();
        gameOn = true;
        directionChangesLeft = 2;

        f_main = new JFrame("SpaceInvaders");
        p_game = new GamePanel(level,player);

        f_main.setPreferredSize(new Dimension(player.getSprite().getWidth()*20, 600+ player.getSprite().getHeight()*10));
        f_main.setResizable(false);
        f_main.add(p_game);
        f_main.pack();
        f_main.setVisible(true);
        f_main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


        this.tmrDelay = 1000;
        this.tmr = new Timer(tmrDelay, e -> {
            if(gameOn){
                f_main.repaint();

                //Checks which direction are aliens moving and gets either far left or far right column, based on direction
                BaseAlienColumn tempColumn;
                if(level.getAlienGrid().getMovementDirection() == 1){
                    tempColumn = level.getAlienGrid().getFarRightAliveColumn();
                }
                else{
                    tempColumn = level.getAlienGrid().getFarLeftAliveColumn();
                }

                //Checks if there are any aliens left alive, if not ends the game
                if(tempColumn.equals(null)){
                    gameOn = false;
                }
                else{

                    //Checks if gird has reach the end of window, if so it changes movement direction
                    if(tempColumn.getColumnPositionX() + maxHalfWidth * 2>= f_main.getWidth() ||
                            tempColumn.getColumnPositionX() <= 0){
                        level.getAlienGrid().swapDirection();
                        directionChangesLeft--;
                    }

                    if(directionChangesLeft<=0){
                        level.getAlienGrid().moveGrid(0,player.getSprite().getHeight(),1);
                        directionChangesLeft = 2;
                    }
                    else{
                        level.getAlienGrid().moveGrid(player.getSprite().getWidth()/3 * level.getAlienGrid().getMovementDirection(),0,1);
                    }

                    if(tmrDelay>50){
                        tmrDelay-= 50;
                        tmr.setDelay(tmrDelay);
                    }
                }

            }
            else{
                tmr.stop();
            }

        });
        tmr.start();
    }


    public static void main(String[] args) throws IOException, InvocationTargetException, InterruptedException {
        new Main();


    }

}
