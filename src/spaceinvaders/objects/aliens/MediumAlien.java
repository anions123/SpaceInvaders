package spaceinvaders.objects.aliens;

import spaceinvaders.misc.Position;
import spaceinvaders.objects.BaseAlien;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.IOException;

public class MediumAlien extends BaseAlien {

    public MediumAlien(Position position) throws IOException {
        super(20, ImageIO.read(new FileInputStream("src/spaceinvaders/sprites/alienMedium.png")), position);
    }
}
