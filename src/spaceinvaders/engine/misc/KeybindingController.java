package spaceinvaders.engine.misc;

import spaceinvaders.resources.keybindings.Keybinding;
import spaceinvaders.resources.keybindings.keybindings.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class KeybindingController {
    private JComponent component;
    private List<Keybinding> keybindings;
    private TimerController timerController;

    private static KeybindingController instance;

    public KeybindingController(JComponent component, TimerController timerController){
        this.component = component;
        this.timerController = timerController;
        keybindings = new ArrayList<>();
        initializeKeybindings();
    }

    public static KeybindingController getInstance(){
        if(instance == null){
            throw new RuntimeException("Need to call getInstance with initialization attributes");
        }
        return instance;
    }

    public static KeybindingController getInstance(JComponent component, TimerController timerController){
        if(instance == null){
            instance = new KeybindingController(component, timerController);
        }
        return instance;
    }

    public void addKeybinding(Keybinding keybinding){
        keybindings.add(keybinding);
    }

    private void initializeKeybindings(){
        keybindings.add(new PressedAKeybinding());
        keybindings.add(new ReleasedAKeybinding());
        keybindings.add(new PressedDKeybinding());
        keybindings.add(new ReleasedDKeybinding());
        keybindings.add(new ReleasedSPACEKeybinding());
        keybindings.add(new PressedRKeybinding(timerController));
    }

    public void setupKeybindings(){
        for(Keybinding k : keybindings){
            k.addInputMap(component);
            k.addActionMap(component);
        }
    }
}
