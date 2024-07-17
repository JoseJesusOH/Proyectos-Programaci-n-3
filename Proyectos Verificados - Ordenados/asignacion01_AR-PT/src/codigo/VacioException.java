/*
* VacioException.java
*
* Creada el e de septiembre de 2021, 9:28 PM
 */
package codigo;

/**
 * Esta clase permite crear excepciones del tipo VacioException.
 *
 * Las excepciones de este tipo serán lanzadas cuando un parámetro de un método
 * tengo un valor inválido. Alumno; José Jesús Orozco Hernández ID:00000229141
 *
 * @author José Jesús Orozco Hernández
 */
public class VacioException extends Exception {

    /**
     * Constructor por omision.
     */
    public VacioException() {
    }

    /**
     * Constructor que inicializa el atributo s de la clase padre.
     *
     * @param s Mensaje de error
     */
    public VacioException(String s) {
        super(s);
    }
}
