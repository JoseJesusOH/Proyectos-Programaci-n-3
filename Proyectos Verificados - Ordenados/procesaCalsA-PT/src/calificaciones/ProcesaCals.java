/*
* ProcesaCals.java
Creada el 3 de octubre del 2021  10:09 PM
 */
package calificaciones;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Clase que escribe y lee archivos de flujos de bytes. Alumno; Jose Jesus
 * Orozco Hernandez Id; 00000229141
 *
 * @author Jose Jesus
 */
public class ProcesaCals {

    /**
     * Promedio Final del alumno
     */
    private double promedioFinal;
    /**
     * Atributo que ayuda a abrir el archivo de texto
     */
    private String texto;
    /**
     * Numero de alumnos
     */
    private int numAlumnos;
    /**
     * Arreglo de matriculas
     */
    private int[] matriculas;
    /**
     * Arreglo de promedios
     */
    private double[] promedios;
    /**
     * Arreglo doble de calificaciones
     */
    private double[][] calif;
    /**
     * Atributo del tipo String
     */
    private String nombreArchivoLeer;
    /**
     * Atributo del tipo String
     */
    private String nombreArchivoEscribir;

    /**
     * Constructor que inicializa los atributos con respecto a su parametro.
     *
     * @param nombreArchivoLeer Nombre del archivo a leer
     * @param nombreArchivoEscribir Nombre del archivo a escribir
     */
    public ProcesaCals(String nombreArchivoLeer, String nombreArchivoEscribir) {
        this.nombreArchivoLeer = nombreArchivoLeer;
        this.nombreArchivoEscribir = nombreArchivoEscribir;
    }

    /**
     * Metodo que leer las calificaiones, las escribe en un archivo .dat, y lee
     * ese archvio
     */
    public void procesaCalsAlumnos() {
        leerCalificacionesAlumnos();
        escribeCalificacionesAlumno();
        leeCalificacionesPromedioAlumno();
    }

    /**
     * Metodo que lee el archivo de calficaciones
     */
    public void leerCalificacionesAlumnos() {
        //Archivo a leer 
        File file = new File(nombreArchivoLeer);
        FileReader fr;
        //lectura del archivo de texto de calificaciones con el fin de usar el StringTokenizer
        try {
            FileReader frd = new FileReader(file);
            BufferedReader br = new BufferedReader(frd);
            int con = 1;
            String linea = br.readLine();
            numAlumnos = Integer.valueOf(linea);
            while (linea != null) {
                if (con == 1) {
                    texto = linea;
                    con++;
                }
                linea = br.readLine();
                if (linea == null) {
                    break;
                } else {
                    texto = texto + "\n" + linea;
                    con++;
                }
            }
            br.close();
            frd.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        //Array que sirve para alacenar las calificaciones
        ArrayList<Double> d = new ArrayList<>();
        //Array que sirve para almacenar las matriculas
        ArrayList<Integer> c = new ArrayList<>();
        //se inicializa el arreglo doble de calificaiones
        calif = new double[numAlumnos][4];
        //Dada a que la lectura de archivo permitio que la variable de texto tenga contenido, 
        //Se me hes posible utilizar el Stringtokenizer
        String cadena = texto;
        StringTokenizer s = new StringTokenizer(cadena);
        //Ciclo del StringTokenizer
        while (s.hasMoreElements()) {
            //Se obtine el elemento en formato de string
            String a = (String) s.nextElement();
            //se compara o no si este tiene un punto en calso de que si corresponde a una calificacion y se
            //agrega al arreglo de calificaciones
            //En el caso de que no, este corresponde a una matricula y se agrega al arreglo de matriculas
            if (a.contains(".")) {
                d.add(Double.valueOf(a));
            } else if (a.length() > 1 && !a.contains(".")) {
                c.add(Integer.valueOf(a));
            }
        }
        //swe iniciliza el arreglo de matriculas y promedios
        matriculas = new int[numAlumnos];
        promedios = new double[numAlumnos];
        //se agregan las matriculas
        for (int i = 0; i < numAlumnos; i++) {
            matriculas[i] = c.get(i);
        }
        //contador auxiliar que nos ayuda a agregar las calficiones del array al arreglo doble de calificaciones
        int contador = 0;
        //Acumuladort que ayuda a calcular el promedio de calficiones de los alumnos y los agrega al arregl del promdio
        float sumaCal = 0;
        for (int i = 0; i < numAlumnos; i++) {
            for (int j = 0; j < 4; j++) {
                //En este se agregan las calificaciones
                calif[i][j] = d.get(contador);
                //Se suman
                sumaCal += d.get(contador);
                contador++;
            }
            //Se calcula el promedio y se agrega a su arreglo
            promedios[i] = sumaCal / 4;
            sumaCal = 0;
        }
        double suma = 0;
        //Se suman los promedios
        for (Double p : promedios) {
            suma += p;
        }
        //Se calcula el promedio final o general por todos los alumnos
        promedioFinal = suma / numAlumnos;

    }
    /**
     * Metodo que escribe las calificaciones de los alumnos en un archivo .dat
     */
    public void escribeCalificacionesAlumno() {
        FileOutputStream fi = null;
        DataOutputStream da;
        try {
            fi = new FileOutputStream(nombreArchivoEscribir);
        } catch (IOException ioe) {
            System.out.println("Erro; " + ioe.getMessage());
        }
        da = new DataOutputStream(fi);
        try {
            //Se escribe el numero de alumnos
            da.writeInt(numAlumnos);
            //Cilo para agregar matriculas y calificaciones
            for (int i = 0; i < numAlumnos; i++) {
                //se escribe la matricula
                da.writeInt(matriculas[i]);
                for (int j = 0; j < 4; j++) {
                    //se escribe la calificacion
                    da.writeDouble(calif[i][j]);
                }
                //Se escribe el promedio
                da.writeDouble(promedios[i]);
            }
            //S escribe el promedio final
            da.writeDouble(promedioFinal);
        } catch (IOException ioe) {
            System.out.println("Erro; " + ioe.getMessage());
            return;
        }
// Cierra el archivo
        try {
            da.close();
            fi.close();
        } catch (IOException ioe) {
            System.out.println("Error; " + ioe.getMessage());
        }
    }
    /**
     * Metodo que lee las calificaciones del archivo binario
     */
    public void leeCalificacionesPromedioAlumno() {
        FileInputStream fi = null;
        DataInputStream di;
        //Se crea archivo
        try {
            fi = new FileInputStream(".\\calificaciones.dat");
        } catch (IOException e) {
            System.out.println("Error; " + e.getMessage());
        }
        di = new DataInputStream(fi);
        try {
            System.out.println("Numero de alumnos; " + di.readInt());
            System.out.println("-------------------------------------------------------");
            System.out.println("               Calificaciones de alumnos               ");
            System.out.println("-------------------------------------------------------");
            System.out.printf("%-10s | %6s | %6s | %6s | %6s | %6s %n", "Matriculas", "Calf1", "Calf2", "Calf3", "Calf4", "Prome");
            System.out.println("-------------------------------------------------------");
            //Ciclo para leer calificaciones
            for (int i = 0; i < numAlumnos; i++) {
                //Se lee e imprime la matricula
                System.out.printf("%-10d", di.readInt());
                for (int j = 0; j < 4; j++) {
                    //Se lee  e imprime la calificacion
                    System.out.printf(" | %6.2f", di.readDouble());
                }
                //Se lee e imprimer el promedio
                System.out.printf(" | %6.2f", di.readDouble());
                System.out.println();
                System.out.println("-------------------------------------------------------");
            }
            //Se lee e imprime el promedio general
            System.out.printf("%-20s %6.2f %n", "Promedio General; ", di.readDouble());
        } catch (IOException e) {
            System.out.println("Error; " + e.getMessage());
        }
        try {
            di.close();
            fi.close();
        } catch (IOException e) {
            System.out.println("Erro; " + e.getMessage());
        }
    }
}
