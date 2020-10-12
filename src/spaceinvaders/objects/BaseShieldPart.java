package spaceinvaders.objects;

import spaceinvaders.misc.GameObject;
import spaceinvaders.misc.Position;

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

    public int getMaxLives() {
        return maxLives;
    }

    public void setMaxLives(int maxLives) {
        this.maxLives = maxLives;
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
            g.drawImage(super.getSprite(), super.getPosition().getX(), super.getPosition().getY(), null);
            g.drawString(currentLives+"/"+maxLives, super.getPosition().getX(), super.getPosition().getY());
        }

    }
}
