package spaceinvaders.resources.objects.player;

import spaceinvaders.GameRunner;
import spaceinvaders.GameSettings;
import spaceinvaders.engine.GameRules;

import java.io.IOException;

public class PlayerControlls {
    private boolean Left = false;
    private boolean Right = false;
    private boolean Shoot = false;

    private GameSettings gameSettings;
    private GameRules gameRules;

    private static PlayerControlls instance;

    private PlayerControlls(){
        gameSettings = GameSettings.getInstance();
        gameRules = GameRules.getInstance();
    }


    public static PlayerControlls getInstance(){
        if(instance == null){
            instance = new PlayerControlls();
        }
        return instance;
    }

    public void execute(){
        if(Left){
            moveLeft();
        }
        if(Right){
            moveRight();
        }
        if(Shoot){
            shoot();
            Shoot = false;
        }

    }

    private void fixOutOfBounds(){
        if(gameRules.getPlayerPosition_X()< 0)
            gameRules.setPlayerPosition_X(0);
        if(gameRules.getPlayerPosition_X() + gameRules.getPlayerSprite_Width() > gameSettings.getWindowWidth()){
            gameRules.setPlayerPosition_X(gameSettings.getWindowWidth() - gameRules.getPlayerSprite_Width());
        }
    }

    private void moveLeft(){
        //GameRules gameRules = GameRules.getInstance();
        gameRules.translatePlayerPosition(-gameSettings.getPlayerSpeed(), 0);
        fixOutOfBounds();
    }

    private void moveRight(){
        gameRules.translatePlayerPosition(gameSettings.getPlayerSpeed(), 0);
        fixOutOfBounds();
    }

    private void shoot(){
        try {
            gameRules.shootAsPlayer();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public void resetControlls(){
        Left = false;
        Right = false;
        Shoot = false;
    }

    public void setLeft(boolean left) {
        Left = left;
    }

    public void setRight(boolean right) {
        Right = right;
    }

    public void setShoot(boolean shoot) {
        Shoot = shoot;
    }

}
