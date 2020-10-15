package spaceinvaders;

import spaceinvaders.objects.BaseAlien;
import spaceinvaders.objects.Projectile;
import spaceinvaders.objects.aliengrid.BaseAlienColumn;

public class AlienCollisionDetector implements CollisionDetector{

    private GameRules gameRules;

    public AlienCollisionDetector(){
        gameRules = GameRules.getInstance();
    }

    @Override
    public boolean process(Projectile projectile) {
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
