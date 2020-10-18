package spaceinvaders.resources.objects.aliengrid.columns;

import spaceinvaders.resources.objects.aliengrid.BaseAlienColumn;
import spaceinvaders.resources.objects.BaseAlien;
import spaceinvaders.resources.objects.aliens.BigAlien;
import spaceinvaders.resources.objects.aliens.MediumAlien;
import spaceinvaders.resources.objects.aliens.SmallAlien;
import spaceinvaders.engine.object.Position;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AlienColumn0 extends BaseAlienColumn {

    @Override
    public List<BaseAlien> setAlienColumn() {
        List<BaseAlien> alienColumn = new ArrayList<>();
        try {
            int y_pos = 0;
            alienColumn.add(new SmallAlien(new Position(0, y_pos, 1)));
            alienColumn.add(new MediumAlien(new Position(0, y_pos + 50, 1)));
            alienColumn.add(new MediumAlien(new Position(0, y_pos + 100, 1)));
            alienColumn.add(new BigAlien(new Position(0, y_pos + 150, 1)));
            alienColumn.add(new BigAlien(new Position(0, y_pos + 200, 1)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return alienColumn;
    }

    @Override
    public int setAlienCount() {
        return 5;
    }

}
