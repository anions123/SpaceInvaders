package spaceinvaders.resources.objects.shields.fortress;

import spaceinvaders.resources.objects.BaseShieldPart;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.IOException;

public class FortressSlope3ShieldPart extends BaseShieldPart {
    public FortressSlope3ShieldPart() throws IOException {
        super(ImageIO.read(new FileInputStream("src/spaceinvaders/resources/sprites/shields/fortress/fortressSlope3.png")), 3);
    }
}
