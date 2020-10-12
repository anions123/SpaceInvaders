package spaceinvaders.objects.shields.fortress;

import spaceinvaders.misc.Position;
import spaceinvaders.objects.BaseShield;

import java.io.IOException;

public class FortressShield extends BaseShield {

    public FortressShield(Position position) {
        super(position, 24, 24);
    }

    @Override
    protected void setupShield() {
        try {
            //first layer
            super.addShieldPartByGrid(
                    new FortressSlope1ShieldPart(),
                    0,
                    0
            );
            super.addShieldPartByGrid(
                    new FortressWallShieldPart(),
                    1,
                    0
            );
            super.addShieldPartByGrid(
                    new FortressWallShieldPart(),
                    2,
                    0
            );
            super.addShieldPartByGrid(
                    new FortressSlope2ShieldPart(),
                    3,
                    0
            );

            //second layer
            super.addShieldPartByGrid(
                    new FortressWallShieldPart(),
                    0,
                    1
            );

            super.addShieldPartByGrid(
                    new FortressSlope3ShieldPart(),
                    1,
                    1
            );
            super.addShieldPartByGrid(
                    new FortressSlope4ShieldPart(),
                    2,
                    1
            );
            super.addShieldPartByGrid(
                    new FortressWallShieldPart(),
                    3,
                    1
            );
            //third layer
            super.addShieldPartByGrid(
                    new FortressWallShieldPart(),
                    0,
                    2
            );
            super.addShieldPartByGrid(
                    new FortressWallShieldPart(),
                    3,
                    2
            );

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
