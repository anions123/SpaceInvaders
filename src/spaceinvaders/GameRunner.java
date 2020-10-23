package spaceinvaders;

import spaceinvaders.engine.GameRules;
import spaceinvaders.engine.misc.KeybindingController;
import spaceinvaders.engine.misc.TimerController;
import spaceinvaders.resources.keybindings.keybindings.*;
import spaceinvaders.resources.scenes.levels.*;
import spaceinvaders.window.WindowLoader;

import javax.swing.*;


public class GameRunner {

    private TimerController timerController;
    private KeybindingController keybindingController;
    private WindowLoader windowLoader;

    public GameRunner() {
        GameRules.getInstance(new Level0());
        windowLoader = new WindowLoader();
        windowLoader.initialize();
        timerController = TimerController.getInstance(windowLoader.getFMain(), windowLoader.getPInfo());
        timerController.startAllTimers();

        keybindingController = new KeybindingController(windowLoader.getPGame());
        keybindingController.addKeybinding(new PressedAKeybinding());
        keybindingController.addKeybinding(new ReleasedAKeybinding());
        keybindingController.addKeybinding(new PressedDKeybinding());
        keybindingController.addKeybinding(new ReleasedDKeybinding());
        keybindingController.addKeybinding(new ReleasedSPACEKeybinding());
        keybindingController.addKeybinding(new PressedRKeybinding(timerController));
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


