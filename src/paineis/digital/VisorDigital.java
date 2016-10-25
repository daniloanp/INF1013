package paineis.digital;

import relogio.Controlador;
import relogio.Estado;
import relogio.Horario;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class VisorDigital extends JPanel implements Observer {
    private JLabel horario = new JLabel("00:00");

    public VisorDigital() {
    	Controlador.getInstance().addObserver(this);
        this.setLayout(new GridBagLayout());
        this.adicionarHorario();
    }

    private void adicionarHorario() {
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        this.add(this.horario, c);
    }

    @Override
    public void update(Observable o, Object arg) {
        this.horario.setText(this.obterHorario());
    }
    

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Font font = obterFont();
        this.horario.setFont(font);
        Dimension size = this.getSize();
        if (size.getHeight() * 5 < size.getWidth()) {
            this.setSize(new Dimension((int) size.getHeight(), (int) (size.getSize().getHeight() * 5.5)));
        }

    }

    private String obterHorario() {
        final Estado estado = Controlador.getInstance().getEstado();
        final Horario horario = Controlador.getInstance().getHorario();
        String minuto = horario.getMinuto().toString();
        String hora = horario.getHora().toString();
        if (estado == Estado.AjusteDeHoras) {
            hora = String.format("<font color=red>%s</font>", hora);
        } else if (estado == Estado.AjusteDeMinutos) {
            minuto = String.format("<font color=red>%s</font>", minuto);
        }
        return String.format("<html>%s:%s</html>", hora, minuto);
    }



    private Font obterFont() {
        return new Font(Font.MONOSPACED, Font.PLAIN, this.getHeight());
    }
}
