/*
* PersistenciaVideojuegosListas.java
*
* Creada el 5 de septiembre de 2021, 8:19 PM
 */
package persistencia;

import dao.InventarioVideojuegos;
import dao.Videojuegos;
import excepciones.PersistenciaException;
import interfaces.IPersistenciaVideojuegos;
import java.util.ArrayList;
import objetosNegocio.Videojuego;
import objetosNegocio.VideojuegoED;

/**
 * Clase superior que invoca los diversos metodos de los paquetes daos . Alumno;
 * José Jesús Orozco Hernández ID:00000229141
 *
 * @author José Jesús Orozco Hernández
 */
public class PersistenciaVideojuegosListas implements IPersistenciaVideojuegos {

    /**
     * Atributo que permite la creacion un objeto de la clase Videojuegos
     */
    private Videojuegos catalogoVideojuegos;
    /**
     * Atributo que permite la creacion un objeto de la clase
     * InventarioVideojuegos
     */
    private InventarioVideojuegos inventarioVideojuegos;

    /**
     * Constructor por omision
     */
    public PersistenciaVideojuegosListas() {
        this.catalogoVideojuegos = new Videojuegos();
        this.inventarioVideojuegos = new InventarioVideojuegos();
    }

    /**
     * Metodo para obtener un videojuego de la lista
     *
     * @param v El videojuego a obtener
     * @return EL videjuego
     * @throws PersistenciaException Si el videojuego no exste
     */
    @Override
    public Videojuego obten(Videojuego v) throws PersistenciaException {
        return catalogoVideojuegos.obten(v);
    }

    /**
     * Metodo para agregar un videojuego a la lista de videojuegos
     *
     * @param v Videojuego a agregar
     * @throws PersistenciaException Si el videojuego ya existe.
     */
    @Override
    public void agregar(Videojuego v) throws PersistenciaException {
        if (catalogoVideojuegos.obten(v) != null) {
            throw new PersistenciaException("El videojuego ya existe en el catalogo");
        } else {
            catalogoVideojuegos.agrega(v);
        }
    }

    /**
     * Metodo para actualizar el videojuego de la lista , que coincida con
     * alguna de la lista.
     *
     * @param videojuego Videojuego a actualizar
     * @throws PersistenciaException Sera lanzada si el videojuego no existe en
     * la lista, o este es nulo
     */
    @Override
    public void actualizar(Videojuego videojuego) throws PersistenciaException {
        try {
            catalogoVideojuegos.actualiza(videojuego);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }
    }

    /**
     * Metodo para eliminar un videojuego de la lista de videojuegos
     *
     * @param videojuego Videojuego a agregar
     * @throws PersistenciaException Si el videojuego no existe, o si el
     * videojuego es nullo
     */
    @Override
    public void eliminar(Videojuego videojuego) throws PersistenciaException {
        if (videojuego == null) {
            throw new PersistenciaException("Videojuego invalido");
        } else {
            try {
                catalogoVideojuegos.elimina(videojuego);
            } catch (PersistenciaException pae) {
                throw new PersistenciaException(pae.getMessage());
            }
        }
    }

    /**
     * Metodo por el cual a la lista de videojuegos del inventario se le agrega
     * un videojuego
     *
     * @param videojuego Videojuego a agregar al inventario
     * @param cantidad La cantidad de existencia y disponibilidad
     * @throws PersistenciaException Lanza la exepcion si el paramtero cantidad
     * es menor a cero o es cero.
     */
    @Override
    public void inventariar(Videojuego videojuego, int cantidad) throws PersistenciaException {
        if (inventarioVideojuegos.obten(new VideojuegoED(videojuego)) == null) {
            inventarioVideojuegos.agrega(new VideojuegoED(videojuego, cantidad, cantidad));
        } else {
            int exi = inventarioVideojuegos.obten(new VideojuegoED(videojuego)).getExistencia();
            int dis = inventarioVideojuegos.obten(new VideojuegoED(videojuego)).getDisponibilidad();
            VideojuegoED actualizar = inventarioVideojuegos.obten(new VideojuegoED(videojuego));
            actualizar.setDisponibilidad(dis + cantidad);
            actualizar.setExistencia(exi + cantidad);
            inventarioVideojuegos.actualiza(actualizar);
        }
    }

    /**
     * MEtodo por el cual se desinventaria un videojuego del inventario, si est
     * no eesta lanza una expacion ,si al desinventariar el videojuego la
     * existencia de este es cero se elimina.
     *
     * @param videojuego Videojuego a desinventariar
     * @param cantidad La cantidad a desinventariar
     * @throws PersistenciaException Lanza la excepcion si no esta el
     * videojuego, o si el paramtero de cantidad es nulo
     */
    @Override
    public void desinventariar(Videojuego videojuego, int cantidad) throws PersistenciaException {
        if (cantidad <= 0) {
            throw new PersistenciaException("Cantidad invalidad, o numero negativo. Imposible inventariar videojuego.");
        }
        if (inventarioVideojuegos.obten(new VideojuegoED(videojuego)) == null) {
            throw new PersistenciaException("No existe el videojuego en el inventario");
        } else {
            int exi = inventarioVideojuegos.obten(new VideojuegoED(videojuego)).getExistencia();
            int dis = inventarioVideojuegos.obten(new VideojuegoED(videojuego)).getDisponibilidad();
            if (cantidad > exi) {
                throw new PersistenciaException("Videojuego insufc}iciente para desinventariar");
            }
            VideojuegoED actualizar = inventarioVideojuegos.obten(new VideojuegoED(videojuego));
            actualizar.setDisponibilidad(dis - cantidad);
            actualizar.setExistencia(exi - cantidad);
            inventarioVideojuegos.actualiza(actualizar);
            int exiDos = inventarioVideojuegos.obten(new VideojuegoED(videojuego)).getExistencia();

            if (exiDos == 0) {
                inventarioVideojuegos.elimina(new VideojuegoED(videojuego));
            }
        }
    }

    /**
     * Metodo por el cual obtenemos la lista del videojuegos
     *
     * @return La lista de videojuegos
     * @throws PersistenciaException Lanza la expepcion , si la lista esta vacia
     */
    @Override
    public ArrayList<Videojuego> consultarVideojuegos() throws PersistenciaException {
        return catalogoVideojuegos.lista();
    }

    /**
     * Metodo por el cual obtenemos un array list de videojuegos por tipo de
     * genero de videojuego
     *
     * @param genero El tipo de genero del videojuego
     * @return La lista de videojuegos que coincidadad con el tipo genero
     * @throws PersistenciaException Lanza la excepcion si la lista de
     * videojuegos esta vacia
     */
    @Override
    public ArrayList<Videojuego> consultarVideojuegosGenero(String genero) throws PersistenciaException {
        return catalogoVideojuegos.listaGenero(genero);
    }

    /**
     * Metodo por el cual obtenemos un array list de videojuegos por consola
     *
     * @param consola El tipo de consola
     * @return La lista de videojuegos que coincidadad con el tipo consola
     * @throws PersistenciaException Lanza la excepcion si la lista de
     * videojuegos esta vacia
     */
    @Override
    public ArrayList<Videojuego> consultarVideojuegosConsola(String consola) throws PersistenciaException {
        return catalogoVideojuegos.listaConsola(consola);
    }

    /**
     * Metodo por el cual obtenemos la lista del videojuegos del inventario
     *
     * @return La lista de videojuegos del inventario
     * @throws PersistenciaException Si la lista esta vacia
     */
    @Override
    public ArrayList<VideojuegoED> consultarInventarioVideojuegos() throws PersistenciaException {
   // En el metodo de inventario videjuegos lista no se lanza una excepcion
        return inventarioVideojuegos.lista();
    }

}
