/*
 * Conversiones.java
Creada el 2 de noviembre del 2021 6:14 PM
 */
package control;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import objetosNegocio.Videojuego;
import objetosNegocio.VideojuegoED;

/**
 * Clase que realiza las conversiones para la utilizacion de tablas.
 * @author Jose
 */
public class Conversiones {

    String nombresColumnasTablasVideojuegos[] = {"Num. Catalogo", "Titulo", "Genero", "Clasificacion", "Consola", "Fabricante", "Version"};
    String nombresColumnasTablasVideojuegosED[] = {"Videojuego", "Existencia", "Disponibilidad"};

    /**
     * Este metodo convierte la lista de videojuegos en un arreglo bidimensional
     * para despues ir llenandolo con todos sus datos esto despues se convierte
     * en un default table model que necesita arreglos bidimensionales
     *
     * @param listaVideojuegos Lista de Videojuegos
     * @return la tabla creada a partir de la lista
     */
    public DefaultTableModel videoJuegosTableModel(List<Videojuego> listaVideojuegos) {
        Object tabla[][];
        if (listaVideojuegos != null) {
            tabla = new Object[listaVideojuegos.size()][7];
            for (int i = 0; i < listaVideojuegos.size(); i++) {
                Videojuego v = listaVideojuegos.get(i);
                tabla[i][0] = v.getNumCatalogo();
                tabla[i][1] = v.getTitulo();
                tabla[i][2] = v.getGenero();
                tabla[i][3] = v.getClasificacion();
                tabla[i][4] = v.getConsola();
                tabla[i][5] = v.getFabricante();
                tabla[i][6] = v.getVersion();
            }
            return new DefaultTableModel(tabla, nombresColumnasTablasVideojuegos);
        }
        return null;
    }

    /**
     * Este metodo convierte la lista de videojuegosED en un arreglo
     * bidimensional para despues ir llenandolo con todos sus datos esto despues
     * se convierte en un default table model que necesita arreglos
     * bidimensionales
     *
     * @param listaVideojuegosED Lista de videojuegos ED
     * @return la tabla creada a partir de la lista.
     */
    public DefaultTableModel videojuegosEDTableModel(List<VideojuegoED> listaVideojuegosED) {
        Object tabla[][];
        if (listaVideojuegosED != null) {
            tabla = new Object[listaVideojuegosED.size()][3];
            for (int i = 0; i < listaVideojuegosED.size(); i++) {
                VideojuegoED ve = listaVideojuegosED.get(i);
                tabla[i][0] = ve.getVideojuego();
                tabla[i][1] = ve.getExistencia();
                tabla[i][2] = ve.getDisponibilidad();
            }
            return new DefaultTableModel(tabla, nombresColumnasTablasVideojuegosED);
        }
        return null;
    }

    /**
     * Convierte la lista de Videojuegos en un combo box model que se usa para
     * elegir como lista
     *
     * @param listaVideojuegos Lista de videojuegos
     * @return el default combo box model que se creo a partir de la lista
     */
    public DefaultComboBoxModel videojuegosComboBoxModel(List<Videojuego> listaVideojuegos) {
        DefaultComboBoxModel<Videojuego> defaultComboBoxModel = new DefaultComboBoxModel<>();
        if (listaVideojuegos != null) {
            for (int i = 0; i < listaVideojuegos.size(); i++) {
                defaultComboBoxModel.addElement(listaVideojuegos.get(i));
            }
            return defaultComboBoxModel;
        }
        return null;
    }
}
