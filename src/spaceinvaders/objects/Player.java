package spaceinvaders.objects;

import spaceinvaders.GameSettings;
import spaceinvaders.misc.GameObject;
import spaceinvaders.misc.Position;
import spaceinvaders.misc.Shooting;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;

public class Player extends GameObject implements Shooting {
    private Projectile projectile;
    private boolean canShoot = true;
    private int livesLeft;

    public Player(Position position) throws IOException {
        super(ImageIO.read(new FileInputStream("src/spaceinvaders/sprites/players/player.png")), position);
        resizeSpriteIfBiggerThan(GameSettings.maxHalfWidth*2, GameSettings.maxHalfHeight*2);
        livesLeft = GameSettings.livesLeft;
    }

    @Override
    public boolean canShoot() {

        if(projectile != null && projectile.isAliveProjectile()){
            canShoot = false;
        }
        else{
            canShoot = true;
            if(projectile != null){
                projectile = null;
            }
        }
        return canShoot;
    }

    @Override
    public void shoot() throws IOException {
        if(canShoot()){
            projectile = new Projectile(new Position(
                    position.getX() + position.getCenterOffset_x(),
                    position.getY() - sprite.getHeight(),
                    position.getDirection_y()), "player");
        }
    }

    @Override
    public void render(Graphics g){
        g.drawImage(sprite, position.getX(), position.getY(), null);
        if(projectile != null && projectile.isAliveProjectile()){
            projectile.render(g);
        }

    }


    //lod
    public int getLivesLeft() {
        return livesLeft;
    }
    public void setLivesLeft(int livesLeft) {
        this.livesLeft = livesLeft;
    }
    public void decLivesLeft() {
        this.livesLeft--;
    }
}
