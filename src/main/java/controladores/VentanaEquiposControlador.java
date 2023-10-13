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

    public void iniciar(SportyfyCore sportyfyCore,String nombrePronosticador) {
        ArrayList<Equipo> equipos = (ArrayList<Equipo>) sportyfyCore.getEquipos();
        this.ventanaEquipos.inicializar();
        this.ventanaEquipos.llenarCombos(equipos);
        accionCombo(sportyfyCore);
        iniciarVentanaPrediccion(sportyfyCore,nombrePronosticador);
    }

    private void iniciarVentanaPrediccion(SportyfyCore sportyfyCore, String nombrePronosticador) {
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
                    controlador.iniciar(sportyfyCore,nombrePronosticador);
                }
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