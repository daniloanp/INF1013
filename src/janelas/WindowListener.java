package janelas;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class WindowListener extends WindowAdapter {
    @Override
    public void windowClosed(WindowEvent e) {
        final Window w = (Window) e.getSource();
        final Window owner = w.getOwner();
        owner.dispatchEvent(new WindowEvent(owner, WindowEvent.WINDOW_CLOSING));
    }
}
