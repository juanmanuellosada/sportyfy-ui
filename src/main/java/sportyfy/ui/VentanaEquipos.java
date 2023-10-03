package sportyfy.ui;
import controladores.VentanaResultadoControlador;
import lombok.Getter;
import sportyfy.core.entidades.Equipo;
import sportyfy.core.modelo.SportyfyCore;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class VentanaEquipos extends JFrame {
    private JFrame frame;
    JButton botonPrediccion;
    @Getter
    private JComboBox<String> comboEquipoA;
    @Getter
    private JComboBox<String> comboEquipoB;

//create the application.
    public VentanaEquipos()  {
    }

    public void inicializar(SportyfyCore sportyfyCore) {
        inicializarFrame();
        inicializarComponentes(sportyfyCore);
    }

    private void inicializarComponentes(SportyfyCore sportyfyCore) {
        botonPrediccion = new JButton("Predecir");
        botonPrediccion.setFont(new Font("Encode Sans", Font.PLAIN, 15));
        botonPrediccion.setBounds(111, 275, 125, 39);
        frame.getContentPane().add(botonPrediccion);

        comboEquipoA = new JComboBox<String>();
        comboEquipoA.setFont(new Font("Encode Sans", Font.PLAIN, 15));
        comboEquipoA.setBounds(10, 203, 136, 22);
        comboEquipoA.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                actualizarComboB((ArrayList<Equipo>) sportyfyCore.getEquipos());
            }
        });
        frame.getContentPane().add(comboEquipoA);

        JLabel etiquetaSeleccion = new JLabel("Seleccione dos equipos:");
        etiquetaSeleccion.setHorizontalAlignment(SwingConstants.CENTER);
        etiquetaSeleccion.setForeground(new Color(0, 208, 0));
        etiquetaSeleccion.setFont(new Font("Encode Sans", Font.PLAIN, 15));
        etiquetaSeleccion.setBounds(10, 171, 328, 23);
        frame.getContentPane().add(etiquetaSeleccion);

        JLabel etiquetaVersus = new JLabel("vs");
        etiquetaVersus.setHorizontalAlignment(SwingConstants.CENTER);
        etiquetaVersus.setForeground(new Color(64, 0, 64));
        etiquetaVersus.setFont(new Font("Encode Sans", Font.PLAIN, 15));
        etiquetaVersus.setBounds(10, 203, 328, 23);
        frame.getContentPane().add(etiquetaVersus);

        comboEquipoB = new JComboBox<String>();
        comboEquipoB.setFont(new Font("Encode Sans", Font.PLAIN, 15));
        comboEquipoB.setBounds(199, 203, 139, 22);
        frame.getContentPane().add(comboEquipoB);


        JLabel img = new JLabel(" ");
        ImageIcon image = new ImageIcon("pelota-futbol.png");
        image = new ImageIcon(image.getImage().getScaledInstance(137, 135, Image.SCALE_DEFAULT));
        frame.getContentPane().add(img); //

        //Propiedades de la etiqueta
        img.setIcon(image);
        img.setSize(137,135);
        img.setLocation(111,25);
        img.setVisible(true);
    }

    public void actualizarComboB(ArrayList<Equipo> equipos) {
        this.comboEquipoB.removeAllItems();
        String a = (String) this.comboEquipoA.getSelectedItem();

        for (Equipo e : equipos) {
            if (!a.equals(e.getNombre())) {
                this.comboEquipoB.addItem(e.getNombre());
            }
        }
    }

    public void llenarCombos(ArrayList<Equipo> equipos) {
        for (Equipo e : equipos) {
            this.comboEquipoA.addItem(e.getNombre());
        }
        actualizarComboB(equipos);
    }

    public void iniciarVentanaPrediccion(SportyfyCore sportyfyCore) {
        botonPrediccion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String equipoSeleccionadoA;
                String equipoSeleccionadoB;
                equipoSeleccionadoA = (String)comboEquipoA.getSelectedItem();
                equipoSeleccionadoB = (String)comboEquipoB.getSelectedItem();

                if(equipoSeleccionadoA == equipoSeleccionadoB){
                    JOptionPane.showMessageDialog(null, "Debes seleccionar dos equipos distintos!");
                }
                else{
                    setVisible(false);
                    VentanaResultadoControlador controlador = new VentanaResultadoControlador(sportyfyCore,equipoSeleccionadoA, equipoSeleccionadoB);
                    controlador.iniciar(sportyfyCore);
                }
            }
        });
    }

    private void inicializarFrame() {
        frame = new JFrame();
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("logo-pelota.png"));
        frame.setTitle("Sportyfy");
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setBounds(100, 100, 362, 376);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }


}
