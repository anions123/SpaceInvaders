package spaceinvaders.aliengrid;

import spaceinvaders.objects.BaseAlien;

import java.util.List;

public abstract class BaseAlienColumn {
    private int alienCount;
    private List<BaseAlien> alienColumn;
    private boolean containsAliveAliens;
    private int columnPositionX;

    public BaseAlienColumn(){
        alienColumn = setAlienColumn();
        alienCount = setAlienCount();
        containsAliveAliens = true;
    }

    protected abstract List<BaseAlien> setAlienColumn();
    protected abstract int setAlienCount();

    public BaseAlien getLastAlive(){
        for (int j = alienColumn.size() - 1; j >= 0; j--) {
            if(alienColumn.get(j).isAlive()){
                return alienColumn.get(j);
            }
        }
        return null;
    }

    public boolean checkIfContainsAliveAliens(){
        if(containsAliveAliens){
            if(getLastAlive().equals(null)){
                containsAliveAliens = false;
            }
        }
        return containsAliveAliens;
    }

    public int getAlienCount(){
        return alienCount;
    }

    public List<BaseAlien> getColumn (){
        return alienColumn;
    }

    public void setColumnPositionX(int x){
        columnPositionX = x;
        for(BaseAlien ba : alienColumn){
            ba.getPosition().setX(x + ba.getPosition().getCenterOffset_x());
        }
    }

    public int getColumnPositionX(){return columnPositionX;}

    public void moveColumn(int x, int y, double speed){
        columnPositionX +=x;
        alienColumn.forEach(o -> o.getPosition().translate(x, y, speed, 1));
    }
}
