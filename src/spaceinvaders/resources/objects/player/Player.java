package spaceinvaders.resources.objects.player;

import spaceinvaders.GameSettings;
import spaceinvaders.engine.object.GameObject;
import spaceinvaders.engine.object.Position;
import spaceinvaders.engine.object.Shooting;
import spaceinvaders.resources.objects.Projectile;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;

public class Player extends GameObject implements Shooting {
    private Projectile projectile;
    private int livesLeft;

    public Player(Position position) throws IOException {
        super(ImageIO.read(new FileInputStream("src/spaceinvaders/resources/sprites/players/player.png")), position);
        livesLeft = GameSettings.getInstance().getLivesLeft();
    }

    @Override
    public boolean canShoot() {
        boolean canShoot;
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
                    position.getX() + position.getCenterOffsetX(),
                    position.getY() - sprite.getHeight(),
                    position.getDirectionY()), "player");
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
