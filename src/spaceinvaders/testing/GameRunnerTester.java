package spaceinvaders.testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import spaceinvaders.engine.GameRules;
import spaceinvaders.resources.scenes.levels.Level0;

public class GameRunnerTester {
    private GameRules gameRules;

    public GameRunnerTester(){
        gameRules = GameRules.getInstance(new Level0());
    }

    @Test
    public void shouldReturnTrueIfPlayerLivesLeftIsLessOrEqualThanZero(){
        //Given
        gameRules.setPlayerLivesLeft(0);
        //When
        boolean result = gameRules.isPlayerDead();
        //Then
        assertTrue(result, "If player has 0 lives, returns true");
    }

    @Test
    public void shouldReturnFalseIfPlayerLivesLeftIsMoreThanZero(){
        //Given
        gameRules.setPlayerLivesLeft(1);
        //When
        boolean result = gameRules.isPlayerDead();
        //Then
        assertFalse(result, "If player has 1 live, returns false");
    }
}
