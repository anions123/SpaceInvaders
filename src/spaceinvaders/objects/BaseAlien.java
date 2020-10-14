package spaceinvaders.objects;

import spaceinvaders.GameSettings;
import spaceinvaders.misc.GameObject;
import spaceinvaders.misc.Position;
import spaceinvaders.misc.Shooting;
import spaceinvaders.scenes.BaseLevel;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public abstract class BaseAlien extends GameObject implements Shooting {
    private int points;
    private boolean isAlive;
    private Projectile projectile;
    private boolean canShoot = true;

    public BaseAlien(int points, BufferedImage image, Position position){
        super(image, position);
        resizeSpriteIfBiggerThan(GameSettings.maxHalfWidth*2, GameSettings.maxHalfHeight*2);
        this.points = points;
        this.isAlive = true;
        super.getPosition().setCenterOffset_x(GameSettings.maxHalfWidth - image.getWidth()/2);
        super.getPosition().setCenterOffset_y(GameSettings.maxHalfHeight - image.getHeight()/2);
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
                    super.getPosition().getX() + super.getPosition().getCenterOffset_x(),
                    super.getPosition().getY() + super.getSprite().getHeight(),
                    super.getPosition().getDirection_y()), "alien");
        }
    }

    @Override
    public void render(Graphics g){
        if(isAlive){
            g.drawImage(super.getSprite(), super.getPosition().getX(), super.getPosition().getY(), null);
            g.drawString("x: "+super.getPosition().getX(), super.getPosition().getX(), super.getPosition().getY()+10);
            g.drawString("y: "+super.getPosition().getY(), super.getPosition().getX(), super.getPosition().getY()+30);
        }
        if(projectile != null && projectile.isAliveProjectile()){
            projectile.render(g);
        }

    }
}
