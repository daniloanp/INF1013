package relogio;

class EstadoRelogioExibicao extends EstadoRelogio {

    EstadoRelogioExibicao(Relogio relogio, boolean a, boolean b) {
        super(relogio,a,b);
    }

    @Override
    EstadoRelogio APressed() {
        this.a = true;
        if (this.b) {
            return null;
        }
        return new EstadoRelogioAjusteDeHoras(getRelogio(),a,b);
    }

    @Override
    EstadoRelogio BPressed() {
        this.b = true;
        return null;
    }

    @Override
    Estado getEstado() {
        return Estado.Exibicao;
    }
}
