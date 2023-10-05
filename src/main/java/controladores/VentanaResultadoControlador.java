package controladores;

import sportyfy.core.Pronosticador;
import sportyfy.core.entidades.Equipo;
import sportyfy.core.modelo.SportyfyCore;
import sportyfy.ui.VentanaResultado;
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

        Pronosticador pronosticador = sportyfyCore.getBuscadorPronosticadores().getPronosticadores().iterator().next();
        sportyfyCore.pronosticar(buscarEquipo(local),buscarEquipo(visitante),iniciador.getPartidos(), pronosticador.getClass().getSimpleName());
    }

    public Equipo buscarEquipo(String nombre){
        List<Equipo> equipos = iniciador.getEquipos();
        for (Equipo equipo : equipos){
            if(equipo.getNombre().equals(nombre)) return equipo;
        }
        return null;
    }
}
