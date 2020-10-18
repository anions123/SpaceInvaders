package spaceinvaders.resources.objects.shields.fortress;

import spaceinvaders.resources.objects.BaseShieldPart;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.IOException;

public class FortressSlope2ShieldPart extends BaseShieldPart {
    public FortressSlope2ShieldPart() throws IOException {
        super(ImageIO.read(new FileInputStream("src/spaceinvaders/resources/sprites/shields/fortress/fortressSlope2.png")), 3);
    }
}
