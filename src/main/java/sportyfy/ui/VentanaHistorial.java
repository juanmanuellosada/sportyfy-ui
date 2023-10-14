package sportyfy.ui;
import sportyfy.ui.personalizador.CustomScrollBarUI;

import javax.swing.*;
import java.awt.*;

public class VentanaHistorial {
    private JFrame frame;
    private JLabel contenedorPronosticos;
    private JScrollPane scrollPane;

    public VentanaHistorial() {
        this.contenedorPronosticos = new JLabel();
        inicializar();
    }

    public void inicializar() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(32, 33, 36));
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("src/recursos/logo-historial-blanco.png"));
        frame.setTitle("Historial");
        frame.setResizable(false);
        frame.setBounds(100, 100, 362, 376);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);

        JLabel etiquetaTitulo = new JLabel("Historial de Pronósticos");
        etiquetaTitulo.setHorizontalAlignment(SwingConstants.LEFT);
        etiquetaTitulo.setForeground(Color.white);
        etiquetaTitulo.setFont(new Font("Calibri Light", Font.PLAIN, 15));
        etiquetaTitulo.setBounds(10, 11, 317, 28);
        frame.getContentPane().add(etiquetaTitulo);

        JLabel contornoTitulo = new JLabel();
        ImageIcon image = new ImageIcon("src/recursos/contorno-titulo-azul.png");
        image = new ImageIcon(image.getImage().getScaledInstance(192, 28, Image.SCALE_SMOOTH));
        contornoTitulo.setIcon(image);
        contornoTitulo.setBounds(0, 11, 192, 28);
        frame.getContentPane().add(contornoTitulo);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 50, 328, 278);
        scrollPane.setBorder(null);
        scrollPane.getVerticalScrollBar().setUI(new CustomScrollBarUI());
        scrollPane.getHorizontalScrollBar().setUI(new CustomScrollBarUI());

        frame.getContentPane().add(scrollPane);

        this.contenedorPronosticos.setFont(new Font("Calibri Light", Font.PLAIN, 15));
        this.contenedorPronosticos.setOpaque(true);
        this.contenedorPronosticos.setBackground(new Color(41,42,45));
        this.contenedorPronosticos.setForeground(Color.white);
        this.contenedorPronosticos.setVerticalAlignment(SwingConstants.TOP);
        this.contenedorPronosticos.setHorizontalAlignment(SwingConstants.LEFT);

        scrollPane.setViewportView(this.contenedorPronosticos);
    }

    public void llenarVentana(String s){
        this.contenedorPronosticos.setText(s);
    }

    public void mostrar(Boolean bool){
        frame.setVisible(bool);
    }



}
