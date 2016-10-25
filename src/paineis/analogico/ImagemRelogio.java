package paineis.analogico;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

class ImagemRelogio {
    private Image imagem;

    ImagemRelogio() throws IOException {
    	final String imagePath = "resources/analogico.jpg";
        imagem = ImageIO.read(new File(imagePath));
    }

    Image obterImagem() {
        return imagem;
    }
}
