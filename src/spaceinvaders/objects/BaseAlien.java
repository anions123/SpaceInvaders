package spaceinvaders.objects;

import spaceinvaders.GameRules;
import spaceinvaders.misc.GameObject;
import spaceinvaders.misc.Position;

import java.awt.image.BufferedImage;

public abstract class BaseAlien extends GameObject implements GameRules {
    private int points;
    private boolean isAlive;

    public BaseAlien(int points, BufferedImage image, Position position){
        super(image, position);
        this.points = points;
        this.isAlive = true;
        super.getPosition().setCenterOffset_x(maxHalfWidth - image.getWidth()/2);
        super.getPosition().setCenterOffset_y(maxHalfHeight - image.getHeight()/2);
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
}
