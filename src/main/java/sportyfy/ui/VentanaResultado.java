package sportyfy.ui;

import lombok.Getter;
import sportyfy.core.entidades.equipo.Equipo;
import sportyfy.core.entidades.partido.Partido;
import sportyfy.core.entidades.resultado.Resultado;
import sportyfy.historial.Historial;
import sportyfy.ui.personalizador.JButtonRedondeado;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Objects;
import java.util.Optional;

import static java.lang.Integer.compare;

@SuppressWarnings("deprecation")
public class VentanaResultado extends JFrame implements PropertyChangeListener {
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

        botonNuevaPrediccion = new JButtonRedondeado("Volver al inicio");
        botonNuevaPrediccion.setFont(new Font("Calibri Light", Font.PLAIN, 15));
        botonNuevaPrediccion.setBounds(94, 272, 165, 39);
        botonNuevaPrediccion.setBorderPainted(false);
        frame.getContentPane().add(botonNuevaPrediccion);
        agregarEfectoBotonNuevaPrediccion();
    }

    public void mostrarResultado(Resultado pronostico) {
        if(obtenerGanador(pronostico) != null)
            mostrarGanador(Objects.requireNonNull(obtenerGanador(pronostico)));
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

    private void agregarEfectoBotonNuevaPrediccion() {
        botonNuevaPrediccion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                botonNuevaPrediccion.setForeground(Color.white);
                botonNuevaPrediccion.setFont(new Font("Calibri Light", Font.PLAIN, 15));
                botonNuevaPrediccion.setBackground(new Color (52, 20, 99));
            }
            public void mouseExited(MouseEvent e) {
                botonNuevaPrediccion.setForeground(new Color (32, 12, 61));
                botonNuevaPrediccion.setFont(new Font("Calibri Light", Font.PLAIN, 15));
                botonNuevaPrediccion.setBackground(Color.white);
            }
        });
    }

    public void mostrarResultado(String s){
        msjGanadorEs.setText("<html><center>Según Sportyfy, no hay pronóstico a favor de ningún/n equipo, se prevee un empate.</center><html>");

    }

    private Equipo obtenerGanador(Resultado resultado){
        System.out.print("se obteiene el ganador");
        Optional<Integer> primerMarcador = resultado.getMarcador(resultado.getPrimerEquipo());
        Optional<Integer> segundoMarcador = resultado.getMarcador(resultado.getSegundoEquipo());

        if(primerMarcador.isPresent() && segundoMarcador.isPresent()) {
            int rtdoComparacion = compare(primerMarcador.get(), segundoMarcador.get());

            switch (rtdoComparacion) {
                case 1:
                    return resultado.getPrimerEquipo();
                case 0:
                    return null;
                case -1:
                    return resultado.getSegundoEquipo();
            }
        }
        else{
            if(primerMarcador.isPresent())
                return resultado.getPrimerEquipo();
            else
                return resultado.getSegundoEquipo();
        }
        return null;
    }

    public void mostrar(Boolean bool){
        frame.setVisible(bool);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if ("resultado".equals(evt.getPropertyName())) {
            Resultado resultadoNuevo = (Resultado) evt.getNewValue();
            System.out.println("Se hizo un nuevo pronóstico con este resultado: " + resultadoNuevo.toString());
            Partido partido = new Partido(resultadoNuevo.getPrimerEquipo(), resultadoNuevo.getSegundoEquipo());
            mostrarResultado(resultadoNuevo);
        }
    }
}