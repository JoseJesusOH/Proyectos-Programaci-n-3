/*
 * Control.java
 * Creada el 27 de octubre del 2021 18:12 PM
 */
package control;

import dao.Videojuegos;
import excepciones.PersistenciaException;
import interfaces.IPersistenciaVideojuegos;
import interfazUsuario.ConstantesGUI;
import interfazUsuario.DlgInventario;
import interfazUsuario.DlgVideojuego;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import objetosNegocio.Videojuego;
import objetosNegocio.VideojuegoED;
import persistencia.PersistenciaVideojuegosArchivos;
import validores.Validadores;

/**
 * Clase control para el manejo de centro de videojuegos Alumno; Josè Jesùs
 * Orozco Hernàndez ID; 00000229141
 *
 * @author Josè Jesùs
 */
public class Control {

    private IPersistenciaVideojuegos p;
    private Conversiones conversiones;

    /**
     * construsctor quqe inicializa los atributos con nuevos
     *
     */
    public Control() {
        p = new PersistenciaVideojuegosArchivos();
        conversiones = new Conversiones();
    }
    /**
     * Metodo que ayuda a agregar un videojuego a un archivo.
     * @param frame  Frame a  utilizar
     */
    public void agregaVideojuego(JFrame frame) {
        Validadores v2 = new Validadores();
        Videojuego v = null, v3 = null;
        String clave = null;
        DlgVideojuego dlgVideojuego;
        StringBuffer respuesta = new StringBuffer("");
        clave = JOptionPane.showInputDialog(frame, "Numero de catalogo;", "Agregar Videojuego", JOptionPane.QUESTION_MESSAGE);
        if (clave == null) {
            throw new PersistenciaException("Cancelando Operacion");
        }
        if (v2.cadenaVacia(clave)) {
            throw new PersistenciaException("Faltó el numero de catalogo");
        } else if (!v2.validaClave(clave)) {
            throw new PersistenciaException("El numero de catalogo debe contener 3 letras mayúsculas y 4 dígitos.");
        }
        clave = clave.replaceAll(" ", "");
        Videojuego v4 = new Videojuego(clave);
        try {
            v3 = p.obten(v4);
        } catch (PersistenciaException e) {
            throw new PersistenciaException(e.getMessage());
        }

        if (v3 != null) {
            dlgVideojuego = new DlgVideojuego(frame, "EL videojuego ya se encuentran en el catalogo", true, v3, ConstantesGUI.DESPLEGAR, respuesta);
        } else {
            dlgVideojuego = new DlgVideojuego(frame, "Capturar datos del videojuego", true, v4, ConstantesGUI.AGREGAR, respuesta);
            if (respuesta.substring(0).equals(ConstantesGUI.CANCELAR)) {
                throw new PersistenciaException("Cancelando Operacion");
            }
            try {
                Videojuego fin = new Videojuego(v4.getNumCatalogo(), v4.getTitulo(), v4.getGenero(),
                        v4.getClasificacion(), v4.getConsola(), v4.getFabricante(), v4.getVersion());
                p.agregar(fin);
            } catch (PersistenciaException e) {
            }
        }
    }
   /**
    * Metodo que inventaria un videojuegoED a un sistema de archiuvos.
    * @param frame Frame auxiliar.
    */
    public void inventariarVideojuego(JFrame frame) {
        VideojuegoED bVideojuego;
        Videojuego videojuego;
        StringBuffer respuesta = new StringBuffer("");
        DlgInventario dlgInventario;
        List<Videojuego> listaVideojuegos;
        DefaultComboBoxModel<Videojuego> videojuegosComboBoxModel;
        listaVideojuegos = p.consultarVideojuegos();
        if (listaVideojuegos == null) {
            throw new PersistenciaException("No hay videojuegos aun");
        } else {
            videojuegosComboBoxModel = conversiones.videojuegosComboBoxModel(listaVideojuegos);
            videojuego = (Videojuego) videojuegosComboBoxModel.getSelectedItem();
            bVideojuego = new VideojuegoED(videojuego);
            dlgInventario = new DlgInventario(frame, "Inventariar videojuego", true, bVideojuego,
                    videojuegosComboBoxModel, ConstantesGUI.AGREGAR, respuesta);
            if (respuesta.substring(0).equals(ConstantesGUI.CANCELAR)) {
                throw new PersistenciaException("Cancelando Operacion");
            }
            try {
                p.inventariar(bVideojuego.getVideojuego(), bVideojuego.getDisponibilidad());
            } catch (PersistenciaException e) {
                throw new PersistenciaException("Error Inventario");
            }
        }
    }

    /**
     * Crea una lista con todos los videojuegos en el registro y lo convierte en
     * tabla
     *
     * @param frame ventana sobre la que se despliega el cuadro de dialogo para
     * capturar los datos
     * @return te devuelve una tabla que contiene todos los videojuegos
     */
    public Tabla getTablaVideojuegos(JFrame frame) {
        List<Videojuego> listaVideojuegos = null;
        try {
            listaVideojuegos = p.consultarVideojuegos();
        } catch (PersistenciaException e) {
            return null;
        }
        return new Tabla("Lista Videojuegos", conversiones.videoJuegosTableModel(listaVideojuegos));
    }

    /**
     * Crea una lista con todos los videojuegosEd en el registro y lo convierte
     * en tabla
     *
     * @param frame ventana sobre la que se despliega el cuadro de dialogo para
     * capturar los datos
     * @return te devuelve una tabla que contiene todos los videojuegosED
     */
    public Tabla getTablaVideojuegosED(JFrame frame) {
        List<VideojuegoED> listaVideojuegosED = null;
        try {
            listaVideojuegosED = p.consultarInventarioVideojuegos();
        } catch (PersistenciaException e) {
            return null;
        }
        return new Tabla("Lista VideojuegosED", conversiones.videojuegosEDTableModel(listaVideojuegosED));
    }
}
