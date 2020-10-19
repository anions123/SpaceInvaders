package spaceinvaders.resources.collisiondetectors.detectors;

import spaceinvaders.engine.GameRules;
import spaceinvaders.resources.collisiondetectors.CollisionDetector;
import spaceinvaders.resources.objects.Projectile;

public class UFOCollisionDetector implements CollisionDetector {
    private GameRules gameRules;

    public UFOCollisionDetector(){
        gameRules = GameRules.getInstance();
    }

    @Override
    public boolean process(Projectile projectile) {
        if(projectile.getOwnerType().equals("player")){
            boolean tester;
            if(!gameRules.isUFONull()){
                tester = gameRules.isUFOColliding(projectile.getCollisionBox());
                if(tester){
                    gameRules.addScore(gameRules.getUFOPoints());
                    gameRules.setUFOAliveState(false);
                    return true;
                }
            }

        }
        return false;
    }
}
