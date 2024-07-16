/*
 * ArchUtils.java
 */
package archUtils;

import java.io.File;

/**
 * Esta clase de utileria tiene métodos para obtener la extensión 
 * de un nombre de archivo y determinar si una extension es una de
 * las extensiones dadas 
 * @author Manuel Domitsu
 */
public class ArchUtils {
  
    /**
     * Este metodo estatico obtiene la extension de un archivo
     * @param file Ruta abstracta del archivo
     * @return Extension de un archivo
     */
    public static String getExtension(File file) {
        String ext = null;
        
        // Obtiene el nombre del archivo
        String s = file.getName();
        // busca el separador de la extension
        int pos = s.lastIndexOf('.');

        // Si hay un punto en el nombre y hay una
        // extension despues del punto
        if (pos > 0 && pos < s.length() - 1) {
            ext = s.substring(pos + 1);
        }
        
        return ext;
    }

  /**
   * Este medodo determina si la extension del nombre de archivo corresponte a
   * una de las extensiones dadas
   *
   * @param ext Extension del nombre de archivo
   * @param exts Extenciones válidas
   * @return true si si la extension del nombre de archivo corresponte a una
   * imagen, false en caso contrario
   */
  public static boolean esExtension(String ext, String[] exts ) {
    for (int i = 0; i < exts.length; i++) {
      if (ext.equals(exts[i])) {
        return true;
      }
    }

    return false;
  }
}
