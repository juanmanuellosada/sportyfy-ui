package controladores;

import lombok.Getter;
import sportyfy.core.entidades.equipo.Equipo;
import sportyfy.core.entidades.resultado.Resultado;
import sportyfy.historial.Historial;
import sportyfy.ui.VentanaHistorial;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.lang.Integer.compare;

@Getter
public class VentanaHistorialControlador {
    private final Historial historial;
    private final VentanaHistorial ventanaHistorial;

    public VentanaHistorialControlador(){
        this.ventanaHistorial = new VentanaHistorial();
        this.historial = new Historial();
    }

    public void iniciar(){
        accionBotonAtras();
    }

    public void cargarPantalla() {
        ventanaHistorial.mostrar(true);
        ventanaHistorial.setFecha(getFecha());
        ventanaHistorial.llenarVentana(mostrarPronosticos(this.historial));
    }

    private void accionBotonAtras() {
        this.ventanaHistorial.getBotonAtras().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ventanaHistorial.mostrar(false);
            }
        });
    }

    public String mostrarPronosticos(Historial historial){
        StringBuilder ret = new StringBuilder("<html>");
        for (Resultado resultado : historial.getPronosticosRealizados().values()){

            String aux = "&nbsp;"+ resultado.getPrimerEquipo().getNombre() +" <b> "+ obtenerMarcador(resultado, resultado.getPrimerEquipo()) +" - ";
            aux += obtenerMarcador(resultado, resultado.getSegundoEquipo())+" </b>"+resultado.getSegundoEquipo().getNombre()+"<br>";

            String ganador = nombreGanador(obtenerGanador(resultado));
            if(!ganador.isEmpty())
                aux += darColor(169,254,88,"&nbsp;&nbsp;Ganador: "+ganador+"<br><br>");
            else
                aux += darColor(169,254,88,"&nbsp;&nbsp;Empate<br><br>");
            ret.append(aux);
        }
        ret.append("<html>");
        return ret.toString();
    }

    private int obtenerMarcador(Resultado r, Equipo e){
        int marcador = 0;
        if(r.getMarcador(e).isPresent())
            marcador = r.getMarcador(e).get();
        return marcador;
    }

    private String nombreGanador(Equipo e){
        if(e != null)
            return e.getNombre();
        else
            return "";
    }

    private Equipo obtenerGanador(Resultado resultado){
        Optional<Integer> primerMarcador = resultado.getMarcador(resultado.getPrimerEquipo());
        Optional<Integer> segundoMarcador = resultado.getMarcador(resultado.getSegundoEquipo());

        if(primerMarcador.isPresent() && segundoMarcador.isPresent()) {
            int rtdoComparacion = compare(primerMarcador.get(), segundoMarcador.get());

            switch (rtdoComparacion) {
                case 1:
                    return resultado.getPrimerEquipo();
                case 0:
                    return null;
                case -1:
                    return resultado.getSegundoEquipo();
            }
        }
        else{
            if(primerMarcador.isPresent())
                return resultado.getPrimerEquipo();
            else
                return resultado.getSegundoEquipo();
        }
        return null;
    }

    private String getFecha() {
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
