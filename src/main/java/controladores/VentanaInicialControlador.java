package controladores;

import sportyfy.core.servicios.buscadores.BuscadorPronosticadores;
import sportyfy.ui.VentanaInicial;
import java.awt.*;
import java.awt.event.ActionEvent;
import sportyfy.core.Pronosticador;
import sportyfy.core.entidades.core.SportyfyCore;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class VentanaInicialControlador {
   private final VentanaInicial ventanaInicial;

    public VentanaInicialControlador(){
       this.ventanaInicial = new VentanaInicial();
    }

    public void iniciar(SportyfyCore sportyfyCore, VentanaHistorialControlador controladorHistorial) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException, FileNotFoundException, UnsupportedEncodingException {
        this.ventanaInicial.inicializar();
        this.ventanaInicial.llenarCombo(obtenerPronosticadores(sportyfyCore));
        inicializarPanelEquipos(sportyfyCore, controladorHistorial);
        abrirHistorial(controladorHistorial);
    }

    private void inicializarPanelEquipos(SportyfyCore sportyfyCore, VentanaHistorialControlador controladorHistorial) {

        JComboBox<String> comboPronosticadores = ventanaInicial.getComboPronosticadores();
        Component[] comboPronosticadoresComponentes = comboPronosticadores.getComponents();

        for (Component c : comboPronosticadoresComponentes) {
            c.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    try {
                        Set<Pronosticador> pronosticadores = new BuscadorPronosticadores().buscarPronosticadores("src/pronosticadores");
                        if (hayCambiosPronosticadores(obtenerPronosticadores(sportyfyCore), pronosticadores)){
                            sportyfyCore.setPronosticadores(pronosticadores);
                            comboPronosticadores.removeAllItems();
                            ventanaInicial.llenarCombo(obtenerPronosticadores(sportyfyCore));
                        }
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
        }

        ventanaInicial.getBotonContinuar().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ventanaInicial.mostrar(false);
                String nombrePronosticadorElegido = ventanaInicial.getComboPronosticadores().getSelectedItem().toString();
                VentanaEquiposControlador ventanaEquiposController = new VentanaEquiposControlador();
                ventanaEquiposController.iniciar(sportyfyCore, nombrePronosticadorElegido, controladorHistorial);
            }
        });
    }

    private void abrirHistorial(VentanaHistorialControlador controladorHistorial){
        this.ventanaInicial.getBotonHistorial().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controladorHistorial.iniciar();
                controladorHistorial.cargarPantalla();
            }
        });
    }

    public boolean hayCambiosPronosticadores(List<String> nombresPronosticadores, Set<Pronosticador> pronosticadores){
        if(nombresPronosticadores.size() != pronosticadores.size())
            return true;
        for(Pronosticador p : pronosticadores){
            if(!nombresPronosticadores.contains(p.getClass().getSimpleName()))
                return true;
        }
        return false;

    }

    public List<String> obtenerPronosticadores(SportyfyCore sportyfyCore) {
        List<String> ret = new ArrayList<>();
        for(Pronosticador p : sportyfyCore.getPronosticadores())
            ret.add(p.getClass().getSimpleName());
        return ret;
    }
}