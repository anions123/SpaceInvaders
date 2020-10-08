package spaceinvaders.aliengrid.grids;

import spaceinvaders.aliengrid.BaseAlienColumn;
import spaceinvaders.aliengrid.BaseAlienGrid;
import spaceinvaders.aliengrid.columns.AlienColumn0;
import spaceinvaders.aliengrid.columns.AlienColumn1;
import spaceinvaders.aliengrid.columns.AlienColumn2;

import java.util.ArrayList;
import java.util.List;

public class AlienGrid1 extends BaseAlienGrid {
    @Override
    protected List<BaseAlienColumn> setAlienGrid() {
        List<BaseAlienColumn> alienColumns = new ArrayList<>();
        int pos_x = 100;
        alienColumns.add(new AlienColumn1());
        alienColumns.get(0).setColumnPositionX(pos_x + 0*70);
        alienColumns.add(new AlienColumn2());
        alienColumns.get(1).setColumnPositionX(pos_x + 1*70);
        for(int i = 0; i < 5; i++){
            alienColumns.add(new AlienColumn0());
            alienColumns.get(i+2).setColumnPositionX(pos_x + (i+2)*70);
        }
        alienColumns.add(new AlienColumn2());
        alienColumns.get(7).setColumnPositionX(pos_x + 7*70);
        alienColumns.add(new AlienColumn1());
        alienColumns.get(8).setColumnPositionX(pos_x + 8*70);
        return alienColumns;
    }

    @Override
    protected int setAlienColumnCount() {
        return 9;
    }
}
