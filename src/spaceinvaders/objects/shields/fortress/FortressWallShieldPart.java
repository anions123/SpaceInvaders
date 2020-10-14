package spaceinvaders.objects.shields.fortress;

import spaceinvaders.misc.Position;
import spaceinvaders.objects.BaseShieldPart;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.IOException;

public class FortressWallShieldPart extends BaseShieldPart {
    public FortressWallShieldPart() throws IOException {
        super(ImageIO.read(new FileInputStream("src/spaceinvaders/sprites/shields/fortress/fortressWall.png")), 3);
    }
}
