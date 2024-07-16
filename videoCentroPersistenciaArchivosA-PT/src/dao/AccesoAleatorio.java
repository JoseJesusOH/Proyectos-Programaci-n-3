/*
* AccesoAleatorio.java
* Creada el 4 de octube de 2021, 16:08 PM
 */
package dao;

import java.io.IOException;
import java.io.RandomAccessFile;
import objetosServicio.Fecha;

/**
 * Esta clase contiene rutinas para trabajar con archivos de acceso aleatorio
 * Autor; José Jesús Orozco Hernandez Id; 00000229141
 *
 * @author Jose Jesus
 */
public class AccesoAleatorio {

    protected RandomAccessFile archivo;
    protected String nomArchivo;
    protected int tamRegistro;
    protected byte blancos[];

    /**
     * Constructor de la clase. Establece el nombre del archivo, el tamaño de
     * cada uno de los registros del archivo y crea un arreglo de bytes en ceros
     * para borrar un registro
     *
     * @param nomArchivo Nombre del archivo
     * @param tamRegistro Tamaño del registro
     */
    public AccesoAleatorio(String nomArchivo, int tamRegistro) {
        this.nomArchivo = nomArchivo;
        this.tamRegistro = tamRegistro;
// Crea un arreglo de bytes en ceros
        blancos = new byte[tamRegistro];
        for (int i = 0; i < tamRegistro; i++) {
            blancos[i] = 0;
        }
    }

    /**
     * Lee una secuencia de caracteres de un archivo de acceso aleatorio y los
     * regresa en un String
     *
     * @param tam Número de caracteres a leer del archivo
     * @return Un String con los caracteres leídos
     * @throws IOException Si hay un error de entrada o salida.
     */
    public String leeString(int tam) throws IOException {
        char cadena[] = new char[tam];
// Lee tam caracteres del archivo y los almacena en un arreglo
        for (int i = 0; i < tam; i++) {
            cadena[i] = archivo.readChar();
        }
// Convierte el arreglo en un String
        String sCadena = new String(cadena);
// Reemplaza los caracteres '\u0000' por espacios
        sCadena = sCadena.replace('\u0000', ' ');
// Elimina los espacios en blanco
        sCadena = sCadena.trim();
        return sCadena;
    }

    /**
     * Escribe una secuencia de caracteres en un archivo. El número de
     * caracteres a escribir está dado por tam y los caracteres están en
     * sCadena.
     *
     * @param sCadena String con los caracteres a escribir
     * @param tam Número de caracteres a escribir.
     * @throws IOException Si hay un error de entrada o salida.
     */
    public void escribeString(String sCadena, int tam) throws IOException {
        StringBuffer cadena;
        if (sCadena != null) {
// Crea un StringBuffer a partir de la cadena
            cadena = new StringBuffer(sCadena);
        } else // Crea una cadena vacía de tamaño tam
        {
            cadena = new StringBuffer(tam);
        }
// Hace el StringBuffer de tamaño tam
        cadena.setLength(tam);
// Convierte el stringbuffer a una cadena
        sCadena = cadena.toString();
// escribe la cadena al archivo
        archivo.writeChars(sCadena);
    }

    /**
     * Lee una fecha de un archivo como tres enteros: día, mes, año
     *
     * @return La fecha leída
     * @throws IOException Si hay un error de entrada o salida.
     */
    public Fecha leeFecha() throws IOException {
// Lee el día del archivo
        int dia = archivo.readInt();
// Lee el mes del archivo
        int mes = archivo.readInt();
// Lee año del archivo
        int anho = archivo.readInt();
// Crea una fecha a partir del día, mes y año
        Fecha fecha = new Fecha(dia, mes, anho);
        return fecha;
    }

    /**
     * Escribe una fecha a un archivo como tres enteros: día, mes, año
     *
     * @param fecha Fecha a escribir
     * @throws IOException Si hay un error de entrada o salida.
     */
    public void escribeFecha(Fecha fecha) throws IOException {
        if (fecha != null) {
// Escribe el día
            archivo.writeInt(fecha.getDia());
// Escribe el mes
            archivo.writeInt(fecha.getMes());
// Escribe el año
            archivo.writeInt(fecha.getAnho());
        } else {

            archivo.writeInt(0);
            archivo.writeInt(0);
            archivo.writeInt(0);
        }
    }

    /**
     * Escribe un registro con tamRegistro bytes en 0 en el archivo
     *
     * @throws IOException Si hay un error de entrada o salida.
     */
    public void borraRegistro() throws IOException {
// Escribe en el archivo tamRegistro bytes en 0
        archivo.write(blancos);
    }

    /**
     * Regresa true si el arreglo de bytes dado por registro contiene puros
     * ceros
     *
     * @param registro Arreglo a probar
     * @return true si el arreglo contiene puros ceros, false en caso contrario.
     */
    public boolean estaRegistroBorrado(byte registro[]) {
// regresa false al primer byte diferente de ceros
        for (int i = 0; i < tamRegistro; i++) {
            if (registro[i] != 0) {
                return false;
            }
        }
// Si son puros ceros regresa true
        return true;
    }

    /**
     * Este método elimina fisicamente los registros borrados de un archivo
     *
     * @throws IOException
     */
    public void empaca() throws IOException {
        byte registro[] = new byte[tamRegistro];
        int registrosBorrados = 0;
// Calcula el número de registros en el archivo
        int numRegistros = (int) archivo.length() / tamRegistro;
// Para cada registro del archivo
        for (int i = 0; i < numRegistros; i++) {
// Posiciona en el i-esimo registro del archivo
            archivo.seek(i * tamRegistro);
// lee el registro
            archivo.read(registro);
// Si el registro está borrado
            if (estaRegistroBorrado(registro)) {
// Recorre todas los registros una posicion hacia
// arriba para recuperar el espacio
                for (int j = i; j < numRegistros - 1; j++) {
// Posiciona en el j-esimo + 1 registro del archivo
                    archivo.seek((j + 1) * tamRegistro);
// lee el registro
                    archivo.read(registro);
// Posiciona en el j-esimo lugar del archivo
                    archivo.seek(j * tamRegistro);
// escribe el registro
                    archivo.write(registro);
                }
// Decrementa el número de registros al eliminar un registro
                numRegistros--;
// Contabiliza el número de registros eliminados
                registrosBorrados++;
            }
        }
// Trunca el archivo para eliminar el espacio liberado por los registros
// eliminados
        archivo.setLength(archivo.length() - registrosBorrados * tamRegistro);
    }
}
