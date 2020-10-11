package spaceinvaders.scenes;

import spaceinvaders.GameSettings;
import spaceinvaders.Rendering;
import spaceinvaders.aliengrid.BaseAlienColumn;
import spaceinvaders.aliengrid.BaseAlienGrid;
import spaceinvaders.misc.CollisionBox;
import spaceinvaders.objects.BaseAlien;
import spaceinvaders.objects.Player;
import spaceinvaders.objects.Projectile;

import java.awt.*;

public abstract class BaseLevel implements Rendering {
    private BaseAlienGrid alienGrid;
    private Player player;

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

        return false;
    }

    public void render(Graphics g){
        alienGrid.render(g);
        player.render(g);
    }

}
