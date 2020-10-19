package spaceinvaders.resources.objects;

import spaceinvaders.engine.misc.TimerController;
import spaceinvaders.engine.object.GameObject;
import spaceinvaders.engine.object.Position;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.IOException;

public class Projectile extends GameObject {
    private String ownerType;
    private boolean aliveProjectile = true;

    public Projectile(Position position, String ownerType) throws IOException {
        super(ImageIO.read(new FileInputStream("src/spaceinvaders/resources/sprites/projectiles/missile.png")), position);
        this.ownerType = ownerType;
        TimerController.getInstance().newProjectile(this);
    }


    public boolean isAliveProjectile() {
        return aliveProjectile;
    }

    public void setAliveProjectile(boolean aliveProjectile) {
        this.aliveProjectile = aliveProjectile;
    }

    public String getOwnerType() {
        return ownerType;
    }

    public void setOwnerType(String ownerType) {
        this.ownerType = ownerType;
    }
}



