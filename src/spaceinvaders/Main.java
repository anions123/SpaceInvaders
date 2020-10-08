package spaceinvaders;

import spaceinvaders.aliengrid.BaseAlienColumn;
import spaceinvaders.objects.BaseAlien;
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

public class Main extends JPanel {

    static JFrame f;


    private BaseAlien player;
    private BaseLevel level;
    private int score = 0;
    private int livesLeft = 3;
    long lastTime;

    public Main() throws IOException {
        this.player = new BigAlien(new Position(100, 600));
        this.level = new Level0();
        /*super.getContentPane().setBackground(Color.BLACK);
        super.setPreferredSize(new Dimension(player.getSprite().getWidth()*20, 600+ player.getSprite().getHeight()*10));
        super.pack();
        super.setVisible(true);
        super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        new Timer(1000, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();

                level.getAlienGrid().moveGrid(20,0,1);
            }

        }).start();


        lastTime = System.nanoTime();*/
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        //g.clearRect(0,0,super.getWidth(), super.getHeight());
        System.out.println("test");
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

    public static void main(String[] args) throws IOException, InvocationTargetException, InterruptedException {
        f = new JFrame("test");

        f.setSize(900, 900);
        f.pack();
        f.setVisible(true);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
