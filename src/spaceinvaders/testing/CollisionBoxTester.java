package spaceinvaders.testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import spaceinvaders.engine.object.CollisionBox;
import spaceinvaders.engine.object.Position;

public class CollisionBoxTester {
    @Test
    public void shouldReturnTrueIfTwoCollisionBoxesAreTouching(){
        //Given
        CollisionBox firstCollisionBox = new CollisionBox(100, 120, new Position(0, 0));
        CollisionBox secondCollisionBox = new CollisionBox(50, 50, new Position(10, 10));
        //When
        boolean result = firstCollisionBox.doCollide(secondCollisionBox);
        //Then
        assertTrue(result, "When two collision boxes collide should return true");
    }

    @Test
    public void shouldReturnFalseIfTwoCollisionBoxesAreNotTouching(){
        //Given
        CollisionBox firstCollisionBox = new CollisionBox(100, 120, new Position(0, 0));
        CollisionBox secondCollisionBox = new CollisionBox(50, 50, new Position(150, 150));
        //When
        boolean result = firstCollisionBox.doCollide(secondCollisionBox);
        //Then
        assertFalse(result, "When two collision boxes are not colliding should return false");
    }
}
