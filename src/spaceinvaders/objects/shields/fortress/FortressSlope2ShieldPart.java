package spaceinvaders.objects.shields.fortress;

import spaceinvaders.misc.Position;
import spaceinvaders.objects.BaseShieldPart;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.IOException;

public class FortressSlope2ShieldPart extends BaseShieldPart {
    public FortressSlope2ShieldPart() throws IOException {
        super(ImageIO.read(new FileInputStream("src/spaceinvaders/sprites/shields/fortress/fortressSlope2.png")), 3);
    }
}
