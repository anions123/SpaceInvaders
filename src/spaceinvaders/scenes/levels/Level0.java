package spaceinvaders.scenes.levels;

import spaceinvaders.GameSettings;
import spaceinvaders.aliengrid.grids.AlienGrid0;
import spaceinvaders.misc.Position;
import spaceinvaders.objects.Player;
import spaceinvaders.scenes.BaseLevel;

import java.io.IOException;

public class Level0 extends BaseLevel {
    private static int playerPosition_y = (int)(GameSettings.windowHeight * 0.8);

    @Override
    public void setupLevel() {
        super.setAlienGrid(new AlienGrid0(this));
        try {
            super.setPlayer(new Player(new Position(GameSettings.windowWidth/2, playerPosition_y, -1)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
