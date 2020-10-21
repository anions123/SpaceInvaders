package spaceinvaders.resources.scenes;

import spaceinvaders.engine.object.CollisionBox;
import spaceinvaders.engine.object.Rendering;
import spaceinvaders.resources.objects.*;
import spaceinvaders.resources.objects.aliengrid.BaseAlienColumn;
import spaceinvaders.resources.objects.aliengrid.BaseAlienGrid;
import spaceinvaders.resources.objects.aliens.UFO;
import spaceinvaders.resources.objects.player.Player;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseLevel implements Rendering {
    protected BaseAlienGrid alienGrid;
    protected Player player;
    protected ArrayList<BaseShield> shields;
    protected UFO ufo;

    public BaseLevel(BaseAlienGrid alienGrid){
        this.alienGrid = alienGrid;
    }

    public BaseAlienGrid getAlienGrid(){
        return alienGrid;
    }
    public void setAlienGrid(BaseAlienGrid alienGrid){
        this.alienGrid = alienGrid;
    }
    public Player getPlayer(){
        return player;
    }
    public void setPlayer(Player player){
        this.player = player;
    }
    public void setShields(ArrayList<BaseShield> shields){
        this.shields = shields;
    }
    public ArrayList<BaseShield> getShields(){
        return shields;
    }


    public void render(Graphics g){
        alienGrid.render(g);
        player.render(g);
        for(BaseShield s : shields){
            s.render(g);
        }
        if(ufo != null){
            if(ufo.isAlive()){
                ufo.render(g);
            }
        }
    }

    //lod
    public abstract void resetGrid();
    public abstract BaseLevel resetLevel();
    public void setUFO(UFO ufo){this.ufo = ufo;}
    public List<BaseAlienColumn> getAllAlienColumns(){
        return alienGrid.getGrid();
    }
    public boolean isPlayerColliding(CollisionBox collisionBox){
        return player.doCollide(collisionBox);
    }
    public void decPlayerLives(){
        player.decLivesLeft();
    }
    public int getPlayerLivesLeft(){
        return player.getLivesLeft();
    }
    public void setPlayerLivesLeft(int lives){player.setLivesLeft(lives);}
    public void translatePlayerPosition(int x, int y){
        player.translatePosition(x, y);
    }
    public void setPlayerPosition_X(int x){
        player.setPosition_X(x);
    }
    public void setPlayerPosition_Y(int y){
        player.setPosition_Y(y);
    }
    public int getPlayerPosition_X(){
        return player.getPosition_X();
    }
    public int getPlayerPosition_Y(){
        return player.getPosition_Y();
    }
    public int getPlayerSprite_Width(){
        return player.getSpriteWidth();
    }
    public int getPlayerSprite_Height(){
        return player.getSpriteHeight();
    }
    public void shootAsPlayer() throws IOException {
        player.shoot();
    }
    public boolean isUFOColliding(CollisionBox collisionBox){
        return ufo.doCollide(collisionBox);
    }
    public int getUFOPoints(){
        return ufo.getPoints();
    };

    public void setUFOAliveState(boolean alive){
        ufo.setAlive(alive);
    }
    public boolean isUFONull(){
        if(ufo == null){
            return true;
        }
        return false;
    }
}
