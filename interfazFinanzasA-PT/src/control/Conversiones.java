/*
 * Conversiones.java
Creada el 2 de noviembre del 2021 6:14 PM
 */
package control;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import objetoNegocio.Egresos;
import objetoNegocio.Ingresos;

/**
 * Clase que realiza las conversiones para la utilizacion de tablas.
 *
 * @author Equipo 1
 */
public class Conversiones {

    String nombreColumnasTablasEgresos[] = {"ID", "Tipo Movimiento", "Cantidad", "Fecha", "Comentario", "Categoria"};
    String nombreColumnasTablasIngresos[] = {"ID", "Tipo Movimiento", "Cantidad", "Fecha", "Comentario"};
    String categoria[] = {"Rutina", "Transporte", "Familia", "Alimentacion", "Regalos", "Educacion", "Salud"};

    /**
     * Este metodo convierte la lista de ungresos en un arreglo bidimensional
     * para despues ir llenandolo con todos sus datos esto despues se convierte
     * en un default table model que necesita arreglos bidimensionales
     *
     * @param listaIngresos Lista de ingresos
     * @return la tabla creada a partir de la lista
     */
    public DefaultTableModel ingresosTableModel(List<Ingresos> listaIngresos) {
        Object tabla[][];
        if (listaIngresos != null) {
            tabla = new Object[listaIngresos.size()][5];
            for (int i = 0; i < listaIngresos.size(); i++) {
                Ingresos d = listaIngresos.get(i);
                tabla[i][0] = d.getID();
                tabla[i][1] = d.getTipoMovimiento();
                tabla[i][2] = d.getCantidad();
                tabla[i][3] = (d.getFecha().getDay() + "/" + d.getFecha().getMonth() + "/" + d.getFecha().getYear());
                tabla[i][4] = d.getComentario();
            }
            return new DefaultTableModel(tabla, nombreColumnasTablasIngresos);
        }
        return null;
    }

    /**
     * Este metodo convierte la lista de egresos en un arreglo
     * bidimensional para despues ir llenandolo con todos sus datos esto despues
     * se convierte en un default table model que necesita arreglos
     * bidimensionales
     *
     * @param listaEgresos Lista de egresos
     * @return la tabla creada a partir de la lista.
     */
    public DefaultTableModel egresosTableModel(List<Egresos> listaEgresos) {
        Object tabla[][];
        if (listaEgresos != null) {
            tabla = new Object[listaEgresos.size()][6];
            for (int i = 0; i < listaEgresos.size(); i++) {
                Egresos d = listaEgresos.get(i);
                tabla[i][0] = d.getID();
                tabla[i][1] = d.getTipoMovimiento();
                tabla[i][2] = d.getCantidad();
                tabla[i][3] = (d.getFecha().getDay() + "/" + d.getFecha().getMonth() + "/" + d.getFecha().getYear());
                tabla[i][4] = d.getComentario();
                tabla[i][5] = d.getCategoria();
            }
            return new DefaultTableModel(tabla, nombreColumnasTablasEgresos);
        }
        return null;
    }
}
