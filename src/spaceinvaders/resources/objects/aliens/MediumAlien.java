package spaceinvaders.resources.objects.aliens;

import spaceinvaders.engine.object.Position;
import spaceinvaders.resources.objects.BaseAlien;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.IOException;

public class MediumAlien extends BaseAlien {

    public MediumAlien(Position position) throws IOException {
        super(20, ImageIO.read(new FileInputStream("src/spaceinvaders/resources/sprites/aliens/alienMedium.png")), position);
    }
}
