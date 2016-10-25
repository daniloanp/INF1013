package janelas;

import paineis.digital.VisorDigital;

import javax.swing.*;
import java.awt.*;
import java.util.Observer;

class RelogioDigital extends JDialog {
    private static final String tituloDaJanela = "Relógio Digital";
    private VisorDigital painel = new VisorDigital();


    RelogioDigital(JFrame parent) {
        super(parent, tituloDaJanela);
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.addWindowListener(new WindowListener());
        this.setContentPane(this.painel);
        this.setBounds((int) (screenSize.getWidth() * .35), (int) (screenSize.getHeight() * .3), 0, 0);
        this.getContentPane().setPreferredSize(this.obterPreferredSize());
        this.setMinimumSize(this.obterPreferredSize());
        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.pack();
    }

    private Dimension obterPreferredSize() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        final double widthRatio = (1.0 / 3);
        int width = (int) (screenSize.getWidth() * (widthRatio));
        int height = width / 3;
        return new Dimension(width, height);
    }

    Observer obterObservador() {
        return painel;
    }
}
