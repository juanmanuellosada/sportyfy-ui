package sportyfy.ui;
import controladores.VentanaEquiposControlador;
import sportyfy.core.BuscadorPronosticadores;
import sportyfy.core.Pronosticador;
import sportyfy.core.modelo.SportyfyCore;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.Set;
import javax.swing.*;

public class VentanaInicial extends JFrame {
    private JFrame frame;
    private JButton botonContinuar;
    JComboBox<String> comboDeportes;
 private String[] deporteSeleccionado ={""};

    public VentanaInicial()  {

    }
     // Initialize the contents of the frame.
    public void inicializar(SportyfyCore sportyfyCore) {
        inicializarFrame();
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        JLabel msjBienvenido = new JLabel("Bienvenido a");
        msjBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
        msjBienvenido.setForeground(new Color(0, 0, 64));
        msjBienvenido.setFont(new Font("Encode Sans", Font.BOLD, 18));
        msjBienvenido.setBounds(10, 28, 328, 23);
        frame.getContentPane().add(msjBienvenido);

        JLabel msjInicio = new JLabel("<html><body>¡Sportyfy te brindará un pronóstico</body></html>");
        msjInicio.setHorizontalAlignment(SwingConstants.CENTER);
        msjInicio.setForeground(new Color(0, 0, 64));
        msjInicio.setFont(new Font("Encode Sans", Font.PLAIN, 13));
        msjInicio.setBounds(10, 116, 328, 23);
        frame.getContentPane().add(msjInicio);

        JLabel msjFin = new JLabel("<html><body>sobre el resultado de un partido!</body></html>");
        msjFin.setFont(new Font("Encode Sans", Font.PLAIN, 13));
        msjFin.setHorizontalAlignment(SwingConstants.CENTER);
        msjFin.setForeground(new Color(0, 0, 64));
        msjFin.setBounds(10, 141, 328, 23);
        frame.getContentPane().add(msjFin);

        JLabel msjSeleccione = new JLabel("Seleccione el deporte:");
        msjSeleccione.setHorizontalAlignment(SwingConstants.CENTER);
        msjSeleccione.setForeground(new Color(0, 208, 0));
        msjSeleccione.setFont(new Font("Encode Sans", Font.PLAIN, 15));
        msjSeleccione.setBounds(10, 192, 328, 23);
        frame.getContentPane().add(msjSeleccione);

        comboDeportes = new JComboBox<String>();
        comboDeportes.setFont(new Font("Encode Sans", Font.PLAIN, 15));
        comboDeportes.setBounds(109, 223, 128, 28);
        frame.getContentPane().add(comboDeportes);

        botonContinuar = new JButton("Continuar");
        botonContinuar.setFont(new Font("Encode Sans", Font.PLAIN, 15));
        botonContinuar.setBounds(104, 262, 139, 39);
        frame.getContentPane().add(botonContinuar);

        JLabel img = new JLabel(" ");
        ImageIcon image = new ImageIcon("logo-sportyfy.png");
        image = new ImageIcon(image.getImage().getScaledInstance(227, 49, Image.SCALE_DEFAULT));
        frame.getContentPane().add(img); //

        //Propiedades de la etiqueta
        img.setIcon(image);
        img.setSize(227,49);
        img.setLocation(59,54);
        img.setVisible(true);
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

    public void iniciarPanelEquipos(SportyfyCore sportyfyCore) {
        botonContinuar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deporteSeleccionado[0] = comboDeportes.getSelectedItem().toString();
                frame.setVisible(false);
                VentanaEquiposControlador ventanaEquiposController = new VentanaEquiposControlador();
                ventanaEquiposController.iniciar(sportyfyCore);

                System.out.println(deporteSeleccionado[0]);
            }
        });
    }

    public void llenarCombo(BuscadorPronosticadores buscadorPronosticadores) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException, FileNotFoundException {
        Set<Pronosticador> pronosticadores = buscadorPronosticadores.buscarPronosticadores("src/pronosticadores");
        for (Pronosticador p : pronosticadores){
            comboDeportes.addItem(p.obtenerDeporte());
        }
    }
}
