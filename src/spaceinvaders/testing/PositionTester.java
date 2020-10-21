package spaceinvaders.testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import spaceinvaders.engine.object.Position;

public class PositionTester {
    @Test
    public void translatingPositionXShouldChangeItsX(){
        //Given
        Position position = new Position();
        position.setX(0);
        //When
        position.translate(100,0);
        //Then
        assertEquals(100,position.getX(),"Translating position's x by 100, should change it by 100");
    }

    @Test
    public void translatingPositionYShouldChangeItsY(){
        //Given
        Position position = new Position();
        position.setY(0);
        //When
        position.translate(0,150);
        //Then
        assertEquals(150,position.getY(),"Translating position's y by 150, should change it by 150");
    }
}
