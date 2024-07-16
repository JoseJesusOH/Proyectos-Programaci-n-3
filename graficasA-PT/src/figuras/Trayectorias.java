/*
 * Trayectorias.java
 */
package figuras;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;

/**
 * Esta clase contiene métodos para dibujar trayectorias
 * @author mdomitsu
 */
public class Trayectorias {

    /**
     * Este metodo dibuja una trayectoria arbitraria sobre un panel
     * @param g Objeto con el contexto de graficación del panel
     * @param d Dimensiones del panel
     */
    public void dibujaTrayectoria(Graphics g, Dimension d) {
        Graphics2D g2 = (Graphics2D) g;

        // Establece el color de la trayectoria
        g2.setPaint(Color.blue);

        // crea la trayectoria
        Path2D trayectoria = new Path2D.Double(Path2D.WIND_EVEN_ODD);
        trayectoria.moveTo(50, 50);
        trayectoria.lineTo(70, 44);
        trayectoria.curveTo(100, 10, 140, 80, 160, 80);
        trayectoria.lineTo(190, 40);
        trayectoria.lineTo(200, 56);
        trayectoria.quadTo(100, 150, 70, 60);
        trayectoria.closePath();

        // Dibuja la trayectoria
        g2.draw(trayectoria);
    }
}
