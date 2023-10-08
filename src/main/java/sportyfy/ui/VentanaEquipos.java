package sportyfy.ui;

import lombok.Getter;
import sportyfy.core.entidades.equipo.Equipo;
import sportyfy.ui.personalizador.JButtonRedondeado;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VentanaEquipos extends JFrame {
    private JFrame frame;
    @Getter
    JButton botonPrediccion;
    @Getter
    private JComboBox<String> comboEquipoA;
    @Getter
    private JComboBox<String> comboEquipoB;

//create the application.
    public VentanaEquipos()  {
    }

    public void inicializar() {
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

    private void inicializarComponentes() {
        JLabel etiquetaSeleccion = new JLabel("Seleccione dos equipos:");
        etiquetaSeleccion.setHorizontalAlignment(SwingConstants.CENTER);
        etiquetaSeleccion.setForeground(new Color(169, 254, 88));
        etiquetaSeleccion.setFont(new Font("Calibri Light", Font.PLAIN, 15));
        etiquetaSeleccion.setBounds(10, 171, 328, 23);
        frame.getContentPane().add(etiquetaSeleccion);

        JLabel etiquetaVersus = new JLabel("vs");
        etiquetaVersus.setHorizontalAlignment(SwingConstants.CENTER);
        etiquetaVersus.setForeground(Color.white);
        etiquetaVersus.setFont(new Font("Calibri Light", Font.PLAIN, 15));
        etiquetaVersus.setBounds(10, 203, 328, 23);
        frame.getContentPane().add(etiquetaVersus);

        botonPrediccion = new JButtonRedondeado("Predecir");
        botonPrediccion.setFont(new Font("Calibri Light", Font.PLAIN, 15));
        botonPrediccion.setBounds(111, 275, 125, 39);
        botonPrediccion.setBorderPainted(false);
        frame.getContentPane().add(botonPrediccion);

        comboEquipoA = new JComboBox<>();
        comboEquipoA.setFont(new Font("Calibri Light", Font.PLAIN, 15));
        comboEquipoA.setBounds(10, 203, 140, 22);
        frame.getContentPane().add(comboEquipoA);

        comboEquipoB = new JComboBox<>();
        comboEquipoB.setFont(new Font("Calibri Light", Font.PLAIN, 15));
        comboEquipoB.setBounds(199, 203, 140, 22);
        frame.getContentPane().add(comboEquipoB);

        agregarImagen("src/recursos/pelota-futbol.png");
    }

    private void agregarImagen(String ruta) {
        JLabel img = new JLabel();
        ImageIcon image = new ImageIcon(ruta);
        image = new ImageIcon(image.getImage().getScaledInstance(137, 135, Image.SCALE_SMOOTH));
        img.setIcon(image);
        img.setBounds(111,25,137,135);
        frame.getContentPane().add(img);
    }

    public void llenarCombos(ArrayList<Equipo> equipos) {
        for (Equipo e : equipos) {
            this.comboEquipoA.addItem(e.getNombre());
        }
        actualizarComboB(equipos);
    }

    public void actualizarComboB(ArrayList<Equipo> equipos) {
        this.comboEquipoB.removeAllItems();
        String a = (String) this.comboEquipoA.getSelectedItem();

        for (Equipo e : equipos) {
            if (a != null && !a.equals(e.getNombre())) {
                this.comboEquipoB.addItem(e.getNombre());
            }
        }
    }

    public void mostrar(Boolean bool){
        frame.setVisible(bool);
    }
}