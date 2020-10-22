package spaceinvaders.testing;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import spaceinvaders.engine.GameRules;
import spaceinvaders.engine.misc.TimerController;
import spaceinvaders.resources.scenes.levels.Level0;

public class TimerControllerTester {

    private TimerController timerController;

    public TimerControllerTester(){
        GameRules gameRules = GameRules.getInstance(new Level0());
        timerController = TimerController.getInstance(null, null);
    }

    @Test
    public void pauseShouldBeSetToTrueIfItWasSetToFalse(){
        //Given
        timerController.setPause(true);
        //When
        timerController.pauseSwitch();
        boolean result = timerController.getPause();
        //Then
        assertFalse(result, "Using pause switch when pause is true, it should set it to false");
    }

    @Test
    public void pauseShouldBeSetToFalseIfItWasSetToTrue(){
        //Given
        timerController.setPause(false);
        //When
        timerController.pauseSwitch();
        boolean result = timerController.getPause();
        //Then
        assertTrue(result, "Using pause switch when pause is false, it should set it to true");
    }
}
