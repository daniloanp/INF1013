package paineis.controles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.function.Function;

abstract class BotaoBase extends JButton {
    private static final Color corPadrao = new Color(192, 192, 192);
    private static final Color corAtivo = new Color(180, 255, 255);

    BotaoBase(String title) {
        super(title);
        super.setContentAreaFilled(false);
        this.addKeyListener(this.obterKeyListener());
        this.addMouseListener(this.obterMouseListener());
        this.setBackground(BotaoBase.corPadrao);
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isPressed()) {
            g.setColor(BotaoBase.corAtivo);
        } else {
            g.setColor(BotaoBase.corPadrao);
        }
        g.fillRect(0, 0, getWidth(), getHeight());


        super.paintComponent(g);
    }

    private KeyListener obterKeyListener() {
        final BotaoBase self = this;
        return new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                self.onPressed().apply(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                self.onReleased().apply(e);
            }
        };
    }

    private MouseListener obterMouseListener() {
        final BotaoBase self = this;
        return new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                self.onPressed().apply(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                self.onReleased().apply(e);
            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        };
    }

    abstract Function<AWTEvent, Void> onPressed();

    abstract Function<AWTEvent, Void> onReleased();
}
