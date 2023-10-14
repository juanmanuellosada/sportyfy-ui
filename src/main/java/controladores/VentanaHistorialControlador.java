package controladores;

import lombok.Getter;
import sportyfy.core.Pronostico;
import sportyfy.core.core.SportyfyCore;
import sportyfy.historial.Historial;
import sportyfy.ui.VentanaHistorial;
import java.util.ArrayList;

public class VentanaHistorialControlador {
    @Getter
    private Historial historial;
    @Getter
    private VentanaHistorial ventanaHistorial;

    public VentanaHistorialControlador(){
        this.ventanaHistorial = new VentanaHistorial();
        this.historial = new Historial();
    }

    public void iniciar(SportyfyCore sportyfyCore){
        sportyfyCore.addObserver(this.historial);
        ventanaHistorial.mostrar(true);
        ventanaHistorial.llenarVentana(mostrarPronosticos((ArrayList<Pronostico>) this.historial.getPronosticosRealizados()));
    }


    public String  darColor(int R, int G, int B, String s){
        return "<font color=\"rgb(" +R + "," + G + "," + B+ ")\">"+s+"</font>";
    }
    public String mostrarPronosticos(ArrayList<Pronostico> pronosticos){
        String listado = "<html>";
        for(Pronostico p : pronosticos) {
            String aux = "";
            if(p.getEquipoGanador() != null){
                aux = p.getPartidoFuturo().getEquipoLocal().getNombre()+" vs. ";
                aux += p.getPartidoFuturo().getEquipoVisitante().getNombre()+"<br>";
                aux += darColor(169,254,88,"<b>GANADOR: "+p.getEquipoGanador().getNombre()+"</b><br><br>");
            }
            else{
                aux += p.getPartidoFuturo().getEquipoLocal().getNombre()+" vs. ";
                aux += p.getPartidoFuturo().getEquipoVisitante().getNombre()+"<br>";
                aux += "<b>EMPATE</b><br><br>";

            }
            listado += aux;
        }
        listado += "<html>";
        return listado;
    }


}
