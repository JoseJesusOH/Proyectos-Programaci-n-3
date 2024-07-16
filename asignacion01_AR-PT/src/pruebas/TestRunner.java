/*
* TestRunner.java
*
* Creada el e de septiembre de 2021, 9:28 PM
 */
package pruebas;

import codigo.VacioException;

/**
 * Clase Principal.
 * Alumno; José Jesús Orozco Hernández ID:00000229141
 *
 * @author José Jesús Orozco Hernández
 */
public class TestRunner {
    private static int numErrores = 0;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArreglosTest ct = new ArreglosTest();
        //Bloques try catch para evaluar los metodos de la clase ArreglosTest
        ct.testVacio();
        try {
            ct.testSuma();
        } catch (VacioException e) {
            numErrores++;
            e.printStackTrace();
        }
        try {
            ct.testSumaExcepcion();
        } catch (VacioException e) {
            numErrores++;
            e.printStackTrace();
        }
          try {
            ct.testMayor();
        } catch (VacioException e) {
            numErrores++;
            e.printStackTrace();
        }
        try {
            ct.testMayorExcepcion();
        } catch (VacioException e) {
            numErrores++;
            e.printStackTrace();
        }
          try {
            ct.testMenor();
        } catch (VacioException e) {
            numErrores++;
            e.printStackTrace();
        }
        try {
            ct.testMenorExcepcion();
        } catch (VacioException e) {
            numErrores++;
            e.printStackTrace();
        }
          try {
            ct.testBusca();
        } catch (VacioException e) {
            numErrores++;
            e.printStackTrace();
        }
        try {
            ct.testBuscaExcepcion();
        } catch (VacioException e) {
            numErrores++;
            e.printStackTrace();
        }
        if (numErrores > 0) {
            throw new RuntimeException("Tenemos " + numErrores + " error(es)");
        }
    }

}
