package spaceinvaders.objects.aliengrid.grids;

import spaceinvaders.GameSettings;
import spaceinvaders.objects.aliengrid.BaseAlienColumn;
import spaceinvaders.objects.aliengrid.BaseAlienGrid;
import spaceinvaders.objects.aliengrid.columns.AlienColumn0;
import spaceinvaders.objects.aliengrid.columns.AlienColumn1;
import spaceinvaders.objects.aliengrid.columns.AlienColumn2;
import spaceinvaders.scenes.BaseLevel;

import java.util.ArrayList;
import java.util.List;

public class AlienGrid1 extends BaseAlienGrid {
    public AlienGrid1(BaseLevel level) {
        super(level);
    }

    @Override
    protected List<BaseAlienColumn> setAlienGrid() {
        List<BaseAlienColumn> alienColumns = new ArrayList<>();
        int pos_x = 0;
        int x_offset = (int)(GameSettings.maxHalfWidth*2.5);
        alienColumns.add(new AlienColumn1());
        alienColumns.get(0).setColumnPositionX(pos_x + 0 * x_offset);
        alienColumns.add(new AlienColumn2());
        alienColumns.get(1).setColumnPositionX(pos_x + 1 * x_offset);
        for(int i = 0; i < 5; i++){
            alienColumns.add(new AlienColumn0());
            alienColumns.get(i+2).setColumnPositionX(pos_x + (i+2) * x_offset);
        }
        alienColumns.add(new AlienColumn2());
        alienColumns.get(7).setColumnPositionX(pos_x + 7 * x_offset);
        alienColumns.add(new AlienColumn1());
        alienColumns.get(8).setColumnPositionX(pos_x + 8 * x_offset);
        return alienColumns;
    }

    @Override
    protected int setAlienColumnCount() {
        return 9;
    }
}
