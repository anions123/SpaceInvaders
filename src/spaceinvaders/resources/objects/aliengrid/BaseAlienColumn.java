package spaceinvaders.resources.objects.aliengrid;

import spaceinvaders.engine.object.Rendering;
import spaceinvaders.resources.objects.BaseAlien;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BaseAlienColumn implements Rendering {
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
        BaseAlien alien;
        for (int j = alienColumn.size() - 1; j >= 0; j--) {
            alien = alienColumn.get(j);
            if(alien.isAlive()){
                return alien;
            }
        }
        return null;
    }

    private List<BaseAlien> getAllAliveAliens(){
        return alienColumn.stream().filter(BaseAlien::isAlive).collect(Collectors.toList());
    }

    public boolean checkIfContainsAliveAliens(){
        if(containsAliveAliens && getLastAlive() == null){
            containsAliveAliens = false;
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
            ba.setPositionX(x + getWidthOfWidestAliveAlien()/2 - ba.getCenterOffsetX());
        }
    }

    public int getColumnPositionX(){return columnPositionX;}

    public int getWidthOfWidestAliveAlien(){
        List<BaseAlien> aliveAliens = getAllAliveAliens();
        if(aliveAliens.isEmpty()){
            return 0;
        }
        BaseAlien widest = aliveAliens.get(0);
        for(BaseAlien ba : aliveAliens){
            if(ba.getSpriteWidth() > widest.getSpriteWidth()){
                widest = ba;
            }
        }
        return widest.getSpriteWidth();
    }

    public void moveColumn(int x, int y){
        columnPositionX +=x;
        alienColumn.forEach(o -> o.translatePosition(x, y));
    }

    public void render(Graphics g) {
        for(BaseAlien a : alienColumn){
            a.render(g);
        }
    }
}
