/*
 * Operaciones.java
 */
package figuras;

import java.awt.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;

/**
 * Esta clase ilustra las operaciones de combinacion de figuras, relleno de
 * figuras y cambio de pincel
 *
 * @author mdomitsu
 */
public class Operaciones {

  /**
   * Este metodo dibuja combinaciones de figuras sobre un panel
   * @param g Objeto con el contexto de graficación del panel
   * @param d Dimensiones del panel
   */
  public void combinaFiguras(Graphics g, Dimension d) {
    Graphics2D g2 = (Graphics2D) g;
    Area area1, area2;

    double ancho = d.width / 6;
    double alto = d.height / 4;
    double x = 50;
    double y = 25;

    // Obten el area de una figura rectangular
    area1 = new Area(new Rectangle2D.Double(x, y, ancho, alto));
    x += ancho / 2;
    y += alto / 2;
    // Obten el area de una figura eliptica
    area2 = new Area(new Ellipse2D.Double(x, y, ancho, alto));
    // Dibuja las dos areas
    g2.setPaint(Color.black);
    g2.draw(area1);
    g2.draw(area2);
    // Obten la union de las areas
    area2.add(area1);
    // Rellana la union de las areas
    g2.setPaint(Color.red);
    g2.fill(area2);

    x += 100 + ancho;
    y = 25;

    // Obten el area de una figura rectangular
    area1 = new Area(new Rectangle2D.Double(x, y, ancho, alto));
    x += ancho / 2;
    y += alto / 2;
    // Obten el area de una figura eliptica
    area2 = new Area(new Ellipse2D.Double(x, y, ancho, alto));
    // Dibuja las dos areas
    g2.setPaint(Color.black);
    g2.draw(area1);
    g2.draw(area2);
    // Obten la resta de las areas
    area2.subtract(area1);
    // Rellana la resta de las areas
    g2.setPaint(Color.yellow);
    g2.fill(area2);

    x = 50;
    y = 100 + alto;

    // Obten el area de una figura rectangular
    area1 = new Area(new Rectangle2D.Double(x, y, ancho, alto));
    x += ancho / 2;
    y += alto / 2;
    // Obten el area de una figura eliptica
    area2 = new Area(new Ellipse2D.Double(x, y, ancho, alto));
    // Dibuja las dos areas
    g2.setPaint(Color.black);
    g2.draw(area1);
    g2.draw(area2);
    // Obten la interseccion de las areas
    area2.intersect(area1);
    // Rellena la interseccion de las areas
    g2.setPaint(Color.green);
    g2.fill(area2);

    x += 100 + ancho;
    y = 100 + alto;

    // Obten el area de una figura rectangular
    area1 = new Area(new Rectangle2D.Double(x, y, ancho, alto));
    x += ancho / 2;
    y += alto / 2;
    // Obten el area de una figura eliptica
    area2 = new Area(new Ellipse2D.Double(x, y, ancho, alto));
    // Dibuja las dos areas
    g2.setPaint(Color.black);
    g2.draw(area1);
    g2.draw(area2);
    // Obten la union exclusiva de las areas
    area2.exclusiveOr(area1);
    // Rellena la union exclusiva de las areas
    g2.setPaint(Color.cyan);
    g2.fill(area2);
  }

  /**
   * Este metodo rellena figuras sobre un panel
   * @param g Objeto con el contexto de graficación del panel
   * @param d Dimensiones del panel
   * @param bi Imagen de relleno
   */
  public void rellenaFiguras(Graphics g, Dimension d, BufferedImage bi) {
    Graphics2D g2 = (Graphics2D) g;
    
    double ancho = d.width / 4;
    double alto = d.height / 4;
    double x = 50;
    double y = 25;

    // Rellena una elipse con un color solido
    Ellipse2D elipse = new Ellipse2D.Double(x, y, ancho, alto);
    g2.setPaint(Color.yellow);
    g2.fill(elipse);

    x += 100 + ancho;
    // Crea un gradiente de color
    GradientPaint gp = new GradientPaint((int) x, (int) y, Color.red,
            (int) (x + ancho), (int) (y + alto), Color.blue);

    // Rellena un rectangulo con un gradiente de color
    Rectangle2D rect = new Rectangle2D.Double(x, y, ancho, alto);
    g2.setPaint(gp);
    g2.fill(rect);

    x = 50 + ancho;
    y = 100 + alto;

    // Crea el rectangulo ancla del tamaño de la imagen
    Rectangle2D tr = new Rectangle2D.Double(0, 0, bi.getWidth(), bi.getHeight());
    TexturePaint tp = new TexturePaint(bi, tr);

    // Rellena el rectangulo con la textura
    RoundRectangle2D rrect = new RoundRectangle2D.Double(x, y, ancho, alto, ancho / 5, alto / 5);
    g2.setPaint(tp);
    g2.fill(rrect);
  }

  /**
   * Este metodo dibuja tipos de contornos sobre un panel
   * @param g Objeto con el contexto de graficación del panel
   * @param d Dimensiones del panel
   * @param bi Imagen de relleno
   */
  public void contornoFiguras(Graphics g, Dimension d, BufferedImage bi) {
    Graphics2D g2 = (Graphics2D) g;
    Area area1, area2;
    
    // Crea dos contornos
    BasicStroke bs1 = new BasicStroke(3);
    BasicStroke bs2 = new BasicStroke(15);

    double ancho = d.width / 6;
    double alto = d.height / 4;
    double x = 50;
    double y = 25;

    // Obten el area de una figura rectangular
    area1 = new Area(new Rectangle2D.Double(x, y, ancho, alto));
    x += ancho / 2;
    y += alto / 2;
    // Obten el area de una figura eliptica
    area2 = new Area(new Ellipse2D.Double(x, y, ancho, alto));
    // Establece el tipo de contorno
    float[] dash1 = {10, 5};
    BasicStroke bs3 = new BasicStroke(1, BasicStroke.CAP_BUTT,
            BasicStroke.JOIN_BEVEL, 0, dash1, 0);
    g2.setStroke(bs3);
    // Dibuja las dos areas
    g2.setPaint(Color.black);
    g2.draw(area1);
    g2.draw(area2);
    // Obten la union de las areas
    area2.add(area1);
    // Dibuja la union de las areas
    g2.setStroke(bs1);
    g2.setPaint(Color.red);
    g2.draw(area2);

    x += 100 + ancho;
    y = 25;

    // Obten el area de una figura rectangular
    area1 = new Area(new Rectangle2D.Double(x, y, ancho, alto));
    x += ancho / 2;
    y += alto / 2;
    // Obten el area de una figura eliptica
    area2 = new Area(new Ellipse2D.Double(x, y, ancho, alto));
    // Establece el tipo de contorno
    float[] dash2 = {5, 10, 10, 5};
    BasicStroke bs4 = new BasicStroke(1, BasicStroke.CAP_BUTT,
            BasicStroke.JOIN_BEVEL, 0, dash2, 0);
    g2.setStroke(bs4);
    // Dibuja las dos areas
    g2.setPaint(Color.black);
    g2.draw(area1);
    g2.draw(area2);
    // Obten la resta de las areas
    area2.subtract(area1);
    // Dibuja la resta de las areas
    g2.setStroke(bs1);
    g2.setPaint(Color.yellow);
    g2.draw(area2);

    x = 50;
    y = 100 + alto;

    // Crea una figura rectangular
    Rectangle2D rect = new Rectangle2D.Double(x, y, 2 * ancho, alto);
    // Crea un gradiente de color
    GradientPaint gp = new GradientPaint((int) x, (int) y, Color.red,
            (int) (x + 2 * ancho), (int) (y + alto), Color.blue);
    // Establece el tipo de contorno
    g2.setStroke(bs2);
    // Dibuja el rectangulo
    g2.setPaint(gp);
    g2.draw(rect);

    x += 50 + 2 * ancho;
    y = 100 + alto;

    // Crea de una figura eliptica
    Ellipse2D elipse = new Ellipse2D.Double(x, y, 2 * ancho, alto);
    // Crea el rectangulo ancla del tamaño de la imagen
    Rectangle2D tr = new Rectangle2D.Double(0, 0, bi.getWidth(), bi.getHeight());
    TexturePaint tp = new TexturePaint(bi, tr);
    // Establece el tipo de contorno
    g2.setStroke(bs2);

    // Dibuja la elipse
    g2.setPaint(tp);
    g2.draw(elipse);
  }

  /**
   * Este metodo dibuja translaciones de figuras sobre un panel
   * @param g Objeto con el contexto de graficación del panel
   * @param d Dimensiones del panel
   */
  public void transladaFiguras(Graphics g, Dimension d) {
    Graphics2D g2 = (Graphics2D) g;

    double ancho = d.width / 4;
    double alto = d.height / 4;
    double x = 50;
    double y = 25;

    // Establece el tipo de contorno
    BasicStroke bs = new BasicStroke(2);
    g2.setStroke(bs);

    // Establece el color del contorno
    g2.setPaint(Color.blue);

    // Crea una figura rectangular
    Rectangle2D rect = new Rectangle2D.Double(x, y, ancho, alto);
    // Crea de una figura eliptica
    Ellipse2D.Double elipse = new Ellipse2D.Double(x, y, ancho, alto);

    // Establece el origen inicial
    g2.translate(10, 10);

    // Dibuja los ejes coordenados
    dibujaEjes(g2, ancho, alto);

    // Dibuja el rectangulo y la elipse
    g2.draw(rect);
    g2.draw(elipse);

    // Translada el origen
    g2.translate(2 * ancho, 0);

    // Dibuja los ejes coordenados
    dibujaEjes(g2, ancho, alto);

    // Dibuja el rectangulo y la elipse
    g2.draw(rect);
    g2.draw(elipse);

    // Translada el origen
    g2.translate(0, 2 * alto);

    // Dibuja los ejes coordenados
    dibujaEjes(g2, ancho, alto);

    // Dibuja el rectangulo y la elipse
    g2.draw(rect);
    g2.draw(elipse);
  }

  /**
   * Este metodo dibuja rotaciones de figuras sobre un panel
   * @param g Objeto con el contexto de graficación del panel
   * @param d Dimensiones del panel
   */
  public void rotaFiguras(Graphics g, Dimension d) {
    Graphics2D g2 = (Graphics2D) g;

    double ancho = d.width / 4;
    double alto = d.height / 4;

    // Establece la posición inicial del origen
    g2.translate(2 * ancho, 2 * alto);

    // Establece el tipo de contorno
    BasicStroke bs = new BasicStroke(2);
    g2.setStroke(bs);

    // Establece el color del contorno
    g2.setPaint(Color.blue);

    // Crea una figura rectangular
    Rectangle2D.Double rect = new Rectangle2D.Double(-ancho / 2, -alto / 2, ancho, alto);
    // Crea de una figura eliptica
    Ellipse2D.Double elipse = new Ellipse2D.Double(-ancho / 2, -alto / 2, ancho, alto);

    // Dibuja los ejes coordenados
    dibujaEjes(g2, ancho, alto);

    // Dibuja el rectangulo y la elipse
    g2.draw(rect);
    g2.draw(elipse);

    // Rota el origen
    g2.rotate(Math.PI / 4);

    // Dibuja los ejes coordenados
    dibujaEjes(g2, ancho, alto);

    // Dibuja el rectangulo y la elipse
    g2.draw(rect);
    g2.draw(elipse);

    // Rota el origen
    g2.rotate(Math.PI / 4);

    // Dibuja los ejes coordenados
    dibujaEjes(g2, ancho, alto);

    // Dibuja el rectangulo  y la elipse
    g2.draw(rect);
    g2.draw(elipse);
  }

  /**
   * Este metodo dibuja figuras escaladas sobre un panel
   * @param g Objeto con el contexto de graficación del panel
   * @param d Dimensiones del panel
   */
  public void escalaFiguras(Graphics g, Dimension d) {
    Graphics2D g2 = (Graphics2D) g;

    double ancho = d.width / 4;
    double alto = d.height / 4;
    double x = 50;
    double y = 25;

    // Establece el tipo de contorno
    BasicStroke bs = new BasicStroke(2);
    g2.setStroke(bs);

    // Establece el color del contorno
    g2.setPaint(Color.blue);

    // Crea una figura rectangular
    Rectangle2D.Double rect = new Rectangle2D.Double(x, y, ancho, alto);
    // Crea de una figura eliptica
    Ellipse2D.Double elipse = new Ellipse2D.Double(x, y, ancho, alto);

    // Dibuja el rectangulo y la elipse
    g2.draw(rect);
    g2.draw(elipse);

    // Escala la imagen
    g2.scale(1.5, 1.5);

    // Dibuja el rectangulo y la elipse
    g2.draw(rect);
    g2.draw(elipse);

    // Escala la imagen
    g2.scale(1.5, 1.5);

    // Dibuja el rectangulo y la elipse
    g2.draw(rect);
    g2.draw(elipse);
  }

  /**
   * Este método dibuja unos ejes coordenados en el contexto g2
   * @param g2 Contexto de Graphics2D en el que se dibujan los ejes
   * @param ancho Longitud del eje X
   * @param alto Longitud del eje Y
   */
  public void dibujaEjes(Graphics2D g2, double ancho, double alto) {
    BasicStroke bs1 = new BasicStroke(2, BasicStroke.CAP_BUTT,
            BasicStroke.JOIN_BEVEL, 0,
            new float[]{5, 5}, 0);
    // Crea los ejes coordenados
    Line2D ejeX = new Line2D.Double(-10, 0, ancho, 0);
    Line2D ejeY = new Line2D.Double(0, -10, 0, alto);

    // Guarda los valores de Paint y Stroke actuales
    Paint paint = g2.getPaint();
    Stroke stroke = g2.getStroke();

    // Establece los nuevos valores de Paint y Stroke
    g2.setStroke(bs1);
    g2.setPaint(Color.black);

    // Dibuja los ejes coordenados
    g2.draw(ejeX);
    g2.draw(ejeY);

    // Reestablece los valores de Paint y Stroke originales
    g2.setStroke(stroke);
    g2.setPaint(paint);
  }

  /**
   * Este metodo dibuja deformaciones de figuras sobre un panel
   * @param g Objeto con el contexto de graficación del panel
   * @param d Dimensiones del panel
   */
  public void deformaFiguras(Graphics g, Dimension d) {
    Graphics2D g2 = (Graphics2D) g;

    double ancho = d.width / 4;
    double alto = d.height / 4;
    double x = 50;
    double y = 10;

    // Establece el tipo de contorno
    BasicStroke bs = new BasicStroke(2);
    g2.setStroke(bs);

    // Establece el color del contorno
    g2.setPaint(Color.blue);

    // Crea una figura rectangular
    Rectangle2D rect = new Rectangle2D.Double(x, y, ancho, alto);
    // Crea de una figura eliptica
    Ellipse2D.Double elipse = new Ellipse2D.Double(x, y, ancho, alto);

    // Establece el origen inicial
    g2.translate(10, 10);

    // Dibuja los ejes coordenados
    dibujaEjes(g2, ancho, alto);

    // Dibuja el rectangulo y la elipse
    g2.draw(rect);
    g2.draw(elipse);

    // Translada el origen
    g2.translate(2 * ancho, 0);

    // Deforma horizontalmente
    g2.shear(0.5, 0);

    // Dibuja los ejes coordenados
    dibujaEjes(g2, ancho, alto);

    // Dibuja el rectangulo y la elipse
    g2.draw(rect);
    g2.draw(elipse);

    // Quita la deformación horizontal
    g2.shear(-0.5, 0);

    // Translada el origen
    g2.translate(-2 * ancho, 2 * alto);

    // Deforma verticalmente
    g2.shear(0, 0.2);

    // Dibuja los ejes coordenados
    dibujaEjes(g2, ancho, alto);

    // Dibuja el rectangulo y la elipse
    g2.draw(rect);
    g2.draw(elipse);

    // Quita la deformación vertical
    g2.shear(0, -0.2);

    // Translada el origen
    g2.translate(2 * ancho, 0);

    // Deforma horizontal y verticalmente
    g2.shear(0.5, 0.2);

    // Dibuja los ejes coordenados
    dibujaEjes(g2, ancho, alto);

    // Dibuja el rectangulo y la elipse
    g2.draw(rect);
    g2.draw(elipse);
  }

  /**
   * Este metodo dibuja figuras recortadas sobre un panel
   * @param g Objeto con el contexto de graficación del panel
   * @param d Dimensiones del panel
   * @param bi Imagen de relleno
   */
  public void recortaFiguras(Graphics g, Dimension d, BufferedImage bi) {
    Graphics2D g2 = (Graphics2D) g;
    Area area1, area2;

    double ancho = d.width / 3;
    double alto = d.height / 3;
    double x = 50;
    double y = 25;

    // Crea el rectangulo ancla del tamaño de la imagen
    Rectangle2D tr = new Rectangle2D.Double(0, 0, bi.getWidth(), bi.getHeight());
    TexturePaint tp = new TexturePaint(bi, tr);

    // establece el tipo de relleno
    g2.setPaint(tp);

    // Crea una figura rectangular
    Rectangle2D rect1 = new Rectangle2D.Double(x, y, ancho, alto);

    // Dibuja el rectangulo
    g2.fill(rect1);

    x += 100 + ancho;

    // Crea una figura rectangular
    Rectangle2D rect2 = new Rectangle2D.Double(x, y, ancho, alto);

    // Crea la figura de recorte
    Ellipse2D elipse1 = new Ellipse2D.Double(x, y, ancho, alto);
    g2.clip(elipse1);

    // Dibuja el rectangulo
    g2.fill(rect2);

    // Elimina el recorte
    g2.setClip(null);

    x = 50;
    y = 50 + alto;

    // Crea una figura rectangular
    Rectangle2D rect3 = new Rectangle2D.Double(x, y, ancho, alto);

    // Crea la figura de recorte
    Ellipse2D elipse2 = new Ellipse2D.Double(x, y, ancho, alto);
    g2.clip(elipse2);

    // Crea otra figura de recorte
    Rectangle2D rect4 = new Rectangle2D.Double(x, y, alto, alto);
    g2.clip(rect4);

    // Dibuja el rectangulo
    g2.fill(rect3);
  }
}
