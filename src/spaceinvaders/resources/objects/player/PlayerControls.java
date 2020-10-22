package spaceinvaders.resources.objects.player;

import spaceinvaders.GameSettings;
import spaceinvaders.engine.GameRules;

import java.io.IOException;

public class PlayerControls {
    private boolean left = false;
    private boolean right = false;
    private boolean shoot = false;

    private GameSettings gameSettings;
    private GameRules gameRules;

    private static PlayerControls instance;

    private PlayerControls(){
        gameSettings = GameSettings.getInstance();
        gameRules = GameRules.getInstance();
    }


    public static PlayerControls getInstance(){
        if(instance == null){
            instance = new PlayerControls();
        }
        return instance;
    }

    public void execute(){
        if(left){
            moveLeft();
        }
        if(right){
            moveRight();
        }
        if(shoot){
            shoot();
            shoot = false;
        }

    }

    private void fixOutOfBounds(){
        if(gameRules.getPlayerPositionX()< 0)
            gameRules.setPlayerPositionX(0);
        if(gameRules.getPlayerPositionX() + gameRules.getPlayerSpriteWidth() > gameSettings.getWindowWidth()){
            gameRules.setPlayerPositionX(gameSettings.getWindowWidth() - gameRules.getPlayerSpriteWidth());
        }
    }

    private void moveLeft(){
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

    public void resetControls(){
        left = false;
        right = false;
        shoot = false;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public void setShoot(boolean shoot) {
        this.shoot = shoot;
    }

}
