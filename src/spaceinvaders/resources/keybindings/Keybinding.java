package spaceinvaders.resources.keybindings;

import javax.swing.*;

public interface Keybinding {
    void addInputMap(JComponent component);
    void addActionMap(JComponent component);
}
