package spaceinvaders.resources.objects.aliens;

import spaceinvaders.engine.object.Position;
import spaceinvaders.resources.objects.BaseAlien;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.IOException;

public class SmallAlien extends BaseAlien {

    public SmallAlien(Position position) throws IOException {
        super(10, ImageIO.read(new FileInputStream("src/spaceinvaders/resources/sprites/aliens/alienSmall.png")), position);
    }
}
