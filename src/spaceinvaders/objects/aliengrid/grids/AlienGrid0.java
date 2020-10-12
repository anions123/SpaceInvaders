package spaceinvaders.objects.aliengrid.grids;

import spaceinvaders.GameSettings;
import spaceinvaders.objects.aliengrid.BaseAlienColumn;
import spaceinvaders.objects.aliengrid.BaseAlienGrid;
import spaceinvaders.objects.aliengrid.columns.AlienColumn0;
import spaceinvaders.scenes.BaseLevel;

import java.util.ArrayList;
import java.util.List;

public class AlienGrid0 extends BaseAlienGrid {
    public AlienGrid0(BaseLevel level) {
        super(level);
    }

    @Override
    protected List<BaseAlienColumn> setAlienGrid() {
        List<BaseAlienColumn> alienColumns = new ArrayList<>();
        int pos_x = 0;
        for(int i = 0; i < 11; i++){
            alienColumns.add(new AlienColumn0());
            alienColumns.get(i).setColumnPositionX(pos_x + i*(int)(GameSettings.maxHalfWidth*2.5));
        }
        return alienColumns;
    }

    @Override
    protected int setAlienColumnCount() {
        return 11;
    }
}
