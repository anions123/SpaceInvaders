package spaceinvaders.objects.aliens;

import spaceinvaders.misc.Position;
import spaceinvaders.objects.BaseAlien;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.IOException;

public class SmallAlien extends BaseAlien {
    public SmallAlien() throws IOException {
        super(10, ImageIO.read(new FileInputStream("src/spaceinvaders/sprites/alienSmall.png")));
    }
    public SmallAlien(Position position) throws IOException {
        super(10, ImageIO.read(new FileInputStream("src/spaceinvaders/sprites/alienSmall.png")), position);
    }
}