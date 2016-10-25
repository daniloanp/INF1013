package janelas;

import paineis.controles.Controles;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class JanelaDosControles extends JFrame {
    private RelogioAnalogico analogico = new RelogioAnalogico(this);
    private RelogioDigital digital = new RelogioDigital(this);

    public JanelaDosControles() throws IOException {
        final Controles controles = new Controles();
        this.setContentPane(controles);
        this.setSize(this.obterPreferredSize());
        this.setMinimumSize(this.obterPreferredSize());
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.pack();
    }

    private Dimension obterPreferredSize() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = (int) (screenSize.getWidth() * .3);
        int height = (int) (screenSize.getHeight() * .15);
        return new Dimension(width, height);
    }

    public void setVisible(boolean visible) {
        super.setVisible(visible);
        digital.setVisible(visible);
        analogico.setVisible(visible);
    }

}
