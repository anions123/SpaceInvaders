package spaceinvaders.resources.keybindings.keybindings;

import spaceinvaders.resources.keybindings.Keybinding;
import spaceinvaders.resources.objects.player.PlayerControls;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ReleasedAKeybinding implements Keybinding {

    @Override
    public void addInputMap(JComponent component) {
        component.getInputMap().put(KeyStroke.getKeyStroke("released A"), "leftOff");
    }

    @Override
    public void addActionMap(JComponent component) {
        component.getActionMap().put("leftOff", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PlayerControls.getInstance().setLeft(false);
            }
        });
    }
}
