package spaceinvaders.objects;

import spaceinvaders.GameSettings;
import spaceinvaders.aliengrid.BaseAlienGrid;
import spaceinvaders.misc.GameObject;
import spaceinvaders.misc.Position;
import spaceinvaders.scenes.BaseLevel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;

public class Projectile extends GameObject {
    private String ownerType;
    private boolean aliveProjectile = true;

    public Projectile(Position position, BaseLevel level, String ownerType) throws IOException {
        super(ImageIO.read(new FileInputStream("src/spaceinvaders/sprites/alienSmall.png")), position);
        this.ownerType = ownerType;
        new Timer(GameSettings.gameDelay, new ProjectileTimerListener(this, level)).start();
    }


    public boolean isAliveProjectile() {
        return aliveProjectile;
    }

    public void setAliveProjectile(boolean aliveProjectile) {
        this.aliveProjectile = aliveProjectile;
    }

    public String getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }
}

class ProjectileTimerListener implements ActionListener{
    Projectile projectile;
    BaseLevel level;

    public ProjectileTimerListener(Projectile projectile, BaseLevel level){
        this.projectile = projectile;
        this.level = level;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        projectile.getPosition().translate(0, GameSettings.projectileSpeed * projectile.getPosition().getDirection_y());
        boolean tester = level.projectileCollisionDetector(projectile);
        if(projectile.getPosition().getY()<=0 || projectile.getPosition().getY() >= GameSettings.windowHeight || tester){
            projectile.setAliveProjectile(false);
            ((Timer)e.getSource()).stop();
        }
    }
}

