package relogio;

public class Horario {
    private Hora hora;
    private Minuto minuto;
    private Segundo segundo;

    private Horario(Hora hora, Minuto minuto, Segundo segundo) {
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }

    Horario() {
        this(Hora.H0, Minuto.M0, Segundo.S0);
    }

    public Hora getHora() {
        return hora;
    }

    public Minuto getMinuto() {
        return minuto;
    }

    public Segundo getSegundo() {
        return segundo;
    }

    void incremento() {
        this.segundo = segundo.Proximo();
        if (this.segundo != Segundo.S0) {
            return;
        }
        this.minuto = minuto.Proximo();
        if (this.minuto != Minuto.M0) {
            return;
        }
        this.hora = this.hora.Proxima();
    }

    void proximoMinuto() {
        this.minuto = minuto.Proximo();
    }

    void proximaHora() {
        this.hora = hora.Proxima();
    }
}
