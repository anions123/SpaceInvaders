package spaceinvaders.objects.shields.fortress;

import spaceinvaders.misc.Position;
import spaceinvaders.objects.BaseShieldPart;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FortressSlope1ShieldPart extends BaseShieldPart {
    public FortressSlope1ShieldPart() throws IOException {
        super(ImageIO.read(new FileInputStream("src/spaceinvaders/sprites/shields/fortress/fortressSlope1.png")), 3);
    }
}
