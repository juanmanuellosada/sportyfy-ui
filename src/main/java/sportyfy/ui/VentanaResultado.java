package sportyfy.ui;
import sportyfy.core.Pronostico;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.ActionEvent;

public class VentanaResultado {
    private JFrame frame;
    private JLabel etiquetaEquipoGanador;

    public VentanaResultado() {
    }
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

        /**
        JButton botonNuevaPrediccion = new JButton("Nueva prediccion");
        botonNuevaPrediccion.setFont(new Font("Encode Sans", Font.PLAIN, 15));
        botonNuevaPrediccion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                System.exit(0);

            }
        });
        botonNuevaPrediccion.setBounds(94, 272, 157, 39);
        frame.getContentPane().add(botonNuevaPrediccion);
*/
        JLabel etiquetaTitulo = new JLabel("Según Sportyfy el equipo ganador será");
        etiquetaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        etiquetaTitulo.setForeground(new Color(0, 0, 64));
        etiquetaTitulo.setFont(new Font("Encode Sans", Font.PLAIN, 15));
        etiquetaTitulo.setBounds(10, 38, 328, 23);
        frame.getContentPane().add(etiquetaTitulo);

        etiquetaEquipoGanador = new JLabel();
        etiquetaEquipoGanador.setHorizontalAlignment(SwingConstants.CENTER);
        etiquetaEquipoGanador.setForeground(new Color(0, 0, 64));
        etiquetaEquipoGanador.setFont(new Font("Encode Sans", Font.BOLD, 15));
        etiquetaEquipoGanador.setBounds(10, 72, 328, 23);
        frame.getContentPane().add(etiquetaEquipoGanador);



        frame.setVisible(true);
    }

    public void mensajeGanador(Pronostico pronostico){
        if(pronostico.getEquipoGanador()==null){
            etiquetaEquipoGanador.setText("No hay Pronóstico a favor de un equipo, se prevee un Empate");
        }
        else{
            String ganador = pronostico.getEquipoGanador().getNombre();
            etiquetaEquipoGanador.setText("El equipo ganador sera : " + ganador);

            JLabel img = new JLabel(" ");
            ImageIcon image = new ImageIcon(ganador.toLowerCase()+".png");
            System.out.println(ganador.toLowerCase());
            image = new ImageIcon(image.getImage().getScaledInstance(137, 135, Image.SCALE_DEFAULT));
            frame.getContentPane().add(img); //

            //Propiedades de la etiqueta
            img.setIcon(image);
            img.setSize(137,135);
            img.setLocation(111,135);
            img.setVisible(true);
        }
    }
}