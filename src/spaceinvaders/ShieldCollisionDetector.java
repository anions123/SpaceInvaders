package spaceinvaders;

import spaceinvaders.objects.BaseShield;
import spaceinvaders.objects.BaseShieldPart;
import spaceinvaders.objects.Projectile;

public class ShieldCollisionDetector implements CollisionDetector{
    private GameRules gameRules;

    public ShieldCollisionDetector(){
        gameRules = GameRules.getInstance();
    }

    @Override
    public boolean process(Projectile projectile) {
        boolean tester;
        for(BaseShield s : gameRules.getLevel().getShields()){
            for(BaseShieldPart sp : s.getShield()){
                tester = sp.getCollisionBox().doCollide(projectile.getCollisionBox());
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
