package spaceinvaders.window.panels;

import spaceinvaders.GameSettings;
import spaceinvaders.engine.GameRules;

import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JPanel{

    private JLabel scoreLabel;
    private JLabel livesLabel;
    private GameRules gameRules;
    private GameSettings gameSettings;

    public InfoPanel(){
        gameSettings = GameSettings.getInstance();
        setBackground(gameSettings.getBackgroundColor());
        setLayout(new GridLayout(1,2));
        scoreLabel = new JLabel("Score "+ gameSettings.getScore(), JLabel.LEFT);
        livesLabel = new JLabel("Lives "+ gameSettings.getLivesLeft(), JLabel.RIGHT);
        scoreLabel.setFont(gameSettings.getGameFont().deriveFont(Font.BOLD, 20));
        scoreLabel.setForeground(gameSettings.getTextColor());
        livesLabel.setFont(gameSettings.getGameFont().deriveFont(Font.BOLD, 20));
        livesLabel.setForeground(gameSettings.getTextColor());
        gameRules = GameRules.getInstance();
        add(scoreLabel);
        add(livesLabel);

    }

    public void updateValues(){
        scoreLabel.setText("Score "+ gameRules.getScore());
        livesLabel.setText("Lives "+ gameRules.getPlayerLivesLeft());
    }
}
