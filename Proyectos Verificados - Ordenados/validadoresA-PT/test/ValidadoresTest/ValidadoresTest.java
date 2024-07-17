/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ValidadoresTest;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import validores.Validadores;

/**
 *
 * @author KarinaCV
 */
public class ValidadoresTest {

    public ValidadoresTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }


    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    /**
     * Prueba unitaria del metodo cadenaVacia de la clase Validadores.
     */
    @Test
    public void testCadenaVacia() {
        Validadores instance = new Validadores();
        boolean result;
        String s;
        System.out.println("Prueba unitaria del metodo cadenaVacia");
        // Prueba si acepta una cadena vacia
        s = "";
        result = instance.cadenaVacia(s);
        assertTrue(result);
        // Prueba si acepta una cadena con espacios
        s = " ";
        result = instance.cadenaVacia(s);
        assertTrue(result);
        // Prueba si acepta una cadena con caracter tabulador
        s = " \t";
        result = instance.cadenaVacia(s);
        assertTrue(result);
        // Prueba si acepta una cadena con caracter tabulador
        s = " \n";
        result = instance.cadenaVacia(s);
        assertTrue(result);
        // Prueba si rechaza una cadena no vacia
        s = "no\nno";
        result = instance.cadenaVacia(s);
        assertFalse(result);
    }

    /**
     * Prueba unitaria del metodo validaCadena de la clase Validadores.
     */
    @Test
    public void testValidaCadena() {
        Validadores instance = new Validadores();
        boolean result;
        String s;
        int longMax;
        System.out.println("Prueba unitaria del metodo validaCadena");
        // Prueba si acepta una cadena de longitud igual a longMax
        longMax = 5;
        s = "12345";
        result = instance.validaCadena(longMax, s);
        assertTrue(result);
        // Prueba si acepta una cadena de longitud menor a longMax
        longMax = 5;
        s = "123";
        result = instance.validaCadena(longMax, s);
        assertTrue(result);
        // Prueba si rechaza una cadena de longitud mayor a longMax
        longMax = 5;
        s = "1234567";
        result = instance.validaCadena(longMax, s);
        assertFalse(result);
        // Prueba si rechaza una cadena vacia
        longMax = 5;
        s = "";
        result = instance.validaCadena(longMax, s);
        assertFalse(result);
    }

    /**
     * Prueba unitaria del metodo validaClave de la clase Validadores.
     */
    @Test
    public void testValidaClave() {
        Validadores instance = new Validadores();
        boolean result;
        String s;
        System.out.println("Prueba unitaria del metodo validaClave");
        // Prueba si acepta una clave valida
        s = "ABC0123";
        result = instance.validaClave(s);
        assertTrue(result);
        // Prueba si rechaza una clave con minusculas
        s = "abc0123";
        result = instance.validaClave(s);
        assertFalse(result);
        // Prueba si rechaza una clave con otros caracteres
        s = "AB+;0123";
        result = instance.validaClave(s);
        assertFalse(result);
        // Prueba si rechaza una clave vacia
        s = "";
        result = instance.validaClave(s);
        assertFalse(result);
        // Prueba si rechaza una clave con espacios
        s = " ";
        result = instance.validaClave(s);
        assertFalse(result);
        // Prueba si rechaza una clave con solo caracteres
        s = "ABC";
        result = instance.validaClave(s);
        assertFalse(result);
        // Prueba si rechaza una clave con solo digitos
        s = "0123";
        result = instance.validaClave(s);
        assertFalse(result);
        // Prueba si rechaza una clave con mas caracteres
        s = "ABCD0123";
        result = instance.validaClave(s);
        assertFalse(result);
        // Prueba si rechaza una clave con menos caracteres
        s = "AB0123";
        result = instance.validaClave(s);
        assertFalse(result);
        // Prueba si rechaza una clave con mas digitos
        s = "ABC01234";
        result = instance.validaClave(s);
        assertFalse(result);
        // Prueba si rechaza una clave con menos digitos
        s = "ABC012";
        result = instance.validaClave(s);
        assertFalse(result);
    }

    /**
     * Prueba unitaria del metodo validaEntero de la clase Validadores.
     */
    @Test
    public void testValidaEntero() {
        Validadores instance = new Validadores();
        boolean result;
        String s;
        System.out.println("Prueba unitaria del metodo validaEntero");
        // Prueba si acepta un entero valido
        s = "1234";
        result = instance.validaEntero(s);
        assertTrue(result);
        // Prueba si rechaza una cadena con letras
        s = "12a3";
        result = instance.validaEntero(s);
        assertFalse(result);
        // Prueba si rechaza una cadena con otros caracteres
        s = "A12+;0";
        result = instance.validaEntero(s);
        assertFalse(result);
        // Prueba si rechaza una cadena vacia
        s = "";
        result = instance.validaEntero(s);
        assertFalse(result);
        // Prueba si rechaza una cadena con espaciosa
        s = " ";
        result = instance.validaEntero(s);
        assertFalse(result);
    }

    /**
     * Prueba unitaria del metodo validaEnteroMaxDigitos de la clase
     * Validadores.
     */
    @Test
    public void testValidaEnteroMaxDigitos() {
        Validadores instance = new Validadores();
        boolean result;
        String s;
        int numDigitos;
        System.out.println(
                "Prueba unitaria del metodo validaEnteroMaxDigitos");
        // Prueba si acepta un entero valido
        numDigitos = 1;
        s = "1";
        result = instance.validaEnteroMaxDigitos(numDigitos, s);
        assertTrue(result);
        // Prueba si acepta un entero valido
        numDigitos = 5;
        s = "12345";
        result = instance.validaEnteroMaxDigitos(numDigitos, s);
        assertTrue(result);
        // Prueba si acepta un entero valido
        numDigitos = 5;
        s = "1234";
        result = instance.validaEnteroMaxDigitos(numDigitos, s);
        assertTrue(result);
        // Prueba si rechaza un entero muy largo
        numDigitos = 5;
        s = "124567";
        result = instance.validaEnteroMaxDigitos(numDigitos, s);
        assertFalse(result);
        // Prueba si rechaza un entero con letras
        numDigitos = 5;
        s = "12a3";
        result = instance.validaEnteroMaxDigitos(numDigitos, s);
        assertFalse(result);
        // Prueba si rechaza una cadena con otros caracteres
        numDigitos = 5;
        s = "A12+;0";
        result = instance.validaEnteroMaxDigitos(numDigitos, s);
        assertFalse(result);
        // Prueba si rechaza una cadena vacia
        numDigitos = 5;
        s = "";
        result = instance.validaEnteroMaxDigitos(numDigitos, s);
        assertFalse(result);
        // Prueba si rechaza una cadena con espaciosa
        numDigitos = 5;
        s = " ";
        result = instance.validaEnteroMaxDigitos(numDigitos, s);
        assertFalse(result);
    }

    /**
     * Prueba unitaria del metodo validaEnteroRango de la clase Validadores.
     */
    @Test
    public void testValidaEnteroRango() {
        Validadores instance = new Validadores();
        boolean result;
        String s;
        int min, max;
        System.out.println("Prueba unitaria del metodo validaEnteroRango");
        min = 10;
        max = 100;
        // Prueba si acepta un entero con rango valido
        s = "50";
        result = instance.validaEnteroRango(min, max, s);
        assertTrue(result);
        // Prueba si acepta un entero con rango valido
        s = "10";
        result = instance.validaEnteroRango(min, max, s);
        assertTrue(result);
        // Prueba si acepta un entero con rango valido
        s = "100";
        result = instance.validaEnteroRango(min, max, s);
        assertTrue(result);
        // Prueba si rechaza un entero con por debajo del rango
        s = "5";
        result = instance.validaEnteroRango(min, max, s);
        assertFalse(result);
        // Prueba si rechaza un entero con por encima del rango
        s = "500";
        result = instance.validaEnteroRango(min, max, s);
        assertFalse(result);
    }

    /**
     * Prueba unitaria del metodo validaFecha de la clase Validadores.
     */
    @Test
    public void testValidaFecha() {
        Validadores instance = new Validadores();
        boolean result;
        String s;
        System.out.println("Prueba unitaria del metodo validaFecha");
        // Prueba si acepta una fecha valida
        s = "1/1/2001";
        result = instance.validaFecha(s);
        assertTrue(result);
        // Prueba si acepta una fecha valida
        s = "01/01/2010";
        result = instance.validaFecha(s);
        assertTrue(result);
        // Prueba si acepta una fecha valida
        s = "15/12/2001";
        result = instance.validaFecha(s);
        assertTrue(result);
        // Prueba si acepta una fecha valida
        s = "21/08/2000";
        result = instance.validaFecha(s);
        assertTrue(result);
        // Prueba si acepta una fecha valida
        s = "31/1/2001";
        result = instance.validaFecha(s);
        assertTrue(result);
        // Prueba si rechaza una fecha invalida
        s = "11/2001";
        result = instance.validaFecha(s);
        assertFalse(result);
        // Prueba si rechaza una fecha invalida
        s = "51/13/2001";
        result = instance.validaFecha(s);
        assertFalse(result);
        // Prueba si rechaza una fecha valida
        s = "0/0/201";
        result = instance.validaFecha(s);
        assertFalse(result);
        // Prueba si rechaza una fecha valida
        s = "12/ago/2001";
        result = instance.validaFecha(s);
        assertFalse(result);
    }
}
