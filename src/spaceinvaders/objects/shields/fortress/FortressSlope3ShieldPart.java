package spaceinvaders.objects.shields.fortress;

import spaceinvaders.misc.Position;
import spaceinvaders.objects.BaseShieldPart;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.IOException;

public class FortressSlope3ShieldPart extends BaseShieldPart {
    public FortressSlope3ShieldPart() throws IOException {
        super(ImageIO.read(new FileInputStream("src/spaceinvaders/sprites/shields/fortress/fortressSlope3.png")), 3);
    }
}
