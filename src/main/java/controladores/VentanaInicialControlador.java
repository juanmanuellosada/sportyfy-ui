package controladores;

import sportyfy.core.BuscadorPronosticadores;
import sportyfy.core.core.SportyfyCore;
import sportyfy.ui.VentanaInicial;

import java.awt.*;
import java.awt.event.ActionEvent;
import sportyfy.core.Pronosticador;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class VentanaInicialControlador {
   VentanaInicial ventanaInicial;

    public VentanaInicialControlador(){
       this.ventanaInicial = new VentanaInicial();
    }

    public void iniciar(SportyfyCore sportyfyCore) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, InstantiationException, NoSuchMethodException, FileNotFoundException, UnsupportedEncodingException {
        this.ventanaInicial.inicializar();
        this.ventanaInicial.llenarCombo(obtenerPronosticadores(sportyfyCore));
        inicializarPanelEquipos(sportyfyCore);
    }

    private void inicializarPanelEquipos(SportyfyCore sportyfyCore) {
        JComboBox comboDeportes = ventanaInicial.getComboDeportes();
        Component[] comboDeportesComponentes = comboDeportes.getComponents();

        for (Component componente : comboDeportesComponentes) {
            componente.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    try {
                        Set<Pronosticador> pronosticadores = new BuscadorPronosticadores().buscarPronosticadores("src/pronosticadores");
                        if (hayCambiosPronosticadores(obtenerPronosticadores(sportyfyCore),pronosticadores)){
                            sportyfyCore.setPronosticadores(pronosticadores);
                            comboDeportes.removeAllItems();
                            ventanaInicial.llenarCombo(obtenerPronosticadores(sportyfyCore));
                            System.out.println("reconoce el evento de hacer click en el ComboBox");
                        }
                    } catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
        }

        ventanaInicial.getBotonContinuar().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ventanaInicial.mostrar(false);
                String nombrePronosticadorElegido = ventanaInicial.getComboDeportes().getSelectedItem().toString();
                VentanaEquiposControlador ventanaEquiposController = new VentanaEquiposControlador();
                ventanaEquiposController.iniciar(sportyfyCore,nombrePronosticadorElegido);

            }
        });
    }

    public boolean hayCambiosPronosticadores(List<String> nombresPronosticadores, Set<Pronosticador> pronosticadores){
        if(nombresPronosticadores.size() != pronosticadores.size()) return true;
        for(Pronosticador pronosticador : pronosticadores){
            if(!nombresPronosticadores.contains(pronosticador.getClass().getSimpleName()))
                return true;
        }
        return false;

    }
    public List<String> obtenerPronosticadores(SportyfyCore sportyfyCore) {
        return sportyfyCore.obtenerNombresPronosticadores(sportyfyCore.getPronosticadores());
    }
}