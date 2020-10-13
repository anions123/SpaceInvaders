package spaceinvaders.misc;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
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
    public void resizeSpriteIfBiggerThan(int width, int height){
        if(sprite.getWidth() > width || sprite.getHeight() > height){
            int w = sprite.getWidth();
            int h = sprite.getHeight();
            width = Math.min(w, width);
            height = Math.min(h, height);
            BufferedImage after = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
            AffineTransform at = new AffineTransform();
            at.scale((double)width/w, (double)height/h);
            AffineTransformOp scaleOp =
                    new AffineTransformOp(at, AffineTransformOp.TYPE_BILINEAR);
            after = scaleOp.filter(sprite, after);
            sprite = after;
            collisionBox.updateCollision(sprite.getWidth(), sprite.getHeight());
        }

    }

    public Position getPosition(){
        return position;
    }
    public void setPosition(Position position){this.position = position;}

    @Override
    public void render(Graphics g) {
        g.drawImage(sprite, position.getX(), position.getY(), null);
    }
}
