package sportyfy.ui.personalizador;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;
import java.awt.*;

public class CustomComboBoxUI extends BasicComboBoxUI {
    private Color backgroundColor = Color.WHITE;
    private Color arrowColor = new Color (32, 12, 61);
    private Color arrowBorderColor = new Color (32, 12, 61);
    private Color textColor = new Color (32, 12, 61);
    private Color selectedBackgroundColor = new Color (52, 20, 99);
    private Color selectedTextColor = Color.WHITE; // Color de fuente del elemento seleccionado



    @Override
    protected JButton createArrowButton() {
        JButton button = super.createArrowButton();
        button.setBackground(arrowColor);
        button.setBorder(BorderFactory.createLineBorder(arrowBorderColor)); // Establece el color del borde de la flecha

        return button;
    }

    @Override
    protected ComboPopup createPopup() {
        return new BasicComboPopup(comboBox) {
            @Override
            protected JScrollPane createScroller() {
                JScrollPane scroller = super.createScroller();
                scroller.getVerticalScrollBar().setUI(new CustomScrollBarUI());
                return scroller;
            }
        };
    }

    @Override
    public void configureArrowButton() {
        super.configureArrowButton();
        arrowButton.setBackground(arrowColor);
        arrowButton.setBorder(BorderFactory.createLineBorder(arrowBorderColor)); // Establece el color del borde de la flecha

    }

    @Override
    protected ListCellRenderer<Object> createRenderer() {
        DefaultListCellRenderer renderer = new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                // Cambia el color del texto y el fondo para el elemento seleccionado
                if (isSelected) {
                    setBackground(selectedBackgroundColor);
                    setForeground(selectedTextColor);
                } else {
                    setBackground(backgroundColor);
                    setForeground(textColor);
                }

                return this;
            }
        };

        return renderer;
    }
}