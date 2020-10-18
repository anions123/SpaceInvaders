package spaceinvaders.resources.scenes.levels;

import spaceinvaders.GameSettings;
import spaceinvaders.resources.objects.aliengrid.grids.AlienGrid0;
import spaceinvaders.engine.object.Position;
import spaceinvaders.resources.objects.Player;
import spaceinvaders.resources.objects.aliengrid.grids.AlienGrid1;
import spaceinvaders.resources.objects.shields.fortress.FortressShield;
import spaceinvaders.resources.scenes.BaseLevel;

import java.io.IOException;
import java.util.ArrayList;

public class Level0 extends BaseLevel {
    private static int playerPosition_y = (int)(GameSettings.windowHeight * 0.8);

    public Level0(){
        super(new AlienGrid0());

        shields = new ArrayList<>();
        shields.add(new FortressShield(new Position((int)(GameSettings.windowWidth * 0.1), (int)(GameSettings.windowHeight*0.6), -1)));
        shields.add(new FortressShield(new Position((int)(GameSettings.windowWidth * 0.3), (int)(GameSettings.windowHeight*0.6), -1)));
        shields.add(new FortressShield(new Position((int)(GameSettings.windowWidth * 0.6), (int)(GameSettings.windowHeight*0.6), -1)));
        shields.add(new FortressShield(new Position((int)(GameSettings.windowWidth * 0.9), (int)(GameSettings.windowHeight*0.6), -1)));
        try {
            player = new Player(new Position(GameSettings.windowWidth/2,playerPosition_y, -1));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
