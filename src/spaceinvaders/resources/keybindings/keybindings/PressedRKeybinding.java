package spaceinvaders.resources.keybindings.keybindings;

import spaceinvaders.engine.misc.TimerController;
import spaceinvaders.resources.keybindings.Keybinding;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class PressedRKeybinding implements Keybinding {
    private TimerController timerController;

    public PressedRKeybinding(TimerController timerController){
        this.timerController = timerController;
    }

    @Override
    public void addInputMap(JComponent component) {
        component.getInputMap().put(KeyStroke.getKeyStroke("pressed R"), "pause");
    }

    @Override
    public void addActionMap(JComponent component) {
        component.getActionMap().put("pause", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timerController.pauseSwitch();
            }
        });
    }
}
