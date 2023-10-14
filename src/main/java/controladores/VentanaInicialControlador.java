package controladores;

import sportyfy.core.Pronostico;
import sportyfy.core.core.SportyfyCore;
import sportyfy.historial.Historial;
import sportyfy.ui.VentanaHistorial;
import sportyfy.ui.VentanaInicial;
import java.awt.event.ActionEvent;
import sportyfy.core.Pronosticador;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class VentanaInicialControlador {
   private VentanaInicial ventanaInicial;
//   private Historial historial;

    public VentanaInicialControlador(){
       this.ventanaInicial = new VentanaInicial();
//        this.historial = new Historial();

    }

    public void iniciar(SportyfyCore sportyfyCore,VentanaHistorialControlador controlador) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException, FileNotFoundException, UnsupportedEncodingException {
        this.ventanaInicial.inicializar();
        this.ventanaInicial.llenarCombo(obtenerPronosticador(sportyfyCore));
        inicializarPanelEquipos(sportyfyCore, controlador);
//        sportyfyCore.addObserver(this.historial);
        abrirHistorial(sportyfyCore, controlador);

    }

    private void inicializarPanelEquipos(SportyfyCore sportyfyCore, VentanaHistorialControlador controlador ) {
        this.ventanaInicial.getBotonContinuar().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ventanaInicial.mostrar(false);
                VentanaEquiposControlador ventanaEquiposController = new VentanaEquiposControlador();
                ventanaEquiposController.iniciar(sportyfyCore, controlador);
            }
        });
    }

    private void abrirHistorial(SportyfyCore sportyfyCore, VentanaHistorialControlador controlador){
        this.ventanaInicial.getBotonHistorial().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controlador.iniciar(sportyfyCore);
            }
        });
    }

    public Pronosticador obtenerPronosticador(SportyfyCore sportyfyCore) {
        return sportyfyCore.getPronosticador();
    }
}