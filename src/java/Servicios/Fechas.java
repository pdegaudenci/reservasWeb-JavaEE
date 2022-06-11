package Servicios;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author pdega
 */
public class Fechas {

    public static boolean fechasSolapas(Date[] fecha1, Date[] fecha2) {
        boolean solapadas = true;
        if (fecha1[0].equals(fecha2[0]) || fecha1[1].equals(fecha2[1])) {
            return true;
        }
        if ((fecha1[0].after(fecha2[1]) || fecha1[1].before(fecha2[0]))) {
            return false;
        }
        return solapadas;
    }

    public static Date formatFechaStringToDate(String fecha) {
        String[] aFecha = fecha.split("-");
        int anio = Integer.parseInt(aFecha[0]);
        int mes = Integer.parseInt(aFecha[1]);
        int dia = Integer.parseInt(aFecha[2]);
        /*
                El metodo constructor de la clase Date suma 1900 al primer parametro (al año)
                Y los meses estan comprendidos entre 0 y 11
         */
        return new Date(anio - 1900, mes - 1, dia);
    }

    public static String formatFechaDateToString(Date fecha) {
        SimpleDateFormat formateador = new SimpleDateFormat("yyyy-MM-dd");
        return formateador.format(fecha);
    }

    public static int diferenciaDeDias(Date fechaInicio, Date fechaFin) {
        int milisegundosXDia = 86400000;
        int diasDeDiferencia = (int) ((fechaFin.getTime() - fechaInicio.getTime()) / milisegundosXDia);
        return diasDeDiferencia;
    }

}
