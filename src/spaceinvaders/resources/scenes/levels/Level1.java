package spaceinvaders.resources.scenes.levels;

import spaceinvaders.GameSettings;
import spaceinvaders.resources.objects.aliengrid.grids.AlienGrid1;
import spaceinvaders.engine.object.Position;
import spaceinvaders.resources.objects.Player;
import spaceinvaders.resources.objects.shields.fortress.FortressShield;
import spaceinvaders.resources.scenes.BaseLevel;

import java.io.IOException;
import java.util.ArrayList;

public class Level1 extends BaseLevel {
    private static int playerPosition_y = (int)(GameSettings.windowHeight * 0.8);

    public Level1(){
        super(new AlienGrid1());

        shields = new ArrayList<>();
        shields.add(new FortressShield(new Position((int)(GameSettings.windowWidth * 0.1), (int)(GameSettings.windowHeight*0.6), -1)));
        shields.add(new FortressShield(new Position((int)(GameSettings.windowWidth * 0.30), (int)(GameSettings.windowHeight*0.6), -1)));
        shields.add(new FortressShield(new Position((int)(GameSettings.windowWidth * 0.50), (int)(GameSettings.windowHeight*0.6), -1)));
        shields.add(new FortressShield(new Position((int)(GameSettings.windowWidth * 0.75), (int)(GameSettings.windowHeight*0.6), -1)));
        shields.add(new FortressShield(new Position((int)(GameSettings.windowWidth * 0.9), (int)(GameSettings.windowHeight*0.6), -1)));

        try {
            player = new Player(new Position(GameSettings.windowWidth/2,playerPosition_y, -1));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
