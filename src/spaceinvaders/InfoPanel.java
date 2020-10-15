package spaceinvaders;

import spaceinvaders.objects.Player;

import javax.swing.*;
import java.awt.*;

public class InfoPanel extends JPanel{

    private JLabel scoreLabel;
    private JLabel livesLabel;
    private GameRules gameRules;

    public InfoPanel(){
        super.setBackground(GameSettings.backgroundColor);
        super.setLayout(new GridLayout(1,2));
        scoreLabel = new JLabel("Score "+ GameSettings.score, JLabel.LEFT);
        livesLabel = new JLabel("Lives "+ GameSettings.livesLeft, JLabel.RIGHT);
        scoreLabel.setFont(GameSettings.gameFont.deriveFont(Font.BOLD, 20));
        scoreLabel.setForeground(GameSettings.textColor);
        livesLabel.setFont(GameSettings.gameFont.deriveFont(Font.BOLD, 20));
        livesLabel.setForeground(GameSettings.textColor);
        gameRules = GameRules.getInstance();
        super.add(scoreLabel);
        super.add(livesLabel);

    }

    public void updateValues(){
        scoreLabel.setText("Score "+ gameRules.getScore());
        livesLabel.setText("Lives "+ gameRules.getPlayerLivesLeft());
    }
}
