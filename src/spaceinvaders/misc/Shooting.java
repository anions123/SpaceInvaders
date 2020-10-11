package spaceinvaders.misc;


import spaceinvaders.scenes.BaseLevel;

import java.io.IOException;

public interface Shooting {
    boolean canShoot();
    void shoot(BaseLevel level) throws IOException;
}
