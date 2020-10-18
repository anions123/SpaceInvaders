package spaceinvaders.resources.keybindings.keybindings;

import spaceinvaders.GameRunner;
import spaceinvaders.resources.keybindings.Keybinding;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class PressedAKeybinding implements Keybinding {
    @Override
    public void addInputMap(JComponent component) {
        component.getInputMap().put(KeyStroke.getKeyStroke("pressed A"), "leftOn");
    }

    @Override
    public void addActionMap(JComponent component) {
        component.getActionMap().put("leftOn", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameRunner.LEFT = true;

            }
        });
    }
}
