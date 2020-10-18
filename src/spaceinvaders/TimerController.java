package spaceinvaders;

import spaceinvaders.objects.BaseAlien;
import spaceinvaders.objects.Projectile;
import spaceinvaders.objects.aliengrid.BaseAlienColumn;
import spaceinvaders.objects.aliengrid.BaseAlienGrid;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TimerController {
    private static List<Timer> timers;
    private static JFrame f_main;
    private static InfoPanel p_info;

    private static TimerController timerController;

    private TimerController(JFrame f_main, InfoPanel p_info){
        timers = new ArrayList<>();
        this.f_main = f_main;
        this.p_info = p_info;
        setupBaseTimers();
    }

    public static TimerController getInstance(JFrame f_main, InfoPanel p_info){
        if(timerController == null){
            timerController = new TimerController(f_main, p_info);
        }
        return timerController;
    }

    public static TimerController getInstance(){
        if(timerController == null){
            throw new RuntimeException("Need to add JFrame and InfoPanel first");
        }
        return timerController;
    }

    private void setupBaseTimers(){
        timers.add(new Timer(GameSettings.gameDelay, new GameTimerListener(f_main, p_info)));
        timers.add(new Timer(GameSettings.gridDelay, new GridTimerListener()));
    }

    public void addNewProjectileTimer(Projectile projectile){
        Timer timer = new Timer(GameSettings.projectileSpeed, new ProjectileTimerListener(projectile));
        timer.start();
        timers.add(timer);
    }

    public void startAllTimers(){
        for(Timer t : timers){
            t.start();
        }
    }

    public void stopAllTimers(){
        for(Timer t : timers){
            t.stop();
        }
    }
}


class GridTimerListener implements ActionListener {
    private int directionChangesLeft = 2;
    private GameRules gameRules;
    private BaseAlienGrid alienGrid;

    public GridTimerListener(){
        gameRules = GameRules.getInstance();
    }

    private BaseAlienColumn getSideAlienColumn(){
        BaseAlienColumn tempColumn;
        if(alienGrid.getMovementDirection() == 1){
            tempColumn = alienGrid.getFarRightAliveColumn();
        }
        else{
            tempColumn = alienGrid.getFarLeftAliveColumn();
        }
        return tempColumn;
    }

    private void randomAlienShoot(){
        try {
            alienGrid.shootAsRandomAlien();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void changeDirectionIfNeeded(BaseAlienColumn tempColumn){
        if(tempColumn.getColumnPositionX() + tempColumn.getWidthOfWidestAliveAlien()>= GameSettings.windowWidth ||
                tempColumn.getColumnPositionX() <= 0){
            alienGrid.swapDirection();
            directionChangesLeft--;
        }
    }

    private void changeTimerDelay(ActionEvent e){
        if(GameSettings.gridDelay>GameSettings.gridDelayDecay){
            GameSettings.gridDelay-= GameSettings.gridDelayDecay;
            ((Timer)e.getSource()).setDelay(GameSettings.gridDelay);
        }
    }

    private void moveAlienGrid(ActionEvent e){
        if(directionChangesLeft<=0){
            alienGrid.moveGrid(0,GameSettings.maxHalfHeight*2,1);
            changeTimerDelay(e);
            directionChangesLeft = 2;
            BaseAlien lowestAlien = alienGrid.getLowestAlienInGrid();
            if(lowestAlien == null){
                gameRules.setGameOn(false);
            }
            else{
                if(lowestAlien.getPosition_Y() + lowestAlien.getSpriteHeight() >= gameRules.getPlayerPosition_Y()){
                    gameRules.setGameOn(false);
                }
            }
        }
        else{
            alienGrid.moveGrid(GameSettings.maxHalfWidth*2/3 *alienGrid.getMovementDirection(),0,1);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(gameRules.isGameOn() && gameRules.getAlienGrid() != null){
            alienGrid = gameRules.getAlienGrid();
            //Checks which direction are aliens moving and gets either far left or far right column, based on direction
            BaseAlienColumn tempColumn = getSideAlienColumn();
            //Checks if there are any aliens left alive, if not ends the game
            if(tempColumn == null){
                gameRules.setGameOn(false);
            }
            else{
                randomAlienShoot();
                //Checks if gird has reach the end of window, if so it changes movement direction
                changeDirectionIfNeeded(tempColumn);
                moveAlienGrid(e);
            }
        }
        else{
            ((Timer)e.getSource()).stop();
        }

    }
}

class ProjectileTimerListener implements ActionListener{
    Projectile projectile;
    GameRules gameRules;

    public ProjectileTimerListener(Projectile projectile){
        this.projectile = projectile;
        gameRules = GameRules.getInstance();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        projectile.translatePosition(0, GameSettings.projectileSpeed * projectile.getDirection_Y());
        boolean tester = gameRules.projectileCollisionDetection(projectile);
        if(projectile.getPosition_X()<=0 || projectile.getPosition_Y() >= GameSettings.windowHeight || tester){
            projectile.setAliveProjectile(false);
            ((Timer)e.getSource()).stop();
        }
    }
}

class GameTimerListener implements ActionListener{
    private JFrame f_main;
    private InfoPanel p_info;
    private GameRules gameRules;

    public GameTimerListener(JFrame f_main, InfoPanel p_info){
        this.f_main = f_main;
        this.p_info = p_info;
        gameRules = GameRules.getInstance();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(f_main != null && f_main.isDisplayable() && gameRules.isGameOn()){
            if(Main.LEFT || Main.RIGHT){
                int left = Main.LEFT ? 1 : 0;
                int right = Main.RIGHT ? 1 : 0;
                gameRules.translatePlayerPosition(-GameSettings.playerSpeed* left +
                        GameSettings.playerSpeed*right, 0);
                if(gameRules.getPlayerPosition_X()< 0)
                    gameRules.setPlayerPosition_X(0);
                if(gameRules.getPlayerPosition_X() + gameRules.getPlayerSprite_Height() > GameSettings.windowWidth){
                    gameRules.setPlayerPosition_X(GameSettings.windowWidth - gameRules.getPlayerSprite_Width());
                }

            }
            if(Main.SHOOTING){
                try {
                    gameRules.shootAsPlayer();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            }
            Main.SHOOTING = false;
            f_main.repaint();
            p_info.updateValues();
        }
        else{
            System.out.println(f_main != null);
            System.out.println(f_main.isDisplayable());
            System.out.println(gameRules.isGameOn());
            ((Timer)e.getSource()).stop();
        }
    }
}


