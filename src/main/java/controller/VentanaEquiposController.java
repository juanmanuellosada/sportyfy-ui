package controller;

import sportyfy.ui.VentanaEquipos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaEquiposController {//implements ActionListener {
    VentanaEquipos ventanaEquipos;
    String equipoSeleccionadoA;
    String equipoSeleccionadoB;

    public VentanaEquiposController(){
       this.ventanaEquipos = new VentanaEquipos();
    }

    public void extracted() {
        this.ventanaEquipos.inicializar();
//        this.ventanaEquipos.getBoton().addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                String equipoSeleccionadoA;
//                equipoSeleccionadoA = (String)ventanaEquipos.getComboEquipoA().getSelectedItem();
//                equipoSeleccionadoB = (String)ventanaEquipos.getComboEquipoB().getSelectedItem();
//                System.out.println(equipoSeleccionadoA);
//
//            }
//        });
    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//        equipoSeleccionadoA = (String)this.ventanaEquipos.getComboEquipoA().getSelectedItem();
//        equipoSeleccionadoB = (String) this.ventanaEquipos.getComboEquipoB().getSelectedItem();
//        System.out.println(equipoSeleccionadoA);
//    }
}
