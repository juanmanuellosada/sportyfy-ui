package controladores;

import sportyfy.core.core.SportyfyCore;
import sportyfy.ui.VentanaInicial;
import java.awt.event.ActionEvent;
import sportyfy.core.Pronosticador;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;

public class VentanaInicialControlador {
   private VentanaInicial ventanaInicial;

    public VentanaInicialControlador(){
       this.ventanaInicial = new VentanaInicial();
    }

    public void iniciar(SportyfyCore sportyfyCore,VentanaHistorialControlador controlador) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException, FileNotFoundException, UnsupportedEncodingException {
        this.ventanaInicial.inicializar();
        this.ventanaInicial.llenarCombo(obtenerPronosticador(sportyfyCore));
        inicializarPanelEquipos(sportyfyCore, controlador);
        abrirHistorial(sportyfyCore, controlador);
    }

    private void inicializarPanelEquipos(SportyfyCore sportyfyCore, VentanaHistorialControlador controlador) {
        this.ventanaInicial.getBotonContinuar().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ventanaInicial.mostrar(false);
                VentanaEquiposControlador ventanaEquiposController = new VentanaEquiposControlador();
                ventanaEquiposController.iniciar(sportyfyCore, controlador);
                controlador.getVentanaHistorial().mostrar(false);
            }
        });
    }

    private void abrirHistorial(SportyfyCore sportyfyCore, VentanaHistorialControlador controlador){
        this.ventanaInicial.getBotonHistorial().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controlador.iniciar(sportyfyCore);
                controlador.cargarPantalla();

//                controlador.getVentanaHistorial().mostrar(true);
            }
        });
    }

    public Pronosticador obtenerPronosticador(SportyfyCore sportyfyCore) {
        return sportyfyCore.getPronosticador();
    }
}