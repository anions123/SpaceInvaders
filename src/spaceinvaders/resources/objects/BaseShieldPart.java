package spaceinvaders.resources.objects;

import spaceinvaders.engine.object.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class BaseShieldPart extends GameObject {
    private int maxLives;
    private int currentLives;

    public BaseShieldPart(BufferedImage sprite, int maxLives){
        super(sprite);
        this.maxLives = maxLives;
        this.currentLives = maxLives;
    }

    public int getCurrentLives() {
        return currentLives;
    }

    public void decCurrentLives() {
        this.currentLives--;
    }

    public void setCurrentLives(int currentLives) {
        this.currentLives = currentLives;
    }

    @Override
    public void render(Graphics g){
        if(currentLives > 0){
            g.drawImage(sprite, position.getX(), position.getY(), null);
            g.drawString(currentLives+"/"+maxLives, position.getX(), position.getY() + 10);
        }

    }
}
