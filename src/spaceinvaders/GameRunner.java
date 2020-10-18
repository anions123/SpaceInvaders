package spaceinvaders;

import spaceinvaders.engine.misc.CollisionDetectorFactory;
import spaceinvaders.engine.GameRules;
import spaceinvaders.engine.misc.KeybindingController;
import spaceinvaders.engine.misc.TimerController;
import spaceinvaders.resources.scenes.levels.*;
import spaceinvaders.window.WindowLoader;

import javax.swing.*;


public class GameRunner {

    private TimerController timerController;
    public static boolean LEFT, RIGHT, SHOOTING = false;
    private KeybindingController keybindingController;
    private GameRules gameRules;
    private WindowLoader windowLoader;

    public GameRunner() {
        gameRules = GameRules.getInstance(new Level0(), new CollisionDetectorFactory());
        windowLoader = new WindowLoader();
        windowLoader.initialize();
        timerController = TimerController.getInstance(windowLoader.getFMain(), windowLoader.getPInfo());
        timerController.startAllTimers();
        keybindingController = KeybindingController.getInstance(windowLoader.getPGame(), timerController);
        keybindingController.setupKeybindings();

    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new GameRunner();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}


