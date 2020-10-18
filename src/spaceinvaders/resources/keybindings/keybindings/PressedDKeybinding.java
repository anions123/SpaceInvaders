package spaceinvaders.resources.keybindings.keybindings;

import spaceinvaders.GameRunner;
import spaceinvaders.resources.keybindings.Keybinding;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class PressedDKeybinding implements Keybinding {
    @Override
    public void addInputMap(JComponent component) {
        component.getInputMap().put(KeyStroke.getKeyStroke("pressed D"), "rightOn");
    }

    @Override
    public void addActionMap(JComponent component) {
        component.getActionMap().put("rightOn", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameRunner.RIGHT = true;
            }
        });
    }
}
