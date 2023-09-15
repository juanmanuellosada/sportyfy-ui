package controladores;

import sportyfy.core.IniciadorSportyfyCore;
import sportyfy.core.futbol.Equipo;
import sportyfy.ui.VentanaEquipos;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VentanaEquiposController {//implements ActionListener {

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
