package sportyfy.ui;

import lombok.Getter;
import sportyfy.core.Pronostico;
import sportyfy.core.core.SportyfyCore;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

public class VentanaResultado extends JFrame implements Observer {
    private JFrame frame;
    private JLabel etiquetaEquipoGanador;
    @Getter
    private JButton botonNuevaPrediccion;

    public VentanaResultado() {
    }
    public void inicializar() {
        inicializarFrame();
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        JLabel msjGanadorEs = new JLabel("Según Sportyfy");
        msjGanadorEs.setHorizontalAlignment(SwingConstants.CENTER);
        msjGanadorEs.setForeground(new Color(0, 0, 64));
        msjGanadorEs.setFont(new Font("Encode Sans", Font.PLAIN, 15));
        msjGanadorEs.setBounds(10, 38, 328, 23);
        frame.getContentPane().add(msjGanadorEs);

        etiquetaEquipoGanador = new JLabel();
        etiquetaEquipoGanador.setHorizontalAlignment(SwingConstants.CENTER);
        etiquetaEquipoGanador.setForeground(new Color(0, 0, 64));
        etiquetaEquipoGanador.setFont(new Font("Encode Sans", Font.PLAIN, 15));
        etiquetaEquipoGanador.setBounds(10, 72, 328, 23);
        frame.getContentPane().add(etiquetaEquipoGanador);


         botonNuevaPrediccion = new JButton("Nueva prediccion");
         botonNuevaPrediccion.setFont(new Font("Encode Sans", Font.PLAIN, 15));
         botonNuevaPrediccion.setBounds(94, 272, 157, 39);
         frame.getContentPane().add(botonNuevaPrediccion);

    }

    private void inicializarFrame() {
        frame = new JFrame();
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("src/recursos/logo-pelota.png"));
        frame.setTitle("Sportyfy");
        frame.setResizable(false);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setBounds(100, 100, 362, 376);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void mostrarGanador(String ganador){
        if(ganador == null){
            etiquetaEquipoGanador.setText("no hay pronóstico a favor de ningún equipo, se prevee un empate");
        }
        else{
            etiquetaEquipoGanador.setText("el equipo ganador será " + ganador);

            JLabel img = new JLabel(" ");
            ImageIcon image = new ImageIcon("src/recursos/logo-equipos/"+ganador.toLowerCase()+".png");
            image = new ImageIcon(image.getImage().getScaledInstance(137, 135, Image.SCALE_DEFAULT));
            frame.getContentPane().add(img);

            //Propiedades de la etiqueta
            img.setIcon(image);
            img.setSize(137,135);
            img.setLocation(104,116);
            img.setVisible(true);
        }
    }

    public void mostrar(Boolean bool){
        frame.setVisible(bool);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof SportyfyCore) {
            SportyfyCore sportyfyCore = (SportyfyCore) o;
            Pronostico pronosticoActual = sportyfyCore.getPronosticoActual();
            mostrarGanador(pronosticoActual.getEquipoGanador().getNombre());
        }
    }
}