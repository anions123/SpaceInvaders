package spaceinvaders;

import spaceinvaders.scenes.BaseLevel;
import spaceinvaders.scenes.levels.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;


public class Main{

    private GameTimerListener gameTimerListener;
    private JFrame f_main;
    private GamePanel p_game;
    private InfoPanel p_info;

    private BaseLevel level;

    public Main() throws IOException {
        //Setup custom font for game
        try {
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/spaceinvaders/fonts/karmatic_arcade/ka1.ttf"));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);
            GameSettings.gameFont = customFont;
        } catch (IOException |FontFormatException e) {
            e.printStackTrace();
            GameSettings.gameFont = new Font("TimesRoman", Font.BOLD, 20);
        }

        level = new Level0();
        level.setupLevel();
        GameSettings.gameOn = true;

        p_game = new GamePanel(level);
        p_game.setPreferredSize(new Dimension(GameSettings.windowWidth, GameSettings.windowHeight - (int)(GameSettings.windowHeight*0.05)));

        p_info = new InfoPanel(level.getPlayer());
        p_info.setPreferredSize(new Dimension(GameSettings.windowWidth, (int)(GameSettings.windowHeight*0.05)));

        f_main = new JFrame("SpaceInvaders");
        f_main.setPreferredSize(new Dimension(GameSettings.windowWidth, GameSettings.windowHeight));
        f_main.setResizable(false);
        f_main.setLayout(new BoxLayout(f_main.getContentPane(), BoxLayout.Y_AXIS));
        f_main.add(p_info);
        f_main.add(p_game);
        f_main.pack();
        f_main.setVisible(true);
        f_main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Setup input for player
        p_game.requestFocus();
        p_game.getInputMap().put(KeyStroke.getKeyStroke('a'), "moveLeft");
        p_game.getInputMap().put(KeyStroke.getKeyStroke('d'), "moveRight");
        p_game.getInputMap().put(KeyStroke.getKeyStroke("released SPACE"), "shoot");

        p_game.getActionMap().put("moveLeft", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(level.getPlayer().getPosition().getX() - GameSettings.playerSpeed < 0)
                    level.getPlayer().getPosition().setX(0);
                else
                    level.getPlayer().getPosition().translate(-GameSettings.playerSpeed, 0);
            }
        });

        p_game.getActionMap().put("moveRight", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(level.getPlayer().getPosition().getX() + level.getPlayer().getSprite().getWidth() + GameSettings.playerSpeed < GameSettings.windowWidth)
                    level.getPlayer().getPosition().translate(GameSettings.playerSpeed, 0);
            }
        });

        p_game.getActionMap().put("shoot", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    level.getPlayer().shoot(level);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        });

        //Timer for game loop
        gameTimerListener = new GameTimerListener(f_main, p_info);
        new Timer(GameSettings.gameDelay, gameTimerListener).start();


    }


    public static void main(String[] args) throws IOException, InvocationTargetException, InterruptedException {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Main();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

}


class GameTimerListener implements ActionListener{
    private JFrame f_main;
    private InfoPanel p_info;

    public GameTimerListener(JFrame f_main, InfoPanel p_info){
        this.f_main = f_main;
        this.p_info = p_info;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(f_main != null && f_main.isDisplayable() && GameSettings.gameOn){
            f_main.repaint();
            p_info.updateValues();
        }
        else{
            ((Timer)e.getSource()).stop();
        }
    }
}
