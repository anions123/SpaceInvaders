package spaceinvaders.misc;

public class CollisionBox {
    private int width;
    private int height;
    private Position position;

    public CollisionBox(Position position){
        this.position = position;
    }

    public CollisionBox(int width, int height, Position position){
        this.width = width;
        this.height = height;
        this.position = position;
    }

    public boolean doCollide(CollisionBox collider){
        if(this.position.getX() >= collider.getPosition().getX()+collider.getWidth()||
        collider.getPosition().getX() >= this.position.getX() + width){
            return false;
        }

        if(this.position.getY() <= collider.getPosition().getY()-collider.getHeight()||
                collider.getPosition().getY() <= this.position.getY() - height){
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
}
