package spaceinvaders.resources.scenes.levels;

import spaceinvaders.GameSettings;
import spaceinvaders.resources.objects.aliengrid.grids.AlienGrid0;
import spaceinvaders.engine.object.Position;
import spaceinvaders.resources.objects.player.Player;
import spaceinvaders.resources.objects.shields.fortress.FortressShield;
import spaceinvaders.resources.scenes.BaseLevel;

import java.io.IOException;
import java.util.ArrayList;

public class Level0 extends BaseLevel {
    private GameSettings gameSettings;
    private int playerPositionY;


    public Level0(){
        super(new AlienGrid0());
        gameSettings = GameSettings.getInstance();
        playerPositionY = (int)(gameSettings.getWindowHeight() * 0.8);
        shields = new ArrayList<>();
        shields.add(new FortressShield(new Position((int)(gameSettings.getWindowWidth() * 0.1), (int)(gameSettings.getWindowHeight()*0.6))));
        shields.add(new FortressShield(new Position((int)(gameSettings.getWindowWidth() * 0.3), (int)(gameSettings.getWindowHeight()*0.6))));
        shields.add(new FortressShield(new Position((int)(gameSettings.getWindowWidth() * 0.6), (int)(gameSettings.getWindowHeight()*0.6))));
        shields.add(new FortressShield(new Position((int)(gameSettings.getWindowWidth() * 0.9), (int)(gameSettings.getWindowHeight()*0.6))));
        try {
            player = new Player(new Position(gameSettings.getWindowWidth()/2, playerPositionY, -1));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void resetGrid() {
        alienGrid = new AlienGrid0();
    }

    @Override
    public BaseLevel resetLevel() {
        return new Level0();
    }
}
