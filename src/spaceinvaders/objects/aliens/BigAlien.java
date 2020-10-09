package spaceinvaders.objects.aliens;

import spaceinvaders.misc.Position;
import spaceinvaders.objects.BaseAlien;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.IOException;

public class BigAlien extends BaseAlien {

    public BigAlien(Position position) throws IOException {
        super(30, ImageIO.read(new FileInputStream("src/spaceinvaders/sprites/alienBig.png")), position);
    }
}
