package controladores;

import sportyfy.ui.VentanaEquipos;

public class VentanaEquiposControlador {//implements ActionListener {
    VentanaEquipos ventanaEquipos;
    String equipoSeleccionadoA;
    String equipoSeleccionadoB;

    public VentanaEquiposControlador(){
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
