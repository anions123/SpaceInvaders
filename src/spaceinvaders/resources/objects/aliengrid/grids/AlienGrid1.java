package spaceinvaders.resources.objects.aliengrid.grids;

import spaceinvaders.resources.objects.aliengrid.BaseAlienColumn;
import spaceinvaders.resources.objects.aliengrid.BaseAlienGrid;
import spaceinvaders.resources.objects.aliengrid.columns.AlienColumn0;
import spaceinvaders.resources.objects.aliengrid.columns.AlienColumn1;
import spaceinvaders.resources.objects.aliengrid.columns.AlienColumn2;

import java.util.ArrayList;
import java.util.List;

public class AlienGrid1 extends BaseAlienGrid {
    public AlienGrid1() {
        super();
    }

    @Override
    protected List<BaseAlienColumn> setAlienGrid() {
        List<BaseAlienColumn> alienColumns = new ArrayList<>();
        int posX = 0;
        BaseAlienColumn alienColumn10 = new AlienColumn1();
        BaseAlienColumn alienColumn11 = new AlienColumn1();
        BaseAlienColumn alienColumn20 = new AlienColumn2();
        BaseAlienColumn alienColumn21 = new AlienColumn2();
        alienColumn10.setColumnPositionX(posX);
        alienColumn11.setColumnPositionX(posX + 8*(int)(alienColumn11.getWidthOfWidestAliveAlien()*1.25));
        alienColumn20.setColumnPositionX(posX + 1*(int)(alienColumn20.getWidthOfWidestAliveAlien()*1.25));
        alienColumn21.setColumnPositionX(posX + 7*(int)(alienColumn21.getWidthOfWidestAliveAlien()*1.25));

        alienColumns.add(alienColumn10);
        alienColumns.add(alienColumn20);

        BaseAlienColumn alienColumn0;
        for(int i = 0; i < 5; i++){
            alienColumn0 = new AlienColumn0();
            alienColumn0.setColumnPositionX(posX + (i+2)*(int)(alienColumn0.getWidthOfWidestAliveAlien()*1.25));
            alienColumns.add(alienColumn0);
        }
        alienColumns.add(alienColumn21);
        alienColumns.add(alienColumn11);
        return alienColumns;
    }

    @Override
    protected int setAlienColumnCount() {
        return 9;
    }
}
