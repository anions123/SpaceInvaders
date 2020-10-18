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

    private TimerController timerController;
    public static boolean LEFT, RIGHT, SHOOTING = false;
    private JFrame f_main;
    private GamePanel p_game;
    private InfoPanel p_info;
    private GameRules gameRules;

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
        gameRules = GameRules.getInstance(new Level0());
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
        //.setupLevel();

        timerController = TimerController.getInstance(f_main, p_info);
        timerController.startAllTimers();


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


