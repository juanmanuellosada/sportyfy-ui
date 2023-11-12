package sportyfy.ui;

import lombok.Getter;
import sportyfy.ui.personalizador.CustomScrollBarUI;
import sportyfy.ui.personalizador.JButtonRedondeado;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VentanaHistorial {
    private JFrame frame;
    private final JLabel contenedorPronosticos;
    private JLabel etiquetaFecha;
    @Getter
    private JButton botonAtras;

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
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        JLabel etiquetaTitulo = new JLabel("Historial de Pronósticos");
        etiquetaTitulo.setHorizontalAlignment(SwingConstants.LEFT);
        etiquetaTitulo.setForeground(Color.white);
        etiquetaTitulo.setFont(new Font("Calibri Light", Font.BOLD, 13));
        etiquetaTitulo.setBounds(10, 11, 317, 28);
        frame.getContentPane().add(etiquetaTitulo);

        etiquetaFecha = new JLabel();
        etiquetaFecha.setHorizontalAlignment(SwingConstants.LEFT);
        etiquetaFecha.setForeground(Color.WHITE);
        etiquetaFecha.setFont(new Font("Calibri Light", Font.PLAIN, 15));
        etiquetaFecha.setBounds(10, 50, 328, 28);
        frame.getContentPane().add(etiquetaFecha);

        botonAtras = new JButtonRedondeado("Volver");
        botonAtras.setFont(new Font("Calibri Light", Font.PLAIN, 11));
        botonAtras.setForeground(Color.white);
        botonAtras.setBorderPainted(false);
        botonAtras.setBackground(new Color(32, 33, 36));
        botonAtras.setBounds(257, 11, 85, 20);
        frame.getContentPane().add(botonAtras);
        agregarAccionBotonAtras();

        JLabel contornoTitulo = new JLabel();
        ImageIcon image = new ImageIcon("src/recursos/contorno-titulo-azul.png");
        image = new ImageIcon(image.getImage().getScaledInstance(192, 28, Image.SCALE_SMOOTH));
        contornoTitulo.setIcon(image);
        contornoTitulo.setBounds(0, 11, 192, 28);
        frame.getContentPane().add(contornoTitulo);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 92, 328, 236);
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

    public void setFecha(String s){
        etiquetaFecha.setText(s);
    }

    public void llenarVentana(String s){
        this.contenedorPronosticos.setText(s);
    }

    private void agregarAccionBotonAtras() {
        botonAtras.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                botonAtras.setForeground(Color.white);
                botonAtras.setBackground(new Color(41,42,45));
            }
            public void mouseExited(MouseEvent e) {
                botonAtras.setForeground(Color.white);
                botonAtras.setBackground(new Color(32, 33, 36));
            }
        });
    }
    public void mostrar(Boolean b){
        frame.setVisible(b);
    }
}