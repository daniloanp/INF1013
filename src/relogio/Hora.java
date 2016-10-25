package relogio;

public enum Hora {
    H0,
    H1,
    H2,
    H3,
    H4,
    H5,
    H6,
    H7,
    H8,
    H9,
    H10,
    H11,
    H12,
    H13,
    H14,
    H15,
    H16,
    H17,
    H18,
    H19,
    H20,
    H21,
    H22,
    H23;

    private static final Hora[] valores = Hora.values();

    public String toString() {
        return String.format("%02d", this.ordinal());
    }

    public Hora Proxima() {
        if (this.ordinal() + 1 < Hora.valores.length) {
            return Hora.valores[this.ordinal() + 1];
        }
        return H0;
    }
}
