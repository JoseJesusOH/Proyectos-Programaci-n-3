/*
* InventarioVideojuegos.java
*
* Creada el 5 de septiembre de 2021, 8:19 PM
 */
package dao;

import excepciones.PersistenciaException;
import java.util.ArrayList;
import objetosNegocio.Videojuego;

/**
 * Esta clase representa videojuegos, donde se guardan los datos de este y los
 * videojuegos actuales. Alumno; José Jesús Orozco Hernández ID:00000229141
 *
 * @author José Jesús Orozco Hernández
 */
public class Videojuegos {
    
    /**
     * Array list de la clase Videjuego
     */
    private ArrayList<Videojuego> videojuegos;

    /**
     * Constructor por ausencia.Ademas se inicializa el atributo de la clase
     */
    public Videojuegos() {
        videojuegos = new ArrayList<>();
    }

    /**
     * Metodo que permite obtener el videojuego, si este se encuentra en la
     * lista principal.
     *
     * @param videojuego Videojuego a buscar
     * @return El videojuego, que coincida con el numero de catalogo, null si
     * este no es encontrado.
     */
    public Videojuego obten(Videojuego videojuego) {
        //Determina si el parametro es nulo
        if (videojuego == null) {
            return null;
        } else {
            //Ciclo for each para bucar si el videojuego del parametro existe en la lista
            for (Videojuego vj : videojuegos) {
                //Condicion para encontrar el juego que coincida
                if (vj.getNumCatalogo().equalsIgnoreCase(videojuego.getNumCatalogo())) {
                    return vj;
                }
            }
            return null;
        }
    }

    /**
     * Metodo que agrega el videojuegoED al lista
     *
     * @param videojuego El videojuego a agregar en la lista.
     */
    public void agrega(Videojuego videojuego) {
        videojuegos.add(videojuego);
    }

    /**
     * Metodo que actualiza el videojuego en la lista que coincida con el numero
     * de catalogo del videojuego a actualizsr.
     *
     * @param videojuego El videojuego a actualizar.
     */
    public void actualiza(Videojuego videojuego) {
        //Evaluar si el parametro es nulo
        if (videojuego == null) {
            throw new PersistenciaException("El videojuego es invalido");
        }
        //Verificar si el videojuego se encuentra en la lista
        int pos = videojuegos.indexOf(videojuego);
        //Si este no esta se lanza la excepcion
        if (pos < 0) {
            throw new PersistenciaException("El videojuego en el inventario no existe");
        }
        //Actualiza videojuego
        videojuegos.set(pos, videojuego);
    }

    /**
     * Metodo que elimina cierto videjuego que coincida con alguna en la lista
     * actual, en base a su numero de catalogo.
     *
     * @param videojuego El videjuego a eliminar
     */
    public void elimina(Videojuego videojuego) {
        //Verifica si el paramtero es nulo
        if (videojuego == null) {
            throw new PersistenciaException("El videojuego es invalido");
        }
        //Encuentra si el videojuego esta en la lista mediante indexof()  
        int pos = videojuegos.indexOf(videojuego);
        if (pos < 0) {
            throw new PersistenciaException("El videojuego en el inventario no existe");
        }
        //Elimina videojuego de la lista
        videojuegos.remove(videojuego);
    }

    /**
     * Metodo que devuelvel la lista de videojuegos actuales.
     *
     * @return La lista de videojuegos
     */
    public ArrayList<Videojuego> lista() {
        return videojuegos;
    }

    /**
     * Metodo que devuelvel la lista de videojuegos actuales que coinicidan con
     * el genero.
     *
     * @param genero El genero de consola
     * @return La lista de videojuegos en base al genero
     */
    public ArrayList<Videojuego> listaGenero(String genero) {
        ArrayList<Videojuego> apoyo = new ArrayList<>();
        for (Videojuego vj : videojuegos) {
            if (vj.getGenero().equalsIgnoreCase(genero)) {
                apoyo.add(vj);
            }
        }
        return apoyo;
    }
   /**
     * Metodo que devuelvel la lista de videojuegos actuales que coinicidan con
     * el tipo de consola.
     * @param consola El tipo de consola
     * @return La lista de videojuegos en base al tipo de consola
     */
    public ArrayList<Videojuego> listaConsola(String consola) {
        ArrayList<Videojuego> apoyo = new ArrayList<>();
        for (Videojuego vj : videojuegos) {
            if (vj.getConsola().equalsIgnoreCase(consola)) {
                apoyo.add(vj);
            }
        }
        return apoyo;
    }
}
