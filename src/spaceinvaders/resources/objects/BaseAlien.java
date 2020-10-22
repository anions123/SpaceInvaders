package spaceinvaders.resources.objects;

import spaceinvaders.engine.object.GameObject;
import spaceinvaders.engine.object.Position;
import spaceinvaders.engine.object.Shooting;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public abstract class BaseAlien extends GameObject implements Shooting {
    private int points;
    private boolean isAlive;
    private Projectile projectile;

    public BaseAlien(int points, BufferedImage image, Position position){
        super(image, position);
        this.points = points;
        this.isAlive = true;
    }

    public Projectile getProjectile() {
        return projectile;
    }

    public int getPoints() {
        return points;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
    @Override
    public boolean canShoot(){
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
                    position.getY() + sprite.getHeight(),
                    position.getDirectionY()), "alien");
        }
    }

    @Override
    public void render(Graphics g){
        if(isAlive){
            g.drawImage(sprite, position.getX(), position.getY(), null);
        }
        if(projectile != null && projectile.isAliveProjectile()){
            projectile.render(g);
        }

    }
}
