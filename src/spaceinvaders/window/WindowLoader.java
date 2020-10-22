package spaceinvaders.window;

import spaceinvaders.GameSettings;
import spaceinvaders.window.panels.GamePanel;
import spaceinvaders.window.panels.InfoPanel;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class WindowLoader {
    private JFrame fMain;
    private GamePanel pGame;
    private InfoPanel pInfo;
    private GameSettings gameSettings;
    private double panelProportion = 0.05;

    public WindowLoader(){
        gameSettings = GameSettings.getInstance();
        setupFont();
        fMain = new JFrame("SpaceInvaders");
        pGame = new GamePanel();
        pInfo = new InfoPanel();
    }

    public void initialize(){
        setupPGame();
        setupPInfo();
        setupFMain();
        pGame.requestFocus();
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
        pInfo.setPreferredSize(new Dimension(gameSettings.getWindowWidth(), (int) (gameSettings.getWindowHeight() * panelProportion)));
    }

    private void setupPGame(){
        pGame.setPreferredSize(new Dimension(gameSettings.getWindowWidth(), gameSettings.getWindowHeight() - (int) (gameSettings.getWindowWidth() * panelProportion)));
    }

    private void setupFMain(){
        fMain.setPreferredSize(new Dimension(gameSettings.getWindowWidth(), gameSettings.getWindowHeight()));
        fMain.setResizable(false);
        fMain.setLayout(new BoxLayout(fMain.getContentPane(), BoxLayout.Y_AXIS));
        fMain.add(pInfo);
        fMain.add(pGame);
        fMain.setVisible(true);
        fMain.pack();
        fMain.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public JFrame getFMain() {
        return fMain;
    }

    public void setFMain(JFrame fMain) {
        this.fMain = fMain;
    }

    public GamePanel getPGame() {
        return pGame;
    }

    public void setPGame(GamePanel pGame) {
        this.pGame = pGame;
    }

    public InfoPanel getPInfo() {
        return pInfo;
    }

    public void setPInfo(InfoPanel pInfo) {
        this.pInfo = pInfo;
    }

}
