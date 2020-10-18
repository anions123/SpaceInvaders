package spaceinvaders;

import spaceinvaders.misc.CollisionBox;
import spaceinvaders.objects.BaseShield;
import spaceinvaders.objects.Player;
import spaceinvaders.objects.Projectile;
import spaceinvaders.objects.aliengrid.BaseAlienColumn;
import spaceinvaders.objects.aliengrid.BaseAlienGrid;
import spaceinvaders.scenes.BaseLevel;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public class GameRules {
    private static BaseLevel level;
    private static boolean gameOn = true;
    private static int score;
    private static CollisionDetectorFactory collisionDetectorFactory;

    private static GameRules instance = null;

    private GameRules(BaseLevel l){
        collisionDetectorFactory = new CollisionDetectorFactory();
        level = l;
    }

    public static GameRules getInstance(){
        return instance;
    }

    public static GameRules getInstance(BaseLevel l){
        if(instance == null){
            instance = new GameRules(l);
        }
        return instance;
    }

    public void addScore(int score){
        GameRules.score += score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        GameRules.score = score;
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
        for(CollisionDetector cd : collisionDetectorFactory.getCollisionDetectors()){
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

    //lod
    public BaseAlienGrid getAlienGrid(){
        return level.getAlienGrid();
    }
    public List<BaseAlienColumn> getAllAlienColumns(){
        return level.getAllAlienColumns();
    }
    public boolean isPlayerColliding(CollisionBox collisionBox){
        return level.isPlayerColliding(collisionBox);
    }
    public void decPlayerLives(){
        level.decPlayerLives();
    }
    public List<BaseShield> getShields(){
        return level.getShields();
    }
    public int getPlayerSprite_Width(){
        return level.getPlayerSprite_Width();
    }
    public int getPlayerSprite_Height(){
        return level.getPlayerSprite_Height();
    }
    public int getPlayerLivesLeft(){
        return level.getPlayerLivesLeft();
    }
    public void translatePlayerPosition(int x, int y){
        level.translatePlayerPosition(x, y);
    }
    public void setPlayerPosition_X(int x){
        level.setPlayerPosition_X(x);
    }
    public int getPlayerPosition_X(){
        return level.getPlayerPosition_X();
    }
    public void setPlayerPosition_Y(int y){
        level.setPlayerPosition_Y(y);
    }
    public int getPlayerPosition_Y(){
        return level.getPlayerPosition_Y();
    }
    public void shootAsPlayer() throws IOException {
        level.shootAsPlayer();
    }

}
