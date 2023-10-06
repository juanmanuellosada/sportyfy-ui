package controladores;
import sportyfy.core.entidades.Equipo;
import sportyfy.core.iniciador.IniciadorSportyfyCore;
import sportyfy.core.core.SportyfyCore;
import sportyfy.ui.VentanaEquipos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VentanaEquiposControlador {//implements ActionListener {

    VentanaEquipos ventanaEquipos;
    String equipoSeleccionadoA;
    String equipoSeleccionadoB;

    public VentanaEquiposControlador() {

        this.ventanaEquipos = new VentanaEquipos();
    }

    public void iniciar(SportyfyCore sportyfyCore) {
        ArrayList<Equipo> equipos = (ArrayList<Equipo>) sportyfyCore.getEquipos();

        this.ventanaEquipos.inicializar(sportyfyCore);
        this.ventanaEquipos.llenarCombos(equipos);
        this.ventanaEquipos.iniciarVentanaPrediccion(sportyfyCore);


    }






    public void mostrarPanel(boolean bool){
        this.ventanaEquipos.setVisible(bool);
    }
}
