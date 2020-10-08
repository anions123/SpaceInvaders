package spaceinvaders.misc;

import java.awt.image.BufferedImage;

public class GameObject{
    private BufferedImage sprite;
    private Position position;

    public GameObject(BufferedImage sprite){
        this.position = new Position();
        this.sprite = sprite;
    }

    public GameObject(BufferedImage sprite, Position position){
        this.position = position;
        this.sprite = sprite;
    }

    public BufferedImage getSprite(){
        return this.sprite;
    }
    public Position getPosition(){
        return this.position;
    }
}
