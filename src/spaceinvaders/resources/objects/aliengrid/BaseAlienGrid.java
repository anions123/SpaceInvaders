package spaceinvaders.resources.objects.aliengrid;

import spaceinvaders.engine.object.Rendering;
import spaceinvaders.resources.objects.BaseAlien;

import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public abstract class BaseAlienGrid implements Rendering {
    private int movementDirection;  //1 = right, -1 = left
    private int alienColumnCount;
    private List<BaseAlienColumn> alienGird;
    private Random random;

    public BaseAlienGrid(){
        movementDirection = 1;
        random = new Random();
        alienColumnCount = setAlienColumnCount();
        alienGird = setAlienGrid();
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
                    if(temp.getPositionY() > lowestAlien.getPositionY()){
                        lowestAlien = temp;
                    }
                }
            }
        }
        return lowestAlien;
    }

    private BaseAlienColumn getRandomAliveColumn(){
        List<BaseAlienColumn> tempColumn = alienGird.stream().filter(BaseAlienColumn::checkIfContainsAliveAliens).collect(Collectors.toList());
        return tempColumn.get(random.nextInt(tempColumn.size()));
    }



    public void moveGrid(int x, int y){
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

