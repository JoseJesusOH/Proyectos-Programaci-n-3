/*
* ArregloTest.java
*
* Creada el e de septiembre de 2021, 9:28 PM
 */
package pruebas;

import codigo.Arreglos;
import codigo.VacioException;

/**
 * Esta clase permite evaluar los metodos de la clase arreglos.
 * Alumno; José Jesús Orozco Hernández ID:00000229141
 *
 * @author José Jesús Orozco Hernández
 */
public class ArreglosTest {

    /**
     * Atributo int que ayuda en el testeo
     */
    int d = 2;
    /**
     * Arreglo con datos
     */
    int[] a = {2, 1, 3, 5, 4};
    /**
     * Arreglo sin datos
     */
    int[] b;
    /**
     * Atributo tipo objeto de la clase arreglos que sirve de apoyo en el testeo
     */
    Arreglos ar = new Arreglos();

    /**
     * Test del metodo vacio de la clase arreglos que determina si un arreglo
     * esta vacio
     */
    public void testVacio() {
        System.out.println("-----------------------------------");
        System.out.println("Prueba del metodo vacio");
        System.out.println("¿EL arreglo se encuentra vacio?");
        System.out.println(ar.vacio(b) == true ? "Si" : "No");
        System.out.println("-----------------------------------");
    }

    /**
     * Test del metodo suma de la clase de arreglos que determina la suma de los
     * datos del arreglo
     *
     * @throws VacioException Excepcion que se lanza si el arreglo esta vacio
     */
    public void testSuma() throws VacioException {
        System.out.println("-----------------------------------");
        System.out.println("Prueba del metodo suma");
        System.out.println("El arreglo cuenta con los siguientes numeros; 1,2,3,4,5,");
        System.out.println("Suma total del arreglo a,Total;" + ar.suma(a));

    }

    /**
     * Test del metodo suma de la clase de arreglos que determina la suma de los
     * datos del arreglo
     *
     * @throws VacioException Excepcion que se lanza si el arreglo esta vacio
     */
    public void testSumaExcepcion() throws VacioException {
        System.out.println("Prueba del metodo suma Excepcion");
        System.out.println("Suma del arreglo b, total;" + ar.suma(b));
        // El arreglo b esta vacio
//        System.out.println("-----------------------------------");
//        System.out.println("Prueba del metodo suma Excepcion");
//        System.out.println("El arreglo cuenta con los siguientes numeros; 1,2,3,4,5,");
//        System.out.println("Total;");
//        System.out.println(ar.suma(a));
    }

    /**
     * Test del metodo mayor de la clase de arreglos que determina el numero
     * mayor del arreglo
     *
     * @throws VacioException Excepcion que se lanza si el arreglo esta vacio
     */
    public void testMayor() throws VacioException {
        System.out.println("-----------------------------------");
        System.out.println("Prueba del metodo mayor");
        System.out.println("El arreglo cuenta con los siguientes numeros; 1,2,3,4,5,");
        System.out.println("Numero mayor del arreglo a;" + ar.mayor(a));
        System.out.println();
    }

    /**
     * Test del metodo mayor de la clase de arreglos que determina el numero
     * mayor del arreglo
     *
     * @throws VacioException Excepcion que se lanza si el arreglo esta vacio
     */
    public void testMayorExcepcion() throws VacioException {
        System.out.println("Prueba del metodo mayor Excepcion");
        System.out.println("Numero mayor del arreglo b, mayor;" + ar.mayor(b));
        //El arreglo b esta vacio
//        System.out.println("-----------------------------------");
//        System.out.println("Prueba del metodo mayor excepcion");
//        System.out.println("El arreglo cuenta con los siguientes numeros; 1,2,3,4,5,");
//        System.out.println("Mayor;");
//        System.out.println(ar.mayor(a));
    }

    /**
     * Test del metodo menor de la clase de arreglos que determina el numero
     * menorr del arreglo
     *
     * @throws VacioException Excepcion que se lanza si el arreglo esta vacio
     */
    public void testMenor() throws VacioException {
        System.out.println("-----------------------------------");
        System.out.println("Prueba del metodo menor");
        System.out.println("El arreglo cuenta con los siguientes numeros; 1,2,3,4,5,");
        System.out.println("Numero menor del arreglo b, menor;" + ar.menor(a));
    }

    /**
     * Test del metodo menor de la clase de arreglos que determina el numero
     * menorr del arreglo
     *
     * @throws VacioException Excepcion que se lanza si el arreglo esta vacio
     */
    public void testMenorExcepcion() throws VacioException {
        System.out.println("-----------------------------------");
        System.out.println("Prueba del metodo menor excepcion");
        System.out.println("Numero menor del arreglo b,menor;" + ar.menor(b));
//        El arreglo b esta vacio
//          System.out.println("-----------------------------------");
//        System.out.println("Prueba del metodo menor");
//        System.out.println("El arreglo cuenta con los siguientes numeros; 1,2,3,4,5,");
//        System.out.println("Menor;");
//        System.out.println(ar.menor(a));
    }

    /**
     * Test del metodo busca de la clase de arreglos que busca un determinado en
     * determinado arreglo.
     *
     * @throws VacioException Excepcion que se lanza si el arreglo esta vacio
     */
    public void testBusca() throws VacioException {
        System.out.println("-----------------------------------");
        System.out.println("Prueba del metodo busca");
        System.out.println("El arreglo cuenta a con los siguientes numeros; 1,2,3,4,5,");
        System.out.println("El numero se encuentra;");
        System.out.println(ar.busca(d, a) < 0 ? "No" : "Si");
    }

    /**
     * Test del metodo busca de la clase de arreglos que busca un determinado entero en un
     * determinado arreglo.
     *
     * @throws VacioException Excepcion que se lanza si el arreglo esta vacio
     */
    public void testBuscaExcepcion() throws VacioException {
        System.out.println("-----------------------------------");
        System.out.println("Prueba del metodo busca exepcion");
        System.out.println("El arreglo b esta vacio");
        System.out.println("El numero se encuentra;");
        System.out.println(ar.busca(d, b) < 0 ? "No" : "Si");
        // El arreglo b esta vacio
//         System.out.println("-----------------------------------");
//        System.out.println("Prueba del metodo busca");
//        System.out.println("El arreglo cuenta a con los siguientes numeros; 1,2,3,4,5,");
//        System.out.println("El numero se encuentra;");
//        System.out.println(ar.busca(d, a) < 0 ? "No" : "Si");
    }
}
