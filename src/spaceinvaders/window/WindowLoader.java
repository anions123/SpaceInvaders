package spaceinvaders.window;

import spaceinvaders.GameSettings;
import spaceinvaders.window.panels.GamePanel;
import spaceinvaders.window.panels.InfoPanel;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class WindowLoader {
    private JFrame f_main;
    private GamePanel p_game;
    private InfoPanel p_info;
    private GameSettings gameSettings;
    private double panelProportion = 0.05;

    public WindowLoader(){
        gameSettings = GameSettings.getInstance();
        setupFont();
        f_main = new JFrame("SpaceInvaders");
        p_game = new GamePanel();
        p_info = new InfoPanel();
    }

    public void initialize(){
        setupPGame();
        setupPInfo();
        setupFMain();
        p_game.requestFocus();
    }

    private void setupFont(){
        try {
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/spaceinvaders/resources/fonts/karmatic_arcade/ka1.ttf"));
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);
            gameSettings.setGameFont(customFont);
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
            gameSettings.setGameFont(new Font("TimesRoman", Font.BOLD, 20));
        }
    }

    private void setupPInfo(){
        p_info.setPreferredSize(new Dimension(gameSettings.getWindowWidth(), (int) (gameSettings.getWindowHeight() * panelProportion)));
    }

    private void setupPGame(){
        p_game.setPreferredSize(new Dimension(gameSettings.getWindowWidth(), gameSettings.getWindowHeight() - (int) (gameSettings.getWindowWidth() * panelProportion)));
    }

    private void setupFMain(){
        f_main.setPreferredSize(new Dimension(gameSettings.getWindowWidth(), gameSettings.getWindowHeight()));
        f_main.setResizable(false);
        f_main.setLayout(new BoxLayout(f_main.getContentPane(), BoxLayout.Y_AXIS));
        f_main.add(p_info);
        f_main.add(p_game);
        f_main.setVisible(true);
        f_main.pack();
        f_main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public JFrame getFMain() {
        return f_main;
    }

    public void setFMain(JFrame f_main) {
        this.f_main = f_main;
    }

    public GamePanel getPGame() {
        return p_game;
    }

    public void setPGame(GamePanel p_game) {
        this.p_game = p_game;
    }

    public InfoPanel getPInfo() {
        return p_info;
    }

    public void setPInfo(InfoPanel p_info) {
        this.p_info = p_info;
    }

}
