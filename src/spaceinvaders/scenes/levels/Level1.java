package spaceinvaders.scenes.levels;

import spaceinvaders.GameSettings;
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
    private ArrayList<BaseShield> shield;

    public Level1(){
        shield = new ArrayList<>();
        shield.add(new FortressShield(new Position((int)(GameSettings.windowWidth * 0.1), (int)(GameSettings.windowHeight*0.6), -1)));
        shield.add(new FortressShield(new Position((int)(GameSettings.windowWidth * 0.3), (int)(GameSettings.windowHeight*0.6), -1)));
        shield.add(new FortressShield(new Position((int)(GameSettings.windowWidth * 0.6), (int)(GameSettings.windowHeight*0.6), -1)));
        shield.add(new FortressShield(new Position((int)(GameSettings.windowWidth * 0.9), (int)(GameSettings.windowHeight*0.6), -1)));
    }

    @Override
    public void setupLevel() {

        super.setAlienGrid(new AlienGrid1(this));
        super.setShields(shield);
        try {
            super.setPlayer(new Player(new Position(GameSettings.windowWidth/2,playerPosition_y, -1)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
