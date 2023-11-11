package controladores;

import sportyfy.core.Pronosticador;
import sportyfy.core.entidades.core.SportyfyCore;
import sportyfy.core.entidades.equipo.Equipo;
import sportyfy.core.entidades.partido.Partido;
import sportyfy.ui.VentanaResultado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class VentanaResultadoControlador {
    VentanaResultado ventanaResultado;
    private final SportyfyCore iniciador;
    private final String local;
    private final String visitante;

    public VentanaResultadoControlador(SportyfyCore sportyfyCore, String local, String visitante){
       this.iniciador = sportyfyCore;
       this.local = local;
       this.visitante = visitante;
       this.ventanaResultado = new VentanaResultado();
    }

    public void iniciar(SportyfyCore sportyfyCore, String nombrePronosticador, VentanaHistorialControlador controladorHistorial) {
        this.ventanaResultado.inicializar();
        sportyfyCore.getNotificador().addPropertyChangeListener(controladorHistorial.getHistorial());

        Partido partidoFuturo = new Partido(buscarEquipo(local,sportyfyCore,nombrePronosticador),buscarEquipo(visitante,sportyfyCore,nombrePronosticador));
        sportyfyCore.pronosticar(partidoFuturo,nombrePronosticador);

        nuevaPrediccion(sportyfyCore, controladorHistorial);
    }

    public Equipo buscarEquipo(String nombre, SportyfyCore sportyfyCore, String nombrePronosticaodor){
        List<Equipo> equipos = traerEquipos(sportyfyCore, nombrePronosticaodor);
        for (Equipo equipo : equipos){
            if(equipo.getNombre().equals(nombre)) return equipo;
        }
        return null;
    }

    private void nuevaPrediccion(SportyfyCore sportyfyCore, VentanaHistorialControlador controladorHistorial) {
        this.ventanaResultado.getBotonNuevaPrediccion().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                ventanaResultado.mostrar(false);
                VentanaInicialControlador ventanaInicialControlador = new VentanaInicialControlador();
                try {
                    ventanaInicialControlador.iniciar(sportyfyCore, controladorHistorial);
                }
                catch (ClassNotFoundException | InvocationTargetException | IllegalAccessException |
                       InstantiationException | NoSuchMethodException | FileNotFoundException |
                       UnsupportedEncodingException exception) {
                    Logger logger = Logger.getLogger("VentanaResultadoControlador");
                    logger.severe(exception.getMessage());
                }
            }
        });
    }

    private ArrayList<Equipo> traerEquipos(SportyfyCore sportyfyCore, String nombrePronosticador) {
        ArrayList<Equipo> equipos = new ArrayList<>();
        for(Pronosticador p : sportyfyCore.getPronosticadores()){
            if(p.getClass().getName().equals(nombrePronosticador)){
                equipos = (ArrayList<Equipo>) p.getEquipos();
            }
        }
        return equipos;
    }
}