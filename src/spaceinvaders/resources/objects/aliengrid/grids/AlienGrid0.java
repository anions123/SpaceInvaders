package spaceinvaders.resources.objects.aliengrid.grids;

import spaceinvaders.resources.objects.aliengrid.BaseAlienColumn;
import spaceinvaders.resources.objects.aliengrid.BaseAlienGrid;
import spaceinvaders.resources.objects.aliengrid.columns.AlienColumn0;

import java.util.ArrayList;
import java.util.List;

public class AlienGrid0 extends BaseAlienGrid {
    public AlienGrid0() {
        super();
    }

    @Override
    protected List<BaseAlienColumn> setAlienGrid() {
        List<BaseAlienColumn> alienColumns = new ArrayList<>();
        int pos_x = 0;
        BaseAlienColumn alienColumn;
        for(int i = 0; i < 11; i++){
            alienColumn = new AlienColumn0();
            alienColumns.add(alienColumn);
            alienColumn.setColumnPositionX(pos_x + i*(int)(alienColumn.getWidthOfWidestAliveAlien()*1.25));
        }
        return alienColumns;
    }

    @Override
    protected int setAlienColumnCount() {
        return 11;
    }
}
