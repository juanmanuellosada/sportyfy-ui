package controladores;

import sportyfy.core.IniciadorSportyfyCore;
import sportyfy.core.futbol.Equipo;
import sportyfy.ui.VentanaEquipos;


import java.util.ArrayList;

public class VentanaEquiposControlador {//implements ActionListener {

    VentanaEquipos ventanaEquipos;
    String equipoSeleccionadoA;
    String equipoSeleccionadoB;

    public VentanaEquiposControlador(){
       this.ventanaEquipos = new VentanaEquipos();
    }

    public void iniciar(IniciadorSportyfyCore iniciador) {
        this.ventanaEquipos.inicializar(iniciador);
        this.ventanaEquipos.llenarCombos((ArrayList<Equipo>) iniciador.getEquipos());
    }
}
