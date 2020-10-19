package spaceinvaders.engine.timerlisteners;

import spaceinvaders.GameSettings;
import spaceinvaders.engine.GameRules;
import spaceinvaders.resources.objects.aliengrid.BaseAlienGrid;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GridShootingTimerListener implements ActionListener {
    private BaseAlienGrid alienGrid;

    private void randomAlienShoot(){
        alienGrid = GameRules.getInstance().getAlienGrid();
        try {
            alienGrid.shootAsRandomAlien();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        randomAlienShoot();
    }
}
