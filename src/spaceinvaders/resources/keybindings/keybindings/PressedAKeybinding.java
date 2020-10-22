package spaceinvaders.resources.keybindings.keybindings;

import spaceinvaders.resources.keybindings.Keybinding;
import spaceinvaders.resources.objects.player.PlayerControls;

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
                PlayerControls.getInstance().setLeft(true);
            }
        });
    }
}
