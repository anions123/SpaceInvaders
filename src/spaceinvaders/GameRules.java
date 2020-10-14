package spaceinvaders;

import spaceinvaders.objects.Player;
import spaceinvaders.objects.Projectile;
import spaceinvaders.scenes.BaseLevel;

import java.awt.*;

public class GameRules {
    private static BaseLevel level;
    private static boolean gameOn = true;

    private static GameRules instance = null;

    public static void initialize(BaseLevel l){
        level = l;
    }

    public static GameRules getInstance(){
        if(instance == null){
            instance = new GameRules();
        }
        return instance;
    }

    public void renderLevel(Graphics g){
        level.render(g);
    }

    public Player getPlayer(){
        return level.getPlayer();
    }

    public boolean isPlayerDead(){
        if(getPlayer().getLivesLeft() <= 0){
            return true;
        }
        return false;
    }

    public boolean projectileCollisionDetection(Projectile projectile){
        for(CollisionDetector cd : level.getCollisionList()){
            if(cd.process(projectile)){
                return true;
            }
        }
        return false;
    }
    public BaseLevel getLevel() {
        return level;
    }

    public void setLevel(BaseLevel level) {
        GameRules.level = level;
    }

    public boolean isGameOn() {
        return gameOn;
    }

    public void setGameOn(boolean gameOn) {
        GameRules.gameOn = gameOn;
    }
}
