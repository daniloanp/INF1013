package relogio;

class EstadoRelogioAjusteDeMinutos extends EstadoRelogio {
    EstadoRelogioAjusteDeMinutos(Relogio relogio, boolean a, boolean b) {
        super(relogio,a,b);
        
    }

    @Override
    EstadoRelogio APressed() {
        this.a = true;
        if (this.b) {
            return null;
        }
        return new EstadoRelogioExibicao(getRelogio(),this.a,this.b);
    }

    @Override
    EstadoRelogio BPressed() {
        this.b = true;
        if (!this.a) {
            getRelogio().getHorario().proximoMinuto();
        }
        return null;
    }

    @Override
    Estado getEstado() {
        return Estado.AjusteDeMinutos;
    }

}
