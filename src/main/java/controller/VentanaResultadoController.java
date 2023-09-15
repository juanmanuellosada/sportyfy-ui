package controller;

import sportyfy.core.IniciadorSportyfyCore;
import sportyfy.core.Pronosticador;
import sportyfy.core.Pronostico;
import sportyfy.core.futbol.Equipo;
import sportyfy.ui.VentanaResultado;

import java.util.List;

public class VentanaResultadoController {
    VentanaResultado ventanaResultado;
    private IniciadorSportyfyCore iniciador;
    private String local;
    private String visitante;
    private Equipo equipoLocal;
    private Equipo equipoVisitante;

    public VentanaResultadoController(IniciadorSportyfyCore iniciador, String local, String visitante){
       this.iniciador=iniciador;
       this.local = local;
       this.visitante = visitante;
       this.ventanaResultado = new VentanaResultado();
    }

    public void iniciar() {
        this.ventanaResultado.inicializar();
        Pronosticador pronosticador = iniciador.getBuscadorPronosticadores().getPronosticadores().iterator().next();
        Pronostico pronostico = pronosticador.pronosticar(buscarEquipo(local),buscarEquipo(visitante),iniciador.getPartidos());
        this.ventanaResultado.mensajeGanador(pronostico);
    }

    public Equipo buscarEquipo(String nombre){
        List<Equipo> equipos = iniciador.getEquipos();
        for (Equipo equipo : equipos){
            if(equipo.getNombre().equals(nombre)) return equipo;
        }
        return null;
    }



}
