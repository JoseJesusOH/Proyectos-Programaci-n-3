/*
 * Control.java
 * Creada el 20 de septiembre del 2021 a las 5:21 PM 
 * Editada el 19 de octubre del 2021 a las 21:59 PM 
 */
package control;

import interfazUsuario.ConstantesGUI;
import interfazUsuario.DlgReemplazar;
import interfazUsuario.FrmEditor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Clase control con la que se desarrollara la funcionalidad de un sistema de
 * archivos. Alumno; José Jesús Orozco Hernández Id; 00000229141
 *
 * @author Jose Jesus
 */
public class Control {

    /**
     * Atributo que representa la direcion del archivo
     */
    private String nomArchivo;
    /**
     * Atributoque representa el contenido de un archivo
     */
    private String texto;

    /**
     * Constructor por defecto.
     */
    public Control() {
    }

    /**
     * Constructor que inciliaza el valor de los atributos conforme a los
     * paramteros.
     *
     * @param nomArchivo Nombre del archivo
     * @param texto Texto que contiene el archivo
     *
     */
    public Control(String nomArchivo, String texto) {
        this.nomArchivo = nomArchivo;
        this.texto = texto;
    }

    /**
     * Metodo para obtener el nombre del archivo
     *
     * @return El nombre del archivo
     */
    public String getNomArchivo() {
        return nomArchivo;
    }

    /**
     * Metodo que obtiene el contenido del archivo
     *
     * @return El contenido del archivo
     */
    public String getTexto() {
        return texto;
    }

    /**
     * Metodo para establecer el contenido del archivo
     *
     * @param texto Texto a escribir
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }

    /**
     * Metodo que utiliza una instancia de JOpcionPane para obtener la
     * confirmación del usuario y en caso afirmativo establece los atributos
     * nomArchivo y texto a cadenas vacías
     *
     * @param frame Frame de editor
     * @return true si se desea un nuevo archivo, false en caso contrario
     */
    public boolean nuevoArchivo(JFrame frame) {
        if (JOptionPane.showOptionDialog(frame, "Crear Nuevo", "Crear Nuevo Archivo", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Nuevo archivo", "Cancelar"}, "Crear Nuevo") == 0) {
            this.nomArchivo = "";
            this.texto = "";
            return true;
        }
        return false;
    }

    /**
     * Metodo obtiene del usuario el nombre del archivo texto a abrir. Para
     * obtener el nombre del archivo utilice la componente JFileChooser con las
     * extensiones de archivo “.txt” y “.java”. El método leerá el archivo texto
     * y guardará su contenido en el atributo texto.
     *
     * @param frame Frame de editor
     */
    public void abrirArchivo(JFrame frame) {
        JFileChooser chooser = new JFileChooser();
        chooser.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filterTxt = new FileNameExtensionFilter(
                "Texto [*.txt]", "txt");
        FileNameExtensionFilter filterJava = new FileNameExtensionFilter(
                "Codigo Java [*.java]", "java");
        chooser.setFileFilter(filterTxt);
        chooser.setFileFilter(filterJava);
        int returnVal = chooser.showOpenDialog(frame);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File f = chooser.getSelectedFile();
            try {
                this.nomArchivo = f.getAbsolutePath();
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                int con = 1;
                String linea = br.readLine();
                while (linea != null) {
                    if (con == 1) {
                        this.setTexto(linea);
                        con++;
                    }
                    linea = br.readLine();
                    if (linea == null) {
                        break;
                    } else {
                        this.setTexto(getTexto() + "\n" + linea);
                        con++;
                    }
                }
                br.close();
                fr.close();
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    /**
     * Metodo que guarda el contenido del atributo texto en el archivo cuyo
     * nombre está dado por el atributo nomArchivo. Si nomArchivo está vacío, se
     * obtiene un nombre utilizando la componente JFileChooser con las
     * extensiones de archivo “.txt” y “.java”.
     *
     * @param frame Frame de editor
     */
    public void guardarArchivo(JFrame frame) {

        if (this.nomArchivo == null || this.texto.equals("")) {
            guardarArchivoComo(frame);
        } else {
            File file2 = new File(this.nomArchivo);
            if (file2.exists() == false) {
                JOptionPane.showMessageDialog(frame, "No se ha seleccionado nada");
            } else {
                FileWriter escribir;
                BufferedWriter files;
                if (JOptionPane.showConfirmDialog(frame, "Esta seguro de guardar el archivo") != JOptionPane.OK_OPTION) {
                } else {
                    try {
                        escribir = new FileWriter(file2.getAbsoluteFile());
                        escribir.write(texto);
                        escribir.close();
                    } catch (IOException e) {
                        Logger.getLogger(FrmEditor.class.getName()).log(Level.SEVERE, null, e);
                    }
                }
            }
        }
    }

    /**
     * Metodo que guarda el contenido del atributo texto con otro nombre de
     * archivo. Para obtener el nombre del archivo utilice la componente
     * JFileChooser con las extensiones de archivo “.txt” y “.java”.
     *
     * @param frame Frame de editor
     */
    public void guardarArchivoComo(JFrame frame) {
        String nombre = "";
        JFileChooser chooser = new JFileChooser(System.getProperty("user.dir"));
        chooser.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filterTxt = new FileNameExtensionFilter(
                "Texto [*.txt]", "txt");
        FileNameExtensionFilter filterJava = new FileNameExtensionFilter(
                "Codigo Java [*.java]", "java");
        chooser.setFileFilter(filterTxt);
        chooser.setFileFilter(filterJava);
        int n = chooser.showSaveDialog(frame);
        if (n != JFileChooser.APPROVE_OPTION) {
            JOptionPane.showMessageDialog(frame, "El documento no se ha guardado");
        }
        if (n == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            FileNameExtensionFilter extensionFilter = (FileNameExtensionFilter) chooser.getFileFilter();
            FileWriter escribir;
            if (file == null) {
                JOptionPane.showMessageDialog(frame, "No se ha enconttado el archivo");
            } else {
                nomArchivo = file.getAbsolutePath() + "." + extensionFilter.getExtensions()[0];
                File pr = new File(nomArchivo);
                if (pr.exists()) {
                    JOptionPane.showMessageDialog(frame, "No se permiten guardar achivos con el mismo nombre que otro");
                } else {
                    int nD = JOptionPane.showConfirmDialog(frame, "¿Desea realmente de guardar el archivo?");
                    if (nD == JOptionPane.OK_OPTION) {
                        try {
                            // + "." + extensionFilter.getExtensions()[0]
                            escribir = new FileWriter(file + "." + extensionFilter.getExtensions()[0]);
                            escribir.write(texto);
                            escribir.close();
                        } catch (IOException e) {
                            Logger.getLogger(FrmEditor.class.getName()).log(Level.SEVERE, null, e);
                        }
                    }
                    if (nD != JOptionPane.OK_OPTION) {
                        nomArchivo = null;
                        texto = "";
                    }
                }
            }
        }

    }

    /**
     * Metodo que utiliza una instancia de JOpcionPane para obtener la
     * confirmación del usuario y en caso afirmativo borra el archivo cuyo
     * nombre está dado por el atributo nomArchivo y establece los atributos
     * nomArchivo y texto a cadenas vacías.
     *
     * @param frame Frame de editor
     * @return true si el archivo se borro, false en caso contrario.
     */
    public boolean eliminarArchivo(JFrame frame) {
        if (nomArchivo != null) {
            int a = JOptionPane.showOptionDialog(null, "Confirma si desea eliminar el archivo", "Eliminar", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Eliminar", "Cancelar"}, "Eliminar");
            if (a == JOptionPane.OK_OPTION) {
                File archivo = new File(nomArchivo);
                archivo.delete();
                nomArchivo = null;
                texto = "";
                JOptionPane.showMessageDialog(frame, "El archivo se borro correctamente");
                return true;
            } else if (a != JOptionPane.OK_OPTION) {
                JOptionPane.showMessageDialog(frame, "El archivo no se ha eliminado, por lo tanto se ha cerrado");
            }
        } else {
            JFileChooser chooser = new JFileChooser();
            chooser.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter filterTxt = new FileNameExtensionFilter(
                    "Texto [*.txt]", "txt");
            FileNameExtensionFilter filterJava = new FileNameExtensionFilter(
                    "Codigo Java [*.java]", "java");
            chooser.setFileFilter(filterTxt);
            chooser.setFileFilter(filterJava);
            int returnVal = chooser.showOpenDialog(frame);
            String ayuda = "";
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                int n = JOptionPane.showOptionDialog(null, "Confirma si desea eliminar el archivo", "Eliminar", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[]{"Eliminar", "Cancelar"}, "Eliminar");
                if (n == JOptionPane.OK_OPTION) {
                    File f = chooser.getSelectedFile();
                    this.nomArchivo = f.getAbsolutePath();
                    File archivo = new File(nomArchivo);
                    archivo.delete();
                    nomArchivo = null;
                    texto = "";
                    JOptionPane.showMessageDialog(frame, "El archivo se borro correctamente");
                    return true;
                } else if (n != JOptionPane.OK_OPTION) {
                    JOptionPane.showMessageDialog(frame, "El archivo no se ha eliminado, por lo tanto se ha cerrado");
                }

            }
        }

        return false;
    }

    /**
     * Metodo que emplea el cuadro de dialogo DlgReemplazar, para obtener del
     * usuario las cadenas buscar y reemplazar y reemplaza de la cadena dada por
     * el atributo texto todas las instancias de la subcadena buscar por la
     * subcadena reemplazar.
     *
     * @param frame Frame de editor
     * @return El método regresa el número de reemplazos hechos.
     */
    public int reemplazar(JFrame frame) {
        if (texto != null) {
            int reemplazo = 0;

            StringBuffer reemplazar = new StringBuffer();
            StringBuffer buscar = new StringBuffer();
            StringBuffer respuesta = new StringBuffer();
            StringBuffer mayuscula = new StringBuffer();
            StringBuffer palabraCompleta = new StringBuffer();

            DlgReemplazar dlgReemplazar = new DlgReemplazar(frame, true, buscar, reemplazar, mayuscula, palabraCompleta, ConstantesGUI.REMPLAZAR, respuesta);

            if (reemplazar.substring(0).equals(ConstantesGUI.CANCELAR)) {
                return 0;
            }
            if (texto == null) {
                return 0;
            }
            int palabra = 0;
            Pattern pattern = Pattern.compile("\\s");
            String[] palabras = pattern.split(texto);
            if (String.valueOf(mayuscula).equals(ConstantesGUI.FALSE)) {
                Pattern com;
                if (String.valueOf(palabraCompleta).equals(ConstantesGUI.TRUE)) {
                    com = Pattern.compile(String.valueOf("\\b" + buscar + "\\b"), Pattern.CASE_INSENSITIVE);
                    Matcher matcher = com.matcher(texto);
                    for (int i = 0; i < palabras.length; i++) {
                        Matcher matcher2 = com.matcher(palabras[i]);
                        if (matcher2.find()) {
                            palabra++;
                        }
                    }
                    texto = matcher.replaceAll(String.valueOf(reemplazar));
                } else if (String.valueOf(palabraCompleta).equals(ConstantesGUI.FALSE)) {
                    com = Pattern.compile(String.valueOf(buscar), Pattern.CASE_INSENSITIVE);
                    Matcher match = com.matcher(texto);
                    for (int i = 0; i < palabras.length; i++) {
                        Matcher matcher3 = com.matcher(palabras[i]);
                        if (matcher3.find()) {
                            palabra++;
                        }
                    }
                    texto = match.replaceAll(String.valueOf(reemplazar));
                }
            } else if (String.valueOf(mayuscula).equals(ConstantesGUI.TRUE)) {
                Pattern com;
                if (String.valueOf(palabraCompleta).equals(ConstantesGUI.TRUE)) {
                    com = Pattern.compile(String.valueOf("\\b" + buscar + "\\b"), Pattern.CASE_INSENSITIVE);
                    Matcher matcher = com.matcher(texto);
                    for (int i = 0; i < palabras.length; i++) {
                        Matcher matcher2 = com.matcher(palabras[i]);
                        if (matcher2.find()) {
                            palabra++;
                        }
                    }
                    texto = matcher.replaceAll(String.valueOf(reemplazar));
                } else if (String.valueOf(palabraCompleta).equals(ConstantesGUI.FALSE)) {
                    com = Pattern.compile(String.valueOf(buscar), Pattern.CASE_INSENSITIVE);
                    Matcher match = com.matcher(texto);
                    for (int i = 0; i < palabras.length; i++) {
                        Matcher matcher3 = com.matcher(palabras[i]);
                        if (matcher3.find()) {
                            palabra++;
                        }
                    }
                    texto = match.replaceAll(String.valueOf(reemplazar));
                }
            }
            JOptionPane.showMessageDialog(null, "Numero de reemplazos hechos: " + palabra);
            return palabra;
//            StringTokenizer tokenizador = new StringTokenizer(texto);
//            while (tokenizador.hasMoreTokens()) {
//                if (tokenizador.nextToken().equals(buscar.toString())) {
//                    reemplazo++;
//                }
//            }
//            if (reemplazo == 0) {
//                JOptionPane.showMessageDialog(null, "Numero de reemplazos hechos: " + reemplazo);
//            } else {
//                JOptionPane.showMessageDialog(null, "Numero de reemplazos hechos: " + reemplazo);
//                texto = texto.replaceAll(String.valueOf(buscar), String.valueOf(reemplazar));
//            }
//            return reemplazo;
        } else {
            JOptionPane.showMessageDialog(null, "No existen cadenas para reemplazar.");
        }
        return -1;
    }

    /**
     * Metodo que cuenta el número de caracteres, palabras y líneas del archivo.
     * El resultado se desplegará en una instancia de JOpcionPane.
     *
     * @param frame Frame de editor
     * @throws IOException Si no se puede leer el archivo
     * @throws FileNotFoundException Si el archivo no se encuentea
     */
    public void contar(JFrame frame) throws IOException, FileNotFoundException {
        if (texto != null) {
////            int numPal = 0;
////             Pattern patternPalabras = Pattern.compile("\\s+");
////             Pattern pattern =Pattern.compile("\n");
////             String text=texto.replaceAll(" ","");
////             int numCaracteres=text.length();
////             Pattern  patterns = Pattern.compile("((\\w|\\W)\\n|\\S$|\\.|\\s|\\,|\\;|\\-)");
////             String [] num=patterns.split(texto);
////             for (String string : num) {
////                numPal++;
////            }
////             String[] numLinea=pattern.split(texto);
////             int numLi=numLinea.length;
////            JOptionPane.showMessageDialog(frame, "El numero de palabras es: " + numPal+
////                    ", El numero de Caracteres es; "+numCaracteres
////                +", El numero de lineas es; "+numLi);
            String d = texto;
            String a = d;
            String[] b = a.split("[^a-zA-Z]");
            int contador = 0;
            int contadorL = 0;
            for (String st : b) {
                Pattern p = Pattern.compile("[a-zA-Z]");     // pattern
                Matcher m = p.matcher(b[contador]);
                if (m.find()) {
                    contadorL++;
                }
                contador++;
            }
             Pattern pattern =Pattern.compile("\n");
             String text=texto.replaceAll(" ","");
             int numCaracteres=text.length();
             String[] numLinea=pattern.split(texto);
             int numLi=numLinea.length;
            JOptionPane.showMessageDialog(frame, "El numero de palabras es: " + contadorL+
                    ", El numero de Caracteres es; "+numCaracteres
                +", El numero de lineas es; "+numLi);
        } else {
            JOptionPane.showMessageDialog(frame, "El numero de palabras es: " + 0);
        }
    }
}
