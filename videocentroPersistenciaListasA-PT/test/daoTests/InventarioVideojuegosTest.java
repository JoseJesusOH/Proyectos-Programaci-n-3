/*
* InventarioVideojuegos.java
*
* Creada el 5 de septiembre de 2021, 8:19 PM
 */
package daoTests;

import dao.InventarioVideojuegos;
import dao.Videojuegos;
import excepciones.PersistenciaException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import objetosNegocio.Videojuego;
import objetosNegocio.VideojuegoED;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Esta clase representa el test inventario de videojuegos, donde se evaluaran
 * los metodos de la clase InventarioVideojuegos. Alumno; José Jesús Orozco
 * Hernández ID:00000229141
 *
 * @author José Jesús Orozco Hernández
 */
public class InventarioVideojuegosTest {

    /**
     * Constructor por omision
     */
    public InventarioVideojuegosTest() {
    }

    /**
     * Test de metodo obtener de la clase InventarioVideojuegos, para comprobar
     * si la lista esta vacia, y ademas buscar determinados vijuegosED
     */
    @Test
    public void testObten() {
        System.out.println("------------------------------------------------------------------");
        InventarioVideojuegos auxiliar = new InventarioVideojuegos();
        VideojuegoED resultado, esperado;
        System.out.println("Prueba del método obten(VideojuegoED videojuegoED), de la clase InventarioVieojuegos");
        // Prueba cuando la lista esta vacia
        resultado = auxiliar.obten(new VideojuegoED(new Videojuego("WII2021")));
        assertNull(resultado);
//         Agrega un videojuegoEd a la lista
        auxiliar.agrega(new VideojuegoED(new Videojuego("Nint2021", "Zelda Legends", "Aventura", "B", "Switch", "Nintendo", "2.1"), 4, 5));
//         Prueba buscando un videojuegoED que no existe
        resultado = auxiliar.obten(new VideojuegoED(new Videojuego("Play1", "Contra", "Maldad", "D", "ChinaO", "C Cor.", "1")));
        assertNull(resultado);
//         Prueba buscando un videojuegoED existente
        esperado = new VideojuegoED(new Videojuego("Nint2021", "Zelda Legends", "Aventura", "B", "Switch", "Nintendo", "2.1"), 4, 5);
        resultado = auxiliar.obten(new VideojuegoED(new Videojuego("Nint2021")));
        assertEquals(esperado, resultado);
        System.out.println("---------------------------------------------------");
    }

    /**
     * Test del metodo agrega de la clase de InventarioVideojuegos, que verificara si se ha
     * agregado el videojuegoEd exitosamente
     */
    @Test
    public void testAgrega() {
        System.out.println("----------------------------------------------------");
        InventarioVideojuegos auxiliar = new InventarioVideojuegos();
        VideojuegoED resultado, esperado;
        System.out.println("Prueba del método agrega(VideojuegoED videojuegoEd,) de la clase InventarioVieojuegos");
        // Agrega un videojuegoED a la lista
        auxiliar.agrega(new VideojuegoED(new Videojuego("Nint2021", "Zelda Legends", "Aventura", "B", "Switch", "Nintendo", "2.1"), 4, 5));
        // Prueba de que se agrego el videojuegoED correctamente
        esperado = new VideojuegoED(new Videojuego("Nint2021", "Zelda Legends", "Aventura", "B", "Switch", "Nintendo", "2.1"), 4, 5);
        resultado = auxiliar.obten(new VideojuegoED(new Videojuego("Nint2021")));
        assertEquals(esperado, resultado);
    }

    /**
     * Test de metodo actualiza de la clase de InventarioVideojuegos, este
     * verificara si la actualizacion de un videojuegoED es exitosa
     */
    @Test
    public void testActualiza() {
        System.out.println("----------------------------------------------------");
        InventarioVideojuegos auxiliar = new InventarioVideojuegos();
        VideojuegoED resultado, esperado;
        System.out.println("Prueba del método actualiza(VideojuegoED videojuegoED), de la clase InventarioVideojuegos");
        // Agrega un videojuego a la lista a la lista
        auxiliar.agrega(new VideojuegoED(new Videojuego("Nint2021", "Zelda Legends", "Aventura", "B", "Switch", "Nintendo", "2.1"), 4, 5));
        // Actualiza el videojuegoEd de la lista
        auxiliar.actualiza(new VideojuegoED(new Videojuego("Nint2021", "Zelda L", "Clasico", "C", "Switch", "Nintendo", "2.1"), 3, 4));
        // Prueba que se actualizo el VideoJuegoED
        esperado = new VideojuegoED(new Videojuego("Nint2021", "Zelda Legends", "Aventura", "B", "Switch", "Nintendo", "2.1"), 4, 5);
        resultado = auxiliar.obten(new VideojuegoED(new Videojuego("Nint2021")));
        assertEquals(esperado, resultado);
    }

    /**
     * Test de metodo actualiza de la clase InventarioVideojuegos, para
     * comprobar si este lanza la excepcion cuando lo corresponda
     */
    @Test(expected = PersistenciaException.class)
    public void testActualizaExcepcion() {
        System.out.println("----------------------------------------------------");
        System.out.println("Prueba de que el metodo actualiza(VideojuegoED videojuegoED), de la clase InventarioVideojuegos lanza una excepcion");
        System.out.println("Se intentara actualizar un videjuego inexistente");
        InventarioVideojuegos auxiliar = new InventarioVideojuegos();
        //Prueba de actualizar un videojuegoED inexistente
        auxiliar.agrega(new VideojuegoED(new Videojuego("Nint2021", "Zelda Legends", "Aventura", "B", "Switch", "Nintendo", "2.1"), 4, 5));
        auxiliar.actualiza(new VideojuegoED(new Videojuego("Play2021", "Fifa", "Futbol", "Deportes", "Play Cuatro", "Sony", "2.3"), 3, 4));
    }


    /**
     * Test de metodo elimina de la clase de InventarioVideojuego, que verificara que un videjuegoEd se haya eliminado exitosamente
     */
    @Test
    public void testElimina() {
        System.out.println("----------------------------------------------------");
        InventarioVideojuegos auxiliar = new InventarioVideojuegos();
        VideojuegoED resultado, esperado;
        System.out.println("Prueba del método elimina(VideojuegoED videojuegoEd), de la clase InventarioVideojuegos");
        // Agrega un videojuegoED a la lista
        auxiliar.agrega(new VideojuegoED(new Videojuego("Nint2021", "Zelda Legends", "Aventura", "B", "Switch", "Nintendo", "2.1"), 4, 5));
        auxiliar.elimina(new VideojuegoED(new Videojuego("Nint2021")));
        // Prueba si se elimino el videojuegoEd de la lista
        resultado = auxiliar.obten(new VideojuegoED(new Videojuego("Nint2021")));
        assertNull(resultado);
    }

    /**
     * Test de metodo elimina de la clase InventarioVideojuegos, para comprobar
     * si este lanza la excepcion cuando lo corresponda
     */
    @Test(expected = PersistenciaException.class)
    public void testEliminaExcepcion() {
        System.out.println("----------------------------------------------------");
        InventarioVideojuegos auxiliar = new InventarioVideojuegos();
        System.out.println("Prueba del método elimina(VideojuegoED videojuegoEd), de la clase InventarioVideojuegos");
        System.out.println("Para comprobar si este lanza la exepcion correspondiente");
        // Agrega un videojuegoED a la lista
        auxiliar.agrega(new VideojuegoED(new Videojuego("Nint2021", "Zelda Legends", "Aventura", "B", "Switch", "Nintendo", "2.1"), 4, 5));
        auxiliar.elimina(new VideojuegoED(new Videojuego("Nint2022")));
    }

    /**
     * Test de metodo lista de la clase InventarioVideojuegos, para comprobar si
     * manda la lista
     */
    @Test
    public void testLista() {
        System.out.println("----------------------------------------------------");
        System.out.println("Prueba del metodo lista(), de la clase InventarioVideojuego");
        InventarioVideojuegos auxiliar = new InventarioVideojuegos();
        List<VideojuegoED> esperado = new ArrayList<>();
        List<VideojuegoED> resultado;
        // Prueba si la lista esta vacia
        resultado = auxiliar.lista();
        assertEquals(esperado, resultado);
        // Agrega videojuegosEd a la lista de videojuegos
        auxiliar.agrega(new VideojuegoED(new Videojuego("Nint2021", "Zelda Legends", "Aventura", "B", "Switch", "Nintendo", "2.1"), 4, 5));
        auxiliar.agrega(new VideojuegoED(new Videojuego("Xbox2021", "Plantas vs Zombies", "Ficcion", "c", "XOne", "Xbox", "2.2"), 5, 6));
        auxiliar.agrega(new VideojuegoED(new Videojuego("Play2021", "Banjo-toie", "Aventura", "B", "PlayS", "Sony", "2.3"), 6, 7));
        // Prueba de la lista
        VideojuegoED arreglo[] = {new VideojuegoED(new Videojuego("Nint2021", "Zelda Legends", "Aventura", "B", "Switch", "Nintendo", "2.1"), 4, 5), new VideojuegoED(new Videojuego("Xbox2021", "Plantas vs Zombies", "Ficcion", "c", "XOne", "Xbox", "2.2"), 5, 6), new VideojuegoED(new Videojuego("Play2021", "Banjo-toie", "Aventura", "B", "PlayS", "Sony", "2.3"), 6, 7)};
        esperado = Arrays.asList(arreglo);
        resultado = auxiliar.lista();
        assertEquals(esperado, resultado);
    }
}
