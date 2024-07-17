
/*
* PersistenciaVideojuegosListas.java
*
* Creada el 5 de septiembre de 2021, 8:19 PM
 */
package persistenciaTests;

import daoTests.*;
import excepciones.PersistenciaException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import objetosNegocio.Videojuego;
import objetosNegocio.VideojuegoED;
import org.junit.Test;
import static org.junit.Assert.*;
import persistencia.PersistenciaVideojuegosListas;

/**
 * Esta clase representa el test de PesistenciaVideojuegosListas, donde se
 * evaluaran los metodos de la clase PesistenciaVideojuegosListas. Alumno; José
 * Jesús Orozco Hernández ID:00000229141
 *
 * @author José Jesús Orozco Hernández
 */
public class PersistenciaVideojuegosListasTest {

    /**
     * Constructor por omision
     */
    public PersistenciaVideojuegosListasTest() {
    }

    /**
     * Test para evaluar el metodo obten de la clase
     * PersistenciaVideojuegosListas
     */
    @Test
    public void testObten() {
        System.out.println("------------------------------------------------------------------");
        PersistenciaVideojuegosListas auxiliar = new PersistenciaVideojuegosListas();
        Videojuego resultado, esperado;
        System.out.println("Prueba del método obten(Videojuego videojuego), de la PersistenciaVideojuegosListas");
        // Prueba cuando la lista esta vacia
        resultado = auxiliar.obten(new Videojuego("Nint2021"));
        assertNull(resultado);
//      Agrega un videojuego a la lista
        auxiliar.agregar(new Videojuego("Nint2021", "Zelda Legends", "Aventura", "B", "Switch", "Nintendo", "2.1"));
        //  Prueba buscando un videojuego que no existe
        resultado = auxiliar.obten(new Videojuego("Nint2023"));
        assertNull(resultado);
        esperado = new Videojuego("Nint2021", "Zelda Legends", "Aventura", "B", "Switch", "Nintendo", "2.1");
        // se obtiene el resultado
        resultado = auxiliar.obten(new Videojuego("Nint2021"));
        // Se compara
        assertEquals(esperado, resultado);
    }

    /**
     * Test de metodo agregar de la clase PersistenciaVideojuegosListas, este
     * verificara si el videojuego es agregado exitosamente
     */
    @Test
    public void testAgregar() {
        System.out.println("----------------------------------------------------");
        PersistenciaVideojuegosListas auxiliar = new PersistenciaVideojuegosListas();
        Videojuego resultado, esperado;
        System.out.println("Prueba del método agregar (Videojuego videojuego), de la clase  PersistenciaVideojuegosListas");
        // Agrega un videojuego a la lista
        auxiliar.agregar(new Videojuego("Nint2021", "Zelda Legends", "Aventura", "A", "Switch", "Nintendo", "2.1"));
        // Prueba que se aagregago un videjuego
        esperado = new Videojuego("Nint2021", "Zelda Legends", "Aventura", "A", "Switch", "Nintendo", "2.1");
        resultado = auxiliar.obten(new Videojuego("Nint2021"));
        assertEquals(esperado, resultado);
    }

    /**
     * Test de metodo agregar de la clase PersistenciaVideojuegosListas, este
     * verificara si se lanza la excepcion esperada
     */
    @Test(expected = PersistenciaException.class)
    public void testAgregarExcepcion() {
        System.out.println("----------------------------------------------------");
        PersistenciaVideojuegosListas auxiliar = new PersistenciaVideojuegosListas();
        Videojuego resultado, esperado;
        System.out.println("Prueba del método agregar(Videojuego videojuego), de la clase  PersistenciaVideojuegosListas");
        // Agrega un videojuego a la lista
        auxiliar.agregar(new Videojuego("Nint2021", "Zelda Legends", "Aventura", "A", "Switch", "Nintendo", "2.1"));
        // Agrega un videojuego a la lista nuevamente
        auxiliar.agregar(new Videojuego("Nint2021", "Zelda Legends", "Aventura", "A", "Switch", "Nintendo", "2.1"));

    }

    /**
     * Test de metodo actualizar de la clase PersistenciaVideojuegosListas, este
     * verificara si la actualizacion de un videojueg es exitosa
     */
    @Test
    public void testActualizar() {
        System.out.println("----------------------------------------------------");
        PersistenciaVideojuegosListas auxiliar = new PersistenciaVideojuegosListas();
        Videojuego resultado, esperado;
        System.out.println("Prueba del método actualizar(Videojuego videojuego), de la clase  PersistenciaVideojuegosListas");
        // Agrega un videojuego a la lista a la lista
        auxiliar.agregar(new Videojuego("Nint2021", "Zelda Legends", "Aventura", "A", "Switch", "Nintendo", "2.1"));
        // Actualiza el videojuego de la lista
        auxiliar.actualizar(new Videojuego("Nint2021", "Zelda L", "Aventura", "B", "Switch", "Nintendo", "2.1"));
        // Prueba que se actualizo un videjuego
        esperado = new Videojuego("Nint2021", "Zelda L", "Aventura", "B", "Switch", "Nintendo", "2.1");
        resultado = auxiliar.obten(new Videojuego("Nint2021"));
        assertEquals(esperado, resultado);
    }

    /**
     * Test de metodo actualizar de la clase PersistenciaVideojuegosListas, para
     * comprobar si este lanza la excepcion cuando le corresponda
     */
    @Test(expected = PersistenciaException.class)
    public void testActualizarExcepcion() {
        PersistenciaVideojuegosListas auxiliar = new PersistenciaVideojuegosListas();
        System.out.println("----------------------------------------------------");
        System.out.println("Prueba de que el metodo actualizar(Videojuego videojuego), de la clase PersistenciaVideojuegosListas lanza una excepcion");
        System.out.println("Se intentara actualizar un videjuego inexistente");
        auxiliar.actualizar(new Videojuego("Play2021", "Fifa", "Futbol", "Deportes", "Play Cuatro", "Sony", "2.3"));
    }

    /**
     * Test de metodo eliminar de la clase PersistenciaVideojuegosListas, que
     * verificara que un videjuego se haya eliminado exitosamente
     */
    @Test
    public void testEliminar() {
        System.out.println("----------------------------------------------------");
        PersistenciaVideojuegosListas auxiliar = new PersistenciaVideojuegosListas();
        Videojuego resultado, esperado;
        System.out.println("Prueba del método elimina(Videojuego videojuego), de la clase videojuegos");
        // Agrega un videojuego a la lista
        auxiliar.agregar(new Videojuego("Nint2021"));
        auxiliar.eliminar(new Videojuego("Nint2021"));
        // Prueba si se elimino el videojuego de la lista
        resultado = auxiliar.obten(new Videojuego("Nint2021"));
        assertNull(resultado);
    }

    /**
     * Test de metodo eliminar de la clase PersistenciaVideojuegosListas, para
     * comprobar si este lanza la excepcion cuando lo corresponda.
     */
    @Test(expected = PersistenciaException.class)
    public void testEliminarExcepcion() {
        System.out.println("----------------------------------------------------");
        PersistenciaVideojuegosListas auxiliar = new PersistenciaVideojuegosListas();
        Videojuego resultado, esperado;
        System.out.println("Prueba del método elimina(Videojuego videojuego), de la clase videojuegos, para comprobar si este lanza una excepcion");
        // Agrega un videojuego a la lista
        auxiliar.agregar(new Videojuego("Nint2021", "Zelda Legends", "Aventura", "B", "Switch", "Nintendo", "2.1"));
        // Eliminara videojuego inexistente
        auxiliar.eliminar(new Videojuego("Nint2022"));
    }

    /**
     * Test de metodo inventariar de la clase PersistenciaVideojuegosListas, para
     * comprobar si este lanza la excepcion cuando lo corresponda.
     */
    @Test
    public void testInventariar() {
        System.out.println("----------------------------------------------------");
        PersistenciaVideojuegosListas auxiliar = new PersistenciaVideojuegosListas();
        Videojuego resultado, esperado;
        System.out.println("Prueba del método inventaria(Videojuego videojuego, int cantidad), de la clase videojuegos");
        // Agrega un videojuego al inventario
        auxiliar.inventariar(new Videojuego("Nint2021", "Zelda Legends", "Aventura", "B", "Switch", "Nintendo", "2.1"), 5);
    }

    /**
     * Test de metodo desinventariar de la clase PersistenciaVideojuegosListas
     */
    @Test
    public void testDesinventariar() {
        System.out.println("----------------------------------------------------");
        PersistenciaVideojuegosListas auxiliar = new PersistenciaVideojuegosListas();
        Videojuego resultado, esperado;
        System.out.println("Prueba del método desinventariar(Videojuego videojuego, int cantidad), de la clase videojuegos");
        auxiliar.inventariar(new Videojuego("Nint2021", "Zelda Legends", "Aventura", "B", "Switch", "Nintendo", "2.1"), 5);
        auxiliar.desinventariar(new Videojuego("Nint2021", "Zelda Legends", "Aventura", "B", "Switch", "Nintendo", "2.1"), 5);

    }

    /**
     * Test de metodo desinventariar de la clase PersistenciaVideojuegosListas, para
     * comprobar si este lanza la excepcion cuando no existan el juego.
     */
    @Test(expected = PersistenciaException.class)
    public void testDesinventariarVideojuegoInexistenteExcepcion() {
        System.out.println("----------------------------------------------------");
        PersistenciaVideojuegosListas auxiliar = new PersistenciaVideojuegosListas();
        Videojuego resultado, esperado;
        System.out.println("Prueba del método desinventariar(Videojuego videojuego), de la clase videojuegos, "
                + "para comprobar si este lanza una excepcion cuando no existe el videojuego en el inventario");
        auxiliar.inventariar(new Videojuego("Nint2021", "Zelda Legends", "Aventura", "B", "Switch", "Nintendo", "2.1"), 5);
        auxiliar.desinventariar(new Videojuego("Nint2022", "Zelda L", "Ficcion", "A", "Play", "Xbox", "2.2"), 5);
    }

    /**
     * Test de metodo desinventariar de la clase PersistenciaVideojuegosListas, para
     * comprobar si este lanza la excepcion cuando  no hay suficientes copias.
     */
    @Test(expected = PersistenciaException.class)
    public void testDesinventariarVideojInsuficienteExcepcion() {
        System.out.println("----------------------------------------------------");
        PersistenciaVideojuegosListas auxiliar = new PersistenciaVideojuegosListas();
        Videojuego resultado, esperado;
        System.out.println("Prueba del método desinventariar(Videojuego videojuego), de la clase videojuegos, "
                + "para comprobar si este lanza una excepcion cuando no existen suficientes videojuegos");
        //Esto era para comprobar donde estaba cierto paramtero que me confundio 
        //Videojuego v = new Videojuego(numCatalogo, titulo, genero, clasificacion, consola, fabricante, version)
       //Inventariar
        auxiliar.inventariar(new Videojuego("Nint2021", "Zelda Legends", "Aventura", "B", "Switch", "Nintendo", "2.1"), 5);
        //Desinventariar
        auxiliar.desinventariar(new Videojuego("Nint2021", "Zelda Legends", "Aventura", "B", "Switch", "Nintendo", "2.1"), 6);

    }

    /**
     * Test de metodo consultaVideojuegos de la clase de videojuegos, para comprobar si
     * devuelve la lista actual
     */
    @Test
    public void testConsultarVideojuegos() {
        System.out.println("----------------------------------------------------");
        System.out.println("Prueba del metodo lista(), de la clase videojuego");
        PersistenciaVideojuegosListas auxiliar = new PersistenciaVideojuegosListas();
        List<Videojuego> esperado = new ArrayList<>();
        List<Videojuego> resultado;
        // Agrega videojuegos a la lista de videojuegos
        Videojuego a = new Videojuego("Nint2021", "Zelda Legends", "Aventura", "a", "Switch", "Nintendo", "2.1");
        Videojuego b = new Videojuego("Xbox2021", "Plantas vs Zombies", "Ficcion", "c", "XOne", "Xbox", "2.2");
        Videojuego c = new Videojuego("Play2021", "Banjo-toie", "Aventura", "B", "PlayS", "Sony", "2.3");
        auxiliar.agregar(a);
        auxiliar.agregar(b);
        auxiliar.agregar(c);
        // Prueba de la lista
        Videojuego arreglo[] = {a, b, c};
        esperado = Arrays.asList(arreglo);
        resultado = auxiliar.consultarVideojuegos();
        assertEquals(esperado, resultado);
    }

    /**
     * Test de metodo lista de la clase de videojuegos, para comprobar si
     * devuelve la lista de los videojuegos que coicinidad con el genero que se
     * esta buscando. 
     */
    @Test
    public void testConsultarVideojuegosGenero() {
        System.out.println("----------------------------------------------------");
        System.out.println("Prueba del metodo listagenero(String genero), de la clase videojuego");
        PersistenciaVideojuegosListas auxiliar = new PersistenciaVideojuegosListas();
        List<Videojuego> esperado = new ArrayList<>();
        List<Videojuego> resultado;

        // Agrega videojuegos a la lista de videojuegos
        Videojuego a = new Videojuego("Nint2021", "Zelda Legends", "Aventura", "a", "Switch", "Nintendo", "2.1");
        Videojuego b = new Videojuego("Xbox2021", "Plantas vs Zombies", "Drama", "c", "XOne", "Xbox", "2.2");
        Videojuego c = new Videojuego("Play2021", "Banjo-toie", "Aventura", "B", "PlayS", "Sony", "2.3");
        auxiliar.agregar(a);
        auxiliar.agregar(b);
        auxiliar.agregar(c);
        // Prueba de la lista para obtener la lista de videojuegos por genero
        Videojuego arreglo[] = {a,c};
        esperado = Arrays.asList(arreglo);
        resultado = auxiliar.consultarVideojuegosGenero("Aventura");
        assertEquals(esperado, resultado);

    }

    /**
     * Test de metodo lista de la clase de videojuegos, para comprobar si
     * devuelve la lista de los videojuegos que coincidan con el tipo de
     * consola, que se envio como paramtero
     */
    @Test
    public void testConsultarVideojuegosConsola() {
        System.out.println("----------------------------------------------------");
        System.out.println("Prueba del metodo listaConsola(String consola), de la clase videojuego");
        PersistenciaVideojuegosListas auxiliar = new PersistenciaVideojuegosListas();
        List<Videojuego> esperado = new ArrayList<>();
        List<Videojuego> resultado;
        // Prueba si la lista esta vacia
        resultado = auxiliar.consultarVideojuegosGenero("Aventura");
        assertEquals(esperado, resultado);
        // Agrega videojuegos a la lista de videojuegos
        Videojuego a = new Videojuego("Nint2021", "Zelda Legends", "Aventura", "a", "PlayS", "PlayS", "2.1");
        Videojuego b = new Videojuego("Xbox2021", "Plantas vs Zombies", "Ficcion", "c", "XOne", "Xbox", "2.2");
        Videojuego c = new Videojuego("Play2021", "Banjo-toie", "Aventura", "B", "PlayS", "Sony", "2.3");
        auxiliar.agregar(a);
        auxiliar.agregar(b);
        auxiliar.agregar(c);
        // Prueba de la lista para obtener la lista de videojuegos por consola
        Videojuego arreglo[] = {a,c};
        esperado = Arrays.asList(arreglo);
        resultado = auxiliar.consultarVideojuegosConsola("Plays");
        assertEquals(esperado, resultado);
    }
    /**
     * Test de metodo lista de la clase PersistenciaVideojuegosListas, para comprobar si
     * manda la lista
     */
    @Test
    public void testConsultarInventarioVideojuegos() {
        System.out.println("----------------------------------------------------");
        System.out.println("Prueba del metodo lista(), de la clase InventarioVideojuego");
        PersistenciaVideojuegosListas auxiliar = new PersistenciaVideojuegosListas();
        List<VideojuegoED> esperado = new ArrayList<>();
        List<VideojuegoED> resultado;

        // Agrega videojuegosEd al inventario
        auxiliar.inventariar(new Videojuego("Nint2021", "Zelda Legends", "Aventura", "B", "Switch", "Nintendo", "2.1"), 5);
        auxiliar.inventariar(new Videojuego("Xbox2021", "Plantas vs Zombies", "Ficcion", "c", "XOne", "Xbox", "2.2"), 5);
        auxiliar.inventariar(new Videojuego("Play2021", "Banjo-toie", "Aventura", "B", "PlayS", "Sony", "2.3"), 5);
        // Prueba de la lista
        VideojuegoED arreglo[] = {new VideojuegoED(new Videojuego("Nint2021", "Zelda Legends", "Aventura", "B", "Switch", "Nintendo", "2.1"), 4, 5), new VideojuegoED(new Videojuego("Xbox2021", "Plantas vs Zombies", "Ficcion", "c", "XOne", "Xbox", "2.2"), 5, 6), new VideojuegoED(new Videojuego("Play2021", "Banjo-toie", "Aventura", "B", "PlayS", "Sony", "2.3"), 6, 7)};
        esperado = Arrays.asList(arreglo);
        resultado = auxiliar.consultarInventarioVideojuegos();
        assertEquals(esperado, resultado);
    }
}
