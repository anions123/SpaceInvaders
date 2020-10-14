package spaceinvaders;

import spaceinvaders.objects.Projectile;

public class PlayerCollisionDetector implements CollisionDetector{

    private GameRules gameRules;

    public PlayerCollisionDetector(){
        gameRules = GameRules.getInstance();
    }

    @Override
    public boolean process(Projectile projectile) {
        boolean tester;
        if(!projectile.getOwnerType().equals("player")){
            tester = gameRules.getPlayer().getCollisionBox().doCollide(projectile.getCollisionBox());
            if(tester){
                gameRules.getPlayer().decLivesLeft();
                if(gameRules.isPlayerDead()){
                    gameRules.setGameOn(false);
                }
                return true;
            }
        }
        return false;
    }
}
