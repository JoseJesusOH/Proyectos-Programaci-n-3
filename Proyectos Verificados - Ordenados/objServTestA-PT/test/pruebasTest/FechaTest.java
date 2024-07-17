/*
* FechaTest.java
*
* Creada el 16 de septiembre de 2021, 11:26 AM
 */
package pruebasTest;

import java.sql.Date;
import objetosServicio.Fecha;
import objetosServicio.Periodo;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Esta clase representa el test de Fecha, donde se evaluaran los metodos de la
 * clase. Alumno; José Jesús Orozco Hernández ID:00000229141
 *
 * @author José Jesús Orozco Hernández
 */
public class FechaTest {

    /**
     * Constructor por omision
     */
    public FechaTest() {
    }

    /**
     * Test del metodo getDia de la clase Fecha
     */
    @Test
    public void testGetDia() {
        System.out.println("Prueba del metodo getDia() de la clase Fecha");
        // Se crea instancia de Fecha
        Fecha nueva = new Fecha(12, 10, 2024);
        //Se obtiene el dia que debe ser como resultado
        int resultado = nueva.getDia();
        //Se compara
        assertEquals(12, resultado);
    }

    /**
     * Test del metodo setDia de la clase Fecha
     */
    @Test
    public void testSetDia() {
        System.out.println("Prueba del metodo setDia() de la clase Fecha");
        //Se crea instancia de fecha
        Fecha nueva = new Fecha();
//se establece el dia
        nueva.setDia(13);
        int resultado = nueva.getDia();
        //se compara
        assertEquals(13, resultado);
    }

    /**
     * Test del metodo getMes de la clase Fecha
     */
    @Test
    public void testGetMes() {
        System.out.println("Prueba del metodo getMes() de la clase Fecha");
        //Se instancia fecha
        Fecha nueva = new Fecha(12, 2, 2024);
        //se obtiene el mes 
        int resultado = nueva.getMes();
        //Se compara
        assertEquals(2, resultado);
    }

    /**
     * Test del metodo setMes de la clase Fecha
     */
    @Test
    public void testsetMes() {
        System.out.println("Prueba del metodo setMes() de la clase Fecha");
        //Se instancia un objeto fecha
        Fecha nueva = new Fecha();
        //se establece el mes
        nueva.setMes(10);
        int resultado = nueva.getMes();
        //Se compara
        assertEquals(10, resultado);

    }

    /**
     * Test del metodo getAnho de la clase Fecha
     */
    @Test
    public void testGetAnho() {
        System.out.println("Prueba del metodo getAnho() de la clase Fecha");
        Fecha nueva = new Fecha();
        //Se instancia un objeto fecha
        int esperado = nueva.getAnho();
        int resultado = nueva.getAnho();
        //Comparacion
        assertEquals(esperado, resultado);
    }

    /**
     * Test del metodo setAnho de la clase Fecha
     */
    @Test
    public void testSetAnho() {
        System.out.println("Prueba del metodo setAnho() de la clase Fecha");
        //Se instancia un objeto fecha
        Fecha nueva = new Fecha();
        // se establece un año
        nueva.setAnho(2024);
        int resultado = nueva.getAnho();
        //Se compara
        assertEquals(2024, resultado);
    }

    /**
     * Test del metodo setFecha(int dia,in mes, int anho) de la clase Fecha
     */
    @Test
    public void testSetFecha() {
        System.out.println("Prueba del metodo setFecha(int dia,int mes,int anho) de la clase Fecha");
        // Se crea un objeto de fecha
        Fecha actual = new Fecha();
        //Se establece una nueva fecha
        actual.setFecha(14, 10, 2024);
        Fecha esperado, resultado;
        esperado = actual;
        resultado = new Fecha(actual);
        //Se comparan
        assertEquals(esperado, resultado);
    }

    /**
     * Test del metodo setFecha(Date fecha) de la clase Fecha
     */
    @Test
    public void testSetFechaDos() {
        System.out.println("Prueba del metodo setFecha(Date fecha) de la clase Fecha");
        // Se crea un objeto de fecha
        Fecha actual = new Fecha();
        //Se establece una nueva fecha con date
        actual.setFecha(new Date(124, 10, 14));
        Fecha esperado, resultado;
        //Se obtiene la actual
        esperado = actual;
        //Se obtiene la fecha
        resultado = new Fecha(actual);
        //Se comparan
        assertEquals(esperado, actual);
    }

    /**
     * Test del metodo vencimiento(int dia,in mes, int anho) de la clase Fecha
     */
    @Test
    public void testVencimiento() {
        System.out.println("Prueba del metodo setVencimiento(int dia,int mes,int anhos) de la clase Fecha");
        // Se crea un objeto de fecha
        Fecha nueva = new Fecha(20, 10, 2024);
        Fecha esperada, resultado;
        //Nueva Fecha
        esperada = new Fecha(23, 12, 2027);
        //Resultado de obtener la fecha
        resultado = nueva.vencimiento(3, 2, 3);
        //Se comparan las fecha
        assertEquals(esperada, resultado);
    }

    /**
     * Test del metodo vencimiento(int dia,in mes) de la clase Fecha
     */
    @Test
    public void testVencimientoDos() {
        System.out.println("Prueba del metodo setVencimiento(int dia,int mes) de la clase Fecha");

        // Se crea un objeto de fecha
        Fecha nueva = new Fecha(20, 10, 2024);
        //Nueva Fecha
        Fecha esperada, resultado;
        esperada = new Fecha(23, 12, 2024);
        //Resultado de obtener la fecha
        resultado = nueva.vencimiento(3, 2);
        //Se comparan las fecha
        assertEquals(esperada, resultado);
    }

    /**
     * Test del metodo vencimiento(int dia) de la clase Fecha
     */
    @Test
    public void testVencimientoTres() {
        System.out.println("Prueba del metodo setVencimiento(int dia) de la clase Fecha");
        // Se crea un objeto de fecha
        Fecha nueva = new Fecha(20, 10, 2024);
        Fecha esperada, resultado;
        //Nueva Fecha
        esperada = new Fecha(23, 10, 2024);
        //Resultado de obtener la fecha
        resultado = nueva.vencimiento(3);
        //Se comparan las fecha
        assertEquals(esperada, resultado);
    }

    /**
     * Test del metodo lapso(Fecha desde),de la clase Fecha
     */
    @Test
    public void testLapso() {
        System.out.println("Prueba del metodo lapso(Fecha desde), de la clase fecha");
        Fecha fecha = new Fecha();
        //Comparacion
        assertEquals(fecha.lapso(new Fecha()), fecha.lapso(new Fecha()));
    }

    /**
     * Test del metodo toDateString(),de la clase Fecha
     */
    @Test
    public void testToDateString() {
        System.out.println("Prueba del metodo toDateString(), de la clase fecha");
        Fecha fecha = new Fecha();
        fecha.setFecha(10, 10, 2022);
        //Variable de apoyo
        String esperado = "2022-10-10";
        //Comparacion
        assertEquals(esperado, fecha.toDateString());
    }

    /**
     * Test del metodo toString(),de la clase Fecha
     */
    @Test
    public void testToString() {
        System.out.println("Prueba del metodo toString(), de la clase fecha");
        Fecha fecha = new Fecha();
        fecha.setFecha(10, 10, 2022);
        //Variable de apoyo
        String esperado = "2022-10-10";
        //Comparacion
        assertEquals(esperado, fecha.toDateString());
    }
}
