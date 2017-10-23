package com.ws.grv.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validador {

    public static DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    public static DateFormat DATE_HOUR_FORMAT = new SimpleDateFormat("dd/MM/yyyy hh:mm");

    public static boolean esVacio(String cadena) {
        return (cadena == null || cadena.trim().isEmpty());
    }

    public static boolean cadena(String cadena, int longitud) {
        String patron = "^[\\sa-zA-ZÑÁÉÍÓÚñáéíóú]{1,}[\\w\\s\\./]{0,}";
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) == ' ') {
                cadena = cadena.substring(i + 1, cadena.length());
                i--;
            } else {
                break;
            }
        }
        if (cadena.length() > longitud) {
            return false;
        } else {
            Pattern pat = Pattern.compile(patron);
            Matcher mat = pat.matcher(cadena);
            if (mat.matches()) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static boolean cadenaSN(String cadena, int longitud) {
        String patron = "[\\sa-zA-ZÑÁÉÍÓÚñáéíóú][\\w\\s\\./]";

        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) == ' ') {
                cadena = cadena.substring(i + 1, cadena.length());
                i--;
            } else {
                break;
            }
        }

        if (cadena.length() > longitud) {
            return false;
        } else {
            Pattern pat = Pattern.compile(patron);
            Matcher mat = pat.matcher(cadena);
            if (mat.matches()) {
                return true;
            } else {
                return false;
            }
        }
    }

    public static boolean boleano(int estado) {
        String patron = "[01]{1}";

        Pattern pat = Pattern.compile(patron);
        Matcher mat = pat.matcher(String.valueOf(estado));
        if (mat.matches()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean numeroEntero(int numero) {
        String patron = "^[0-9]{1,}";

        Pattern pat = Pattern.compile(patron);
        Matcher mat = pat.matcher(String.valueOf(numero));
        if (mat.matches()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean esNumerico(String numero) {
        String patron = "[0-9]*";

        Pattern pat = Pattern.compile(patron);
        Matcher mat = pat.matcher(numero);
        if (mat.matches()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean numeroEntero(int numero, int longitud) {
        String patron = "^[0-9]{1," + longitud + "}";

        Pattern pat = Pattern.compile(patron);
        Matcher mat = pat.matcher(String.valueOf(numero));
        if (mat.matches()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean ruc(String ruc) {
        String patron = "^[12]{1}0{1}[0-9]{9}";

        Pattern pat = Pattern.compile(patron);
        Matcher mat = pat.matcher(ruc);
        if (mat.matches()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean menorIgual(Date tope, Date fecha) {
        try {
            if (tope.after(fecha) || tope.equals(fecha)) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public static boolean mayor(Date tope, Date fecha) {
        try {
            if (tope.before(fecha)) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public static boolean menor(Date tope, Date fecha) {
        try {
            if (tope.after(fecha)) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

    public static boolean between(Date inicio, Date fin, Date fecha) {
        try {
            if (inicio.before(fecha) || inicio.equals(fecha)) {
                if (fin.after(fecha) || fin.equals(fecha)) {
                    return true;
                }
            }
        } catch (Exception e) {
        }
        return false;
    }

    public static <T> T[] toArray(T[] ts, List<T> list) throws Exception {
        for (int i = 0; i < list.size(); i++) {
            ts[i] = list.get(i);
        }
        list.toArray(ts);
        return ts;
    }

    public static boolean mayorIgual(Date tope, Date fecha) {
        try {
            if (tope.before(fecha) || tope.equals(fecha)) {
                return true;
            }
        } catch (Exception e) {
        }
        return false;
    }

//    public static ApplicationContext getApplicationContext() {
//        if (applicationContext == null) {
//            try {
//                applicationContext = new ClassPathXmlApplicationContext("classpath:/com/solmit/compra/modelo/conf/application-context-solmit-compra-main-desarrollo.xml");
//            } catch (BeansException beansException) {
//                beansException.printStackTrace();
//            }
//        }
//        return applicationContext;
//    }
    public static long diferenciaFechas(Date f_mayor, Date f_menor) {
        try {
            return f_mayor.getTime() - f_menor.getTime();
        } catch (Exception e) {
        }
        return 0;
    }

    private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    /**
     * Validate given email with regular expression.
     *
     * @param email email for validation
     * @return true valid email, otherwise false
     */
    public static boolean validateEmail(String email) {

        // Compiles the given regular expression into a pattern.
        Pattern pattern = Pattern.compile(PATTERN_EMAIL);

        // Match the given input against this pattern
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();

    }

    public static Map<String, Integer> obtener_diferencias_d_h_m_s(Date fechaMayor, Date fechaMenor) {
        long dif = Validador.diferenciaFechas(fechaMayor, fechaMenor);
        long segundos = dif / 1000;
        long minutos = dif / 1000 / 60;
        long horas = dif / 1000 / 60 / 60;
        long dias = dif / 1000 / 60 / 60 / 24;
        segundos = segundos - (minutos * 60);
        minutos = minutos - (horas * 60);
        horas = horas - (dias * 24);
        Map<String, Integer> map = new HashMap<>();
        map.put("d", Integer.valueOf(String.valueOf(dias)));
        map.put("h", Integer.valueOf(String.valueOf(horas)));
        map.put("m", Integer.valueOf(String.valueOf(minutos)));
        map.put("s", Integer.valueOf(String.valueOf(segundos)));
        return map;
    }

//    //Médoto para comparar si las fechas son iguales...
//    public static int comparaFechas(Date fechaInicio, Date fechaFin, int dias, int horas, int minutos) {
//        int resp = 0;
//        try {
//            Calendar calendar = Calendar.getInstance();
//            calendar.setTime(fechaInicio);
//            calendar.add(Calendar.DAY_OF_YEAR, dias);
//            calendar.add(Calendar.HOUR, horas);
//            calendar.add(Calendar.MINUTE, minutos);
//            Date fechainicio = calendar.getTime();
//            resp = fechainicio.compareTo(fechaFin);
//        } catch (Exception e) {
//            e.getMessage();
//        }
//        return resp;
//    }
    //Concatena la duración de días, horas y minutos...
    public static String concatenaDuracion(int dias, int horas, int minutos) {
        String duracion = (dias < 10 ? "0" + dias : dias) + ":" + (horas < 10 ? "0" + horas : horas) + ":" + (minutos < 10 ? "0" + minutos : minutos);
        return duracion;
    }

}
