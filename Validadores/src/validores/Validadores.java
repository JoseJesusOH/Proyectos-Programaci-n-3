/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validores;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Esta clase provee de metodos para validar que las cadenas de sus parámetros
 * representan a datos de los tipos especificados por el metodo
 */
/**
 *
 * @author KarinaCV
 */
public class Validadores {

    /**
     * Valida si la cadena s está vacia.
     *
     * @param s Cadena a verificar
     * @return true si la cadena es vacia o nula, false en caso contrario.
     */
    public boolean cadenaVacia(String s) {
        CharSequence cadena = s;
        // Define una expresión regular para una cadena vacía
        String reCadena = "^\\s*$";
        // Compila la expresión regular a un patrón
        Pattern pattern = Pattern.compile(reCadena);
        // Crea un comparador para comparar la cadena contra el patrón
        Matcher matcher = pattern.matcher(cadena);
        // Si la cadena se ajusta al patrón
        if (matcher.matches()) {
            return true;
        }
        return false;
    }

    /**
     * Valida si la cadena s no excede la longitud longMax
     *
     * @param longMax Longitud máxima de la cadena
     * @param s Cadena a verificar
     * @return true si la cadena no excede la longitud longMax, false en caso
     * contrario
     *
     */
    public boolean validaCadena(int longMax, String s) {
        CharSequence cadena = s;
        // Define una expresión regular para una cadena de longitud máxima
        // dada por el parámetro longMax
        String reCadena = "^\\w{1," + longMax + "}$";
        // Compila la expresión regular a un patrón
        Pattern pattern = Pattern.compile(reCadena);
        // Crea un comparador para comparar la cadena contra el patrón
        Matcher matcher = pattern.matcher(cadena);
        // Si la cadena se ajusta al patrón
        if (matcher.matches()) {
            return true;
        }
        return false;
    }

    /**
     * Valida una clave. Una clave esta formada de 3 letras mayúsculas y 4
     * digitos
     *
     * @param s Clave a validar
     * @return true si es una clave valida, false en caso contrario
     */
    public boolean validaClave(String s) {
        CharSequence cadena = s.trim();
        // Define una expresión regular para una clave
        String reCadena = "^[A-Z]{3}[0-9]{4}$";
        // Compila la expresión regular a un patrón
        Pattern pattern = Pattern.compile(reCadena);
        // Crea un comparador para comparar la cadena contra el patrón
        Matcher matcher = pattern.matcher(cadena);
        // Si la cadena se ajusta al patrón
        if (matcher.matches()) {
            return true;
        }
        return false;
    }

    /**
     * Valida si la cadena s sólo contiene digitos.
     *
     * @param s Cadena a verificar
     * @return true si la cadena representa un entero, false en caso contrario.
     */
    public boolean validaEntero(String s) {
        CharSequence cadena = s.trim();
        // Define una expresión regular para una cadena con puros digitos
        String reCadena = "^\\d+$";
        // Compila la expresión regular a un patrón
        Pattern pattern = Pattern.compile(reCadena);
        // Crea un comparador para comparar la cadena contra el patrón
        Matcher matcher = pattern.matcher(cadena);
        // Si la cadena se ajusta al patrón
        if (matcher.matches()) {
            return true;
        }
        return false;
    }

    /**
     * Valida si la cadena s representa un entero positivo de no más de
     * numDigitos de longitud.
     *
     * @param s Cadena a verificar
     * @return true si la cadena representa un entero, false en caso contrario.
     */
    public boolean validaEnteroMaxDigitos(int numDigitos, String s) {
        CharSequence cadena = s.trim();
        // Define una expresión regular para una cadena con cuando mucho
        // numDigitos
        String reCadena = "^\\d{1," + numDigitos + "}$";
        // Compila la expresión regular a un patrón
        Pattern pattern = Pattern.compile(reCadena);
        // Crea un comparador para comparar la cadena contra el patrón
        Matcher matcher = pattern.matcher(cadena);
        // Si la cadena se ajusta al patrón
        if (matcher.matches()) {
            return true;
        }
        return false;
    }

    /**
     * Valida un entero positivo en el rango [min, max].
     *
     * @param min Limite inferior del entero
     * @param max Limite superior del entero
     * @param s Cadena a verificar
     * @return true si la cadena representa un entero, false en caso contrario.
     */
    public boolean validaEnteroRango(int min, int max, String s) {
        // valida que solo tenga digitos
        if (!validaEntero(s)) {
            return false;
        }
        // Convierte la cadena a un entero
        int n = Integer.parseInt(s);
        // Si la cadena no está en el rango dado
        if (n < min || n > max) {
            return false;
        }
        return true;
    }

    /**
     * Valida si la cadena s representa una fecha en el formato dd/mm/aaaa.
     *
     * @param s Cadena a verificar
     * @return true si la cadena representa una fecha en el formato dd/mm/aaaa,
     * false en caso contrario.
     */
    public boolean validaFecha(String s) {
        CharSequence cadena = s.trim();
        // Define una expresión regular para una fecha
        String reCadena = "^((0?[1-9])|([1-2]\\d)|([3][0-1]))\\/((0?[1-9])|(1[0-2]))\\/\\d{4}$";
        // Compila la expresión regular a un patrón
        Pattern pattern = Pattern.compile(reCadena);
        // Crea un comparador para comparar la cadena contra el patrón
        Matcher matcher = pattern.matcher(cadena);
        // Si la cadena se ajusta al patrón
        if (matcher.matches()) {
            return true;
        }
        return false;
    }
}
