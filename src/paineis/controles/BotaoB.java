package paineis.controles;

import relogio.Controlador;

import java.awt.*;
import java.util.function.Function;

class BotaoB extends BotaoBase {
    private final Controlador controlador = Controlador.getInstance();
    private static final String titulo = "B";

    BotaoB() {
        super(titulo);
    }


    @Override
    Function<AWTEvent, Void> onPressed() {
        return ((e) -> {
            controlador.BPressed();
            return null;
        });
    }

    @Override
    Function<AWTEvent, Void> onReleased() {
        return ((e) -> {
            controlador.BReleased();
            return null;
        });
    }
}
