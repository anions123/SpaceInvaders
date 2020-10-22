package spaceinvaders.engine.object;


public class Position {
    private int x;
    private int y;
    private int centerOffsetX;
    private int centerOffsetY;
    private int directionY;

    public Position(){
    }

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Position(int x, int y, int directionY){
        this.x = x;
        this.y = y;
        this.directionY = directionY;
    }

    public Position(int x, int y, int directionY, int centerOffsetX, int centerOffsetY){
        this.x = x;
        this.y = y;
        this.centerOffsetX = centerOffsetX;
        this.centerOffsetY = centerOffsetY;
        this.directionY = directionY;
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

    public void setCenterOffsetX(int x){
        this.centerOffsetX = x;
    }
    public int getCenterOffsetX(){
        return centerOffsetX;
    }

    public void setCenterOffsetY(int y){
        this.centerOffsetY = y;
    }
    public int getCenterOffsetY(){
        return centerOffsetY;
    }

    public int getDirectionY() {
        return directionY;
    }

    public void setDirectionY(int directionY) {
        this.directionY = directionY;
    }
}
