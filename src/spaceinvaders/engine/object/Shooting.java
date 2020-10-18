package spaceinvaders.engine.object;


import java.io.IOException;

public interface Shooting {
    boolean canShoot();
    void shoot() throws IOException;
}
