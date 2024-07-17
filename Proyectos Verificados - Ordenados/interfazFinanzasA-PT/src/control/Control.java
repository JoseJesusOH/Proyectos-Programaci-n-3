/*
 * Control.java
 * Creada el 27 de octubre del 2021 18:12 PM
 */
package control;

import excepciones.FinanzaException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import interfaces.IFinanzas;
import interfazFinanzas.ConstantesGUI;
import interfazFinanzas.DlgCategorias;
import interfazFinanzas.DlgEgresos;
import interfazFinanzas.DlgIngresos;
import interfazFinanzas.DlgInteres;
import interfazFinanzas.DlgPeriodo;
import interfazFinanzas.FechaD;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import objetoNegocio.Egresos;
import objetoNegocio.Ingresos;
import objetosServicio.Fecha;
import objetosServicio.Periodo;
import persistencia.PersistenciaFinanzas;

/**
 * Clase control para el manejo de egresos e ingresos.
 *
 * @author Equipo 1
 */
public class Control {

    private static String[] letras = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};
    public static Fecha f = new Fecha();
    private IFinanzas iF;
    private Conversiones conversiones;

    /**
     * construsctor quqe inicializa los atributos con nuevos
     *
     */
    public Control() {
        iF = new PersistenciaFinanzas();
        conversiones = new Conversiones();
    }

    /**
     * Metodo que genera un id aleatorio para el egreso
     *
     * @return el id generado a partir de la fecha y tres letras
     */
    public static String idEgreso() {
        String dia = String.valueOf(f.getDay());
        String mes = String.valueOf(f.getMonth() + 1);
        String year = String.valueOf(f.getYear());
        String s = "E" + dia + mes + year;
        for (int i = 0; i < 3; i++) {
            int random = (int) (Math.random() * (26));
            s += letras[random];
        }
        return s;
    }

    /**
     * Metodo que genera un id aleatorio para el ingreso
     *
     * @return el id generado a partir de la fecha y tres letras
     */
    public static String idIngreso() {
        String dia = String.valueOf(f.getDay());
        String mes = String.valueOf(f.getMonth() + 1);
        String year = String.valueOf(f.getYear());
        String s = "E" + dia + mes + year;
        for (int i = 0; i < 3; i++) {
            int random = (int) (Math.random() * (26));
            s += letras[random];
        }
        return s;
    }

    /**
     * Metodo que permite agregar un ingreso al registro de ingresos.
     *
     * @param frame Frame a utilizar
     * @throws FinanzaException Si se cancela la operacion.
     */
    public void agregarIngreso(JFrame frame) throws FinanzaException {
        Ingresos ingresos, bIngresos = null;
        StringBuffer respuesta = new StringBuffer("");
        DlgIngresos dlgIngresos;
        List<Ingresos> listaIngresos;

        String idIngreso = null;
        while (true) {
            idIngreso = idIngreso();
            Ingresos e = new Ingresos(idIngreso);
            try {
                bIngresos = iF.obtener(e);
            } catch (FinanzaException es) {
            }
            if (bIngresos == null) {
                break;
            }
        }
        Ingresos oficial = new Ingresos(idIngreso);
        dlgIngresos = new DlgIngresos(frame, "Agregar Ingresos", true, respuesta, ConstantesGUI.AGREGAR, oficial);
        if (respuesta.substring(0).equals(ConstantesGUI.CANCELAR)) {
            throw new FinanzaException("Ha cancelado la operacion");
        }
        try {
            iF.agregar(oficial);
        } catch (FinanzaException e) {
            throw new FinanzaException(e.getMessage());
        }
    }

    /**
     * Metodo que permite agregar un egreso al registro de egresos.
     *
     * @param frame Frame a utilizar
     * @throws FinanzaException Si se cancela la operacion.
     */
    public void agregarEgreso(JFrame frame) throws FinanzaException {
        Egresos egresos, bEgresos = null;
        StringBuffer respuesta = new StringBuffer("");
        DlgEgresos dlgEgresos;
        List<Egresos> listaEgresos;

        String idEgreso = null;
        while (true) {
            idEgreso = idEgreso();
            Egresos e = new Egresos(idEgreso);
            try {
                bEgresos = iF.obtener(e);
            } catch (FinanzaException es) {
            }
            if (bEgresos == null) {
                break;
            }
        }
        Egresos oficial = new Egresos(idEgreso);
        dlgEgresos = new DlgEgresos(frame, "Agregar Egresos", true, respuesta, oficial, ConstantesGUI.AGREGAR);
        if (respuesta.substring(0).equals(ConstantesGUI.CANCELAR)) {
            throw new FinanzaException("Ha cancelado la operacion");
        }
        try {
            iF.agregar(oficial);
        } catch (FinanzaException e) {
            throw new FinanzaException(e.getMessage());
        }

    }

    /**
     * Metodo que permite eliminar un egreso del registro de egresos
     *
     * @param egresos Egreso a eliminar
     * @throws FinanzaException Si la operacion se cancela
     */
    public void eliminarEgreso(Egresos egresos) throws FinanzaException {
        try {
            iF.eliminar(egresos);
            JOptionPane.showMessageDialog(null, "El egreso se ha eliminado");
        } catch (FinanzaException e) {
        }
    }

    /**
     * Metodo que permite eliminar un ingreso del registro de ingresos
     *
     * @param ingresos Ingreso a eliminar
     * @throws FinanzaException Si la operacion se cancela
     */
    public void eliminarIngreso(Ingresos ingresos) throws FinanzaException {
        try {
            iF.eliminar(ingresos);
            JOptionPane.showMessageDialog(null, "El ingreso se ha eliminado");
        } catch (FinanzaException e) {
        }
    }

    /**
     * Metodo que actualiza un egreso del registro de egresos.
     *
     * @param egresosd Egreso a actualizar
     * @param frame Frame a utilizar
     * @throws FinanzaException Si la operacion se cancela.
     */
    public void actualizarEgreso(Egresos egresosd, JFrame frame) throws FinanzaException {
        Egresos egresos = null, bEgresos = null;
        StringBuffer respuesta = new StringBuffer("");
        DlgEgresos dlgEgresos;
        List<Egresos> listaEgresos;

        try {
            egresos = iF.obtener(egresosd);
        } catch (FinanzaException e) {
            throw new FinanzaException(e.getMessage());
        }
        dlgEgresos = new DlgEgresos(frame, "Actualizar Egresos", true, respuesta, egresos, ConstantesGUI.ACTUALIZAR);
        if (respuesta.substring(0).equals(ConstantesGUI.CANCELAR)) {
            throw new FinanzaException("Ha cancelado la operacion");
        }
        try {
            Egresos actualizarE = new Egresos(egresos.getID(), egresos.getCantidad(), egresos.getFecha(), egresos.getComentario(), "Egresos", egresos.getCategoria());
            iF.actualizar(actualizarE);
        } catch (FinanzaException e) {
            throw new FinanzaException(e.getMessage());
        }

    }

    /**
     * Metodo que actualiza un ingreso del registro de ingresos.
     *
     * @param ingresosd Ingreso a actualizar
     * @param frame Frame a utilizar
     * @throws FinanzaException Si la operacion se cancela.
     */
    public void actualizarIngreso(Ingresos ingresosd, JFrame frame) throws FinanzaException {
        Ingresos ingresos = null, bIngresos = null;
        StringBuffer respuesta = new StringBuffer("");
        DlgIngresos dlgIngresos;
        List<Egresos> listaEgresos;

        try {
            ingresos = iF.obtener(ingresosd);
        } catch (FinanzaException e) {
            throw new FinanzaException(e.getMessage());
        }

        dlgIngresos = new DlgIngresos(frame, "Actualizar Ingresos", true, respuesta, ConstantesGUI.ACTUALIZAR, ingresos);
        if (respuesta.substring(0).equals(ConstantesGUI.CANCELAR)) {
            throw new FinanzaException("Ha cancelado la operacion");
        }
        try {
            Ingresos actualizarI = new Ingresos(ingresos.getID(), ingresos.getCantidad(), ingresos.getFecha(), ingresos.getComentario(), "Ingresos");
            iF.actualizar(actualizarI);
        } catch (FinanzaException e) {
            throw new FinanzaException(e.getMessage());
        }

    }

    /**
     * Metodo que retorna una tabla con la lista de ingresos actuales.
     *
     * @return La tabla y lo ingresos actuales.
     */
    public Tabla getTablaIngresos() {
        List<Ingresos> listaIngresos = null;
        try {
            listaIngresos = iF.consultarIngresos();
        } catch (FinanzaException e) {
        }
        if (listaIngresos != null) {
            return new Tabla("Lista de ingresos", conversiones.ingresosTableModel(listaIngresos));
        }
        return null;
    }

    /**
     * Metodo que retorna una tabla con la lista de egresos actuales.
     *
     * @return La tabla y lo egresos actuales.
     */
    public Tabla getTablaEgresos() {
        List<Egresos> listaEgresos = null;
        try {
            listaEgresos = iF.consultarEgresos();
        } catch (FinanzaException e) {
        }
        if (listaEgresos != null) {
            return new Tabla("Lista de egresos", conversiones.egresosTableModel(listaEgresos));
        }
        return null;
    }

    /**
     * Metodo que retorna una tabla con la lista de ingresos por fecha.
     *
     * @param frame Frame
     * @return La tabla y lo ingresos por fecha.
     */
    public Tabla getTablaIngresosFecha(JFrame frame) {
        List<Ingresos> listaIngresos = new ArrayList();
        Fecha fd = new Fecha();
        FechaD dlg;
        StringBuffer respuesta = new StringBuffer("");
        String mensaje = null;
        dlg = new FechaD(frame, "Ingrese la fecha", true, ConstantesGUI.AGREGAR, respuesta, fd);
        if (fd == null) {
            return null;
        } else {
            try {
                Fecha fs = fd;
                listaIngresos = iF.consultarIngresosFecha(fs);
            } catch (FinanzaException e) {
                return null;
            }
            if (respuesta.substring(0).equals(ConstantesGUI.CANCELAR)) {
                return null;
            }
            return new Tabla("Lista de ingresos por fecha", conversiones.ingresosTableModel(listaIngresos));
        }
    }

    /**
     * Metodo que retorna una tabla con la lista de egresos por fecha.
     *
     * @param frame Frame
     * @return La tabla y lo egresos por fecha.
     */
    public Tabla getTablaEgresosFecha(JFrame frame) {
        List<Egresos> listaEgresos = new ArrayList();
        Fecha fd = null;
        FechaD dlg;
        StringBuffer respuesta = new StringBuffer("");
        String mensaje = null;
        dlg = new FechaD(frame, "Ingrese la fecha", true, ConstantesGUI.AGREGAR, respuesta, fd);
        if (fd == null) {
            return null;
        } else {
            try {
                Fecha fs = fd;
                listaEgresos = iF.consultarEgresosFecha(fs);
            } catch (FinanzaException e) {
                return null;
            }
            if (respuesta.substring(0).equals(ConstantesGUI.CANCELAR)) {
                return null;
            }
            return new Tabla("Lista de egresos por fecha", conversiones.egresosTableModel(listaEgresos));
        }
    }

    /**
     * Metodo que retorna una tabla con la lista de ingresos por periodo.
     *
     * @param frame Frame
     * @return La tabla y lo ingresos por periodo.
     */
    public Tabla getTablaIngresosPeriodo(JFrame frame) {
        List<Ingresos> listaIngresos = new ArrayList();
        Periodo periodo = new Periodo(null, null);
        DlgPeriodo dlgPeriodo;
        StringBuffer respuesta = new StringBuffer("");
        String mensaje = null;

        dlgPeriodo = new DlgPeriodo(frame, "Ingrese Periodo", true, periodo, ConstantesGUI.AGREGAR, respuesta);
        if (periodo.getDesde() == null || periodo.getHasta() == null) {
            return null;
        } else {
            try {
                Periodo p = new Periodo(periodo.getDesde(), periodo.getHasta());
                listaIngresos = iF.consultarIngresosPeriodo(p);
            } catch (FinanzaException e) {
                return null;
            }

            if (respuesta.substring(0).equals(ConstantesGUI.CANCELAR)) {
                return null;
            }
            return new Tabla("Lista de ingresos por periodo", conversiones.ingresosTableModel(listaIngresos));
        }
    }

    /**
     * Metodo que retorna una tabla con la lista de egresos por periodo.
     *
     * @param frame Frame
     * @return La tabla y lo egresos por periodo.
     */
    public Tabla getTablaEgresosPeriodo(JFrame frame) {
        List<Egresos> listaEgresos = new ArrayList();
        Periodo periodo = new Periodo(null, null);
        DlgPeriodo dlgPeriodo;
        StringBuffer respuesta = new StringBuffer("");
        String mensaje = null;

        dlgPeriodo = new DlgPeriodo(frame, "Ingrese Periodo", true, periodo, ConstantesGUI.AGREGAR, respuesta);

        if (periodo.getDesde() == null || periodo.getHasta() == null) {
            return null;
        } else {
            try {
                Periodo p = new Periodo(periodo.getDesde(), periodo.getHasta());
                listaEgresos = iF.consultarEgresosPeriodo(periodo);
            } catch (FinanzaException e) {
                return null;
            }
            if (respuesta.substring(0).equals(ConstantesGUI.CANCELAR)) {
                return null;
            }
            return new Tabla("Lista de egresos por periodo", conversiones.egresosTableModel(listaEgresos));
        }
    }

    /**
     * Metodo que retorna una tabla con la lista de egresos por categoria.
     *
     * @param frame Frame
     * @return La tabla y lo egresos por categoria.
     */
    public Tabla getTablaEgresosCategoria(JFrame frame) {
        List<Egresos> listaEgresos = new ArrayList();
        StringBuffer respuesta = new StringBuffer("");
        String mensaje = "";
        DlgCategorias dlg;
        dlg = new DlgCategorias(frame, "Seleccione la categoria", true, mensaje, respuesta, ConstantesGUI.AGREGAR);
        try {
            listaEgresos = iF.consultarEgresosCategoria(ConstantesGUI.AUXILIAR);
            ConstantesGUI.AUXILIAR = "";
        } catch (FinanzaException e) {
            return null;
        }
        if (respuesta.substring(0).equals(ConstantesGUI.CANCELAR)) {
            return null;
        }
        return new Tabla("Lista de egresos por categoria", conversiones.egresosTableModel(listaEgresos));
    }

    /**
     * Metodo que obtiene el total de los egresos actuales.
     *
     * @return el total(cantida pesos) de los egresos,
     */
    public double egresosD() {
        double egresos = 0.0;
        List<Egresos> listaEgresos = null;
        try {
            listaEgresos = iF.consultarEgresos();
        } catch (FinanzaException e) {
        }
        if (listaEgresos != null) {
            for (int i = 0; i < listaEgresos.size(); i++) {
                Egresos get = listaEgresos.get(i);
                egresos += get.getCantidad();
            }
        }
        return egresos;
    }

    /**
     * Metodo que obtiene el total de los ingresos actuales.
     *
     * @return el total(cantida pesos) de los ingresos,
     */
    public double ingresosD() {
        double ingresos = 0.0;
        List<Ingresos> listaIngresos = null;
        try {
            listaIngresos = iF.consultarIngresos();
        } catch (FinanzaException e) {
        }
        if (listaIngresos != null) {
            for (int i = 0; i < listaIngresos.size(); i++) {
                Ingresos get = listaIngresos.get(i);
                ingresos += get.getCantidad();
            }
        }
        return ingresos;
    }

    /**
     * Metodo que obtiene el estatus financiero ingresos-egresos
     *
     * @return estatus financiero.
     */
    public double estadoFinanciero() {
        double egresos = 0.0;
        double ingresos = 0.0;
        List<Egresos> listaEgresos = null;
        try {
            listaEgresos = iF.consultarEgresos();
        } catch (FinanzaException e) {
        }
        if (listaEgresos != null) {
            for (int i = 0; i < listaEgresos.size(); i++) {
                Egresos get = listaEgresos.get(i);
                egresos += get.getCantidad();
            }
        }

        List<Ingresos> listaIngresos = null;
        try {
            listaIngresos = iF.consultarIngresos();
        } catch (FinanzaException e) {
        }
        if (listaIngresos != null) {
            for (int i = 0; i < listaIngresos.size(); i++) {
                Ingresos get = listaIngresos.get(i);
                ingresos += get.getCantidad();
            }
        }
        return ingresos - egresos;
    }
}
