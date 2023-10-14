package controladores;

import sportyfy.core.core.SportyfyCore;
import sportyfy.core.entidades.equipo.Equipo;
import sportyfy.ui.VentanaEquipos;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VentanaEquiposControlador {
    VentanaEquipos ventanaEquipos;

    public VentanaEquiposControlador() {
        this.ventanaEquipos = new VentanaEquipos();
    }

    public void iniciar(SportyfyCore sportyfyCore, VentanaHistorialControlador controlador) {
        ArrayList<Equipo> equipos = (ArrayList<Equipo>) sportyfyCore.getEquipos();
        this.ventanaEquipos.inicializar();
        this.ventanaEquipos.llenarCombos(equipos);
        accionCombo(sportyfyCore);
        iniciarVentanaPrediccion(sportyfyCore, controlador);
    }

    private void iniciarVentanaPrediccion(SportyfyCore sportyfyCore, VentanaHistorialControlador controlador) {
        ventanaEquipos.getBotonPrediccion().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String equipoSeleccionadoA;
                String equipoSeleccionadoB;
                equipoSeleccionadoA = (String) ventanaEquipos.getComboEquipoA().getSelectedItem();
                equipoSeleccionadoB = (String) ventanaEquipos.getComboEquipoB().getSelectedItem();

                ventanaEquipos.mostrar(false);
                VentanaResultadoControlador ResultadoControlador = new VentanaResultadoControlador(sportyfyCore, equipoSeleccionadoA, equipoSeleccionadoB);
                ResultadoControlador.iniciar(sportyfyCore, controlador);
            }
        });
    }

    private void accionCombo(SportyfyCore sportyfyCore) {
        ventanaEquipos.getComboEquipoA().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ventanaEquipos.actualizarComboB((ArrayList<Equipo>) sportyfyCore.getEquipos());
            }
        });
    }


}