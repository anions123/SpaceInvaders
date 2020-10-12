package spaceinvaders.scenes;

import spaceinvaders.GameSettings;
import spaceinvaders.misc.Rendering;
import spaceinvaders.objects.*;
import spaceinvaders.objects.aliengrid.BaseAlienColumn;
import spaceinvaders.objects.aliengrid.BaseAlienGrid;

import java.awt.*;
import java.util.ArrayList;

public abstract class BaseLevel implements Rendering {
    private BaseAlienGrid alienGrid;
    private Player player;
    private ArrayList<BaseShield> shields;

    abstract public void setupLevel();

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

    public boolean projectileCollisionDetector(Projectile projectile){
        boolean tester;
        if(projectile.getOwnerType().equals("alien")){
            tester = player.getCollisionBox().doCollide(projectile.getCollisionBox());
            if(tester){
                player.decLivesLeft();
                if(player.getLivesLeft()<=0){
                    GameSettings.gameOn = false;
                }
                return true;
            }
        }
        else if(projectile.getOwnerType().equals("player")){
            for(BaseAlienColumn al : alienGrid.getGrid()){
                for(BaseAlien a : al.getColumn()){
                    tester = a.getCollisionBox().doCollide(projectile.getCollisionBox());
                    if(tester){
                        if(a.isAlive()){
                            a.setAlive(false);
                            player.addScore(a.getPoints());
                            return true;
                        }
                        else{
                            return false;
                        }

                    }
                }
            }
        }

        for(BaseShield s : shields){
            for(BaseShieldPart sp : s.getShield()){
                tester = sp.getCollisionBox().doCollide(projectile.getCollisionBox());
                if(tester){
                    if(sp.getCurrentLives() > 0){
                        sp.decCurrentLives();
                        return true;
                    }
                    else{
                        return false;

                    }
                }
            }
        }
        return false;
    }

    public void render(Graphics g){
        alienGrid.render(g);
        player.render(g);
        for(BaseShield s : shields){
            s.render(g);
        }
    }

}
