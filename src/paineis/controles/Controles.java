package paineis.controles;

import javax.swing.*;
import java.awt.*;

public class Controles extends JPanel {
    public Controles() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 0.5;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(10, 10, 10, 10);
        c.gridx = 0;
        c.gridy = 0;
        this.add(new BotaoA(), c);
        c.gridx = 1;
        this.add(new BotaoB(), c);
    }
}

