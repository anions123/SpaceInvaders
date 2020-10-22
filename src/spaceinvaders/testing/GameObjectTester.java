package spaceinvaders.testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import spaceinvaders.engine.object.GameObject;

import java.awt.*;
import java.awt.image.BufferedImage;

public class GameObjectTester {
    private BufferedImage testingSprite;

    public GameObjectTester(){
        testingSprite = new BufferedImage(150, 150, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = testingSprite.createGraphics();
        graphics.setPaint(new Color(150,150,150));
        graphics.fillRect(0,0, 150, 150);
    }

    @Test
    public void givenSmallerWidthShouldResizeImageWidthToMatchIt(){
        //Given
        GameObject gameObject = new GameObject(testingSprite);
        int width = 50;
        //When
        gameObject.resizeSpriteIfBiggerThan(width, gameObject.getSpriteHeight());
        //Then
        assertEquals(50, gameObject.getSpriteWidth(), "If sprite's width is 150 and given width is 50, sprite's width should be changed to 50");
    }

    @Test
    public void givenSmallerHeightShouldResizeImageHeightToMatchIt(){
        //Given
        GameObject gameObject = new GameObject(testingSprite);
        int height = 100;
        //When
        gameObject.resizeSpriteIfBiggerThan(gameObject.getSpriteWidth(), height);
        //Then
        assertEquals(100, gameObject.getSpriteHeight(), "If sprite's height is 150 and given height is 100, sprite's height should be changed to 100");
    }

    @Test
    public void givenLargerWidthAndHeightShouldNotResizeImageToMatchIt(){
        //Given
        GameObject gameObject = new GameObject(testingSprite);
        int height = 200;
        int width = 200;
        //When
        gameObject.resizeSpriteIfBiggerThan(width, height);
        //Then
        assertEquals(150, gameObject.getSpriteWidth(), "If sprite's width is 150 and given width is 200, sprite's width should not change");
        assertEquals(150, gameObject.getSpriteHeight(), "If sprite's height is 150 and given height is 200, sprite's height should not change");
    }
}
