package sportyfy.ui;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class VentanaInicial  {
    private JFrame frame;
    private JButton botonContinuar;
    JComboBox<String> comboDeportes;
 private String[] deporteSeleccionado ={""};

    //Create the application.
    public VentanaInicial()  {
    }

     // Initialize the contents of the frame.
    public void inicializar() {

        frame = new JFrame();
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("logo-pelota.png"));

        frame.setTitle("Sportyfy");
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setBounds(100, 100, 362, 376);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);

        JLabel etiquetaBienvenido = new JLabel("Bienvenido a");
        etiquetaBienvenido.setHorizontalAlignment(SwingConstants.CENTER);
        etiquetaBienvenido.setForeground(new Color(0, 0, 64));
        etiquetaBienvenido.setFont(new Font("Encode Sans", Font.BOLD, 18));
        etiquetaBienvenido.setBounds(10, 28, 328, 23);
        frame.getContentPane().add(etiquetaBienvenido);

        JLabel etiquetaMsjInicio = new JLabel("<html><body>Sportyfy te brindara un pronostico</body></html>");
        etiquetaMsjInicio.setHorizontalAlignment(SwingConstants.CENTER);
        etiquetaMsjInicio.setForeground(new Color(0, 0, 64));
        etiquetaMsjInicio.setFont(new Font("Encode Sans", Font.PLAIN, 13));
        etiquetaMsjInicio.setBounds(10, 116, 328, 23);
        frame.getContentPane().add(etiquetaMsjInicio);

        JLabel etiquetaMsjFin = new JLabel("<html><body>sobre el resultado de un partido!</body></html>");
        etiquetaMsjFin.setFont(new Font("Encode Sans", Font.PLAIN, 13));
        etiquetaMsjFin.setHorizontalAlignment(SwingConstants.CENTER);
        etiquetaMsjFin.setForeground(new Color(0, 0, 64));
        etiquetaMsjFin.setBounds(10, 141, 328, 23);
        frame.getContentPane().add(etiquetaMsjFin);

        JLabel etiquetaSeleccion = new JLabel("Seleccione el deporte:");
        etiquetaSeleccion.setHorizontalAlignment(SwingConstants.CENTER);
        etiquetaSeleccion.setForeground(new Color(0, 208, 0));
        etiquetaSeleccion.setFont(new Font("Encode Sans", Font.PLAIN, 15));
        etiquetaSeleccion.setBounds(10, 192, 328, 23);
        frame.getContentPane().add(etiquetaSeleccion);

        comboDeportes = new JComboBox<String>();
        comboDeportes.setFont(new Font("Encode Sans", Font.PLAIN, 15));
        comboDeportes.setBounds(109, 223, 128, 28);
        comboDeportes.addItem("Futbol");
        comboDeportes.addItem("Basket");
        comboDeportes.addItem("Hockey");
        frame.getContentPane().add(comboDeportes);

        botonContinuar = new JButton("Continuar");
        botonContinuar.setFont(new Font("Encode Sans", Font.PLAIN, 15));
        botonContinuar.setBounds(104, 262, 139, 39);
        frame.getContentPane().add(botonContinuar);frame.getContentPane().add(botonContinuar);
        botonContinuar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deporteSeleccionado[0] = comboDeportes.getSelectedItem().toString();
                frame.setVisible(false);
                VentanaEquipos ventanaEquipos = new VentanaEquipos();
                ventanaEquipos.inicializar();
                System.out.println(deporteSeleccionado[0]);

            }
        });

        JLabel img = new JLabel(" ");
        ImageIcon image = new ImageIcon("logo-sportyfy.png");
        image = new ImageIcon(image.getImage().getScaledInstance(227, 49, Image.SCALE_DEFAULT));
        frame.getContentPane().add(img); //

        //Propiedades de la etiqueta
        img.setIcon(image);
        img.setSize(227,49);
        img.setLocation(59,54);
        img.setVisible(true);
        frame.setVisible(true);
    }

    public JFrame getFrame(){
        return frame;
    }

    public String getDeporteSeleccionado(){
        return deporteSeleccionado[0];
    }


}
