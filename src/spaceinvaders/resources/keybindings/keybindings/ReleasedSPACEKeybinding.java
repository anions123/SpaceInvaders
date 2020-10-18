package spaceinvaders.resources.keybindings.keybindings;

import spaceinvaders.GameRunner;
import spaceinvaders.resources.keybindings.Keybinding;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ReleasedSPACEKeybinding implements Keybinding {
    @Override
    public void addInputMap(JComponent component) {
        component.getInputMap().put(KeyStroke.getKeyStroke("released SPACE"), "shoot");
    }

    @Override
    public void addActionMap(JComponent component) {
        component.getActionMap().put("shoot", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GameRunner.SHOOTING = true;
            }
        });

    }
}
