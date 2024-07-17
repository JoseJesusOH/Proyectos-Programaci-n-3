/*
* Arreglos.java
*
* Creada el 5 de septiembre de 2021, 8:19 PM
 */
package codigo;

/**
 * Esta clase deoniminada arreglos desarrola varios metodos para operaciones con
 * arreglos del tipo entero. Alumno; José Jesús Orozco Hernández ID:00000229141
 *
 * @author José Jesús Orozco Hernández
 */
public class Arreglos {

    /**
     * Constructor por omision
     */
    public Arreglos() {
    }

    /**
     * MEtodo que determinar si elarreglo del tipo entero esta vacio
     *
     * @param datos Arreglo a evaluar
     * @return Verdadero si el arreglo esta vacio, falso en caso contraio.
     */
    public boolean vacio(int datos[]) {
        //Condicion que determina si el arreglo esta vacia
        if (datos == null) {
            return true;
        }
        return false;
    }

    /**
     * Metodo que sumara cada dato que contiene el arreglo.
     *
     * @param datos El arreglo del tipo int
     * @return La suma de cada dato que contega el arreglo
     * @throws VacioException Si el arreglo esta vacio
     */
    public int suma(int datos[]) throws VacioException {
        int acum = 0;
        //condicion que determina si el arreglo esta vacio
        if (vacio(datos) == true) {
            throw new VacioException("El arreglo esta vacio");
        } else {
            //Ciclo para sumar todos los numeros del arreglo
            for (int i = 0; i < datos.length; i++) {
                acum = acum + datos[i];
            }
        }
        return acum;
    }

    /**
     * Metodo que determinara el numero mayor dentro del arreglo.
     *
     * @param datos El arreglo del tipo entero a evaluar.
     * @return El numero mayor del arreglo
     * @throws VacioException Lanzara esta excepcion si el arreglo esta vacio
     */
    public int mayor(int datos[]) throws VacioException {
        //condicion que determina si el arreglo esta vacio
        if (vacio(datos) == true) {
            throw new VacioException("El arreglo esta vacio");
        } else {
            int mayor = datos[0];
            //Ciclo para buscar el numero menor del arreglo
            for (int i = 0; i < datos.length; i++) {
                if (datos[i] > mayor) {
                    mayor = datos[i];
                }
            }
            return mayor;
        }
    }

    /**
     * Metodo que determinara el numero menor dentro del arreglo.
     *
     * @param datos El arreglo del tipo entero a evaluar.
     * @return El numero menor del arreglo
     * @throws VacioException Lanzara esta excepcion si el arreglo esta vacio
     */
    public int menor(int datos[]) throws VacioException {
        //condicion que determina si el arreglo esta vacio
        if (vacio(datos) == true) {
            throw new VacioException("El arreglo esta vacio");
        } else {
            //Variable de apoyo
            int menor = datos[0];
            //Ciclo para buscar el numero menor del arreglo
            for (int i = 0; i < datos.length; i++) {
                if (datos[i] < menor) {
                    menor = datos[i];
                }
            }
            return menor;
        }
    }

    /**
     * Metodo que determinara si un determinado numero se encuentra dentro del
     * arreglo.
     *
     * @param n El numero a buscar
     * @param datos El arreglo del tipo entero.
     * @return El numero si este fue encontrado, -1 en caso contrario
     * @throws VacioException Lanzara esta excepcion si el arreglo esta vacio
     */
    public int busca(int n, int datos[]) throws VacioException {
        if (vacio(datos) == true) {
            throw new VacioException("El arreglo esta vacio");
        } else {
            for (int i = 0; i < datos.length; i++) {
                int dato = datos[i];
                if (dato == n) {
                    return i;
                }
                if (dato == n) {
                    break;
                }
            }
            return -1;
        }
    }
}
