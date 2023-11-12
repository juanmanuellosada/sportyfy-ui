package sportyfy.ui;

import lombok.Getter;
import sportyfy.ui.personalizador.JButtonRedondeado;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

@Getter
public class VentanaInicial extends JFrame {
    private JFrame frame;
    private JPanel panel;
    private JButton botonContinuar;
    private JButton botonHistorial;
    private JComboBox<String> comboPronosticadores;

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

        JLabel msjSeleccione = new JLabel("Seleccione un pronosticador:");
        msjSeleccione.setHorizontalAlignment(SwingConstants.CENTER);
        msjSeleccione.setForeground(new Color(169, 254, 88));
        msjSeleccione.setFont(new Font("Calibri Light", Font.PLAIN, 15));
        msjSeleccione.setBounds(10, 192, 328, 23);
        frame.getContentPane().add(msjSeleccione);

        comboPronosticadores = new JComboBox<>();
        comboPronosticadores.setPreferredSize(new Dimension(150,30));
        comboPronosticadores.setFont(new Font("Calibri Light", Font.PLAIN, 15));
        comboPronosticadores.setBounds(34, 223, 282, 25);
        frame.getContentPane().add(comboPronosticadores);

        botonContinuar = new JButtonRedondeado("Continuar");
        botonContinuar.setFont(new Font("Calibri Light", Font.PLAIN, 15));
        botonContinuar.setBounds(111, 275, 125, 39);
        botonContinuar.setBorderPainted(false);
        frame.getContentPane().add(botonContinuar);
        agregarAccionBotonContinuar();

        botonHistorial = new JButtonRedondeado("HISTORIAL");
        botonHistorial.setFont(new Font("Calibri Light", Font.PLAIN, 11));
        botonHistorial.setForeground(Color.white);
        botonHistorial.setBorderPainted(false);
        botonHistorial.setBackground(new Color(32, 12, 61));
        botonHistorial.setBounds(247, 11, 100, 20);
        frame.getContentPane().add(botonHistorial);
        agregarAccionBotonHistorial();

        agregarLogoSportyfy();
    }

    private void agregarAccionBotonHistorial() {
        botonHistorial.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                botonHistorial.setForeground(Color.white);
                botonHistorial.setBackground(new Color (52, 20, 99));
            }
            public void mouseExited(MouseEvent e) {
                botonHistorial.setForeground(Color.white);
                botonHistorial.setBackground(new Color (32, 12, 61));
            }
        });
    }

    private void agregarAccionBotonContinuar() {
        botonContinuar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                botonContinuar.setForeground(Color.white);
                botonContinuar.setBackground(new Color (52, 20, 99));
            }
            public void mouseExited(MouseEvent e) {
                botonContinuar.setForeground(new Color (32, 12, 61));
                botonContinuar.setBackground(Color.white);
            }
        });
    }

    private void agregarLogoSportyfy() {
        JLabel img = new JLabel();
        ImageIcon image = new ImageIcon("src/recursos/logo-sportyfy.png");
        image = new ImageIcon(image.getImage().getScaledInstance(227,49, Image.SCALE_SMOOTH));
        img.setIcon(image);
        img.setBounds(59,54,227,49);
        frame.getContentPane().add(img);
    }

    public void llenarCombo(List<String> pronosticadores){
        for (String p : pronosticadores)
            comboPronosticadores.addItem(p);
    }

    public void mostrar(Boolean b){
        frame.setVisible(b);
    }
}