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
        abrirHistorial(sportyfyCore, controladorHistorial);
    }


    private void inicializarPanelEquipos(SportyfyCore sportyfyCore, VentanaHistorialControlador controladorHistorial) {
        JComboBox<String> comboDeportes = ventanaInicial.getComboDeportes();
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
                        }
                    } catch (FileNotFoundException ex) {
                        throw new RuntimeException(ex);
                    } catch (IOException ex) {
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
                ventanaEquiposController.iniciar(sportyfyCore, nombrePronosticadorElegido, controladorHistorial);

            }
        });
    }

    private void abrirHistorial(SportyfyCore sportyfyCore, VentanaHistorialControlador controlador){
        this.ventanaInicial.getBotonHistorial().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controlador.iniciar(sportyfyCore);
                controlador.cargarPantalla();

//                controlador.getVentanaHistorial().mostrar(true);
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
//        return sportyfyCore.obtenerNombresPronosticadores(sportyfyCore.getPronosticadores());
        List<String> ret = new ArrayList<>();
        for(Pronosticador p : sportyfyCore.getPronosticadores())
            ret.add(p.getDeporte());
        return ret;
    }
}