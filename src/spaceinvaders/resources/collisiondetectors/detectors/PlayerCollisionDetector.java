package spaceinvaders.resources.collisiondetectors.detectors;

import spaceinvaders.engine.GameRules;
import spaceinvaders.resources.collisiondetectors.CollisionDetector;
import spaceinvaders.resources.objects.Projectile;

public class PlayerCollisionDetector implements CollisionDetector {

    private GameRules gameRules;

    public PlayerCollisionDetector(){
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
