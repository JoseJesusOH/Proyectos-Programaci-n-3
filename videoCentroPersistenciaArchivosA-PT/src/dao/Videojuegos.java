/*
* Videojuegos.java
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

/**
 * Clase que admnistra videojuegos, por medio de archivos de acceso aleatorio.
 * Autor; Jose Jesus Orozco Hernandez Id; 00000229141
 * @author Jose Jesus
 */
public class Videojuegos extends AccesoAleatorio {
    //   Tamaño de un registro (datos de un videojuego)
    //   numCatalogo        7 caracteres 14 bytes
    //   titulo            35 caracteres 70 bytes
    //   genero            20 caracteres 40 bytes
    //   clasificacion      5 caracteres 10 bytes
    //   consola           20 caracteres 40 bytes
    //   fabricante        20 caracteres 40 bytes
    //   version              1 caracter  2 bytes
    //   Total                          216 bytes
    // Videojuego  v  = new Videojuego(numCatalogo, titulo, genero,clasificacion, consola,fabricante, Version);

    public Videojuegos(String nomArchivo) {
        super(nomArchivo, 216);
    }

    /**
     * Lee un videojuego de un archivo
     *
     * @return El videojuego leído
     * @throws IOException Si hay un error de entrada / salida.
     */
    private Videojuego leeVideojuego() throws IOException {
        Videojuego v = new Videojuego();
// Lee del archivo cada uno de los atributos del videojuego

      //   Tamaño de un registro (datos de un videojuego)
    //   numCatalogo        7 caracteres 14 bytes
    //   titulo            35 caracteres 70 bytes
    //   genero            20 caracteres 40 bytes
    //   clasificacion      5 caracteres 10 bytes
    //   consola           20 caracteres 40 bytes
    //   fabricante        20 caracteres 40 bytes
    //   version             1 caracter   2 bytes
    //   Total                          216 bytes
        v.setNumCatalogo(leeString(7));
        v.setTitulo(leeString(35));
        v.setGenero(leeString(20));
        v.setClasificacion(leeString(5));
        v.setConsola(leeString(20));
        v.setFabricante(leeString(20));
        v.setVersion(leeString(1));

        return v;
    }

    /**
     * Escribe un videojuego a un archivo
     *
     * @param genero Videojuego a escribir
     * @throws IOException Si hay un error de entrada / salida.
     */
    private void escribeVideojuego(Videojuego v) throws IOException {
        //Se escribe el vieojuego
    //   Tamaño de un registro (datos de un videojuego)
    //   numCatalogo        7 caracteres 14 bytes
    //   titulo            35 caracteres 70 bytes
    //   genero            20 caracteres 40 bytes
    //   clasificacion      5 caracteres 10 bytes
    //   consola           20 caracteres 40 bytes
    //   fabricante        20 caracteres 40 bytes
    //   version             1 caracter   2 bytes
    //   Total                          216 bytes
        escribeString(v.getNumCatalogo(), 7);
        escribeString(v.getTitulo(), 35);
        escribeString(v.getGenero(), 20);
        escribeString(v.getClasificacion(),5);
        escribeString(v.getConsola(), 20);
        escribeString(v.getFabricante(), 20);
        escribeString(v.getVersion(), 1);
    }

    /**
     * Regresa el videojuego del archivo que coincida con el genero del parametro.
     * Las numeros de catalogo de los videjuegos del archivo y del parametro deben coincidir.
     * 
     * @param v Videojuego a buscar
     * @return El videojuego si lo encuentra. null en caso contrario.
     */
    public Videojuego obten(Videojuego v) throws PersistenciaException {
        Videojuego videojuegoLeido;
// Abre el archivo de sólo lectura
        try {
            archivo = new RandomAccessFile(nomArchivo, "r");
        } catch (FileNotFoundException fnfe) {
            throw new PersistenciaException("Archivo inexistente");
        }
        try {
// Mientras haya videojuegos en el archivo
            while (true) {
// Lee un videojuego
                videojuegoLeido = leeVideojuego();
// Si es el videojuego buscado, regrésalo
                if (v.equals(videojuegoLeido)) {
                    return videojuegoLeido;
                }
            }
        } // Si se llegó al final del archivo sin encontrar el género
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
     * Este método permite agregar un videojuego a un archivo.
     *
     * @param v Videojuego a agregar
     */
    public void agrega(Videojuego v) throws PersistenciaException {
// Abre el archivo de escritura/lectura
        try {
            archivo = new RandomAccessFile(nomArchivo, "rw");
        } catch (FileNotFoundException fnfe) {
            throw new PersistenciaException("Archivo inexistente");
        }
        try {
// Se posiciona al final del archivo
            archivo.seek(archivo.length());
// Escribe el videojuego
            escribeVideojuego(v);
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
     * Actualiza el videojuego del archivo que coincida con el genero del parametro.
     * Las numero de catalogo de los videojuegos del archivo y del parametro deben coincidir.
     *
     * @param v Videojuego a agregar
     */
    public void actualiza(Videojuego v) throws PersistenciaException {
        Videojuego videojuegoLeido;
// Abre el archivo de escritura/lectura
        try {
            archivo = new RandomAccessFile(nomArchivo, "rw");
        } catch (FileNotFoundException fnfe) {
            throw new PersistenciaException("Archivo inexistente");
        }
        try {
// Mientras haya vidoejuegos en el archivo
            while (true) {
// Lee una videojuego
                videojuegoLeido = leeVideojuego();
// Si es el videojuego buscado
                if (v.getNumCatalogo().equals(videojuegoLeido.getNumCatalogo())) {
// Se posiciona al principio del registro
                    archivo.seek(archivo.getFilePointer() - tamRegistro);
// Escribe el videojuego modificado
                    escribeVideojuego(v);
// Termina la búsqueda
                    break;
                }
            }
        } // Si se llegó al final del archivo
        catch (EOFException eofe) {
            throw new PersistenciaException("El Videojuego no existe");
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
     * Elimina el videojuego del archivo que coincida con el numero de catalogo del parametro.
     * Los numeros de catalogo de los videojuegos del archivo y del parametro deben coincidir.
     *
     * @param v Videjuego a eliminar
     */
    public void elimina(Videojuego v) throws PersistenciaException {
        Videojuego videojuegoLeido;
// Abre el archivo de escritura/lectura
        try {
            archivo = new RandomAccessFile(nomArchivo, "rw");
        } catch (FileNotFoundException fnfe) {
            throw new PersistenciaException("Archivo inexistente");
        }
        try {
// Mientras haya videojuegos en el archivo
            while (true) {
// Lee un videojuego
                videojuegoLeido = leeVideojuego();
// Si es el videojuego buscado
                if (v.getNumCatalogo().equals(videojuegoLeido.getNumCatalogo())) {
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
            throw new PersistenciaException("El videojuego no existe");
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
     * Este método permite consultar los videojuegos del archivo videojuegos.
     *
     * @return Una lista de los objetos del tipo videojuego del archivo videojuegos
     */
    public ArrayList<Videojuego> lista() throws PersistenciaException {
        ArrayList<Videojuego> lista = new ArrayList<>();
        Videojuego videojuego;
// Abre el archivo de sólo lectura
        try {
            archivo = new RandomAccessFile(nomArchivo, "r");
        } catch (FileNotFoundException fnfe) {
            throw new PersistenciaException("Archivo inexistente");
        }
        try {
// Mientras haya videojuegos en el archivo
            while (true) {
// Lee un videojuego
                videojuego = leeVideojuego();
// Agrega el videojuego a la lista de géneros
                lista.add(videojuego);
            }
        } // Si se llegó al final del archivo
        catch (EOFException eofe) {
// Regresa la lista de generos
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

    /**
     * Este método permite consultar los videojuegos del archivo videojuegos que tienen
     * el mismo genero.
     *
     * @param genero Genero a buscar
     * @return Una lista de videojuegos del archivo videojuegos que tienen el mismo ghenero.
     */
    public ArrayList<Videojuego> listaGenero(String genero) throws PersistenciaException {
        ArrayList<Videojuego> lista = new ArrayList<>();
        Videojuego videojuego;
// Abre el archivo de sólo lectura
        try {
            archivo = new RandomAccessFile(nomArchivo, "r");
        } catch (FileNotFoundException fnfe) {
            throw new PersistenciaException("Archivo inexistente");
        }

        try {
// Mientras haya videojuegos en el archivo
            while (true) {
// Lee un videojuego
                videojuego = leeVideojuego();
// Si es el videojuego buscado
                if (genero.equals(videojuego.getGenero())) // Agrega el videojuego a la lista de videojuegos
                {
                    lista.add(videojuego);
                }
            }
        } // Si se llegó al final del archivo
        catch (EOFException eofe) {
// Regresa la lista de generos
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
     /**
     * Este método permite consultar los videojuegos del archivo videojuegos que tienen
     * el mismo tipo de consola.
     *
     * @param consola Tipo de consola
     * @return Una lista de videojuegos del archivo videojuegos que tienen el mismo tipo de consola.
     */
    public ArrayList<Videojuego> listaConsola(String consola) throws PersistenciaException {
        ArrayList<Videojuego> lista = new ArrayList<>();
        Videojuego videojuego;
// Abre el archivo de sólo lectura
        try {
            archivo = new RandomAccessFile(nomArchivo, "r");
        } catch (FileNotFoundException fnfe) {
            throw new PersistenciaException("Archivo inexistente");
        }

        try {
// Mientras haya videojuegos en el archivo
            while (true) {
// Lee un videojuego
                videojuego = leeVideojuego();
// Si es el videojuego buscado
                if (consola.equals(videojuego.getConsola())) // Agrega el videojuego a la lista de videojuegos
                {
                    lista.add(videojuego);
                }
            }
        } // Si se llegó al final del archivo
        catch (EOFException eofe) {
// Regresa la lista de generos
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
