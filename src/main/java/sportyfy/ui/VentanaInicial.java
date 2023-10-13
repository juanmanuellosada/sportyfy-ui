package sportyfy.ui;

import lombok.Getter;
import sportyfy.core.Pronosticador;
import sportyfy.ui.personalizador.JButtonRedondeado;
import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxRenderer;
import java.awt.*;
import java.util.List;


public class VentanaInicial extends JFrame {
    private JFrame frame;
    @Getter
    private JButton botonContinuar;
    @Getter
    private JComboBox<String> comboDeportes;

    public VentanaInicial()  {

    }
    public void inicializar(){
        inicializarFrame();
        inicializarComponentes();
    }
    private void inicializarFrame() {
        frame = new JFrame();
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("src/recursos/logo-pelota.png"));
        frame.setTitle("Sportyfy");
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(32, 12, 61));
        frame.setBounds(100, 100, 362, 376);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void inicializarComponentes(){
        JLabel msjBienvenido = new JLabel("Bienvenido a");
        msjBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
        msjBienvenido.setForeground(Color.WHITE);
        msjBienvenido.setFont(new Font("Calibri Light", Font.BOLD, 18));
        msjBienvenido.setBounds(10, 28, 328, 23);
        frame.getContentPane().add(msjBienvenido);

        JLabel msjInicio = new JLabel("<html><center>¡Sportyfy te brindará un pronóstico<br>sobre el resultado de un partido!</center></html>");
        msjInicio.setHorizontalAlignment(SwingConstants.CENTER);
        msjInicio.setForeground(Color.WHITE);
        msjInicio.setFont(new Font("Calibri Light", Font.PLAIN, 13));
        msjInicio.setBounds(10, 116, 328, 30);
        frame.getContentPane().add(msjInicio);

        JLabel msjSeleccione = new JLabel("Seleccione el pronosticador-deporte :");
        msjSeleccione.setHorizontalAlignment(SwingConstants.CENTER);
        msjSeleccione.setForeground(new Color(169, 254, 88));
        msjSeleccione.setFont(new Font("Calibri Light", Font.BOLD, 15));
        msjSeleccione.setBounds(10, 192, 328, 23);
        frame.getContentPane().add(msjSeleccione);

        comboDeportes = new JComboBox<>();
        comboDeportes.setPreferredSize(new Dimension(250,30));
        comboDeportes.setFont(new Font("Calibri Light", Font.PLAIN, 15));
        comboDeportes.setBounds(50, 223, 250, 25);

        comboDeportes.setRenderer(new CenteredComboBoxRenderer());
        frame.getContentPane().add(comboDeportes);

        botonContinuar = new JButtonRedondeado("Continuar");
        botonContinuar.setFont(new Font("Calibri Light", Font.PLAIN, 15));
        botonContinuar.setBounds(111, 275, 125, 39);
        botonContinuar.setBorderPainted(false);
        frame.getContentPane().add(botonContinuar);

        agregarImagen("src/recursos/logo-sportyfy.png");
    }

    private void agregarImagen(String ruta) {
        JLabel img = new JLabel();
        ImageIcon image = new ImageIcon(ruta);
        image = new ImageIcon(image.getImage().getScaledInstance(227,49, Image.SCALE_SMOOTH));
        img.setIcon(image);
        img.setBounds(59,54,227,49);
        frame.getContentPane().add(img);
    }

    public void llenarCombo(List<String> pronosticadores){
        for(String nombrePronosticador: pronosticadores){
            comboDeportes.addItem(nombrePronosticador);
        }
    }

    public void mostrar(Boolean bool){
        frame.setVisible(bool);
    }

    static class CenteredComboBoxRenderer extends BasicComboBoxRenderer {
        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            setHorizontalAlignment(SwingConstants.CENTER); // Centra el texto
            setVerticalAlignment(SwingConstants.CENTER);
            return this;
        }
    }

}