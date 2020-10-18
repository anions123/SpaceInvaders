package spaceinvaders.objects;

import spaceinvaders.TimerController;
import spaceinvaders.misc.GameObject;
import spaceinvaders.misc.Position;

import javax.imageio.ImageIO;
import java.io.FileInputStream;
import java.io.IOException;

public class Projectile extends GameObject {
    private String ownerType;
    private boolean aliveProjectile = true;
    private TimerController timerController;

    public Projectile(Position position, String ownerType) throws IOException {
        super(ImageIO.read(new FileInputStream("src/spaceinvaders/sprites/projectiles/missile.png")), position);
        this.ownerType = ownerType;
        timerController = TimerController.getInstance();
        timerController.addNewProjectileTimer(this);
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



