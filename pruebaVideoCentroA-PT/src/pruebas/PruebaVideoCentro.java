/*
* PruebaVideoCentro.java
* Creada el 4 de octubre del 2021, 8:14 PM
 */
package pruebas;

import excepciones.PersistenciaException;
import interfaces.IPersistenciaVideojuegos;
import objetosNegocio.Videojuego;
import persistencia.PersistenciaVideojuegosArchivos;

/**
 * Prueba que se realiza para comprobar la clase de
 * PersistenciaVideojuegosArchivos. Alumno; Jose Jesus Orozco Hernandez Id;
 * 00000229141
 *
 * @author Jose Jesus
 */
public class PruebaVideoCentro {

    /**
     * Metodo main para probar la PersistenciaVideojuegosArchivos
     *
     * @param args Argumentos
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Recuerde el archivo no contiene nada");
        System.out.println("---------------------------------------------------------------------");
        System.out.println("Se crea una intancia de PersistenciaVideojuegosArchivos , llamada persistencia");
        IPersistenciaVideojuegos persistencia = new PersistenciaVideojuegosArchivos();
        
        try {
            System.out.println("---------------------------------------------------------------------");
            persistencia.agregar(new Videojuego("V00001", "Superman Returns", "Acción", "T-Teen", "XBox 360", "Electronic Arts", "1"));
            Videojuego v1 = persistencia.obten(new Videojuego("V00001"));
            System.out.println("Se agrega el videojuego V00001 ");
            System.out.print("Se ha agregado; ");
            System.out.print(v1 != null ? "Si" : "No");
            System.out.println();
            System.out.println("---------------------------------------------------------------------");
            persistencia.agregar(new Videojuego("V00002", "Tomb Raider", "Acción", "T-Teen", "PS2", "Eidos", "2"));
            Videojuego v2 = persistencia.obten(new Videojuego("V00002"));
            System.out.println("Se agrega el videojuego V00002 ");
            System.out.print("Se ha agregado; ");
            System.out.print(v2 != null ? "Si" : "No");
            System.out.println();
            System.out.println("---------------------------------------------------------------------");
            persistencia.agregar(new Videojuego("V00003", "Super Smash Bros. Brawl", "Acción", "T-Teen", "Nintendo Wii", "Nintendo", "1"));
            Videojuego v3 = persistencia.obten(new Videojuego("V00003"));
            System.out.println("Se agrega el videojuego V00001 ");
            System.out.print("Se ha agregado; ");
            System.out.print(v3 != null ? "Si" : "No");
            System.out.println();
            System.out.println("Se agrega el videojuego V00003" + v3 != null ? "Si" : "No");
            System.out.println("---------------------------------------------------------------------");
            System.out.println("Se agregara el videojuego V00001 nuevamente");
            persistencia.agregar(new Videojuego("V00001", "Superman Returns", "Acción", "T-Teen", "XBox 360", "Electronic Arts", "1"));
        } catch (PersistenciaException e) {
            System.out.println("Error; " + e.getMessage());
        }
        try {
            System.out.println("-------------------------------------------------------------------");
            System.out.println("Lista de videojuegos actuales");
            System.out.println(persistencia.consultarVideojuegos());
            System.out.println("---------------------------------------------------------------------");
            System.out.println("Se actualizara el genero del videojuego V00003");
            Videojuego v = persistencia.obten(new Videojuego("V00003"));
            v.setGenero("Fantasia");
            persistencia.actualizar(v);
        } catch (PersistenciaException e) {
            System.out.println("Error; " + e.getMessage());
        }
        System.out.println("---------------------------------------------------------------------");

        try {
            System.out.println("Se eliminara el videojuego");
            persistencia.eliminar(new Videojuego("V00002"));
            System.out.println("---------------------------------------------------------------------");
            System.out.println("Lista del catalogo de videojuegos;");
            System.out.println(persistencia.consultarVideojuegos());
            System.out.println("---------------------------------------------------------------------");
            System.out.println("Lista del catalogo de videojuegos de consola XBox 360;");
            System.out.println(persistencia.consultarVideojuegosConsola("XBox 360"));
            System.out.println("---------------------------------------------------------------------");
            System.out.println("Se obtendra el videojuego V00001 y si este esta se agregara al inventario, tres copias de el");
            Videojuego v1 = persistencia.obten(new Videojuego("V00001"));
            if (v1 != null) {
                persistencia.inventariar(v1, 3);
            }
            try {
                System.out.println("----------------------------------------");
                System.out.println("Se obtendra el videojuego V00002 y si este esta se agregara al inventario, una copia de el");
                Videojuego v2 = persistencia.obten(new Videojuego("V00002"));
                if (v2 != null) {
                    persistencia.inventariar(v2, 1);
                }
                System.out.println("----------------------------------------");
            } catch (PersistenciaException e) {
                System.out.println("Error; " + e.getMessage());
            }
            System.out.println("Se obtendra el videojuego V00003 y si este esta se agregara al inventario, dos copias de el");
            Videojuego v3 = persistencia.obten(new Videojuego("V00003"));
            if (v3 != null) {
                persistencia.inventariar(v3, 2);
            }
            System.out.println("---------------------------------------------------------------------");
            System.out.println("Se obtendra nuevamente el videojuego V00003 y si se agregara al inventario, otra copias de el");
            Videojuego v4 = persistencia.obten(new Videojuego("V00003"));
            if (v4 != null) {
                persistencia.inventariar(v4, 1);
            }
            System.out.println("---------------------------------------------------------------------");
            System.out.println("Lista de videojuegos del inventario");
            System.out.println(persistencia.consultarInventarioVideojuegos());
            System.out.println("----------------------------------");
            System.out.println("Ahora se elimina del inventario una copia del videojuego cuyo número de catálogo es V00001");
            persistencia.desinventariar(v1, 1);
            System.out.println("----------------------------------");
            System.out.println("Lista de videojuegos del inventario");
            System.out.println(persistencia.consultarInventarioVideojuegos());
        } catch (PersistenciaException e) {
            System.out.println("Error; " + e.getMessage());
        }
        System.out.println("---------------------------------------------");
        System.out.println("Recuerde ahora el archivo contiene datos.");
        System.out.println("Y los try catch anteriores cacharan puras expeciones si vuelve a correr el archivo");
    }

}
