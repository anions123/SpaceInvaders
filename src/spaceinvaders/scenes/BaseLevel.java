package spaceinvaders.scenes;

import spaceinvaders.aliengrid.BaseAlienGrid;

public abstract class BaseLevel {
    private BaseAlienGrid alienGrid;

    public BaseLevel(BaseAlienGrid alienGrid){
        this.alienGrid = alienGrid;
    }
    public BaseAlienGrid getAlienGrid(){
        return alienGrid;
    }

}
