/*
* IventarioVideojuegos.java
* Creada el 4 de octube de 2021, 16:08 PM
 */
package dao;

import excepciones.PersistenciaException;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import objetosNegocio.Videojuego;
import objetosNegocio.VideojuegoED;

/**
 * Clase que admnistra InventarioVideojuegos, por medio de archivos de acceso
 * aleatorio. Autor; Jose Jesus Orozco Hernandez Id; 00000229141
 *
 * @author Jose Jesus
 */
public class InventarioVideojuegos extends AccesoAleatorio {
    //   Tamaño de un registro (datos de un videojuego)
    //   numCatalogo        7 caracteres 14 bytes
    //   existencia                  int  4 bytes
    //   disponibilidad              int  4 bytes
    //   Total                           22 bytes
    // VideojuegoED v = new VideojuegoED(videojuego, existencia, disponibilidad);

//   Tamaño de un registro (datos de un videojuego)
    //   numCatalogo        7 caracteres 14 bytes
    //   titulo            35 caracteres 70 bytes
    //   genero            20 caracteres 40 bytes
    //   clasificacion      5 caracteres 10 bytes
    //   consola           20 caracteres 40 bytes
    //   fabricante        20 caracteres 40 bytes
    //   version           int            4 bytes
    //   Total                          218 bytes
    // Videojuego  v  = new Videojuego(numCatalogo, titulo, genero,clasificacion, consola,fabricante, Version);
    /**
     * Contructor de InventarioVidejuegos que inicilia el nombre del archivo y
     * tamaño de bytes
     *
     * @param nomArchivo Nombre del archivo
     */
    public InventarioVideojuegos(String nomArchivo) {
        super(nomArchivo, 22);
    }

    /**
     * Lee un videojuegoED de un archivo
     *
     * @return El videojuegoED leído
     * @throws IOException Si hay un error de entrada / salida.
     */
    private VideojuegoED leeVideojuegoED() throws IOException {
        Videojuego v = new Videojuego();
        v.setNumCatalogo(leeString(7));
        Videojuegos auxiliar = new Videojuegos(".\\videojuegos.dat");
        Videojuego axuliarDos = auxiliar.obten(v);
        v = axuliarDos;
        VideojuegoED vED = new VideojuegoED(v);
// Lee del archivo cada uno de los atributos del videojuego

        //   Tamaño de un registro (datos de un videojuego)
        //   numCatalogo        7 caracteres 14 bytes
        //   existencia                  int  4 bytes
        //   disponibilidad              int  4 bytes
        //   Total                           22 bytes
        // VideojuegoED v = new VideojuegoED(videojuego, existencia, disponibilidad);
        vED.setExistencia(archivo.readInt());
        vED.setDisponibilidad(archivo.readInt());
        return vED;
    }

    /**
     * Escribe un videojuegoED a un archivo
     *
     * @param genero VideojuegoED a escribir
     * @throws IOException Si hay un error de entrada / salida.
     */
    private void escribeVideojuegoED(VideojuegoED vED) throws IOException {
        //Se escribe el vieojuego
        //   Tamaño de un registro (datos de un videojuego)
        //   numCatalogo        7 caracteres 14 bytes
        //   existencia                  int  4 bytes
        //   disponibilidad              int  4 bytes
        //   Total                           22 bytes
        // VideojuegoED v = new VideojuegoED(videojuego, existencia, disponibilidad);
        escribeString(vED.getVideojuego().getNumCatalogo(), 7);
        archivo.writeInt(vED.getExistencia());
        archivo.writeInt(vED.getDisponibilidad());
    }

    /**
     * Regresa el videojuegoED del archivo que coincida con el numero de
     * catalogo del parametro. Los numeros de catalogo del archivo y del
     * parametro deben coincidir.
     *
     * @param vED VideojuegoED a obtener
     * @return El videojuegoED si lo encuentra. null en caso contrario.
     */
    public VideojuegoED obten(VideojuegoED vED) throws PersistenciaException {
        VideojuegoED videojuegoEDLeido;
// Abre el archivo de sólo lectura
        try {
            archivo = new RandomAccessFile(nomArchivo, "r");
        } catch (FileNotFoundException fnfe) {
            throw new PersistenciaException("Archivo inexistente");
        }
        try {
// Mientras haya videojuegosED en el archivo
            while (true) {
// Lee un videojuegoED
                videojuegoEDLeido = leeVideojuegoED();
// Si es el videojuegoED buscado, regrésalo
                if (vED.getVideojuego().getNumCatalogo().equals(videojuegoEDLeido.getVideojuego().getNumCatalogo())) {
                    return videojuegoEDLeido;

                }
                
            }
        } // Si se llegó al final del archivo sin encontrar el VidejuegoED
        catch (EOFException eofe) {
            return null;
        } // Si ocurrió un error de entrada salida
        catch (IOException eofe) {
            throw new PersistenciaException("Error al acceder al archivo");
        } finally {
            try {
// Cierra el archivo
                archivo.close();
            } // Si ocurrió un error de entrada salida
            catch (IOException eofe) {
                throw new PersistenciaException("Error al cerrar el archivo");
            }
        }
    }

    /**
     * Este método permite agregar un videojuegoED a un archivo.
     *
     * @param vED VidejuegoED a agregar
     */
    public void agrega(VideojuegoED vED) throws PersistenciaException {
// Abre el archivo de escritura/lectura
        try {
            archivo = new RandomAccessFile(nomArchivo, "rw");
        } catch (FileNotFoundException fnfe) {
            throw new PersistenciaException("Archivo inexistente");
        }
        try {
// Se posiciona al final del archivo
            archivo.seek(archivo.length());
// Escribe el videojuegoED
            escribeVideojuegoED(vED);
        } // Si ocurrió un error de entrada salida
        catch (IOException eofe) {
            throw new PersistenciaException("Error al acceder al archivo");
        } finally {
            try {
// Cierra el archivo
                archivo.close();
            } // Si ocurrió un error de entrada salida
            catch (IOException eofe) {
                throw new PersistenciaException("Error al cerrar el archivo");
            }
        }
    }

    /**
     * Actualiza el videojuegoED del archivo que coincida con el numero de
     * catalogo del parametro. Las numeros de catalogo de videjuegosED del
     * archivo y del parametro deben coincidir.
     *
     * @param vED VidejuegoED a actualizar
     */
    public void actualiza(VideojuegoED vED) throws PersistenciaException {
        VideojuegoED videojuegoEDLeido;
// Abre el archivo de escritura/lectura
        try {
            archivo = new RandomAccessFile(nomArchivo, "rw");
        } catch (FileNotFoundException fnfe) {
            throw new PersistenciaException("Archivo inexistente");
        }
        try {
// Mientras haya vidoejuegosED en el archivo
            while (true) {
// Lee una videojuegoED
                videojuegoEDLeido = leeVideojuegoED();
// Si es el videojuegoED buscado
                if (vED.getVideojuego().getNumCatalogo().equals(videojuegoEDLeido.getVideojuego().getNumCatalogo())) {
// Se posiciona al principio del registro
                    archivo.seek(archivo.getFilePointer() - tamRegistro);
// Escribe el videojuegoED modificado
                    escribeVideojuegoED(vED);
// Termina la búsqueda
                    break;
                }
            }
        } // Si se llegó al final del archivo
        catch (EOFException eofe) {
            throw new PersistenciaException("El videojuegoED no existe");
        } // Si ocurrió un error de entrada salida
        catch (IOException eofe) {
            throw new PersistenciaException("Error al acceder al archivo");
        } finally {
            try {
// Cierra el archivo
                archivo.close();
            } // Si ocurrió un error de entrada salida
            catch (IOException eofe) {
                throw new PersistenciaException("Error al cerrar el archivo");
            }
        }
    }

    /**
     * Elimina el videojuegoED del archivo que coincida con el numero de catalgo
     * de videjuegoED del parametro. Los numeros de catalogo de videojueogoED
     * del archivo y del parametro deben coincidir.
     *
     * @param vED VidejuegoED a eliminar
     */
    public void elimina(VideojuegoED vED) throws PersistenciaException {
        VideojuegoED videojuegoEDLeido;
// Abre el archivo de escritura/lectura
        try {
            archivo = new RandomAccessFile(nomArchivo, "rw");
        } catch (FileNotFoundException fnfe) {
            throw new PersistenciaException("Archivo inexistente");
        }
        try {
// Mientras haya videojuegosED en el archivo
            while (true) {
// Lee un videojuegoED
                videojuegoEDLeido = leeVideojuegoED();
// Si es el videojuegoED buscado
                if (vED.getVideojuego().getNumCatalogo().equals(videojuegoEDLeido.getVideojuego().getNumCatalogo())) {
// Se posiciona al principio del registro
                    archivo.seek(archivo.getFilePointer() - tamRegistro);
// Escribe un registro en blanco y empaca
                    borraRegistro();
                    empaca();
// Termina la búsqueda
                    break;
                }
            }
        } // Si se llegó al final del archivo
        catch (EOFException eofe) {
            throw new PersistenciaException("El videjuegoED no existe");
        } // Si ocurrió un error de entrada salida
        catch (IOException eofe) {
            throw new PersistenciaException("Error al acceder al archivo");
        } finally {
            try {

// Cierra el archivo
                archivo.close();
            } // Si ocurrió un error de entrada salida
            catch (IOException eofe) {
                throw new PersistenciaException("Error al cerrar el archivo");
            }
        }
    }

    /**
     * Este método permite consultar los videjuegosED del archivo
     * inventarioVidejuegos.dat.
     *
     * @return Una lista de los objetos del tipo videjuegoED del archivo
     * inventarioVideojuegos
     */
    public ArrayList<VideojuegoED> lista() throws PersistenciaException {
        ArrayList<VideojuegoED> lista = new ArrayList<>();
        VideojuegoED videojuegoED;
// Abre el archivo de sólo lectura
        try {
            archivo = new RandomAccessFile(nomArchivo, "r");
        } catch (FileNotFoundException fnfe) {
            throw new PersistenciaException("Archivo inexistente");
        }
        try {
// Mientras haya videojuegosED en el archivo
            while (true) {
// Lee un videojuegoED
                videojuegoED = leeVideojuegoED();
// Agrega el videojuegoED a la lista de géneros
                lista.add(videojuegoED);
            }
        } // Si se llegó al final del archivo
        catch (EOFException eofe) {
// Regresa la lista de VidejuegosED
            return lista;
        } // Si ocurrió un error de entrada salida
        catch (IOException eofe) {
            throw new PersistenciaException("Error al acceder al archivo");
        } finally {
            try {
// Cierra el archivo
                archivo.close();
            } // Si ocurrió un error de entrada salida
            catch (IOException eofe) {
                throw new PersistenciaException("Error al cerrar el archivo");
            }
        }
    }

}
