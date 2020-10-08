package spaceinvaders.objects;

import spaceinvaders.misc.GameObject;
import spaceinvaders.misc.Position;

import java.awt.image.BufferedImage;

public abstract class BaseAlien extends GameObject {
    private int points;
    private boolean isAlive;
    private static int maxHalfWidth = 32;
    private final int centerOffset;

    public BaseAlien(int points, BufferedImage image) {
        super(image);
        this.points = points;
        this.isAlive = true;
        this.centerOffset = maxHalfWidth - image.getWidth()/2;
    }

    public BaseAlien(int points, BufferedImage image, Position position){
        super(image, position);
        this.points = points;
        this.isAlive = true;
        this.centerOffset = maxHalfWidth - image.getWidth()/2;
    }

    public int getPoints() {
        return points;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public int getCenterOffset() {
        return centerOffset;
    }
}
