/*
 * Texto.java
 */
package figuras;

import graficas.DlgSelectorFuentes;
import java.awt.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;

/**
 * Esta clase muestra diferentes operaciones para dibujar texto
 *
 * @author mdomitsu
 */
public class Texto {

  /**
   * Este metodo dibuja texto sobre el panel de su parametro
   *
   * @param g Objeto con el contexto de graficación del panel
   * @param d Dimensiones del panel
   */
  public void dibujaTexto(Graphics g, Dimension d) {
    Graphics2D g2 = (Graphics2D) g;
    float x, y;

    // Crea un tipo de fuente
    Font fuente = new Font("Serif", Font.PLAIN, 96);
    // Establece el tipo de fuente
    g2.setFont(fuente);

    // Dibuja una cadena de texto
    g2.drawString("Hola mundo", 20, 100);

    // Establece la sugerencia de usar suavizamiento de orillas
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);

    // Dibuja una cadena de texto
    g2.drawString("Hola mundo", 20, 200);
  }

  /**
   * Este metodo dibuja sobre el panel de su parametro texto rotado
   *
   * @param g Objeto con el contexto de graficación del panel
   * @param d Dimensiones del panel
   */
  public void rotaTexto(Graphics g, Dimension d) {
    Graphics2D g2 = (Graphics2D) g;
    float x, y;

    // Crea un tipo de fuente
    Font fuente = new Font("Serif", Font.PLAIN, 48);
    // Establece el tipo de fuente
    g2.setFont(fuente);

    // Establece la sugerencia de usar suavizamiento de orillas
    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);

    // Establece el origen de coordenadas
    g2.translate(80, 250);

    // Dibuja una cadena de texto
    g2.drawString("Hola mundo", 0, 0);

    // Gira el sistema coordenado 45 grados
    g2.rotate(-Math.PI / 4);

    // Dibuja una cadena de texto
    g2.drawString("Hola mundo", 0, 0);

    // Gira el sistema coordenado otros 45 grados
    g2.rotate(-Math.PI / 4);

    // Dibuja una cadena de texto
    g2.drawString("Hola mundo", 0, 0);
  }

  /**
   * Este metodo despliega un cuadro de dialogo para seleccioanar una fuente de
   * las instaladas en el sistema.
   *
   * @param frame frame sobre el que se desplegará el cuadro de dialogo
   */
  public void fuentes(JFrame frame) {
    GraphicsEnvironment gEnv =
            GraphicsEnvironment.getLocalGraphicsEnvironment();

    // Obtiene los nombres de las familias de fuentes instaladas
    // en el sistema
    String[] nombresFamiliaFuentes = gEnv.getAvailableFontFamilyNames();
    // Crea la instancia de la clase DefaultComboMoxModel
    // formada a partir de los nombres de las familias de fuentes
    // instaladas en el sistema
    DefaultComboBoxModel listaNombresFamiliaFuentes = new DefaultComboBoxModel(nombresFamiliaFuentes);

    Font fuente = new Font(nombresFamiliaFuentes[0], Font.PLAIN, 18);

    DlgSelectorFuentes dlg = new DlgSelectorFuentes(frame,
            "Selector de fuentes", true, fuente, listaNombresFamiliaFuentes);
  }
}
