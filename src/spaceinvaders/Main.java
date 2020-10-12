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
    public static boolean LEFT, RIGHT, SHOOTING = false;
    private JFrame f_main;
    private GamePanel p_game;
    private InfoPanel p_info;
    private GameRules gameRules;

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

        //level = new Level0();
        //.setupLevel();
        gameRules = GameRules.getInstance();
        gameRules.initialize(new Level1());

        p_game = new GamePanel();
        p_game.setPreferredSize(new Dimension(GameSettings.windowWidth, GameSettings.windowHeight - (int)(GameSettings.windowHeight*0.05)));

        p_info = new InfoPanel();
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
        p_game.getInputMap().put(KeyStroke.getKeyStroke("pressed A"), "leftOn");
        p_game.getInputMap().put(KeyStroke.getKeyStroke("released A"), "leftOff");
        p_game.getInputMap().put(KeyStroke.getKeyStroke("pressed D"), "rightOn");
        p_game.getInputMap().put(KeyStroke.getKeyStroke("released D"), "rightOff");

        p_game.getInputMap().put(KeyStroke.getKeyStroke("released SPACE"), "shoot");

        p_game.getActionMap().put("leftOff", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LEFT = false;
            }
        });
        p_game.getActionMap().put("leftOn", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LEFT = true;

            }
        });

        p_game.getActionMap().put("rightOff", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RIGHT = false;
            }
        });
        p_game.getActionMap().put("rightOn", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RIGHT = true;
            }
        });

        p_game.getActionMap().put("shoot", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SHOOTING = true;
            }
        });

        //Timer for game loop
        gameTimerListener = new GameTimerListener(f_main, p_info);
        new Timer(GameSettings.gameDelay, gameTimerListener).start();


    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new Main();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

}


class GameTimerListener implements ActionListener{
    private JFrame f_main;
    private InfoPanel p_info;
    private GameRules gameRules;

    public GameTimerListener(JFrame f_main, InfoPanel p_info){
        this.f_main = f_main;
        this.p_info = p_info;
        gameRules = GameRules.getInstance();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(f_main != null && f_main.isDisplayable() && gameRules.isGameOn()){
            if(Main.LEFT || Main.RIGHT){
                int left = Main.LEFT ? 1 : 0;
                int right = Main.RIGHT ? 1 : 0;
                gameRules.getPlayer().getPosition().translate(-GameSettings.playerSpeed* left +
                        GameSettings.playerSpeed*right, 0);
                if(gameRules.getPlayer().getPosition().getX()< 0)
                    gameRules.getPlayer().getPosition().setX(0);
                if(gameRules.getPlayer().getPosition().getX() + gameRules.getPlayer().getSprite().getHeight() > GameSettings.windowWidth){
                    gameRules.getPlayer().getPosition().setX(GameSettings.windowWidth - gameRules.getPlayer().getSprite().getWidth());
                }

            }
            if(Main.SHOOTING){
                try {
                    gameRules.getPlayer().shoot();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            }
            Main.SHOOTING = false;
            f_main.repaint();
            p_info.updateValues();
        }
        else{
            ((Timer)e.getSource()).stop();
        }
    }
}
