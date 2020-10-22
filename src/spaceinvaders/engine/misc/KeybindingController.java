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

    public KeybindingController(JComponent component, TimerController timerController){
        this.component = component;
        this.timerController = timerController;
        keybindings = new ArrayList<>();
    }

    public void addKeybinding(Keybinding keybinding){
        keybindings.add(keybinding);
    }

    public void setupKeybindings(){
        for(Keybinding k : keybindings){
            k.addInputMap(component);
            k.addActionMap(component);
        }
    }
}
