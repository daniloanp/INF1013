package paineis.analogico;

import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

class CriadorDeLinha {
    private static final double anguloBase = -Math.PI / 2;
    private Point2D centro;
    private double raio;
    private double progresso;
    private double total;

    CriadorDeLinha(Point2D centro, double raio, double progresso, double total) {
        this.centro = centro;
        this.raio = raio;
        this.progresso = progresso;
        this.total = total;
    }

    Line2D.Double obterLinha() {
        return new Line2D.Double(centro, pontoDestino());
    }

    private double obterAngulo() {
        return (progresso * 2 * Math.PI / total) + anguloBase;
    }

    private Point2D pontoDestino() {
        final double angulo = obterAngulo();
        final double x = centro.getX() + Math.cos(angulo) * raio;
        final double y = centro.getX() + Math.sin(angulo) * raio;
        return new Point2D.Double(x, y);
    }
}