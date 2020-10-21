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
        if(this.position.getX() >= collider.getPosition_X()+collider.getWidth()||
        collider.getPosition_X() >= this.position.getX() + width){
            return false;
        }

        if(this.position.getY() <= collider.getPosition_Y()-collider.getHeight()||
                collider.getPosition_Y() <= this.position.getY() - height){
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
    public int getPosition_X(){
        return position.getX();
    }
    public int getPosition_Y(){
        return position.getY();
    }
}
