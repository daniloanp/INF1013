package paineis.controles;

import relogio.Controlador;

import java.awt.*;
import java.util.function.Function;

class BotaoA extends BotaoBase {
    private final Controlador controlador = Controlador.getInstance();
    private static final String titulo = "A";

    BotaoA() {
        super(titulo);
    }


    @Override
    Function<AWTEvent, Void> onPressed() {
        return ((e) -> {
            controlador.APressed();
            return null;
        });
    }

    @Override
    Function<AWTEvent, Void> onReleased() {
        return ((e) -> {
            controlador.AReleased();
            return null;
        });
    }
}
