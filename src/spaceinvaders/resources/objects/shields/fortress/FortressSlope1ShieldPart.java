package spaceinvaders.resources.objects.shields.fortress;

import spaceinvaders.resources.objects.BaseShieldPart;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.IOException;

public class FortressSlope1ShieldPart extends BaseShieldPart {
    public FortressSlope1ShieldPart() throws IOException {
        super(ImageIO.read(new FileInputStream("src/spaceinvaders/resources/sprites/shields/fortress/fortressSlope1.png")), 3);
    }
}
