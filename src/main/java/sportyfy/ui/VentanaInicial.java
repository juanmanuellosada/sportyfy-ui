package sportyfy.ui;

import lombok.Getter;
import sportyfy.core.Pronosticador;
import sportyfy.core.core.SportyfyCore;
import sportyfy.core.Pronostico;
import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;

public class VentanaInicial extends JFrame {//implements Observer {
    private JFrame frame;
    @Getter
    private JButton botonContinuar;
    private JComboBox<String> comboDeportes;

    public VentanaInicial()  {

    }
     // Initialize the contents of the frame.
    public void inicializar(){
        inicializarFrame();
        inicializarComponentes();
    }

    private void inicializarComponentes(){
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
        ImageIcon image = new ImageIcon("src/recursos/logo-sportyfy.png");
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

    public void llenarCombo(Set<Pronosticador> pronosticadores){
        for (Pronosticador p : pronosticadores)
            comboDeportes.addItem(p.obtenerDeporte());
    }

    public void mostrar(Boolean bool){
        frame.setVisible(bool);
    }

//    @Override
//    public void update(Observable o, Object arg) {
//        if (o instanceof SportyfyCore) {
//            SportyfyCore sportyfyCore = (SportyfyCore) o;
//            System.out.println(sportyfyCore.getBuscadorPronosticadores().getPronosticadores().getClass().getSimpleName());
//            llenarCombo(sportyfyCore.getBuscadorPronosticadores().getPronosticadores());
//        }
//    }

}
