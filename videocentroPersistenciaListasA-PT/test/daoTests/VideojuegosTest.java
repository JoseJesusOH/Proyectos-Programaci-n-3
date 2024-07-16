
/*
* InventarioVideojuegos.java
*
* Creada el 5 de septiembre de 2021, 8:19 PM
 */
package daoTests;

import dao.Videojuegos;
import excepciones.PersistenciaException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import objetosNegocio.Videojuego;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Esta clase representa el test de videojuegos, donde se evaluaran los metodos
 * de la clase Videojuegos. Alumno; José Jesús Orozco Hernández ID:00000229141
 *
 * @author José Jesús Orozco Hernández
 */
public class VideojuegosTest {

    /**
     * Constructor por omision
     */
    public VideojuegosTest() {
    }

    /**
     * Test de metodo obten de la clase de videojuegos, que verifica si la lista esta vacia y cuando esta tenga datos.
     */
    @Test
    public void testObten() {
        System.out.println("------------------------------------------------------------------");
        Videojuegos auxiliar = new Videojuegos();
        Videojuego resultado, esperado;

        System.out.println("Prueba del método obten(Videojuego videojuego), de la clase videojuegos");
        // Prueba cuando la lista esta vacia
        resultado = auxiliar.obten(new Videojuego("Nint2021"));
        assertNull(resultado);
//         Agrega un videojuego a la lista
        auxiliar.agrega(new Videojuego("Nint2021", "Zelda Legends", "Aventura", "B", "Switch", "Nintendo", "2.1"));
//         Prueba buscando un videojuego que no existe
        resultado = auxiliar.obten(new Videojuego("Nint2023"));
        assertNull(resultado);
//         Prueba buscando un videojuego existente
        esperado = new Videojuego("Nint2021", "Zelda Legends", "Aventura", "B", "Switch", "Nintendo", "2.1");
        resultado = auxiliar.obten(new Videojuego("Nint2021"));
        assertEquals(esperado, resultado);
        System.out.println("---------------------------------------------------");
    }

    /**
     * Test de metodo agrega de la clase de videojuegos, que verificara si se ha
     * agregado el videojuego exitosamente
     */
    @Test
    public void testAgrega() {
        System.out.println("----------------------------------------------------");
        Videojuegos auxiliar = new Videojuegos();
        Videojuego resultado, esperado;
        System.out.println("Prueba del método agrega(Videojuego videojuego,) de la clase videojuegos");
        // Agrega un videojuego a la lista
        auxiliar.agrega(new Videojuego("Nint2021", "Zelda Legends", "Aventura", "B", "Switch", "Nintendo", "2.1"));
        // Prueba de que se agrego el videojuego correctamente
        esperado = new Videojuego("Nint2021", "Zelda Legends", "Aventura", "B", "Switch", "Nintendo", "2.1");
        resultado = auxiliar.obten(new Videojuego("Nint2021"));
        assertEquals(esperado, resultado);
    }

    /**
     * Test de metodo actualiza de la clase de videojuegos, este verificara si la actualizacion de un videojuego es exitosa
     */
    @Test
    public void testActualiza() {
        System.out.println("----------------------------------------------------");
        Videojuegos auxiliar = new Videojuegos();
        Videojuego resultado, esperado;
        System.out.println("Prueba del método actualiza(Videojuego videojuego), de la clase videojuegos");
        // Agrega un videojuego a la lista a la lista
        auxiliar.agrega(new Videojuego("Nint2021", "Zelda Legends", "Aventura", "A", "Switch", "Nintendo", "2.1"));
        // Actualiza el videojuego de la lista
        auxiliar.actualiza(new Videojuego("Nint2021", "Zelda L", "Clasico", "B", "Switch", "Nintendo", "2.1"));
        // Prueba que se actualizo un genero
        esperado = new Videojuego("Nint2021", "Zelda Legends", "Aventura", "B", "Switch", "Nintendo", "2.1");
        resultado = auxiliar.obten(new Videojuego("Nint2021"));
        assertEquals(esperado, resultado);
    }
//

    /**
     * Test de metodo actualiza de la clase Videojuegos, para comprobar si este
     * lanza la excepcion cuando le corresponda
     */
    @Test(expected = PersistenciaException.class)
    public void testActualizaExcepcion() {
        System.out.println("----------------------------------------------------");
        System.out.println("Prueba de que el metodo actualiza(Videojuego videojuego), de la clase videojuegos lanza una excepcion");
        System.out.println("Se intentara actualizar un videjuego inexistente");
        Videojuegos auxiliar = new Videojuegos();
        auxiliar.actualiza(new Videojuego("Play2021", "Fifa", "Futbol", "Deportes", "Play Cuatro", "Sony", "2.3"));
    }

    /**
     * Test de metodo elimina de la clase de videojuegos, que verificara que un videjuego se haya eliminado exitosamente
     */
    @Test
    public void testElimina() {
        System.out.println("----------------------------------------------------");
        Videojuegos auxiliar = new Videojuegos();
        Videojuego resultado, esperado;

        System.out.println("Prueba del método elimina(Videojuego videojuego), de la clase videojuegos");
        // Agrega un videojuego a la lista
        auxiliar.agrega(new Videojuego("Nint2021"));
        auxiliar.elimina(new Videojuego("Nint2021"));
        // Prueba si se elimino el videojuego de la lista
        resultado = auxiliar.obten(new Videojuego("Nint2021"));
        assertNull(resultado);
    }

    /**
     * Test de metodo elimina de la clase InventarioVideojuegos, para comprobar
     * si este lanza la excepcion cuando lo corresponda.
     */
    @Test(expected = PersistenciaException.class)
    public void testEliminaExcepcion() {
        System.out.println("----------------------------------------------------");
        Videojuegos auxiliar = new Videojuegos();
        Videojuego resultado, esperado;

        System.out.println("Prueba del método elimina(Videojuego videojuego), de la clase videojuegos, para comprobar si este lanza una excepcion");
        // Agrega un videojuego a la lista
        auxiliar.agrega(new Videojuego("Nint2021", "Zelda Legends", "Aventura", "B", "Switch", "Nintendo", "2.1"));
        auxiliar.elimina(new Videojuego("Nint2022"));

    }

    /**
     * Test de metodo lista de la clase de videojuegos, para comprobar si
     * devuelve la lista actual
     */
    @Test
    public void testLista() {
        System.out.println("----------------------------------------------------");
        System.out.println("Prueba del metodo lista(), de la clase videojuego");
        Videojuegos auxiliar = new Videojuegos();
        List<Videojuego> esperado = new ArrayList<>();
        List<Videojuego> resultado;
        // Prueba si la lista esta vacia
        resultado = auxiliar.lista();
        assertEquals(esperado, resultado);
        // Agrega videojuegos a la lista de videojuegos
        Videojuego a = new Videojuego("Nint2021", "Zelda Legends", "Aventura", "a", "Switch", "Nintendo", "2.1");
        Videojuego b = new Videojuego("Xbox2021", "Plantas vs Zombies", "Ficcion", "c", "XOne", "Xbox", "2.2");
        Videojuego c = new Videojuego("Play2021", "Banjo-toie", "Aventura", "B", "PlayS", "Sony", "2.3");
        auxiliar.agrega(a);
        auxiliar.agrega(b);
        auxiliar.agrega(c);

        // Prueba de la lista
        Videojuego arreglo[] = {a, b, c};
        esperado = Arrays.asList(arreglo);
        resultado = auxiliar.lista();
        assertEquals(esperado, resultado);
    }

    /**
     * Test de metodo lista de la clase de videojuegos, para comprobar si
     * devuelve la lista de los videojuegos que coicinidad con el genero que se
     * esta buscando.
     */
    @Test
    public void testListaGenero() {
        System.out.println("----------------------------------------------------");
        System.out.println("Prueba del metodo listagenero(String genero), de la clase videojuego");
        Videojuegos auxiliar = new Videojuegos();
        List<Videojuego> esperado = new ArrayList<>();
        List<Videojuego> resultado;
        // Prueba si la lista esta vacia
        resultado = auxiliar.listaGenero("Aventura");
        assertEquals(esperado, resultado);
        // Agrega videojuegos a la lista de videojuegos
        Videojuego a = new Videojuego("Nint2021", "Zelda Legends", "Aventura", "a", "Switch", "Nintendo", "2.1");
        Videojuego b = new Videojuego("Xbox2021", "Plantas vs Zombies", "Ficcion", "c", "XOne", "Xbox", "2.2");
        Videojuego c = new Videojuego("Play2021", "Banjo-toie", "Aventura", "B", "PlayS", "Sony", "2.3");
        auxiliar.agrega(a);
        auxiliar.agrega(b);
        auxiliar.agrega(c);
        // Prueba de la lista para obtener la lista de generos
        Videojuego arreglo[] = {a, c};
        esperado = Arrays.asList(arreglo);
        resultado = auxiliar.listaGenero("Aventura");
        assertEquals(esperado, resultado);

    }

    /**
     * Test de metodo lista de la clase de videojuegos, para comprobar si
     * devuelve la lista de los videojuegos que coincidan con el tipi de
     * consola, que se envio como paramtero
     */
    @Test
    public void testListaConsola() {
        System.out.println("----------------------------------------------------");
        System.out.println("Prueba del metodo listaConsola(String consola), de la clase videojuego");
        Videojuegos auxiliar = new Videojuegos();
        List<Videojuego> esperado = new ArrayList<>();
        List<Videojuego> resultado;
        // Prueba si la lista esta vacia
        resultado = auxiliar.listaGenero("Aventura");
        assertEquals(esperado, resultado);
        // Agrega videojuegos a la lista de videojuegos
        Videojuego a = new Videojuego("Nint2021", "Zelda Legends", "Aventura", "a", "Switch", "Nintendo", "2.1");
        Videojuego b = new Videojuego("Xbox2021", "Plantas vs Zombies", "Ficcion", "c", "XOne", "Xbox", "2.2");
        Videojuego c = new Videojuego("Play2021", "Banjo-toie", "Aventura", "B", "PlayS", "Sony", "2.3");
        auxiliar.agrega(a);
        auxiliar.agrega(b);
        auxiliar.agrega(c);
        // Prueba de la lista para obtener la lista de generos
        Videojuego arreglo[] = {a, c};
        esperado = Arrays.asList(arreglo);
        resultado = auxiliar.listaGenero("Aventura");
        assertEquals(esperado, resultado);
    }
}
