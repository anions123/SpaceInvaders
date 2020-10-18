package spaceinvaders.resources.timerlisteners;

import spaceinvaders.GameSettings;
import spaceinvaders.engine.GameRules;
import spaceinvaders.resources.objects.Projectile;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProjectileTimerListener implements ActionListener {
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
        if(projectile.getPosition_Y()<=0 || projectile.getPosition_Y() >= GameSettings.windowHeight || tester){
            projectile.setAliveProjectile(false);
            ((Timer)e.getSource()).stop();
        }
    }
}


