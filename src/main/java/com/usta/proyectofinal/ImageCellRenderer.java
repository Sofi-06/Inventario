package com.usta.proyectofinal;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 *
 * @author USUARIO
 */
public class ImageCellRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel label = (JLabel) super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Si el valor es una URL, intenta cargar la imagen desde esa URL
        if (value instanceof String) {
            String urlStr = (String) value;
            try {
                URL url = new URL(urlStr);
                Image image = ImageIO.read(url);
                ImageIcon icon = new ImageIcon(image);
                label.setIcon(icon);
                label.setHorizontalAlignment(SwingConstants.CENTER); // Centra la imagen en la celda
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return label;
    }
}
