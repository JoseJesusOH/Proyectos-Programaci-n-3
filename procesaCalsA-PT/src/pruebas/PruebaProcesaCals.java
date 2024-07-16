/*
* PruebaProcesaCals.java
Creada el 3 de octubre del 2021  10:09 PM
 */
package pruebas;

import calificaciones.ProcesaCals;

/**
 * Esta clase prueba los metodos de la clase ProcesaCals, que trabaja sobre
 * archivos de texto y binarios. Alumno;José Jesús Orozco Hernández
 * ID:00000229141
 *
 * @author José Jesús Orozco
 */
public class PruebaProcesaCals {

    /**
     * Metodo main
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Objeto de la clase ProcesaCals
        ProcesaCals p = new ProcesaCals(".\\calificaciones.txt", ".\\calificaciones.dat");
        //Lectura y escritura de archivos
        p.procesaCalsAlumnos();
    }

}
