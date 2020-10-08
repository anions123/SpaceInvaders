package spaceinvaders.aliengrid.columns;

import spaceinvaders.aliengrid.BaseAlienColumn;
import spaceinvaders.objects.BaseAlien;
import spaceinvaders.objects.aliens.BigAlien;
import spaceinvaders.objects.aliens.MediumAlien;
import spaceinvaders.objects.aliens.SmallAlien;
import spaceinvaders.misc.Position;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AlienColumn0 extends BaseAlienColumn {

    @Override
    public List<BaseAlien> setAlienColumn() {
        List<BaseAlien> alienColumn = new ArrayList<>();
        try {
            int y_pos = 100;
            alienColumn.add(new SmallAlien(new Position(0, y_pos)));
            alienColumn.add(new MediumAlien(new Position(0, y_pos + 50)));
            alienColumn.add(new MediumAlien(new Position(0, y_pos + 100)));
            alienColumn.add(new BigAlien(new Position(0, y_pos + 150)));
            alienColumn.add(new BigAlien(new Position(0, y_pos + 200)));
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
