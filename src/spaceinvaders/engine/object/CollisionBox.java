package spaceinvaders.engine.object;

public class CollisionBox {
    private int width;
    private int height;
    private Position position;


    public CollisionBox(int width, int height, Position position){
        this.width = width;
        this.height = height;
        this.position = position;
    }

    public boolean doCollide(CollisionBox collider){
        if(this.position.getX() >= collider.getPositionX()+collider.getWidth()||
        collider.getPositionX() >= this.position.getX() + width){
            return false;
        }

        if(this.position.getY() <= collider.getPositionY()-collider.getHeight()||
                collider.getPositionY() <= this.position.getY() - height){
            return false;
        }

        return true;
    }

    public Position getPosition() { return position; }
    public void setPosition(Position position) { this.position = position; }

    public int getHeight() { return height; }
    public void setHeight(int height) { this.height = height; }

    public int getWidth() { return width; }
    public void setWidth(int width) { this.width = width; }

    public void updateCollision(int width, int height){
        this.width = width;
        this.height = height;

    }

    //lod
    public int getPositionX(){
        return position.getX();
    }
    public int getPositionY(){
        return position.getY();
    }
}
