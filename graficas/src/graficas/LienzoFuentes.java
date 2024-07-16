/*
 * LienzoFuentes.java
 */
package graficas;

import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author Manuel Domitsu
 */
public class LienzoFuentes extends javax.swing.JPanel {

  /**
   * Creates new form LienzoFuentes
   */
  public LienzoFuentes() {
    initComponents();
  }

  public void setFuente(Font fuente) {
    this.fuente = fuente;
  }
  
  /**
   * Metódo que dibuja sobre el panel
   * @param g Objeto con el contexto de graficación
   */
  @Override
  public void paintComponent(Graphics g) {
    // Obtiene el tamaño del panel
    Dimension d = getSize();

    Graphics2D g2 = (Graphics2D) g;
    String s = "Hola mundo";

    // Establece la fuente a usar
    g2.setFont(fuente);
    g2.setPaint(Color.black);

    // Obtiene una instancia de FontRenderContext que contiene
    // información para obtener el tamaño de una cadena
    FontRenderContext frc = g2.getFontRenderContext();
    // Obtiene el rectangulo que limita la cadena
    Rectangle2D bounds = g2.getFont().getStringBounds(s, frc);
    // Obtiene el ancho del rectangulo que limita la cadena
    float width = (float) bounds.getWidth();

    // Calcula la posición horizontal para centrar el texto
    int x = (int) ((float) d.width - width) / 2;
    int y = (int) ((float) d.height - 50);

    // Dibuja la cadena de texto
    g2.drawString(s, x, y);
  }
  
  /**
   * Metódo que borra lo dibujado en el panel
   * @param g Objeto con el contexto de graficación
   */
  public void borra(Graphics g) {
    super.paintComponent(g);
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setPreferredSize(new java.awt.Dimension(400, 200));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
  private Font fuente;
}
