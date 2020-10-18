package spaceinvaders.engine.object;


public class Position {
    private int x;
    private int y;
    private int centerOffset_x;
    private int centerOffset_y;
    private int direction_y;

    public Position(){
    }

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Position(int x, int y, int direction_y){
        this.x = x;
        this.y = y;
        this.direction_y = direction_y;
    }

    public Position(int x, int y, int direction_y, int centerOffset_x, int centerOffset_y){
        this.x = x;
        this.y = y;
        this.centerOffset_x = centerOffset_x;
        this.centerOffset_y = centerOffset_y;
        this.direction_y = direction_y;
    }

    public void translate(int x, int y){
        this.x += x;
        this.y += y;
    }

    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }

    public void setCenterOffset_x(int x){
        this.centerOffset_x = x;
    }
    public int getCenterOffset_x(){
        return centerOffset_x;
    }

    public void setCenterOffset_y(int y){
        this.centerOffset_y = y;
    }
    public int getCenterOffset_y(){
        return centerOffset_y;
    }

    public int getDirection_y() {
        return direction_y;
    }

    public void setDirection_y(int direction_y) {
        this.direction_y = direction_y;
    }
}
