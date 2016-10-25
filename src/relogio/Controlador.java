package relogio;

public class Controlador extends Relogio {
    private static Controlador instance = null;

    private Controlador() {
        super();
    }

    public static Controlador getInstance() {
        if (instance == null) {
            instance = new Controlador();
        }
        return instance;
    }

}
