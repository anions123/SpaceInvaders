package spaceinvaders.objects;

import spaceinvaders.GameSettings;
import spaceinvaders.misc.Rendering;
import spaceinvaders.misc.Position;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseShield implements Rendering {
    private List<BaseShieldPart> shield;
    private Position position;
    private int cellWidth;
    private int cellHeight;

    public BaseShield(Position position, int cellHeight, int cellWidth){
        this.shield = new ArrayList<>();
        this.position = position;
        this.cellHeight = cellHeight;
        this.cellWidth = cellWidth;
        setupShield();
    }

    protected abstract void setupShield();

    public void addShieldPartByGrid(BaseShieldPart shieldPart, int grid_x, int grid_y){
        shieldPart.getPosition().setX(position.getX() + grid_x * cellWidth);
        shieldPart.getPosition().setY(position.getY() + grid_y * cellHeight);
        //Resize part if its bigger than cell size
        shieldPart.resizeSpriteIfBiggerThan(cellWidth, cellHeight);

        shield.add(shieldPart);
    }

    public List<BaseShieldPart> getShield() {
        return shield;
    }

    public void setShield(List<BaseShieldPart> shield) {
        this.shield = shield;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public void render(Graphics g){
        for(BaseShieldPart sp : shield){
            sp.render(g);
        }
    }
}
