package controladores;

import sportyfy.core.core.SportyfyCore;
import sportyfy.core.entidades.equipo.Equipo;
import sportyfy.core.entidades.partido.PartidoFuturo;
import sportyfy.ui.VentanaResultado;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class VentanaResultadoControlador {
    VentanaResultado ventanaResultado;
    private SportyfyCore iniciador;
    private String local;
    private String visitante;

    public VentanaResultadoControlador(SportyfyCore sportyfyCore, String local, String visitante){
       this.iniciador = sportyfyCore;
       this.local = local;
       this.visitante = visitante;
       this.ventanaResultado = new VentanaResultado();
    }

    public void iniciar(SportyfyCore sportyfyCore) {
        this.ventanaResultado.inicializar();
        sportyfyCore.addObserver(this.ventanaResultado);

        PartidoFuturo partidoFuturo = new PartidoFuturo(buscarEquipo(local),buscarEquipo(visitante));
        sportyfyCore.pronosticar(partidoFuturo,iniciador.getPartidosJugados());
        nuevaPrediccion(sportyfyCore);
    }

    public Equipo buscarEquipo(String nombre){
        List<Equipo> equipos = iniciador.getEquipos();
        for (Equipo equipo : equipos){
            if(equipo.getNombre().equals(nombre)) return equipo;
        }
        return null;
    }

    private void nuevaPrediccion(SportyfyCore sportyfyCore) {
        this.ventanaResultado.getBotonNuevaPrediccion().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
                ventanaResultado.mostrar(false);
                VentanaInicialControlador ventanaInicialControlador = new VentanaInicialControlador();
                try {
                    ventanaInicialControlador.iniciar(sportyfyCore);
                }
                catch (ClassNotFoundException | InvocationTargetException | IllegalAccessException |
                       InstantiationException | NoSuchMethodException | FileNotFoundException |
                       UnsupportedEncodingException exception ) {
                    exception.printStackTrace();
                }
            }
        });
    }
}