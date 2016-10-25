package janelas;

import paineis.analogico.VisorAnalogico;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Observer;

class RelogioAnalogico extends JDialog {
    private final static String tituloDaJanela = "Relógio Analogico";
    private VisorAnalogico painel = new VisorAnalogico();

    RelogioAnalogico(JFrame parent) throws IOException {
        super(parent, tituloDaJanela);
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setContentPane(painel);
        Dimension size = this.obterPreferredSize();
        this.setBounds(0, (int) (screenSize.getHeight() * .3), size.width, size.height);
        this.getContentPane().setPreferredSize(size);
        this.setResizable(false);
        this.addWindowListener(new WindowListener());
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.pack();
    }

    private Dimension obterPreferredSize() {
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        final int tamanho = (int) (screenSize.getWidth() * (1 / 3.0));
        return new Dimension(tamanho, tamanho);
    }

    Observer obterObservador() {
        return painel;
    }
}
