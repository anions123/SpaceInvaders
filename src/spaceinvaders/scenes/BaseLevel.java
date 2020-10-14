package spaceinvaders.scenes;

import spaceinvaders.CollisionDetector;
import spaceinvaders.misc.Rendering;
import spaceinvaders.objects.*;
import spaceinvaders.objects.aliengrid.BaseAlienGrid;

import java.awt.*;
import java.util.ArrayList;

public abstract class BaseLevel implements Rendering {
    protected BaseAlienGrid alienGrid;
    protected Player player;
    protected ArrayList<BaseShield> shields;
    protected ArrayList<CollisionDetector> collisionList;

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
    public ArrayList<CollisionDetector> getCollisionList(){
        return collisionList;
    }

    public void render(Graphics g){
        alienGrid.render(g);
        player.render(g);
        for(BaseShield s : shields){
            s.render(g);
        }
    }

}
