package spaceinvaders.scenes.levels;

import spaceinvaders.AlienCollisionDetector;
import spaceinvaders.GameSettings;
import spaceinvaders.PlayerCollisionDetector;
import spaceinvaders.ShieldCollisionDetector;
import spaceinvaders.objects.BaseShield;
import spaceinvaders.objects.aliengrid.grids.AlienGrid0;
import spaceinvaders.misc.Position;
import spaceinvaders.objects.Player;
import spaceinvaders.objects.aliengrid.grids.AlienGrid1;
import spaceinvaders.objects.shields.fortress.FortressShield;
import spaceinvaders.scenes.BaseLevel;

import java.io.IOException;
import java.util.ArrayList;

public class Level0 extends BaseLevel {
    private static int playerPosition_y = (int)(GameSettings.windowHeight * 0.8);

    public Level0(){
        shields = new ArrayList<>();
        shields.add(new FortressShield(new Position((int)(GameSettings.windowWidth * 0.1), (int)(GameSettings.windowHeight*0.6), -1)));
        shields.add(new FortressShield(new Position((int)(GameSettings.windowWidth * 0.3), (int)(GameSettings.windowHeight*0.6), -1)));
        shields.add(new FortressShield(new Position((int)(GameSettings.windowWidth * 0.6), (int)(GameSettings.windowHeight*0.6), -1)));
        shields.add(new FortressShield(new Position((int)(GameSettings.windowWidth * 0.9), (int)(GameSettings.windowHeight*0.6), -1)));

        alienGrid = new AlienGrid0(this);
        try {
            player = new Player(new Position(GameSettings.windowWidth/2,playerPosition_y, -1));
        } catch (IOException e) {
            e.printStackTrace();
        }

        collisionList = new ArrayList<>();
        collisionList.add(new PlayerCollisionDetector());
        collisionList.add(new AlienCollisionDetector());
        collisionList.add(new ShieldCollisionDetector());
    }

}
