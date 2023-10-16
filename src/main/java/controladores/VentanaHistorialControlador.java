package controladores;

import lombok.Getter;
import sportyfy.core.Pronostico;
import sportyfy.core.core.SportyfyCore;
import sportyfy.historial.Historial;
import sportyfy.ui.VentanaHistorial;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

@Getter
public class VentanaHistorialControlador {
    private final Historial historial;
    private final VentanaHistorial ventanaHistorial;

    public VentanaHistorialControlador(){
        this.ventanaHistorial = new VentanaHistorial();
        this.historial = new Historial();
    }

    public void iniciar(SportyfyCore sportyfyCore){
        sportyfyCore.addObserver(this.historial);
        accionAtras();
    }

    public void cargarPantalla() {
        ventanaHistorial.mostrar(true);
        ventanaHistorial.setFecha(getFecha());
        ventanaHistorial.llenarVentana(mostrarPronosticos((ArrayList<Pronostico>) this.historial.getPronosticosRealizados()));
    }

    private void accionAtras() {
        this.ventanaHistorial.getBotonAtras().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ventanaHistorial.mostrar(false);
            }
        });
    }

    public String mostrarPronosticos(ArrayList<Pronostico> pronosticos){
        StringBuilder listado = new StringBuilder("<html>");
        for(Pronostico p : pronosticos) {
            String aux = "&nbsp;";
            if(p.getEquipoGanador() != null){
                aux += p.getPartidoFuturo().getEquipoLocal().getNombre()+" - ";
                aux += p.getPartidoFuturo().getEquipoVisitante().getNombre()+"<br>";
                aux += darColor(169,254,88,"&nbsp;&nbsp;Ganador: "+p.getEquipoGanador().getNombre()+"<br><br>");
            }
            else{
                aux += p.getPartidoFuturo().getEquipoLocal().getNombre()+" vs. ";
                aux += p.getPartidoFuturo().getEquipoVisitante().getNombre()+"<br>";
                aux += darColor(169,254,88,"&nbsp;&nbsp;Empate<br><br>");

            }
            listado.append(aux);
        }
        listado.append("<html>");
        return listado.toString();
    }

    public String getFecha() {
        String ret = "Hoy - ";

        Date fechaActual = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaActual);

        SimpleDateFormat sdf = new SimpleDateFormat("EEEE", new Locale("es", "ES"));
        String nombreDia = sdf.format(fechaActual);
        ret += nombreDia+", "+calendar.get(Calendar.DAY_OF_MONTH)+" de ";

        SimpleDateFormat sdf2 = new SimpleDateFormat("MMMM", new Locale("es", "ES"));
        String nombreMes = sdf2.format(fechaActual);
        ret += nombreMes+" de "+calendar.get(Calendar.YEAR);

        return ret;
    }

    public String  darColor(int R, int G, int B, String s){
        return "<font color=\"rgb(" +R + "," + G + "," + B+ ")\">"+s+"</font>";
    }
}
