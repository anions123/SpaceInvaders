package spaceinvaders.resources.collisiondetectors.detectors;

import spaceinvaders.engine.GameRules;
import spaceinvaders.resources.collisiondetectors.ProjectileCollisionDetector;
import spaceinvaders.resources.objects.BaseShield;
import spaceinvaders.resources.objects.BaseShieldPart;
import spaceinvaders.resources.objects.Projectile;

public class ShieldProjectileCollisionDetector implements ProjectileCollisionDetector {
    private GameRules gameRules;

    public ShieldProjectileCollisionDetector(){
        gameRules = GameRules.getInstance();
    }

    @Override
    public boolean process(Projectile projectile) {
        boolean tester;
        for(BaseShield s : gameRules.getShields()){
            for(BaseShieldPart sp : s.getShield()){
                tester = sp.doCollide(projectile.getCollisionBox());
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
}
