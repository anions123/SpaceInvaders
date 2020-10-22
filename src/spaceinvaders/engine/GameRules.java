package spaceinvaders.engine;

import spaceinvaders.GameSettings;
import spaceinvaders.engine.misc.TimerController;
import spaceinvaders.engine.object.CollisionBox;
import spaceinvaders.resources.objects.BaseShield;
import spaceinvaders.resources.objects.aliens.UFO;
import spaceinvaders.resources.objects.player.Player;
import spaceinvaders.resources.objects.aliengrid.BaseAlienColumn;
import spaceinvaders.resources.objects.aliengrid.BaseAlienGrid;
import spaceinvaders.resources.objects.player.PlayerControls;
import spaceinvaders.resources.scenes.BaseLevel;

import java.awt.*;
import java.io.IOException;
import java.util.List;

public class GameRules {
    private BaseLevel level;
    private boolean gameOn = true;
    private int score;

    private static GameRules instance = null;

    private GameRules(BaseLevel level){
        this.level = level;
    }

    public static GameRules getInstance(){
        if(instance == null){
            throw new RuntimeException("Need to setup GameRules, by running getInstance with attributes");
        }
        return instance;
    }

    public static GameRules getInstance(BaseLevel level){
        if(instance == null){
            instance = new GameRules(level);
        }
        return instance;
    }

    public void addScore(int score){
        this.score += score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void renderLevel(Graphics g){
        level.render(g);
    }

    public Player getPlayer(){
        return level.getPlayer();
    }

    public boolean isPlayerDead() {
        return (level.getPlayerLivesLeft() <= 0);
    }


    public BaseLevel getLevel() {
        return level;
    }

    public void setLevel(BaseLevel level) {
        this.level = level;
    }

    public boolean isGameOn() {
        return gameOn;
    }

    public void setGameOn(boolean gameOn) {
        this.gameOn = gameOn;
    }

    //lod
    public void setUFO(UFO ufo){
        level.setUFO(ufo);
    }
    public void resetGame(){
        level = level.resetLevel();
        TimerController.getInstance().startAllTimers();
        PlayerControls.getInstance().resetControls();
        GameSettings.getInstance().setGridDelay(500);
        score = 0;
        gameOn = true;
    }
    public void resetGrid(){
        level.resetGrid();
        TimerController.getInstance().startAllTimers();
        PlayerControls.getInstance().resetControls();
        GameSettings.getInstance().setGridDelay(500);
    }
    public BaseAlienGrid getAlienGrid(){
        return level.getAlienGrid();
    }
    public List<BaseAlienColumn> getAllAlienColumns(){
        return level.getAllAlienColumns();
    }
    public boolean isPlayerColliding(CollisionBox collisionBox){
        return level.isPlayerColliding(collisionBox);
    }
    public boolean isUFOColliding(CollisionBox collisionBox){return level.isUFOColliding(collisionBox);}
    public void decPlayerLives(){
        level.decPlayerLives();
    }
    public List<BaseShield> getShields(){
        return level.getShields();
    }
    public int getPlayerSpriteWidth(){
        return level.getPlayerSpriteWidth();
    }
    public int getPlayerSpriteHeight(){
        return level.getPlayerSpriteHeight();
    }
    public int getPlayerLivesLeft(){
        return level.getPlayerLivesLeft();
    }
    public void setPlayerLivesLeft(int lives){level.setPlayerLivesLeft(lives);}
    public void translatePlayerPosition(int x, int y){
        level.translatePlayerPosition(x, y);
    }
    public void setPlayerPositionX(int x){
        level.setPlayerPositionX(x);
    }
    public int getPlayerPositionX(){
        return level.getPlayerPositionX();
    }
    public void setPlayerPositionY(int y){
        level.setPlayerPositionY(y);
    }
    public int getPlayerPositionY(){
        return level.getPlayerPositionY();
    }
    public void shootAsPlayer() throws IOException {
        level.shootAsPlayer();
    }
    public int getUFOPoints(){return level.getUFOPoints();}
    public void setUFOAliveState(boolean alive){level.setUFOAliveState(alive);}
    public boolean isUFONull(){return level.isUFONull();}
}
