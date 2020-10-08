package spaceinvaders.objects;

import spaceinvaders.misc.GameObject;
import spaceinvaders.misc.Position;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.IOException;

public class Player extends GameObject {

    public Player() throws IOException {
        super(ImageIO.read(new FileInputStream("src/spaceinvaders/sprites/alienBig.png")));
    }

    public Player(Position position) throws IOException {
        super(ImageIO.read(new FileInputStream("src/spaceinvaders/sprites/alienBig.png")), position);
    }
}
