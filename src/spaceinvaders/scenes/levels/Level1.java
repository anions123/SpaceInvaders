package spaceinvaders.scenes.levels;

import spaceinvaders.AlienCollisionDetector;
import spaceinvaders.GameSettings;
import spaceinvaders.PlayerCollisionDetector;
import spaceinvaders.ShieldCollisionDetector;
import spaceinvaders.objects.BaseShield;
import spaceinvaders.objects.aliengrid.grids.AlienGrid1;
import spaceinvaders.misc.Position;
import spaceinvaders.objects.Player;
import spaceinvaders.objects.shields.fortress.FortressShield;
import spaceinvaders.scenes.BaseLevel;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Level1 extends BaseLevel {
    private static int playerPosition_y = (int)(GameSettings.windowHeight * 0.8);

    public Level1(){
        shields = new ArrayList<>();
        shields.add(new FortressShield(new Position((int)(GameSettings.windowWidth * 0.1), (int)(GameSettings.windowHeight*0.6), -1)));
        shields.add(new FortressShield(new Position((int)(GameSettings.windowWidth * 0.30), (int)(GameSettings.windowHeight*0.6), -1)));
        shields.add(new FortressShield(new Position((int)(GameSettings.windowWidth * 0.50), (int)(GameSettings.windowHeight*0.6), -1)));
        shields.add(new FortressShield(new Position((int)(GameSettings.windowWidth * 0.75), (int)(GameSettings.windowHeight*0.6), -1)));
        shields.add(new FortressShield(new Position((int)(GameSettings.windowWidth * 0.9), (int)(GameSettings.windowHeight*0.6), -1)));

        alienGrid = new AlienGrid1();
        try {
            player = new Player(new Position(GameSettings.windowWidth/2,playerPosition_y, -1));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
