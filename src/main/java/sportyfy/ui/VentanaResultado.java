package sportyfy.ui;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;

public class VentanaResultado {
    private JFrame frame;

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
        JLabel etiquetaTitulo = new JLabel("Segun Sportyfy el equipo ganador sera");
        etiquetaTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        etiquetaTitulo.setForeground(new Color(0, 0, 64));
        etiquetaTitulo.setFont(new Font("Encode Sans", Font.PLAIN, 15));
        etiquetaTitulo.setBounds(10, 68, 328, 23);
        frame.getContentPane().add(etiquetaTitulo);

        JLabel etiquetaEquipoGanador = new JLabel("*equipo ganador*");
        etiquetaEquipoGanador.setHorizontalAlignment(SwingConstants.CENTER);
        etiquetaEquipoGanador.setForeground(new Color(0, 0, 64));
        etiquetaEquipoGanador.setFont(new Font("Encode Sans", Font.BOLD, 15));
        etiquetaEquipoGanador.setBounds(10, 102, 328, 23);
        frame.getContentPane().add(etiquetaEquipoGanador);

        frame.setVisible(true);
    }
}