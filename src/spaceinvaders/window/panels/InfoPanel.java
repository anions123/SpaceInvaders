package spaceinvaders.window.panels;

import spaceinvaders.GameSettings;
import spaceinvaders.engine.GameRules;

import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JPanel{

    private JLabel scoreLabel;
    private JLabel livesLabel;
    private JLabel highScoreLabel;
    private GameRules gameRules;
    private GameSettings gameSettings;

    public InfoPanel(){
        gameSettings = GameSettings.getInstance();
        setBackground(gameSettings.getBackgroundColor());
        setLayout(new GridLayout(1,2));
        scoreLabel = new JLabel("Score 0", JLabel.LEFT);
        livesLabel = new JLabel("Lives "+ gameSettings.getLivesLeft(), JLabel.RIGHT);
        highScoreLabel = new JLabel("High Score "+gameSettings.getHighScore(), JLabel.CENTER);
        scoreLabel.setFont(gameSettings.getGameFont().deriveFont(Font.BOLD, 20));
        scoreLabel.setForeground(gameSettings.getTextColor());
        livesLabel.setFont(gameSettings.getGameFont().deriveFont(Font.BOLD, 20));
        livesLabel.setForeground(gameSettings.getTextColor());
        highScoreLabel.setFont(gameSettings.getGameFont().deriveFont(Font.BOLD, 20));
        highScoreLabel.setForeground(gameSettings.getTextColor());
        gameRules = GameRules.getInstance();
        add(scoreLabel);
        add(highScoreLabel);
        add(livesLabel);


    }

    public void updateValues(){
        scoreLabel.setText("Score "+ gameRules.getScore());
        livesLabel.setText("Lives "+ gameRules.getPlayerLivesLeft());
        if(gameRules.getScore() > gameSettings.getHighScore()){
            gameSettings.setHighScore(gameRules.getScore());
        }
        highScoreLabel.setText("High Score "+gameSettings.getHighScore());
    }
}
