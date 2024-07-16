/*
* PeriodoTest.java

* Creada el 16 de septiembre de 2021, 11:26 AM
*
 */
package pruebasTest;

import objetosServicio.Fecha;
import objetosServicio.Periodo;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Esta clase representa el test de Periodo, donde se evaluaran los metodos de
 * la clase. Alumno; José Jesús Orozco Hernández ID:00000229141
 *
 * @author José Jesús Orozco Hernández
 */
public class PeriodoTest {

    /**
     * Constructor por omision
     */
    public PeriodoTest() {
    }

    /**
     * Prueba del metodo getDesde, de la clase periodo
     */
    @Test
    public void testGetDesde() {
        System.out.println("Prueba del metodo getDesde(), de la clase Periodo");
        //Se crea periodo
        Periodo periodo = new Periodo(new Fecha(20, 10, 2022), new Fecha(20, 10, 2024));
        //Se crea la fecha esperada
        Fecha esperada = new Fecha(20, 10, 2022);
        //Se obtiene la fecha desde
        Fecha resultado = periodo.getDesde();
        //Se comparan para saber si son iguales
        assertEquals(esperada, resultado);
    }

    /**
     * Prueba del metodo getDesde, de la clase periodo
     */
    @Test
    public void testSetDesde() {
        System.out.println("Prueba del metodo setDesde(Fecha desde), de la clase Periodo");
        //Se crea periodo
        Periodo periodo = new Periodo(new Fecha(20, 10, 2022), new Fecha(20, 10, 2024));
        //Se establece una nueva fecha desde
        periodo.setDesde(new Fecha(20, 10, 2023));
        //Se crea la fecha esperada
        Fecha esperada = new Fecha(20, 10, 2023);
        //Se obtiene la fecha desde
        Fecha resultado = periodo.getDesde();
        //Se comparan para saber si son iguales
        assertEquals(esperada, resultado);
    }

    /**
     * Prueba del metodo getDesde, de la clase periodo
     */
    @Test
    public void testGetHasta() {
        System.out.println("Prueba del metodo getHasta(), de la clase Periodo");
        //Se crea periodo
        Periodo periodo = new Periodo(new Fecha(20, 10, 2022), new Fecha(20, 10, 2024));
        //Se crea la fecha esperada hasta
        Fecha esperada = new Fecha(20, 10, 2024);
        //Se obtiene la fecha hasta
        Fecha resultado = periodo.getHasta();
        //Se comparan para saber si son iguales
        assertEquals(esperada, resultado);
    }

    /**
     * Prueba del metodo getDesde, de la clase periodo
     */
    @Test
    public void testSetHasta() {
        System.out.println("Prueba del metodo setHasta(Fecha hasta), de la clase Periodo");
        //Se crea periodo
        Periodo periodo = new Periodo(new Fecha(20, 10, 2022), new Fecha(20, 10, 2024));
        //Se establece una nueva fecha hasta
        periodo.setHasta(new Fecha(20, 10, 2026));
        //Se crea la fecha esperada hasta
        Fecha esperada = new Fecha(20, 10, 2026);
        //Se obtiene la fecha hasta
        Fecha resultado = periodo.getHasta();
        //Se comparan para saber si son iguales
        assertEquals(esperada, resultado);
    }

    /**
     * Prueba del metodo getDesde, de la clase periodo
     */
    @Test
    public void testContiene() {
        System.out.println("Prueba del metodo contiene(Fecha fecha), de la clase Periodo");
        Periodo periodo = new Periodo(new Fecha(20, 10, 2022), new Fecha(20, 10, 2024));
        //comparacion d contiene
        assertTrue(periodo.contiene(new Fecha(20, 10, 2023)));
    }

    /**
     * Prueba del metodo getDesde, de la clase periodo
     */
    @Test
    public void testToString() {
        System.out.println("Prueba del metodo toString(), de la clase Periodo");
        Periodo periodo = new Periodo(new Fecha(20, 10, 2022), new Fecha(20, 10, 2024));
        //Comparacion de cadenas
        assertEquals("20/10/2022 a 20/10/2024", periodo.toString());
    }

}
