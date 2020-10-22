package spaceinvaders.engine.timerlisteners;

import spaceinvaders.GameSettings;
import spaceinvaders.engine.GameRules;
import spaceinvaders.resources.objects.BaseAlien;
import spaceinvaders.resources.objects.aliengrid.BaseAlienColumn;
import spaceinvaders.resources.objects.aliengrid.BaseAlienGrid;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GridMovementTimerListener implements ActionListener {
    private int directionChangesLeft = 2;
    private GameRules gameRules;
    private BaseAlienGrid alienGrid;
    private GameSettings gameSettings;

    public GridMovementTimerListener(){
        gameSettings = GameSettings.getInstance();
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



    private void changeDirectionIfNeeded(BaseAlienColumn tempColumn){
        if(tempColumn.getColumnPositionX() + tempColumn.getWidthOfWidestAliveAlien()>= gameSettings.getWindowWidth() ||
                tempColumn.getColumnPositionX() <= 0){
            alienGrid.swapDirection();
            directionChangesLeft--;
        }
    }

    private void changeTimerDelay(ActionEvent e){
        if(gameSettings.getGridDelay()>gameSettings.getGridDelayDecay()){
            gameSettings.setGridDelay(gameSettings.getGridDelay()-gameSettings.getGridDelayDecay());
            ((Timer)e.getSource()).setDelay(gameSettings.getGridDelay());
        }
    }

    private void moveAlienGrid(ActionEvent e){
        if(directionChangesLeft<=0){
            alienGrid.moveGrid(0,gameSettings.getGridMoveVerticalSpacing());
            changeTimerDelay(e);
            directionChangesLeft = 2;
            BaseAlien lowestAlien = alienGrid.getLowestAlienInGrid();
            if(lowestAlien == null){
                gameRules.setGameOn(false);
            }
            else{
                if(lowestAlien.getPositionY() + lowestAlien.getSpriteHeight() >= gameRules.getPlayerPositionY()){
                    gameRules.setGameOn(false);
                }
            }
        }
        else{
            alienGrid.moveGrid(gameSettings.getGridMoveHorizontalSpacing() *alienGrid.getMovementDirection(),0);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        alienGrid = gameRules.getAlienGrid();
        //Checks which direction are aliens moving and gets either far left or far right column, based on direction
        BaseAlienColumn tempColumn = getSideAlienColumn();
        //Checks if there are any aliens left alive, if not ends the game
        if(tempColumn == null){
            gameRules.resetGrid();
        }
        else{
            moveAlienGrid(e);
            changeDirectionIfNeeded(tempColumn);
        }
    }
}



