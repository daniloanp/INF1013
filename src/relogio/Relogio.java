package relogio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

class Relogio extends Observable {
    private Horario horario = new Horario();
    private Timer temporizador;
    private EstadoRelogio estado;

    Relogio() {
        final int decimoDeSegundo = 100;
        temporizador = new Timer(decimoDeSegundo, this.acao());
        temporizador.start();
        estado = EstadoRelogio.obterEstadoInicial(this);
    }

    public Horario getHorario() {
        return horario;
    }

    public Estado getEstado() {
        return estado.getEstado();
    }


    public void APressed() {
        EstadoRelogio proximo = estado.APressed();
        if (proximo != null) {
            this.estado = proximo;
        }
    }

    public void BPressed() {
        EstadoRelogio proximo = estado.BPressed();
        if (proximo != null) {
            this.estado = proximo;
        }
    }

    public void AReleased() {
        EstadoRelogio proximo = estado.AReleased();
        if (proximo != null) {
            this.estado = proximo;
        }
    }

    public void BReleased() {
        EstadoRelogio proximo = estado.BReleased();
        if (proximo != null) {
            this.estado = proximo;
        }
    }

    private ActionListener acao() {
        final Relogio relogio = this;
        return new ActionListener() {
            private final IteradorDeTempo iter = new IteradorDeTempo();

            @Override
            public synchronized void actionPerformed(ActionEvent e) {
                if (iter.passada()) {
                    relogio.horario.incremento();
                }
                relogio.setChanged();
                relogio.notifyObservers(relogio);
            }
        };
    }

    private final class IteradorDeTempo {
        private int contador = 0;

        boolean passada() {
            contador += 1;
            if (contador == 10) {
                contador = 0;
                return true;
            }
            return false;
        }
    }

}
