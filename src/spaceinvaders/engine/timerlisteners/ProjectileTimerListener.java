package spaceinvaders.engine.timerlisteners;

import spaceinvaders.GameSettings;
import spaceinvaders.engine.misc.CollisionDetectorFactory;
import spaceinvaders.resources.collisiondetectors.ProjectileCollisionDetector;
import spaceinvaders.resources.objects.Projectile;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProjectileTimerListener implements ActionListener {
    private Projectile projectile;
    private GameSettings gameSettings;
    private CollisionDetectorFactory collisionDetectorFactory;

    public ProjectileTimerListener(Projectile projectile){
        gameSettings = GameSettings.getInstance();
        this.collisionDetectorFactory = new CollisionDetectorFactory();
        this.projectile = projectile;
    }

    public boolean projectileCollisionDetection(Projectile projectile){
        for(ProjectileCollisionDetector cd : collisionDetectorFactory.getCollisionDetectors()){
            if(cd.process(projectile)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        projectile.translatePosition(0, gameSettings.getProjectileSpeed() * projectile.getDirectionY());
        boolean tester = projectileCollisionDetection(projectile);
        if(projectile.getPositionY()<=0 || projectile.getPositionY() >= gameSettings.getWindowHeight() || tester){
            projectile.setAliveProjectile(false);
            ((Timer)e.getSource()).stop();
        }
    }
}



