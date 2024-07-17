/*
* InventarioVideojuegos.java
*
* Creada el 5 de septiembre de 2021, 8:19 PM
 */
package dao;

import excepciones.PersistenciaException;
import java.util.ArrayList;
import objetosNegocio.VideojuegoED;

/**
 * Esta clase representa el inventario de videojuegos, donde se guardan los
 * datos de este y las copias y disponibilidad de los videojuegos. Alumno; José
 * Jesús Orozco Hernández ID:00000229141
 *
 * @author José Jesús Orozco Hernández
 */
public class InventarioVideojuegos {
    /**
     * Array list de la clase VidejuegoED
     */
    private ArrayList<VideojuegoED> inventariovideojuegos;
    /**
     * Constructor por ausencia.Ademas se inicializa el atributo de la clase
     */
    public InventarioVideojuegos() {
        inventariovideojuegos = new ArrayList<>();
    }
   /**
    * Metodo que permite obtener el videojuegoED, si este se encuentra en la lista principal.
    * @param videojuegoED VideojuegoED a buscar
    * @return El videojuegoEd, que coincida con el numero de catalogo, null si este no es encontrado.
    */
    public VideojuegoED obten(VideojuegoED videojuegoED) {
        //Determina si el parametro es nulo
        if (videojuegoED == null) {
            return null;
        } else {
            //Ciclo para bucar si el videojuegoED del parametro existe en la lista
            for (VideojuegoED ivj : inventariovideojuegos) {
                //Condicion para encontrar el juego que coincida
                if (ivj.getVideojuego().getNumCatalogo().equalsIgnoreCase(videojuegoED.getVideojuego().getNumCatalogo())) {
                    return ivj;
                }
            }
            return null;
        }
    }
  /**
   * Metodo que agrega el videojuegoED al lista
   * @param videojuegoED El videojuegoED a agregar en la lista.
   */
    public void agrega(VideojuegoED videojuegoED) throws PersistenciaException {
        inventariovideojuegos.add(videojuegoED);
    }
    /**
     * Metodo que actualiza el videojuegoED en la lista que coincida con el numero de catalogo del videojuego a actualizsr.
     * @param videojuegoED El videojuegoEd a actualizar.
     */
    public void actualiza(VideojuegoED videojuegoED)throws PersistenciaException  {
        //Evaluar si el parametro es nulo
        if (videojuegoED == null) {
            throw new PersistenciaException("El videojuego es invalido");
        }
        //Verificar si el videojuegoED se encuentra en la lista
        int pos = inventariovideojuegos.indexOf(videojuegoED);
        //Si este no esta se lanza la excepcion
        if (pos < 0) {
            throw new PersistenciaException("El videojuego en el inventario no existe");
        }
        //Actualiza videojuegoED
        inventariovideojuegos.set(pos, videojuegoED);
    }
   /**
    * Metodo que elimina cierto videjuegoED que coincida con alguna en la lista actual,
    * en base a su numero de catalogo
    * @param videojuegoED El videjuegoED a eliminar
    */
    public void elimina(VideojuegoED videojuegoED) throws PersistenciaException {
        //Verifica si el paramtero es nulo
        if (videojuegoED == null) {
            throw new PersistenciaException("El videojuego es invalido");
        }
        //Encuentra si el videojuegoED esta en la lista mediante indexof()
        int pos = inventariovideojuegos.indexOf(videojuegoED);
        if (pos < 0) {
            throw new PersistenciaException("El videojuego en el inventario no existe");
        }
        //Se elimina el videojuegoED
        inventariovideojuegos.remove(videojuegoED);
    }
    /**
     * Metodo que devuelvel la lista de videojuegos ED actuales
     * @return La lista de videojuegosED
     */
    public ArrayList<VideojuegoED> lista() {
        return inventariovideojuegos;
    }
}
