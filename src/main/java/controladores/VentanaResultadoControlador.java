package controladores;

import sportyfy.core.Pronosticador;
import sportyfy.core.Pronostico;
import sportyfy.core.entidades.Equipo;
import sportyfy.core.modelo.SportyfyCore;
import sportyfy.ui.VentanaResultado;
import java.util.List;

public class VentanaResultadoControlador {
    VentanaResultado ventanaResultado;
    private SportyfyCore iniciador;
    private String local;
    private String visitante;
    private Equipo equipoLocal;
    private Equipo equipoVisitante;

    public VentanaResultadoControlador(SportyfyCore sportyfyCore, String local, String visitante){
       this.iniciador=sportyfyCore;
       this.local = local;
       this.visitante = visitante;
       this.ventanaResultado = new VentanaResultado();
    }

    public void iniciar(SportyfyCore sportyfyCore) {
        this.ventanaResultado.inicializar();
//        Pronosticador pronosticador = iniciador.getBuscadorPronosticadores().getPronosticadores().iterator().next();
//        Pronostico pronostico = pronosticador.pronosticar(buscarEquipo(local),buscarEquipo(visitante),iniciador.getPartidos());

        Pronosticador pronosticador = sportyfyCore.getBuscadorPronosticadores().getPronosticadores().iterator().next();
        sportyfyCore.pronosticar(buscarEquipo(local),buscarEquipo(visitante),iniciador.getPartidos(), pronosticador.getClass().getSimpleName());
        Pronostico pronostico = sportyfyCore.getPronosticoActual();
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
