package spaceinvaders.aliengrid;

import spaceinvaders.GameSettings;
import spaceinvaders.Rendering;
import spaceinvaders.misc.CollisionBox;
import spaceinvaders.objects.BaseAlien;
import spaceinvaders.objects.Player;
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

    public BaseAlienGrid(BaseLevel level){
        movementDirection = 1;
        alienColumnCount = setAlienColumnCount();
        alienGird = setAlienGrid();
        new Timer(GameSettings.gridDelay, new GridTimerListener(level)).start();
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
        for(int i = alienGird.size() - 1; i>=0; i--){
            if(alienGird.get(i).checkIfContainsAliveAliens())return alienGird.get(i);
        }
        return null;
    }

    public BaseAlienColumn getFarLeftAliveColumn(){
        for(int i = 0; i<alienGird.size(); i++){
            if(alienGird.get(i).checkIfContainsAliveAliens())return alienGird.get(i);
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
                    if(temp.getPosition().getY() > lowestAlien.getPosition().getY()){
                        lowestAlien = temp;
                    }
                }
            }
        }
        return lowestAlien;
    }

    public BaseAlienColumn getRandomAliveColumn(){
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

    public void render(Graphics g) {
        for(BaseAlienColumn ac : alienGird){
            ac.render(g);
        }
    }
}

class GridTimerListener implements ActionListener{
    private BaseLevel level;
    private int directionChangesLeft = 2;

    public GridTimerListener(BaseLevel level){
        this.level = level;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(GameSettings.gameOn && level.getAlienGrid() != null){
            //Checks which direction are aliens moving and gets either far left or far right column, based on direction
            BaseAlienColumn tempColumn;
            if(level.getAlienGrid().getMovementDirection() == 1){
                tempColumn = level.getAlienGrid().getFarRightAliveColumn();
            }
            else{
                tempColumn = level.getAlienGrid().getFarLeftAliveColumn();
            }

            //Checks if there are any aliens left alive, if not ends the game
            if(tempColumn == null){
                GameSettings.gameOn = false;
            }
            else{
                try {
                    level.getAlienGrid().getRandomAliveColumn().getLastAlive().shoot(level);
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                //Checks if gird has reach the end of window, if so it changes movement direction
                if(tempColumn.getColumnPositionX() + GameSettings.maxHalfWidth * 2>= GameSettings.windowWidth ||
                        tempColumn.getColumnPositionX() <= 0){
                    level.getAlienGrid().swapDirection();
                    directionChangesLeft--;
                }

                if(directionChangesLeft<=0){
                    level.getAlienGrid().moveGrid(0,GameSettings.maxHalfHeight*2,1);
                    if(GameSettings.gridDelay>GameSettings.gridDelayDecay){
                        GameSettings.gridDelay-= GameSettings.gridDelayDecay;
                        ((Timer)e.getSource()).setDelay(GameSettings.gridDelay);
                    }
                    directionChangesLeft = 2;
                    BaseAlien lowestAlien = level.getAlienGrid().getLowestAlienInGrid();
                    if(lowestAlien == null){
                        GameSettings.gameOn = false;
                    }
                    else{
                        if(lowestAlien.getPosition().getY() + lowestAlien.getSprite().getHeight() >= level.getPlayer().getPosition().getY()){
                            GameSettings.gameOn = false;
                        }
                    }
                }
                else{
                    level.getAlienGrid().moveGrid(GameSettings.maxHalfWidth*2/3 * level.getAlienGrid().getMovementDirection(),0,1);
                }


            }

        }
        else{
            ((Timer)e.getSource()).stop();
        }

    }
}
