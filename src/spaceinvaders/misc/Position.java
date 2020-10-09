package spaceinvaders.misc;


public class Position {
    private int x;
    private int y;
    private int centerOffset_x;
    private int centerOffset_y;

    public Position(){
        x = 0;
        y = 0;
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

    public void setCenterOffset_x(int x){ this.centerOffset_x = x; }
    public int getCenterOffset_x(){return centerOffset_x;}

    public void setCenterOffset_y(int y){ this.centerOffset_y = y; }
    public int getCenterOffset_y(){return centerOffset_y;}
}
