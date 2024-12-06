package wallet.view.components;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

public class MyCheckbox extends JCheckBox {
    public MyCheckbox() {

        setForeground(Color.BLACK); // Color de texto
        setFont(new Font("sansserif", 1, 10));
        ImageIcon icon = new ImageIcon("src/resources/N-Check.png");
        setIcon(icon); // Ícono cuando no está seleccionado
        setSelectedIcon(new ImageIcon("src/resources/Check.png")); // Ícono cuando está seleccionado

    }

}
