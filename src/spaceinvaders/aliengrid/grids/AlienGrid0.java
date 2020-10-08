package spaceinvaders.aliengrid.grids;

import spaceinvaders.aliengrid.BaseAlienColumn;
import spaceinvaders.aliengrid.BaseAlienGrid;
import spaceinvaders.aliengrid.columns.AlienColumn0;

import java.util.ArrayList;
import java.util.List;

public class AlienGrid0 extends BaseAlienGrid {

    @Override
    protected List<BaseAlienColumn> setAlienGrid() {
        List<BaseAlienColumn> alienColumns = new ArrayList<>();
        int pos_x = 100;
        for(int i = 0; i < 11; i++){
            alienColumns.add(new AlienColumn0());
            alienColumns.get(i).setColumnPositionX(pos_x + i*70);
        }
        return alienColumns;
    }

    @Override
    protected int setAlienColumnCount() {
        return 11;
    }
}
