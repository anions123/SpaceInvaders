package spaceinvaders.engine.object;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

public class GameObject implements Rendering {
    protected BufferedImage sprite;
    protected Position position;
    protected CollisionBox collisionBox;

    public GameObject(BufferedImage sprite){
        this.sprite = sprite;
        this.position = new Position();
        this.collisionBox = new CollisionBox(sprite.getWidth(), sprite.getHeight(), position);
        setupCenterOffset();
    }

    public GameObject(BufferedImage sprite, Position position){
        this.sprite = sprite;
        this.position = position;
        this.collisionBox = new CollisionBox(sprite.getWidth(), sprite.getHeight(), position);
        setupCenterOffset();
    }

    private void setupCenterOffset(){
        position.setCenterOffsetX(sprite.getWidth()/2);
        position.setCenterOffsetY(sprite.getHeight()/2);
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
            BufferedImage after = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
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

    //lod
    public void setPositionX(int x){
        position.setX(x);
    }
    public void setPositionY(int y){
        position.setY(y);
    }
    public int getPositionX(){
        return position.getX();
    }
    public int getPositionY(){
        return position.getY();
    }
    public void translatePosition(int x, int y){
        position.translate(x, y);
    }
    public int getDirectionY(){
        return position.getDirectionY();
    }
    public int getCenterOffsetX(){
        return position.getCenterOffsetX();
    }
    public int getSpriteHeight(){
        return sprite.getHeight();
    }
    public int getSpriteWidth(){
        return sprite.getWidth();
    }
    public boolean doCollide(CollisionBox collisionBox){
        return this.collisionBox.doCollide(collisionBox);
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(sprite, position.getX(), position.getY(), null);
    }
}
