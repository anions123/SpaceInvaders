package spaceinvaders.misc;


public class Position {
    private int x;
    private int y;

    public Position(){
        this.x = 0;
        this.y = 0;
    }

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void translate(int x, int y, double speed, long deltaTime){
        this.x += x * speed * deltaTime;
        this.y += y * speed * deltaTime;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
}
