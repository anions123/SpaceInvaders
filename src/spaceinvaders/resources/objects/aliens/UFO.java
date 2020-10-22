package spaceinvaders.resources.objects.aliens;

import spaceinvaders.engine.misc.TimerController;
import spaceinvaders.engine.object.Position;
import spaceinvaders.resources.objects.BaseAlien;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.IOException;

public class UFO extends BaseAlien {

    public UFO(Position position) throws IOException {
        super(150,ImageIO.read(new FileInputStream("src/spaceinvaders/resources/sprites/aliens/alienBig.png")), position);
        TimerController.getInstance().newUFO(this);
    }
}
