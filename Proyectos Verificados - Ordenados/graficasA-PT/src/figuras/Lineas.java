/*
 * Lineas.java
 */
package figuras;

import java.awt.*;
import java.awt.geom.*;

/**
 * Esta clase contiene métodos para dibujar lineas, curvas y puntos
 * @author mdomitsu
 */
public class Lineas {

    /**
     * Este metodo dibuja un conjunto de lineas sobre un panel 
     * @param g Objeto con el contexto de graficación del panel
     * @param d Dimensiones del panel
     */
    public void dibujaLineas(Graphics g, Dimension d) {
        Graphics2D g2 = (Graphics2D) g;
        int numeroLineas = 25;
        Color[] colores = {Color.red, Color.green, Color.blue};

        for (int i = 0; i < numeroLineas; i++) {
            // Establece el color de la linea
            g2.setPaint(colores[i % colores.length]);

            double radio = (double) i / numeroLineas;
            double iradio = 1 - radio;

            // Dibuja una linea en la esquina inferior izquierda
            Line2D linea1 = new Line2D.Double(0, radio * d.height,
                    radio * d.width, d.height);
            g2.draw(linea1);

            // Dibuja una linea en la esquina superior derecha
            Line2D linea2 = new Line2D.Double(d.width, iradio * d.height,
                    iradio * d.width, 0);
            g2.draw(linea2);
        }
    }

    /**
     * Este metodo dibuja un conjunto de curvas cuadraticas sobre un panel
     * @param g Objeto con el contexto de graficación del panel
     * @param d Dimensiones del panel
     */
    public void dibujaCurvasCuadraticas(Graphics g, Dimension d) {
        Graphics2D g2 = (Graphics2D) g;
        QuadCurve2D q = new QuadCurve2D.Double();
        Color[] colores = {Color.red, Color.green, Color.blue};
        int numeroCurvas = 7;

        Point2D pi = new Point2D.Double(50, d.height / 2);
        Point2D pf = new Point2D.Double(d.width - 50, d.height / 2);
        Point2D pc;

        for (int i = 0; i < numeroCurvas; i++) {
            double radio = (double) i / numeroCurvas;
            double iradio = 1 - radio;

           // Dibuja el punto de control externo de la curva
            pc = new Point2D.Double(50 + (d.width - 100) * radio,
                    (d.height - 100) * iradio);
            dibujaPunto(g, pc, colores[i % colores.length]);

            // Establece el color de la curva
            g2.setPaint(colores[i % colores.length]);

            // Dibuja la curva cuadrática
            q.setCurve(pi, pc, pf);
            g2.draw(q);
        }
    }

    /**
     * Este metodo dibuja un conjunto de curvas cubicas sobre un panel
     * @param g Objeto con el contexto de graficación del panel
     * @param d Dimensiones del panel
     */
    public void dibujaCurvasCubicas(Graphics g, Dimension d) {
        Graphics2D g2 = (Graphics2D) g;
        CubicCurve2D q = new CubicCurve2D.Double();
        Color[] colores1 = {Color.red, Color.green, Color.blue};
        int numeroCurvas = 5;

        Point2D pi = new Point2D.Double(50, d.height / 2);
        Point2D pf = new Point2D.Double(d.width - 50, d.height / 2);
        Point2D pc1, pc2;

        for (int i = 0; i < numeroCurvas; i++) {
            double radio = (double) i / numeroCurvas;
            double iradio = 1 - radio;

           // Dibuja el punto de control 1 externo de la curva
            pc1 = new Point2D.Double(50 + (d.width - 100) * radio / 2,
                    (d.height - 100) * iradio);
            dibujaPunto(g, pc1, colores1[i % colores1.length]);

           // Dibuja el punto de control 2 externo de la curva
            pc2 = new Point2D.Double(d.width * (1 + radio) / 2,
                    50 + (d.height - 100) * radio);
            dibujaPunto(g, pc2, colores1[i % colores1.length]);

            // Establece el color de la curva
            g2.setPaint(colores1[i % colores1.length]);

            // Dibuja la curva cubica
            q.setCurve(pi, pc1, pc2, pf);
            g2.draw(q);
        }
    }

    /**
     * Dibuja un punto como un circulo sobre un panel
     * @param g Objeto con el contexto de graficación del panel
     * @param x Coordenada X del punto a dibujar
     * @param y Coordenada Y del punto a dibujar
     * @param paint Color del punto a dibujar
     */
    public void dibujaPunto(Graphics g, double x, double y, Paint paint) {
        Graphics2D g2 = (Graphics2D) g;

       // Establece el color del punto
       g2.setPaint(paint);

       // Dibuja el punto como un circulo de radio 5
        Ellipse2D e = new Ellipse2D.Double(x, y, 5, 5);
        g2.fill(e);
    }

    /**
     * Dibuja un punto como un circulo sobre un panel
     * @param g Objeto con el contexto de graficación del panel
     * @param p coordenadas del punto a dibujar
     * @param paint Color del punto a dibujar
     */
    public void dibujaPunto(Graphics g, Point2D p, Paint paint) {
        Graphics2D g2 = (Graphics2D) g;

       // Establece el color del punto
       g2.setPaint(paint);

       // Dibuja el punto como un circulo de radio 5
        Ellipse2D e = new Ellipse2D.Double(p.getX(), p.getY(), 5, 5);
        g2.fill(e);
    }
}
