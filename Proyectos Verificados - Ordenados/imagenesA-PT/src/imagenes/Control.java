/*
 * Control.java
 */
package imagenes;

import archUtils.ArchUtils;
import interfazUsuario.Lienzo;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.color.ColorSpace;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Esta clase contiene métodos para cargar, guardar y procesar imagenes
 *
 * @author mdomitsu
 */
public class Control {
  JFrame frame;
  String titulo;
  Lienzo lienzo;
  Graphics g;
  File file = null;
  // Imagen original
  private BufferedImage obi;
  // Imagen a procesar
  private BufferedImage pbi;

  /**
   * Inicializa los atributos de la clase
   *
   * @param frame Ventana que contiene el panel usado para desplegar las
   * imagenes
   * @param lienzo Panel usado para desplegar las imagenes
   */
  public Control(JFrame frame, Lienzo lienzo) {
    this.frame = frame;
    this.lienzo = lienzo;
    g = lienzo.getGraphics();
    titulo = frame.getTitle();
  }

  /**
   * Borra una imagen del panel, desplegando una imagen en blanco
   */
  public void nuevaImagen() {
    // Obtiene el tamaño del panel
    int altoImagen = lienzo.getHeight();
    int anchoImagen = lienzo.getWidth();

    // Crea una imagen del tamaño del panel
    obi = new BufferedImage(anchoImagen, altoImagen,
            BufferedImage.TYPE_INT_RGB);

    // Obtiene el contexto de graficación de la imagen
    Graphics2D g2 = obi.createGraphics();

    // Llena la imagen con el color blanco
    g2.setPaint(Color.white);
    g2.fillRect(0, 0, anchoImagen, altoImagen);

    // Despliega la imagen
    lienzo.setImagen(obi);
    lienzo.paintComponent(g);

    // Borra el nombre de la imagen de la barra de titulo de la aplicacion
    frame.setTitle(titulo);
    file = null;
  }

  /**
   * Este metodo lee una imagen bmp, gif, jpg, png y la guarda en el atributo
   * obi del tipo BufferedImage
   */
  public void leeImagen() {
    JFileChooser fc = new JFileChooser();
    // Elimina el filtro *.*
    fc.setAcceptAllFileFilterUsed(false);
    // Crea el filtro para las extenciones validas
    FileNameExtensionFilter extFiltro = new FileNameExtensionFilter(
            "Images", "bmp", "gif", "jpg", "png");
    // Establece el filtro para las extenciones validas
    fc.setFileFilter(extFiltro);
    // Despliega el cuadro de dialogo para seleccionar la imagen a abrir
    int returnVal = fc.showOpenDialog(frame);
    // Si se selecciono una imagen
    if (returnVal == JFileChooser.APPROVE_OPTION) {
      // Obtiene el objeto File de la imagen seleccionada
      file = fc.getSelectedFile();

      try {
        // lee la imagen y la guarda en el atributo obi
        obi = ImageIO.read(file);

        // Despliega la imagen
        lienzo.setImagen(obi);
        lienzo.paintComponent(g);

        // Despliega el nombre de la imagen en la barra de titulo de la aplicacion
        frame.setTitle(titulo + ": " + file.getName());
      } catch (IOException e) {
        JOptionPane.showMessageDialog(frame,
                "Error al cargar imagen");
      }
    }
  }

  /**
   * Este metodo guarda la imagen bmp, gif, jpg, png del atributo obi
   * del tipo BufferedImage en un archivo
   */
  public void guardarImagen() {
    // Si la imagen a guardar es nueva
    if (file == null) {
      guardaImagenComo();
    } else {
      // Obtiene la extension del nombre del archivo de la imagen
      String nombreExt = ArchUtils.getExtension(file);

      try {
        // Guarda la imagen
        ImageIO.write(obi, nombreExt, file);
      } catch (IOException e) {
        JOptionPane.showMessageDialog(frame,
                "Error al guardar la imagen");
      }
    }
  }

  /**
   * Este metodo guarda la imagen bmp, gif, jpg, png del atributo dbi del tipo
   * BufferedImage en un archivo
   */
  public void guardaImagenComo() {
    File fileSel = null;
    String[] imagenesExt = {"bmp", "gif", "jpg", "png"};

    JFileChooser fc = new JFileChooser();
    // Elimina el filtro *.*
    fc.setAcceptAllFileFilterUsed(false);
    // Agrega varios filtros de imagenes
    fc.addChoosableFileFilter(
            new FileNameExtensionFilter("Imagen BMP", "bmp"));
    fc.addChoosableFileFilter(
            new FileNameExtensionFilter("Imagen GIF", "gif"));
    fc.addChoosableFileFilter(
            new FileNameExtensionFilter("Imagen JPG", "jpg"));
    fc.addChoosableFileFilter(
            new FileNameExtensionFilter("Imagen PNG", "png"));
    //Establece el nombre inicial de la imagen
    fc.setSelectedFile(file);

    // Despliega cuadro de dialogo para obtener el nombre
    // del archivo en el que se va a guardar la imagen
    int returnVal = fc.showSaveDialog(frame);
    if (returnVal == JFileChooser.APPROVE_OPTION) {
      String nombreExt = null;

      // Obtiene el nombre del archivo seleccionado
      fileSel = fc.getSelectedFile();
      // Obtiene el nombre del filtro seleccionado
      FileNameExtensionFilter extFiltro = (FileNameExtensionFilter) fc.getFileFilter();
      // Obtiene la extension del nombre del filtro seleccionado
      String ext = extFiltro.getExtensions()[0];

      String path = fileSel.getPath();

      // Obtiene la extension del nombre del archivo seleccionado
      nombreExt = ArchUtils.getExtension(fileSel);

      // Si el nombre seleccionado no corresponde a uno de imagen
      if (nombreExt != null
              && !ArchUtils.esExtension(nombreExt, imagenesExt)) {
        JOptionPane.showMessageDialog(frame,
                "No es un archivo de imagen");
        return;
      }

      // Si no hay extension del nombre del archivo seleccionado
      if (nombreExt == null) {
        // Agregale la extension del nombre del filtro seleccionado
        path += "." + ext;
        fileSel = new File(path);
        nombreExt = ext;
      }

      try {
        // Guarda la imagen
        ImageIO.write(obi, nombreExt, fileSel);
        
        // Despliega el nombre de la imagen en la barra de titulo de la aplicacion
        frame.setTitle(titulo + ": " + fileSel.getName());        
      } catch (IOException e) {
        JOptionPane.showMessageDialog(frame,
                "Error al guardar la imagen");
      }
    }
  }

  /**
   * Este método dibuja sobre la imagen dada por obi
   */
  public void dibujaEnImagen() {
    // Si no hay una imagen para dibujar
    if (obi == null) {
      JOptionPane.showMessageDialog(frame,
              "No hay una imagen para dibujar");
      return;
    }

    // Obtiene el contexto de graficación de la imagen
    Graphics2D g2 = obi.createGraphics();

    // Establece el color de una trayectoria
    g2.setPaint(Color.black);

    // crea una trayectoria
    Path2D trayectoria = new Path2D.Double(Path2D.WIND_EVEN_ODD);
    trayectoria.moveTo(50, 50);
    trayectoria.lineTo(70, 44);
    trayectoria.curveTo(100, 10, 140, 80, 160, 80);
    trayectoria.lineTo(190, 40);
    trayectoria.lineTo(200, 56);
    trayectoria.quadTo(100, 150, 70, 60);
    trayectoria.closePath();

    // Dibuja la trayectoria sobre la imagen obi
    g2.draw(trayectoria);

    // Despliega la imagen
    lienzo.setImagen(obi);
    lienzo.paintComponent(g);
  }

  /**
   * Restaura la imagen original
   */
  public void restauraImagenOriginal() {
    // Obtiene el tamaño de la imagen
    int altoImagen = obi.getHeight();
    int anchoImagen = obi.getWidth();

    // Crea una imagen vacia con formato RGB normalizada
    pbi = new BufferedImage(anchoImagen, altoImagen, BufferedImage.TYPE_INT_RGB);
    Graphics2D g2 = pbi.createGraphics();
    // Copia la imagen original formateada como una imagen RGB normalizada
    g2.drawImage(obi.getSubimage(0, 0, anchoImagen, altoImagen), null, 0, 0);

    // Despliega la imagen original
    lienzo.setImagen(obi);
    lienzo.paintComponent(g);
  }

  /**
   * Este metodo verifica que haya una imagen lista para ser procesada
   */
  private boolean preparaImagenProcesar() {
    // Si no hay se ha creado una imagen vacia o se ha
    // cargado una imagen desde un archivo
    if (obi == null) {
      JOptionPane.showMessageDialog(frame,
              "No hay una imagen para procesar");
      return false;
    }

    // Si no hay una imagen a procesar
    if (pbi == null) {
      // Obtiene el tamaño de la imagen
      int altoImagen = obi.getHeight();
      int anchoImagen = obi.getWidth();

      // Crea una imagen vacia con formato RGB normalizada
      pbi = new BufferedImage(anchoImagen, altoImagen, BufferedImage.TYPE_INT_RGB);
      Graphics2D g2 = pbi.createGraphics();
      // Copia la imagen original formateada como una imagen RGB normalizada
      g2.drawImage(obi.getSubimage(0, 0, anchoImagen, altoImagen), null, 0, 0);
    }

    return true;
  }

  /**
   * Este metodo suaviza una imagen
   */
  public void suaviza() {
    // verifica que haya una imagen lista para ser procesada
    if (!preparaImagenProcesar()) {
      return;
    }

    // Define un kernel suavizador
    float ninth = 1.0f / 9.0f;
    float[] blurKernel = {
      ninth, ninth, ninth,
      ninth, ninth, ninth,
      ninth, ninth, ninth
    };

    // crea una operación de convolución a partir del kernel
    ConvolveOp op = new ConvolveOp(new Kernel(3, 3, blurKernel));

    // Filtra la imagen usando la operacion
    pbi = op.filter(pbi, null);

    // Despliega la imagen
    lienzo.setImagen(pbi);
    lienzo.paintComponent(g);
  }

  /**
   * Este metodo intensifica una imagen
   */
  public void intensifica() {
    // verifica que haya una imagen lista para ser procesada
    if (!preparaImagenProcesar()) {
      return;
    }

    // Define un kernel intensificador
    float[] sharpKernel = {
      0.0f, -1.0f, 0.0f,
      -1.0f, 5.0f, -1.0f,
      0.0f, -1.0f, 0.0f
    };

    // crea una operación de convolución a partir del kernel
    ConvolveOp op = new ConvolveOp(new Kernel(3, 3, sharpKernel));

    // Filtra la imagen usando la operacion
    pbi = op.filter(pbi, null);

    // Despliega la imagen
    lienzo.setImagen(pbi);
    lienzo.paintComponent(g);
  }

  /**
   * Este metodo detecta las orillas de una imagen
   */
  public void detectorOrillas() {
    // verifica que haya una imagen lista para ser procesada
    if (!preparaImagenProcesar()) {
      return;
    }

    // Define un kernel detector de orillas
    float[] edgeKernel = {
      0.0f, -1.0f, 0.0f,
      -1.0f, 4.0f, -1.0f,
      0.0f, -1.0f, 0.0f
    };

    // crea una operación de convolución a partir del kernel 
    ConvolveOp op = new ConvolveOp(new Kernel(3, 3, edgeKernel));

    // Filtra la imagen usando la operacion
    pbi = op.filter(pbi, null);

    // Despliega la imagen
    lienzo.setImagen(pbi);
    lienzo.paintComponent(g);
  }

  /**
   * Este metodo invierte los colores de los pixeles de una image, haciendo los
   * pixeles claros oscuros y viceversa.
   */
  public void invertir() {
    // verifica que haya una imagen lista para ser procesada
    if (!preparaImagenProcesar()) {
      return;
    }

    // Define una tabla de busqueda para invertir los tres canales.
    // Se aplica la misma tabla para los tres canales
    short[] invert = new short[256];
    for (int i = 0; i < 256; i++) {
      invert[i] = (short) (255 - i);
    }
    LookupTable table = new ShortLookupTable(0, invert);

    // crea una operación de busqueda a partir de la tabla
    LookupOp op = new LookupOp(table, null);

    // Filtra la imagen usando la operacion
    pbi = op.filter(pbi, null);

    // Despliega la imagen
    lienzo.setImagen(pbi);
    lienzo.paintComponent(g);
  }

  /**
   * Este metodo elimina la componente verde de una imagen.
   */
  public void eliminarVerdes() {
    // verifica que haya una imagen lista para ser procesada
    if (!preparaImagenProcesar()) {
      return;
    }

    // Define una tabla de busqueda para eliminar la componente
    // verde de la imagen. Se aplican tabla diferentes para los
    // canales
    short[] zero = new short[256];
    short[] straight = new short[256];
    for (int i = 0; i < 256; i++) {
      zero[i] = (short) 0;
      straight[i] = (short) i;
    }
    short[][] greenRemove = {straight, zero, straight};
    LookupTable table = new ShortLookupTable(0, greenRemove);

    // crea una operación de busqueda a partir de la tabla
    LookupOp op = new LookupOp(table, null);

    // Filtra la imagen usando la operacion
    pbi = op.filter(pbi, null);

    // Despliega la imagen
    lienzo.setImagen(pbi);
    lienzo.paintComponent(g);
  }

  /**
   * Este metodo aumenta la brillantez de una imagen utilizando una
   * transformacion lineal.
   */
  public void aclaradoLineal() {
    // verifica que haya una imagen lista para ser procesada
    if (!preparaImagenProcesar()) {
      return;
    }

    // Define una tabla de busqueda para aumentar la
    // brillantez de una imagen usando una transformacion
    // lineal
    short[] brighten = new short[256];
    for (int i = 0; i < 256; i++) {
      brighten[i] = (short) (128 + i / 2);
    }
    LookupTable table = new ShortLookupTable(0, brighten);

    // crea una operación de busqueda a partir de la tabla
    LookupOp op = new LookupOp(table, null);

    // Filtra la imagen usando la operacion
    pbi = op.filter(pbi, null);

    // Despliega la imagen
    lienzo.setImagen(pbi);
    lienzo.paintComponent(g);
  }

  /**
   * Este metodo aumenta la brillantez de una imagen utilizando una
   * transformacion raiz cuadratica.
   */
  public void aclaradoRaiz() {
    // verifica que haya una imagen lista para ser procesada
    if (!preparaImagenProcesar()) {
      return;
    }

    // Define una tabla de busqueda para aumentar la
    // brillantez de una imagen usando una transformacion
    // raiz cuadratica.
    short[] rootBrighten = new short[256];
    for (int i = 0; i < 256; i++) {
      rootBrighten[i] = (short) (Math.sqrt((double) i / 255.0) * 255.0);
    }
    LookupTable table = new ShortLookupTable(0, rootBrighten);

    // crea una operación de busqueda a partir de la tabla
    LookupOp op = new LookupOp(table, null);

    // Filtra la imagen usando la operacion
    pbi = op.filter(pbi, null);

    // Despliega la imagen
    lienzo.setImagen(pbi);
    lienzo.paintComponent(g);
  }

  /**
   * Este metodo reduce el maximo numero de colores de 2^24 = 16777216 a 2^9 =
   * 256.
   */
  public void posterizar() {
    // verifica que haya una imagen lista para ser procesada
    if (!preparaImagenProcesar()) {
      return;
    }

    // Define una tabla de busqueda para reducir el maximo
    // numero de colores de 2^24 = 16777216 a 2^9 = 256.
    short[] posterize = new short[256];
    for (int i = 0; i < 256; i++) {
      posterize[i] = (short) (i - (i % 32));
    }
    LookupTable table = new ShortLookupTable(0, posterize);

    // crea una operación de busqueda a partir de la tabla
    LookupOp op = new LookupOp(table, null);

    // Filtra la imagen usando la operacion
    pbi = op.filter(pbi, null);

    // Despliega la imagen
    lienzo.setImagen(pbi);
    lienzo.paintComponent(g);
  }

  /**
   * Este metodo binariza una imagen reduciendo cada banda de color a dos
   * posibles valores 0 o 1, reduciendo el numero de colores a 2^3 = 8.
   */
  public void binarizar() {
    // verifica que haya una imagen lista para ser procesada
    if (!preparaImagenProcesar()) {
      return;
    }

    // Define una tabla de busqueda para binarizar una imagen
    short[] threshold = new short[256];
    for (int i = 0; i < 256; i++) {
      threshold[i] = (i < 128) ? (short) 0 : (short) 255;
    }
    LookupTable table = new ShortLookupTable(0, threshold);

    // crea una operación de busqueda a partir de la tabla
    LookupOp op = new LookupOp(table, null);

    // Filtra la imagen usando la operacion
    pbi = op.filter(pbi, null);

    // Despliega la imagen
    lienzo.setImagen(pbi);
    lienzo.paintComponent(g);
  }

  /**
   * Este metodo convierte una imagen de color a tonos de grises.
   */
  public void toGrises() {
    // verifica que haya una imagen lista para ser procesada
    if (!preparaImagenProcesar()) {
      return;
    }

    // Crea una operacion de conversion de colores para cambiar
    // de colores a tonos de grises
    ColorConvertOp op =
            new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY), null);

    // Filtra la imagen usando la operacion
    pbi = op.filter(pbi, null);

    // Despliega la imagen
    lienzo.setImagen(pbi);
    lienzo.paintComponent(g);
  }

  /**
   * Este metodo aumenta la brillantez de una imagen en un 20%, Haciendo un
   * reescalamiento de colores.
   */
  public void aclara() {
    // verifica que haya una imagen lista para ser procesada
    if (!preparaImagenProcesar()) {
      return;
    }

    // Crea una operacion de escalamiento para aclarar una imagen en
    // 20%
    RescaleOp op = new RescaleOp(1.2f, 0, null);

    // Filtra la imagen usando la operacion
    pbi = op.filter(pbi, null);

    // Despliega la imagen
    lienzo.setImagen(pbi);
    lienzo.paintComponent(g);
  }

  /**
   * Este metodo disminuye la brillantez de una imagen en un 20%, Haciendo un
   * reescalamiento de colores.
   */
  public void oscurece() {
    // verifica que haya una imagen lista para ser procesada
    if (!preparaImagenProcesar()) {
      return;
    }

    // Crea una operacion de escalamiento para oscurecer una imagen en
    // 20%
    RescaleOp op = new RescaleOp(0.8f, 0, null);

    // Filtra la imagen usando la operacion
    pbi = op.filter(pbi, null);

    // Despliega la imagen
    lienzo.setImagen(pbi);
    lienzo.paintComponent(g);
  }

  /**
   * Este metodo modifica la brillantez de cada banda por separado de una imagen
   * en un 20%, haciendo un reescalamiento de colores.
   */
  public void ajustaBrillantezBandas() {
    // verifica que haya una imagen lista para ser procesada
    if (!preparaImagenProcesar()) {
      return;
    }

    // Crea una operacion de escalamiento de color para aclarar
    // la banda roja un 20 % y oscurecer la banda azul un 20%
    // dejando la banda verde sin modificar
    RescaleOp op = new RescaleOp(new float[]{1.2f, 1.0f, 0.8f},
            new float[]{32.0f, 0f, 0.0f}, null);

    // Filtra la imagen usando la operacion
    pbi = op.filter(pbi, null);

    // Despliega la imagen
    lienzo.setImagen(pbi);
    lienzo.paintComponent(g);
  }

  /**
   * Este metodo aumenta el ancho de una imagen en 20% y disminuye la altura en
   * 20% haciendo una operacion de transformacion.
   */
  public void escala() {
    // verifica que haya una imagen lista para ser procesada
    if (!preparaImagenProcesar()) {
      return;
    }

    // Crea una transformacion para aumentar el ancho de la imagen
    // en 20% y disminuir la altura en 20%
    AffineTransform at = AffineTransform.getScaleInstance(1.2, 0.8);
    RenderingHints rh = new RenderingHints(
            RenderingHints.KEY_INTERPOLATION,
            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    AffineTransformOp op = new AffineTransformOp(at, rh);

    // Filtra la imagen usando la operacion
    pbi = op.filter(pbi, null);

    // Despliega la imagen
    lienzo.setImagen(pbi);
    lienzo.paintComponent(g);
  }

  /**
   * Este metodo rota una imagen en 60 grados alrededor de su centro. haciendo
   * una operacion de transformacion.
   */
  public void rota() {
    // verifica que haya una imagen lista para ser procesada
    if (!preparaImagenProcesar()) {
      return;
    }

    // Obtiene el tamaño de la imagen
    int altoImagen = pbi.getHeight();
    int anchoImagen = pbi.getWidth();

    // Crea una transformacion para rotar una imagen en 60 grados
    // alrededor de su centro
    AffineTransform at = AffineTransform.getRotateInstance(Math.PI / 6, altoImagen / 2, anchoImagen / 2);
    RenderingHints rh = new RenderingHints(
            RenderingHints.KEY_INTERPOLATION,
            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    AffineTransformOp op = new AffineTransformOp(at, rh);

    // Filtra la imagen usando la operacion
    pbi = op.filter(pbi, null);

    // Despliega la imagen
    lienzo.setImagen(pbi);
    lienzo.paintComponent(g);
  }
}
