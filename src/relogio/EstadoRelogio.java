package relogio;

abstract class EstadoRelogio {
    private Relogio relogio;
    protected boolean a;
    protected boolean b;

    EstadoRelogio(Relogio relogio, boolean a, boolean b) {
        this.relogio = relogio;
        this.a = a;
        this.b = b;
    }

    static EstadoRelogio obterEstadoInicial(Relogio relogio) {
        return new EstadoRelogioExibicao(relogio, false,false);
    }

    abstract EstadoRelogio APressed();

    abstract EstadoRelogio BPressed();


    EstadoRelogio AReleased() {
        this.a = false;
        return null;
    }

    EstadoRelogio BReleased() {
        this.b = false;
        return null;
    }

    protected Relogio getRelogio() {
        return this.relogio;
    }

    abstract Estado getEstado();
}
