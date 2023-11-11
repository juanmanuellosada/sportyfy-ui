package controladores;

import sportyfy.core.Pronosticador;
import sportyfy.core.entidades.core.SportyfyCore;
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

    public void iniciar(SportyfyCore sportyfyCore,String nombrePronosticador, VentanaHistorialControlador controlador) {
        ArrayList<Equipo> equipos = traerEquipos(sportyfyCore, nombrePronosticador);
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

    private ArrayList<Equipo> traerEquipos(SportyfyCore sportyfyCore, String nombrePronosticador) {
        ArrayList<Equipo> equipos = new ArrayList<>();
        for(Pronosticador p : sportyfyCore.getPronosticadores()){
            if(p.getDeporte().equals(nombrePronosticador)){
                equipos = (ArrayList<Equipo>) p.getEquipos();
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
                ArrayList<Equipo> equipos = traerEquipos(sportyfyCore, nombrePronosticador);
                ventanaEquipos.actualizarComboB(equipos);
            }
        });
    }


}