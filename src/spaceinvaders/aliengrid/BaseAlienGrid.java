package spaceinvaders.aliengrid;

import java.util.List;

public abstract class BaseAlienGrid {
    private int alienColumnCount;
    private List<BaseAlienColumn> alienGird;

    public BaseAlienGrid(){
        this.alienColumnCount = setAlienColumnCount();
        this.alienGird = setAlienGrid();
    }

    protected abstract List<BaseAlienColumn> setAlienGrid();
    protected abstract int setAlienColumnCount();


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
