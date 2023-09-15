package controladores;

import sportyfy.core.IniciadorSportyfyCore;
import sportyfy.ui.VentanaInicial;

import java.lang.reflect.InvocationTargetException;

public class VentanaInicialControlador {
   VentanaInicial ventanaInicial;

    public VentanaInicialControlador(){
       this.ventanaInicial = new VentanaInicial();
    }

    public void iniciar(IniciadorSportyfyCore iniciador) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException {
        this.ventanaInicial.inicializar(iniciador);
        this.ventanaInicial.llenarCombo(iniciador.getBuscadorPronosticadores());
    }



}
