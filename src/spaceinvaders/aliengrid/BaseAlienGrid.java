package spaceinvaders.aliengrid;

import java.util.List;

public abstract class BaseAlienGrid {
    private int movementDirection;  //1 = right, -1 = left
    private int alienColumnCount;
    private List<BaseAlienColumn> alienGird;

    public BaseAlienGrid(){
        movementDirection = 1;
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

    public void moveGrid(int x, int y, double speed){
        alienGird.forEach(o -> o.moveColumn(x, y, speed));
    }

    public int getAlienColumnCount(){
        return alienColumnCount;
    }

    public List<BaseAlienColumn> getGrid (){
        return alienGird;
    }

}
