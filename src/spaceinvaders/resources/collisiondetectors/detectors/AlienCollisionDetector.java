package spaceinvaders.resources.collisiondetectors.detectors;

import spaceinvaders.engine.GameRules;
import spaceinvaders.resources.collisiondetectors.CollisionDetector;
import spaceinvaders.resources.objects.BaseAlien;
import spaceinvaders.resources.objects.Projectile;
import spaceinvaders.resources.objects.aliengrid.BaseAlienColumn;

public class AlienCollisionDetector implements CollisionDetector {

    private GameRules gameRules;

    @Override
    public boolean process(Projectile projectile) {
        gameRules = GameRules.getInstance();
        boolean tester;
        if(!projectile.getOwnerType().equals("alien")){
            for(BaseAlienColumn al : gameRules.getAllAlienColumns()){
                for(BaseAlien a : al.getColumn()){
                    tester = a.doCollide(projectile.getCollisionBox());
                    if(tester){
                        if(a.isAlive()){
                            a.setAlive(false);
                            gameRules.addScore(a.getPoints());
                            return true;
                        }
                        else{
                            return false;
                        }

                    }
                }
            }
        }
        return false;
    }
}