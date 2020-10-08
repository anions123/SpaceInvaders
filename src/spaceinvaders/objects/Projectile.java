package spaceinvaders.objects;

import spaceinvaders.misc.GameObject;
import spaceinvaders.misc.Position;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.IOException;

public class Projectile extends GameObject {
    public Projectile() throws IOException {
        super(ImageIO.read(new FileInputStream("src/spaceinvaders/sprites/alienSmall.png")));
    }

    public Projectile(Position position) throws IOException {
        super(ImageIO.read(new FileInputStream("src/spaceinvaders/sprites/alienSmall.png")), position);
    }
}
