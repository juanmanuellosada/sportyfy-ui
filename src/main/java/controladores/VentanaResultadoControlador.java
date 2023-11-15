package controladores;

import sportyfy.core.Pronosticador;
import sportyfy.core.entidades.core.SportyfyCore;
import sportyfy.core.entidades.equipo.Equipo;
import sportyfy.core.entidades.partido.Partido;
import sportyfy.core.entidades.resultado.Resultado;
import sportyfy.ui.VentanaResultado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

public class VentanaResultadoControlador {
    VentanaResultado ventanaResultado;
    private final String primerEquipo;
    private final String segundoEquipo;

    public VentanaResultadoControlador(String primerEquipo, String segundoEquipo){
        this.primerEquipo = primerEquipo;
        this.segundoEquipo = segundoEquipo;
        this.ventanaResultado = new VentanaResultado();
    }

    public void iniciar(SportyfyCore sportyfyCore, String nombrePronosticador, VentanaHistorialControlador controladorHistorial) {
        this.ventanaResultado.inicializar();

        Partido partido = new Partido (buscarEquipo(primerEquipo, sportyfyCore), buscarEquipo(segundoEquipo, sportyfyCore));
        Resultado resultado = sportyfyCore.pronosticar(partido, nombrePronosticador);

        ventanaResultado.mostrarResultado(resultado);
        nuevaPrediccion(sportyfyCore, controladorHistorial);
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

    public Equipo buscarEquipo(String nombre, SportyfyCore sportyfyCore){
        Set<Equipo> equipos = traerEquipos(sportyfyCore);
        for (Equipo equipo : equipos){
            if(equipo.getNombre().equals(nombre)) return equipo;
        }
        return null;
    }

    private Set<Equipo> traerEquipos(SportyfyCore sportyfyCore) {
        Set<Equipo> equipos = new HashSet<>();
        for(Pronosticador p : sportyfyCore.getPronosticadores()){
                equipos = p.getEquipos();
        }
        return equipos;
    }
}