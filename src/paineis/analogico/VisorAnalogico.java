package paineis.analogico;

import relogio.*;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class VisorAnalogico extends JPanel implements Observer {
    private ImagemRelogio imagem;
    private final double padding = 3.0;

    public VisorAnalogico() throws IOException {
        imagem = new ImagemRelogio();
        Controlador.getInstance().addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        this.repaint();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        final Color corPonteiroSegundos = new Color(255, 200, 0);
        final Color corPonteiroMinutos = new Color(0, 0, 255);
        final Color corPonteiroHora = new Color(255, 0, 0);
        double dim = this.obterDiametro();
        g.drawImage(imagem.obterImagem(), (int) this.padding, (int) this.padding, (int) dim, (int) dim, this);
        Graphics2D g2d = (Graphics2D) g; // strong assertion;
        g2d.setColor(corPonteiroHora);
        final Point2D centro = obterCentro();
        final double raio = dim / 2.0;
        g2d.setStroke(new BasicStroke(7));
        g2d.draw(getLinhaHora(centro, raio));
        g2d.setStroke(new BasicStroke(5));
        g2d.setColor(corPonteiroMinutos);
        g2d.draw(getLinhaMinutos(centro, raio));
        g2d.setStroke(new BasicStroke(3));
        g2d.setColor(corPonteiroSegundos);
        g2d.draw(getLinhaSegundos(centro, raio));
    }

    private Point2D obterCentro() {
        double dim = this.obterDiametro();
        final double x = (this.padding + dim) / 2.0;
        final double y = (this.padding + dim) / 2.0;
        return new Point2D.Double(x, y);
    }

    private double obterDiametro() {
        Dimension size = this.getSize();
        if (size.getWidth() <= size.getHeight()) {
            return (size.getWidth() - this.padding * 2.0);
        }
        return (size.getHeight() - this.padding * 2.0);
    }

    private Line2D getLinhaSegundos(Point2D centro, double raio) {
        return new CriadorDeLinha(centro, raio * .9, this.getHorario().getSegundo().ordinal(), Segundo.values().length).obterLinha();
    }
    
    private Line2D getLinhaMinutos(Point2D centro, double raio) {
        return new CriadorDeLinha(centro, raio * .75, this.getHorario().getMinuto().ordinal(), Minuto.values().length).obterLinha();
    }

    private Line2D getLinhaHora(Point2D centro, double raio) {
        return new CriadorDeLinha(centro, raio * .6, this.getHorario().getHora().ordinal(), Hora.values().length / 2).obterLinha();
    }

    private Horario getHorario() {
        Horario h = Controlador.getInstance().getHorario();
        return h;
    }
}
