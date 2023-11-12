package controladores;

import sportyfy.core.Pronosticador;
import sportyfy.core.entidades.core.SportyfyCore;
import sportyfy.core.entidades.equipo.Equipo;
import sportyfy.ui.VentanaEquipos;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class VentanaEquiposControlador {
    VentanaEquipos ventanaEquipos;

    public VentanaEquiposControlador() {
        this.ventanaEquipos = new VentanaEquipos();
    }

    public void iniciar(SportyfyCore sportyfyCore,String nombrePronosticador, VentanaHistorialControlador controlador) {
        Set<Equipo> equipos = traerEquipos(sportyfyCore, nombrePronosticador);
        this.ventanaEquipos.inicializar();
        if (!equipos.isEmpty()) {
            this.ventanaEquipos.llenarCombos(equipos);
        }
        else{
           System.out.print("NO SE ESTAN TRAYENDO CORRECTAMENTE LOS EQUIPOS");
        }
        accionCombo(sportyfyCore, nombrePronosticador);
        iniciarVentanaPrediccion(sportyfyCore, nombrePronosticador, controlador);
    }

    private Set<Equipo> traerEquipos(SportyfyCore sportyfyCore, String nombrePronosticador) {
        Set<Equipo> equipos = new HashSet<>();
        for(Pronosticador p : sportyfyCore.getPronosticadores()){
            if(p.getDeporte().equals(nombrePronosticador)){
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

                if(equipoSeleccionadoA != null && equipoSeleccionadoA.equals(equipoSeleccionadoB)){
                    JOptionPane.showMessageDialog(null, "Debes seleccionar dos equipos distintos!");
                }
                else{
                    ventanaEquipos.mostrar(false);
                    VentanaResultadoControlador controlador = new VentanaResultadoControlador(sportyfyCore, equipoSeleccionadoA, equipoSeleccionadoB);
                    controlador.iniciar(sportyfyCore,nombrePronosticador, controladorHistorial);
                }
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