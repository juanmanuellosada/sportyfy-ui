package sportyfy.ui;

import lombok.Getter;
import sportyfy.core.Pronostico;
import sportyfy.core.core.SportyfyCore;
import sportyfy.core.entidades.equipo.Equipo;
import sportyfy.ui.personalizador.JButtonRedondeado;
import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class VentanaResultado extends JFrame implements Observer {
    private JFrame frame;
    private JLabel msjGanadorEs;
    @Getter
    private JButton botonNuevaPrediccion;

    public VentanaResultado() {
    }
    public void inicializar() {
        inicializarFrame();
        inicializarComponentes();
    }

    private void inicializarFrame() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(32, 12, 61));
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
        msjGanadorEs = new JLabel("<html><center>Según Sportyfy</center><html>");
        msjGanadorEs.setHorizontalAlignment(SwingConstants.CENTER);
        msjGanadorEs.setForeground(Color.WHITE);
        msjGanadorEs.setFont(new Font("Calibri Light", Font.PLAIN, 15));
        msjGanadorEs.setBounds(10, 38, 328, 40);
        frame.getContentPane().add(msjGanadorEs);

        botonNuevaPrediccion = new JButtonRedondeado("Nueva predicción");
        botonNuevaPrediccion.setFont(new Font("Calibri Light", Font.PLAIN, 15));
        botonNuevaPrediccion.setBounds(94, 272, 157, 39);
        botonNuevaPrediccion.setBorderPainted(false);
        frame.getContentPane().add(botonNuevaPrediccion);
    }

    private void mostrarResultado(Pronostico pronosticoActual) {
        if(pronosticoActual.getEquipoGanador()!=null)
            mostrarGanador(pronosticoActual.getEquipoGanador());
        else
            mostrarEmpate();
    }

    private void mostrarGanador(Equipo equipo){
        msjGanadorEs.setText("<html><center>Según Sportyfy, el equipo ganador será "+equipo.getNombre()+"</center><html>");
        mostrarImagen("src/recursos/logo-equipos/" + equipo.getNombre().toLowerCase() + ".png");
    }

    private void mostrarEmpate(){
        msjGanadorEs.setText("<html><center>Según Sportyfy, no hay pronóstico a favor de ningún/n equipo, se prevee un empate.</center><html>");
        mostrarImagen("src/recursos/pelota-futbol.png");
    }

    private void mostrarImagen(String ruta) {
        JLabel img = new JLabel();
        ImageIcon image = new ImageIcon(ruta);
        image = new ImageIcon(image.getImage().getScaledInstance(137, 135, Image.SCALE_SMOOTH));
        img.setIcon(image);
        img.setBounds(104, 116, 137, 135);
        frame.getContentPane().add(img);
    }

    public void mostrar(Boolean bool){
        frame.setVisible(bool);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof SportyfyCore) {
            SportyfyCore sportyfyCore = (SportyfyCore) o;
            Pronostico pronosticoActual = sportyfyCore.getPronosticoActual();
            mostrarResultado(pronosticoActual);
        }
    }
}