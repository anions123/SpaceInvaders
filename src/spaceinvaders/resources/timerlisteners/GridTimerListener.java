package spaceinvaders.resources.timerlisteners;

import spaceinvaders.GameSettings;
import spaceinvaders.engine.GameRules;
import spaceinvaders.resources.objects.BaseAlien;
import spaceinvaders.resources.objects.aliengrid.BaseAlienColumn;
import spaceinvaders.resources.objects.aliengrid.BaseAlienGrid;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class GridTimerListener implements ActionListener {
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
        if(gameRules.isGameOn() && gameRules.getLevel() != null){
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



