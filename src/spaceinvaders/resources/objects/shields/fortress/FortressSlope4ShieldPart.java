package spaceinvaders.resources.objects.shields.fortress;

import spaceinvaders.resources.objects.BaseShieldPart;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.IOException;

public class FortressSlope4ShieldPart extends BaseShieldPart {
    public FortressSlope4ShieldPart() throws IOException {
        super(ImageIO.read(new FileInputStream("src/spaceinvaders/resources/sprites/shields/fortress/fortressSlope4.png")), 3);
    }
}
