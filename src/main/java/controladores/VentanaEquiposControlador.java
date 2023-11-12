package controladores;

import sportyfy.core.Pronosticador;
import sportyfy.core.entidades.core.SportyfyCore;
import sportyfy.core.entidades.equipo.Equipo;
import sportyfy.ui.VentanaEquipos;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

public class VentanaEquiposControlador {
    VentanaEquipos ventanaEquipos;

    public VentanaEquiposControlador() {
        this.ventanaEquipos = new VentanaEquipos();
    }

    public void iniciar(SportyfyCore sportyfyCore, String nombrePronosticador, VentanaHistorialControlador controladorHistorial) {
        Set<Equipo> equipos = traerEquipos(sportyfyCore, nombrePronosticador);
        this.ventanaEquipos.inicializar();
        if (!equipos.isEmpty()) {
            this.ventanaEquipos.llenarCombos(equipos);
        }
        accionCombo(sportyfyCore, nombrePronosticador);
        iniciarVentanaPrediccion(sportyfyCore, nombrePronosticador, controladorHistorial);
    }

    private Set<Equipo> traerEquipos(SportyfyCore sportyfyCore, String nombrePronosticador) {
        Set<Equipo> equipos = new HashSet<>();
        for(Pronosticador p : sportyfyCore.getPronosticadores()){
            if(p.getClass().getSimpleName().equals(nombrePronosticador)){
                equipos = p.getEquipos();
            }
        }
        return equipos;
    }

    private void iniciarVentanaPrediccion(SportyfyCore sportyfyCore, String nombrePronosticador, VentanaHistorialControlador controladorHistorial) {
        ventanaEquipos.getBotonPrediccion().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String equipoSeleccionadoA;
                String equipoSeleccionadoB;
                equipoSeleccionadoA = (String) ventanaEquipos.getComboEquipoA().getSelectedItem();
                equipoSeleccionadoB = (String) ventanaEquipos.getComboEquipoB().getSelectedItem();

                ventanaEquipos.mostrar(false);
                VentanaResultadoControlador controladorResultado = new VentanaResultadoControlador(equipoSeleccionadoA, equipoSeleccionadoB);
                controladorResultado.iniciar(sportyfyCore, nombrePronosticador, controladorHistorial);
            }
        });
    }

    private void accionCombo(SportyfyCore sportyfyCore, String nombrePronosticador) {
        ventanaEquipos.getComboEquipoA().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Set<Equipo> equipos = traerEquipos(sportyfyCore, nombrePronosticador);
                ventanaEquipos.actualizarComboB(equipos);
            }
        });
    }
}