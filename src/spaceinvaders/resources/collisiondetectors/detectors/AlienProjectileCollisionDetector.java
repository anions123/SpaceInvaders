package spaceinvaders.resources.collisiondetectors.detectors;

import spaceinvaders.engine.GameRules;
import spaceinvaders.resources.collisiondetectors.ProjectileCollisionDetector;
import spaceinvaders.resources.objects.BaseAlien;
import spaceinvaders.resources.objects.Projectile;
import spaceinvaders.resources.objects.aliengrid.BaseAlienColumn;

public class AlienProjectileCollisionDetector implements ProjectileCollisionDetector {

    private GameRules gameRules;

    public AlienProjectileCollisionDetector(){
        gameRules = GameRules.getInstance();
    }

    @Override
    public boolean process(Projectile projectile) {
        if(!projectile.getOwnerType().equals("alien")){
            boolean tester;
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