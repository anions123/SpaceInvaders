package spaceinvaders.engine.misc;

import spaceinvaders.resources.keybindings.Keybinding;
import spaceinvaders.resources.keybindings.keybindings.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class KeybindingController {
    private JComponent component;
    private List<Keybinding> keybindings;

    public KeybindingController(JComponent component){
        this.component = component;
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
