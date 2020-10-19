package spaceinvaders.engine.timerlisteners;

import spaceinvaders.GameSettings;
import spaceinvaders.engine.GameRules;
import spaceinvaders.engine.object.Position;
import spaceinvaders.resources.objects.aliens.UFO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class UFOSpawnTimerListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            GameRules.getInstance().setUFO(new UFO(new Position(GameSettings.getInstance().getWindowWidth(), 0)));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
