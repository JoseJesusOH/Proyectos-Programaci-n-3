/*
 * Rectangulos.java
 */
package figuras;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

/**
 * Esta clase contiene métodos para dibujar rectangulos, elipses y arcos
 *
 * @author mdomitsu
 */
public class Rectangulos {

  /**
   * Este metodo dibuja un conjunto de rectangulos sobre un panel
   *
   * @param g Objeto con el contexto de graficación del panel
   * @param d Dimensiones del panel
   */
  public void dibujaRectangulos(Graphics g, Dimension d) {
    Graphics2D g2 = (Graphics2D) g;
    int numeroRectangulos = 5;
    Color[] colores = {Color.red, Color.green, Color.blue};

    double x = 0;

    for (int i = 0; i < numeroRectangulos; i++) {
      // Establece el color de la rectangulo
      g2.setPaint(colores[i % colores.length]);

      double paso = d.width / numeroRectangulos;
      double alto = paso / (i + 1);

      // Dibuja una rectangulo en la esquina inferior izquierda
      Rectangle2D rectangulo1 = new Rectangle2D.Double(i * paso, 0,
              paso, alto);
      g2.draw(rectangulo1);

      // Dibuja una rectangulo en la esquina superior derecha
      Rectangle2D rectangulo2 = new Rectangle2D.Double(x, d.height - alto,
              alto, alto);
      x += alto;
      g2.draw(rectangulo2);
    }
  }

  /**
   * Este metodo dibuja un conjunto de rectangulos redondeados sobre un panel
   *
   * @param g Objeto con el contexto de graficación del panel
   * @param d Dimensiones del panel
   */
  public void dibujaRectangulosRedondeados(Graphics g, Dimension d) {
    Graphics2D g2 = (Graphics2D) g;
    int numeroRectangulos = 5;
    Color[] colores = {Color.red, Color.green, Color.blue};

    double x = 0;

    for (int i = 0; i < numeroRectangulos; i++) {
      // Establece el color de la rectangulo
      g2.setPaint(colores[i % colores.length]);

      double paso = d.width / numeroRectangulos;
      double alto = paso / (i + 1);
      double aw = paso / 5;
      double ah = alto / 5;

      // Dibuja una rectangulo en la esquina inferior izquierda
      RoundRectangle2D rectangulo1 = new RoundRectangle2D.Double(i * paso, 0,
              paso, alto, aw, ah);
      g2.draw(rectangulo1);

      // Dibuja una rectangulo en la esquina superior derecha
      RoundRectangle2D rectangulo2 = new RoundRectangle2D.Double(x, d.height - alto,
              alto, alto, ah, ah);
      x += alto;
      g2.draw(rectangulo2);
    }
  }

  /**
   * Este metodo dibuja un conjunto de elipses sobre un panel
   *
   * @param g Objeto con el contexto de graficación del panel
   * @param d Dimensiones del panel
   */
  public void dibujaElipses(Graphics g, Dimension d) {
    Graphics2D g2 = (Graphics2D) g;
    int numeroElipses = 5;
    Color[] colores = {Color.red, Color.green, Color.blue};

    for (int i = 0; i < numeroElipses; i++) {
      // Establece el color de la elipse
      g2.setPaint(colores[i % colores.length]);

      double ancho = d.width / (i + 1);
      double alto = d.height / (i + 1);
      double x1 = (d.width - ancho) / 2;
      double y = (d.height - alto) / 2;
      double x2 = (d.width - alto) / 2;

      // Dibuja una elipse
      Ellipse2D elipse1 = new Ellipse2D.Double(x1, y, ancho, alto);
      g2.draw(elipse1);

      // Dibuja un circulo
      Ellipse2D elipse2 = new Ellipse2D.Double(x2, y, alto, alto);
      g2.draw(elipse2);
    }
  }

  /**
   * Este metodo dibuja un conjunto de arcos sobre un panel
   *
   * @param g Objeto con el contexto de graficación del panel
   * @param d Dimensiones del panel
   */
  public void dibujaArcos(Graphics g, Dimension d) {
    Graphics2D g2 = (Graphics2D) g;
    int numeroArcos = 4;
    Color[] colores = {Color.red, Color.green, Color.blue};

    for (int i = 0; i < numeroArcos; i++) {
      // Establece el color del arco
      g2.setPaint(colores[i % colores.length]);

      double ancho = d.width / (i + 1);
      double alto = d.height / (i + 1);
      double x1 = (d.width - ancho) / 2;
      double y = (d.height - alto) / 2;
      double x2 = (d.width - alto) / 2;

      // Dibuja un arco elíptico
      Arc2D arco1 = new Arc2D.Double(x1, y, ancho, alto, 90 * i, 45, i % 3);
      g2.draw(arco1);

      // Dibuja un arco circular
      Arc2D arco2 = new Arc2D.Double(x2, y, alto, alto, 90 * i, 45, i % 3);
      g2.draw(arco2);
    }
  }
}
