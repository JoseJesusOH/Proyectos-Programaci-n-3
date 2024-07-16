/*
* DlgReemplazar.java
  * Creada el 20 de septiembre del 2021 a las 5:21 PM 
 */
package interfazUsuario;

import java.awt.Dimension;
import java.awt.Point;

/**
 * Cuadro de dialogo reemplazar. Alumno; José Jesús Orozco Hernández Id;
 * 00000229141
 *
 * @author Jose Jesus
 */
public class DlgReemplazar extends javax.swing.JDialog {

    /**
     * Constructor que establece las características del cuadro de diálogo y la
     * operación a realizar con él.
     *
     * @param parent Ventana sobre la que aparecerá el cuadro de diálogo
     * @param modal true si permite acceder fuera de los límites del cuadro de
     * diálogo, false en caso contrario
     * @param buscar Texto Buscar
     * @param reemplazar Texto a remplazar
     * @param operacion Operación a realizar en el cuadro de diálogo: AGREGAR =
     * 0, ACTUALIZAR = 1, ELIMINAR = 2, DESPLEGAR = 3;
     * @param respuesta Boton presionado al salir de los cuadros de diálogos:
     * ACEPTAR = "Aceptar", CANCELAR = "Cancelar".
     */
    public DlgReemplazar(java.awt.Frame parent, boolean modal, StringBuffer buscar, StringBuffer reemplazar, int operacion, StringBuffer respuesta) {
        super(parent, modal);
        this.buscar = buscar;
        this.reemplazar = reemplazar;
        this.operación = operacion;
        this.respuesta = respuesta;
        initComponents();
        setTitle("Reemplazar palabras en archivo");
        if (operacion == ConstantesGUI.REMPLAZAR) {
            campoTextoBuscar.setEnabled(true);
            campoTextoBuscar.setEditable(true);
            campoTextoReemplazar.setEnabled(true);
            campoTextoReemplazar.setEditable(true);

// centra el cuadro de dialogo sobre la ventana de la aplicación
            centraCuadroDialogo(parent);
// Muestra el cuadro de diálogo
            setVisible(true);
        }
    }

    /**
     * Este método centra el cuadro de dialogo sobre la ventana de la
     * aplicación.
     *
     * @param parent Ventana sobre la que aparecerá el cuadro de diálogo
     */
    private void centraCuadroDialogo(java.awt.Frame parent) {
        // Obtiene el tamaño y posición de la ventana de la aplicación 
        Dimension frameSize = parent.getSize();
        Point loc = parent.getLocation();
        // Obtiene el tamaño del cuadro de diálogo 
        Dimension dlgSize = getPreferredSize();

        // Centra el cuadro de diálogo sobre la ventana padre 
        setLocation((frameSize.width - dlgSize.width) / 2 + loc.x,
                (frameSize.height - dlgSize.height) / 2 + loc.y);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        campoTextoBuscar = new javax.swing.JTextField();
        campoTextoReemplazar = new javax.swing.JTextField();
        botonAceptar = new javax.swing.JButton();
        botonRestaurar = new javax.swing.JButton();
        botonCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Buscar;");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Reemplazo;");

        campoTextoBuscar.setEditable(false);
        campoTextoBuscar.setColumns(10);

        campoTextoReemplazar.setEditable(false);
        campoTextoReemplazar.setColumns(10);

        botonAceptar.setText("Aceptar");
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });

        botonRestaurar.setText("Restaurar");
        botonRestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRestaurarActionPerformed(evt);
            }
        });

        botonCancelar.setText("Cancelar");
        botonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(58, 58, 58)
                        .addComponent(campoTextoBuscar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(botonAceptar)
                            .addComponent(jLabel2))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(botonRestaurar)
                                .addGap(42, 42, 42)
                                .addComponent(botonCancelar))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(campoTextoReemplazar, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoTextoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoTextoReemplazar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botonAceptar)
                    .addComponent(botonRestaurar)
                    .addComponent(botonCancelar))
                .addContainerGap(87, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Metodo que estblece buscar, y reemplzar deacuerdo a los campos de texto
     *
     * @param evt Evento del boton, que sucede cuando se le da click
     */
    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
        // TODO add your handling code here:
        if (operación == ConstantesGUI.REMPLAZAR) {

            buscar.append(campoTextoBuscar.getText());
            reemplazar.append(campoTextoReemplazar.getText());
            respuesta.delete(0, respuesta.length());
// Establece que se presionó el botón botonAceptar
            respuesta.append(ConstantesGUI.ACEPTAR);
        }
// Destruye el cuadro de díalogo
        dispose();;
    }//GEN-LAST:event_botonAceptarActionPerformed
    /**
     * Metodo que destruye el cuadro de dialogo
     *
     * @param evt Evento del boton, que sucede cuando se le da click
     */
    private void botonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelarActionPerformed
        // TODO add your handling code here:
//// Destruye el cuadro de díalogo 
        dispose();
    }//GEN-LAST:event_botonCancelarActionPerformed
    /**
     * Metodo que establece los campos de texto a cadenas vacias
     *
     * @param evt Evento del boton, que sucede cuando se le da click
     */
    private void botonRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRestaurarActionPerformed
        // TODO add your handling code here:
        campoTextoBuscar.setText("");
        campoTextoReemplazar.setText("");
    }//GEN-LAST:event_botonRestaurarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonCancelar;
    private javax.swing.JButton botonRestaurar;
    private javax.swing.JTextField campoTextoBuscar;
    private javax.swing.JTextField campoTextoReemplazar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
    /**
     * Atributo buscar
     */
    private StringBuffer buscar;
    /**
     * Atributo reemplazar 
     */
    private StringBuffer reemplazar;
    /**
     * Operacion  que se realiza
     */
    private int operación;
    /**
     * Atributo respuesta
     */
    private StringBuffer respuesta;
}
