package controladores;

import sportyfy.core.iniciador.IniciadorSportyfyCore;
import sportyfy.core.modelo.SportyfyCore;
import sportyfy.ui.VentanaInicial;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;

public class VentanaInicialControlador {
   VentanaInicial ventanaInicial;

    public VentanaInicialControlador(){
       this.ventanaInicial = new VentanaInicial();
    }

    public void iniciar(SportyfyCore spc) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException, FileNotFoundException {
        this.ventanaInicial.inicializar(spc);
        this.ventanaInicial.llenarCombo(spc.getBuscadorPronosticadores());
        this.ventanaInicial.iniciarPanelEquipos(spc);
    }
}
