package spaceinvaders.objects;

import spaceinvaders.GameRules;
import spaceinvaders.GameSettings;
import spaceinvaders.misc.GameObject;
import spaceinvaders.misc.Position;
import spaceinvaders.scenes.BaseLevel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;

public class Projectile extends GameObject {
    private String ownerType;
    private boolean aliveProjectile = true;

    public Projectile(Position position, String ownerType) throws IOException {
        super(ImageIO.read(new FileInputStream("src/spaceinvaders/sprites/projectiles/missile.png")), position);
        this.ownerType = ownerType;
        new Timer(GameSettings.gameDelay, new ProjectileTimerListener(this)).start();
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
    GameRules gameRules;

    public ProjectileTimerListener(Projectile projectile){
        this.projectile = projectile;
        gameRules = GameRules.getInstance();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        projectile.translatePosition(0, GameSettings.projectileSpeed * projectile.getDirection_Y());
        boolean tester = gameRules.projectileCollisionDetection(projectile);
        if(projectile.getPosition_X()<=0 || projectile.getPosition_Y() >= GameSettings.windowHeight || tester){
            projectile.setAliveProjectile(false);
            ((Timer)e.getSource()).stop();
        }
    }
}

