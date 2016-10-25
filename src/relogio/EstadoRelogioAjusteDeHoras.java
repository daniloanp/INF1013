package relogio;

class EstadoRelogioAjusteDeHoras extends EstadoRelogio {
    EstadoRelogioAjusteDeHoras(Relogio relogio, boolean a, boolean b) {
        super(relogio,a,b);
    }

    @Override
    EstadoRelogio APressed() {
        this.a = true;
        if (this.b) {
            return null;
        }
        return new EstadoRelogioAjusteDeMinutos(getRelogio(), this.a,this.b);
    }

    @Override
    EstadoRelogio BPressed() {
        this.b = true;
        if (!this.a) {
            getRelogio().getHorario().proximaHora();
        }
        return null;
    }

    @Override
    Estado getEstado() {
        return Estado.AjusteDeHoras;
    }
}
