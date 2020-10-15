package spaceinvaders.objects.aliengrid;

import spaceinvaders.GameRules;
import spaceinvaders.GameSettings;
import spaceinvaders.misc.Rendering;
import spaceinvaders.objects.BaseAlien;
import spaceinvaders.scenes.BaseLevel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public abstract class BaseAlienGrid implements Rendering {
    private int movementDirection;  //1 = right, -1 = left
    private int alienColumnCount;
    private List<BaseAlienColumn> alienGird;

    public BaseAlienGrid(){
        movementDirection = 1;
        alienColumnCount = setAlienColumnCount();
        alienGird = setAlienGrid();
        new Timer(GameSettings.gridDelay, new GridTimerListener()).start();
    }

    protected abstract List<BaseAlienColumn> setAlienGrid();
    protected abstract int setAlienColumnCount();


    public void swapDirection(){
        movementDirection*=-1;
    }

    public int getMovementDirection(){
        return movementDirection;
    }

    public BaseAlienColumn getFarRightAliveColumn(){
        BaseAlienColumn alienColumn;
        for(int i = alienGird.size() - 1; i>=0; i--){
            alienColumn = alienGird.get(i);
            if(alienColumn.checkIfContainsAliveAliens())return alienColumn;
        }
        return null;
    }

    public BaseAlienColumn getFarLeftAliveColumn(){
        BaseAlienColumn alienColumn;
        for(int i = 0; i<alienGird.size(); i++){
            alienColumn = alienGird.get(i);
            if(alienColumn.checkIfContainsAliveAliens())return alienColumn;
        }
        return null;
    }

    public BaseAlien getLowestAlienInGrid(){
        BaseAlien lowestAlien = null;
        BaseAlien temp;
        for(BaseAlienColumn ac : alienGird){
            if(ac.checkIfContainsAliveAliens()){
                temp = ac.getLastAlive();
                if(lowestAlien == null){
                    lowestAlien = temp;
                }
                else{
                    if(temp.getPosition_Y() > lowestAlien.getPosition_Y()){
                        lowestAlien = temp;
                    }
                }
            }
        }
        return lowestAlien;
    }

    private BaseAlienColumn getRandomAliveColumn(){
        List<BaseAlienColumn> tempColumn = alienGird.stream().filter(f->f.checkIfContainsAliveAliens()).collect(Collectors.toList());
        Random rand = new Random();
        return tempColumn.get(rand.nextInt(tempColumn.size()));
    }



    public void moveGrid(int x, int y, double speed){
        alienGird.forEach(o -> o.moveColumn(x, y));
    }

    public int getAlienColumnCount(){
        return alienColumnCount;
    }

    public List<BaseAlienColumn> getGrid (){
        return alienGird;
    }

    //lod
    public void shootAsRandomAlien() throws IOException {
        BaseAlienColumn chosenColumn = getRandomAliveColumn();
        BaseAlien lastAlien = chosenColumn.getLastAlive();
        lastAlien.shoot();
    }

    @Override
    public void render(Graphics g) {
        for(BaseAlienColumn ac : alienGird){
            ac.render(g);
        }
    }
}

class GridTimerListener implements ActionListener{
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
