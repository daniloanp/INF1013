import janelas.JanelaDosControles;

import javax.swing.*;
import java.io.IOException;

public class Principal {
    public static void main(String[] args) {
        try {
            JanelaDosControles janelas = new JanelaDosControles();
            janelas.setVisible(true);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Algum erro ocorreu.", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}
