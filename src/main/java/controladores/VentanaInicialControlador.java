package controladores;

import java.util.Set;
import sportyfy.ui.VentanaInicial;
import java.awt.event.ActionEvent;
import sportyfy.core.Pronosticador;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import sportyfy.core.modelo.SportyfyCore;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;

public class VentanaInicialControlador {
   VentanaInicial ventanaInicial;

    public VentanaInicialControlador(){
       this.ventanaInicial = new VentanaInicial();
    }

    public void iniciar(SportyfyCore sportyfyCore) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException, FileNotFoundException, UnsupportedEncodingException {
        this.ventanaInicial.inicializar();
        this.ventanaInicial.llenarCombo(obtenerPronosticadores(sportyfyCore));
        inicializarPanelEquipos(sportyfyCore);
    }

    private void inicializarPanelEquipos(SportyfyCore sportyfyCore) {
        this.ventanaInicial.getBotonContinuar().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ventanaInicial.mostrar(false);
                VentanaEquiposControlador ventanaEquiposController = new VentanaEquiposControlador();
                ventanaEquiposController.iniciar(sportyfyCore);
            }
        });
    }

    public Set<Pronosticador> obtenerPronosticadores (SportyfyCore spc) throws FileNotFoundException {
        return spc.getBuscadorPronosticadores().buscarPronosticadores("src/pronosticadores");
    }
}
