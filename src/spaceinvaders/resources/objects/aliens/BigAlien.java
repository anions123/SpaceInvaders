package spaceinvaders.resources.objects.aliens;

import spaceinvaders.engine.object.Position;
import spaceinvaders.resources.objects.BaseAlien;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.IOException;

public class BigAlien extends BaseAlien {

    public BigAlien(Position position) throws IOException {
        super(30, ImageIO.read(new FileInputStream("src/spaceinvaders/resources/sprites/aliens/alienBig.png")), position);
    }
}
