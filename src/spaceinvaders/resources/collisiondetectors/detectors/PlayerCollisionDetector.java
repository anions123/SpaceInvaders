package spaceinvaders.resources.collisiondetectors.detectors;

import spaceinvaders.engine.GameRules;
import spaceinvaders.resources.collisiondetectors.CollisionDetector;
import spaceinvaders.resources.objects.Projectile;

public class PlayerCollisionDetector implements CollisionDetector {

    private GameRules gameRules;

    @Override
    public boolean process(Projectile projectile) {
        boolean tester;
        gameRules = GameRules.getInstance();
        if(!projectile.getOwnerType().equals("player")){
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
