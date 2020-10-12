package spaceinvaders.misc;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GameObject implements Rendering {
    private BufferedImage sprite;
    private Position position;
    private CollisionBox collisionBox;

    public GameObject(){
        this.sprite = null;
        this.position = new Position();
        this.collisionBox = new CollisionBox(position);
    }

    public GameObject(BufferedImage sprite){
        this.sprite = sprite;
        this.position = new Position();
        this.collisionBox = new CollisionBox(sprite.getWidth(), sprite.getHeight(), position);
    }

    public GameObject(BufferedImage sprite, Position position){
        this.sprite = sprite;
        this.position = position;
        this.collisionBox = new CollisionBox(sprite.getWidth(), sprite.getHeight(), position);
    }

    public GameObject(BufferedImage sprite, Position position, CollisionBox collisionBox){
        this.sprite = sprite;
        this.position = position;
        this.collisionBox = collisionBox;
    }


    public CollisionBox getCollisionBox(){return collisionBox;}
    public void setCollisionBox(CollisionBox collisionBox){this.collisionBox = collisionBox;}

    public BufferedImage getSprite(){
        return sprite;
    }
    public void setSprite(BufferedImage sprite){this.sprite = sprite;}

    public Position getPosition(){
        return position;
    }
    public void setPosition(Position position){this.position = position;}

    @Override
    public void render(Graphics g) {
        g.drawImage(sprite, position.getX(), position.getY(), null);
    }
}
