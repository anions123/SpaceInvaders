package spaceinvaders.engine.timerlisteners;

import spaceinvaders.GameSettings;
import spaceinvaders.resources.objects.aliens.UFO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UFOMovementTimerListener implements ActionListener {
    private UFO ufo;
    private GameSettings gameSettings;

    public UFOMovementTimerListener(UFO ufo){
        this.ufo = ufo;
        gameSettings = GameSettings.getInstance();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(ufo.isAlive()){
            ufo.translatePosition(-gameSettings.getUfoSpeed(), 0);
            if(ufo.getPositionX()+ufo.getSpriteWidth()<=0){
                ((Timer)e.getSource()).stop();
            }
        }

    }
}
