package spaceinvaders.aliengrid;

import spaceinvaders.objects.BaseAlien;

import java.util.List;

public abstract class BaseAlienColumn {
    private int alienCount;
    private List<BaseAlien> alienColumn;

    public BaseAlienColumn(){
        this.alienColumn = setAlienColumn();
        this.alienCount = setAlienCount();
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

    public int getAlienCount(){
        return alienCount;
    }

    public List<BaseAlien> getColumn (){
        return alienColumn;
    }

    public void setColumnPositionX(int x){
        for(BaseAlien ba : alienColumn){
            ba.getPosition().setX(x + ba.getCenterOffset());
        }
    }

    public void moveColumn(int x, int y, double speed){
        alienColumn.forEach(o -> o.getPosition().translate(x, y, speed, 1));
    }
}
