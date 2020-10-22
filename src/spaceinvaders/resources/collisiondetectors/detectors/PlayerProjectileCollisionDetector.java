package spaceinvaders.resources.collisiondetectors.detectors;

import spaceinvaders.engine.GameRules;
import spaceinvaders.resources.collisiondetectors.ProjectileCollisionDetector;
import spaceinvaders.resources.objects.Projectile;

public class PlayerProjectileCollisionDetector implements ProjectileCollisionDetector {

    private GameRules gameRules;

    public PlayerProjectileCollisionDetector(){
        gameRules = GameRules.getInstance();
    }

    @Override
    public boolean process(Projectile projectile) {
        if(!projectile.getOwnerType().equals("player")){
            boolean tester;
            tester = gameRules.isPlayerColliding(projectile.getCollisionBox());
            if(tester){
                gameRules.decPlayerLives();
                if(gameRules.isPlayerDead()){
                    gameRules.setGameOn(false);
                }
                return true;
            }
        }
        return false;
    }
}
