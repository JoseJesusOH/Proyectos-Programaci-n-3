package interfazFinanzas;

import java.awt.Dimension;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import objetoNegocio.Egresos;
import objetosServicio.Fecha;
import validores.Validadores;

/**
 *
 * @author Pacheco, Orozco y Cervantes
 */
public class DlgEgresos extends javax.swing.JDialog {
    Click so = new Click("/recursos/click1.wav");
    ImageIcon a = new ImageIcon(getClass().getResource("/recursos/aceptar-el-contorno-del-boton-circular.png"));
    ImageIcon b = new ImageIcon(getClass().getResource("/recursos/rehacer-simbolo-de-flecha.png"));
    ImageIcon c = new ImageIcon(getClass().getResource("/recursos/error.png"));
    ImageIcon d = new ImageIcon(getClass().getResource("/recursos/save.png"));
    ImageIcon e = new ImageIcon(getClass().getResource("/recursos/eliminar.png"));
    ImageIcon[] ar = {a, b, c, d, e};
    ImageIcon rutinaA = new ImageIcon(getClass().getResource("/recursos/st_patricks_day_calendar_celebration_holiday_icon_132875.png"));
    ImageIcon transporteA = new ImageIcon(getClass().getResource("/recursos/bustransport_bus_4984.png"));
    ImageIcon familiaA = new ImageIcon(getClass().getResource("/recursos/306familymanwomangirlgirl2_100722.png"));
    ImageIcon alimentacionA = new ImageIcon(getClass().getResource("/recursos/Bread_icon-icons.com_68777.png"));
    ImageIcon regalosA = new ImageIcon(getClass().getResource("/recursos/free-30-instagram-stories-icons36_122584.png"));
    ImageIcon educacionA = new ImageIcon(getClass().getResource("/recursos/3069198-cap-education-hat-school_112714.png"));
    ImageIcon saludA = new ImageIcon(getClass().getResource("/recursos/1-80_icon-icons.com_65644.png"));
    ImageIcon[] iconos = {rutinaA, transporteA, familiaA, alimentacionA, regalosA, educacionA, saludA};
    private boolean rutina = false;
    private boolean transporte = false;
    private boolean familia = false;
    private boolean alimentacion = false;
    private boolean regalos = false;
    private boolean educacion = false;
    private boolean salud = false;
    private boolean[] arregloCategoria = {false, false, false, false, false, false, false};

    /**
     * Creates new form DlgEgresos
     *
     * @param parent
     * @param title
     * @param modal
     * @param respuesta
     * @param egresos
     * @param operacion
     */
    public DlgEgresos(java.awt.Frame parent, String title, boolean modal, StringBuffer respuesta, Egresos egresos, int operacion) {
        super(parent, title, modal);
        this.respuesta = respuesta;
        this.operacion = operacion;
        this.egresos = egresos;
        initComponents();
        if (operacion == ConstantesGUI.AGREGAR) {
            botonAceptar.setText("Guardar");
            botonAceptar.setIcon(ar[3]);
            botonRestaurar.setIcon(ar[1]);
            botonCancelar1.setIcon(ar[2]);
        } else if (operacion == ConstantesGUI.ACTUALIZAR) {
            botonAceptar.setText("Actualizar");
            botonAceptar.setIcon(ar[0]);
            botonRestaurar.setIcon(ar[1]);
            botonCancelar1.setIcon(ar[2]);
        } else if (operacion == ConstantesGUI.ELIMINAR) {
            botonAceptar.setText("Eliminar");
            botonRestaurar.setEnabled(false);
            botonAceptar.setIcon(ar[4]);
            botonRestaurar.setIcon(ar[1]);
            botonCancelar1.setIcon(ar[2]);
        } else if (operacion == ConstantesGUI.DESPLEGAR) {
            botonAceptar.setText("Continuar");
            botonRestaurar.setEnabled(false);
            botonCancelar1.setEnabled(false);
            botonAceptar.setIcon(ar[0]);
            botonRestaurar.setIcon(ar[1]);
            botonCancelar1.setIcon(ar[2]);
        }
        if ((operacion == ConstantesGUI.ELIMINAR)
                || (operacion == ConstantesGUI.ACTUALIZAR)
                || (operacion == ConstantesGUI.DESPLEGAR)) {
            campoTextoCantidad1.setText(String.valueOf(egresos.getCantidad()));
            campoTextoFecha.setText(egresos.getFecha().toString());
            campoTextoComentario.setText(egresos.getComentario());

            int d = 0, f = 0;
            String categoria[] = {"Rutina", "Transporte", "Familia", "Alimentacion", "Regalos", "Educacion", "Salud"};
            for (int i = 0; i < categoria.length; i++) {
                String string = categoria[i];
                if (string.equalsIgnoreCase(egresos.getCategoria())) {
                    d = i;
                }
            }
            iconoCa.setIcon(iconos[d]);
            cajaCombinadaCategoria.setSelectedIndex(d);
        }
        if ((operacion == ConstantesGUI.ELIMINAR)
                || (operacion == ConstantesGUI.DESPLEGAR)) {
            campoTextoCantidad1.setEditable(false);
            campoTextoFecha.setEditable(false);
            campoTextoComentario.setEditable(false);
            cajaCombinadaCategoria.setEditable(false);
        }
        respuesta.append(ConstantesGUI.CANCELAR);
        centraCuadroDialogo(parent);
        setSize(670, 535);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void centraCuadroDialogo(java.awt.Frame parent) {
        Dimension frameSize = parent.getSize();
        Point loc = parent.getLocation();

        Dimension dlgSize = getPreferredSize();

        setLocation((frameSize.width - dlgSize.width) / 2 + loc.x, (frameSize.height - dlgSize.height) / 2 + loc.y);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jPanel4 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        campoTextoFecha = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        campoTextoComentario = new javax.swing.JTextField();
        campoTextoCantidad1 = new javax.swing.JTextField();
        cajaCombinadaCategoria = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        iconoCa = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        botonAceptar = new javax.swing.JButton();
        botonRestaurar = new javax.swing.JButton();
        botonCancelar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel4.setBackground(new java.awt.Color(102, 0, 0));
        jPanel4.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(168, 105, 105));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(null);

        campoTextoFecha.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        campoTextoFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTextoFechaActionPerformed(evt);
            }
        });
        jPanel2.add(campoTextoFecha);
        campoTextoFecha.setBounds(140, 320, 170, 30);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Formato: DD/MM/AAAA");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(140, 360, 200, 24);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel3.setText("Fecha");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(20, 320, 53, 24);

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel2.setText("Categoria");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(20, 220, 102, 24);

        jLabel5.setBackground(new java.awt.Color(0, 0, 0));
        jLabel5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel5.setText("Cantidad");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(20, 40, 77, 24);

        campoTextoComentario.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        campoTextoComentario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTextoComentarioActionPerformed(evt);
            }
        });
        jPanel2.add(campoTextoComentario);
        campoTextoComentario.setBounds(150, 120, 340, 30);

        campoTextoCantidad1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        campoTextoCantidad1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTextoCantidad1ActionPerformed(evt);
            }
        });
        jPanel2.add(campoTextoCantidad1);
        campoTextoCantidad1.setBounds(150, 40, 170, 30);

        cajaCombinadaCategoria.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        cajaCombinadaCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rutina", "Transporte", "Familia", "Alimentacion", "Regalos", "Educación", "Salud" }));
        cajaCombinadaCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cajaCombinadaCategoriaActionPerformed(evt);
            }
        });
        jPanel2.add(cajaCombinadaCategoria);
        cajaCombinadaCategoria.setBounds(140, 220, 120, 30);
        jPanel2.add(jSeparator1);
        jSeparator1.setBounds(180, 90, 0, 2);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("________________________________________________________");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(0, 280, 620, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("________________________________________________________");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(0, 70, 620, 30);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("________________________________________________________");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(0, 150, 620, 30);

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel9.setText("Categoria Actual");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(380, 190, 150, 24);

        iconoCa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 0, 0)));
        jPanel2.add(iconoCa);
        iconoCa.setBounds(400, 220, 100, 80);

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel11.setText("Comentario");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(20, 120, 102, 24);

        jPanel4.add(jPanel2);
        jPanel2.setBounds(20, 20, 620, 400);

        botonAceptar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        botonAceptar.setText("Aceptar");
        botonAceptar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonAceptarActionPerformed(evt);
            }
        });
        jPanel4.add(botonAceptar);
        botonAceptar.setBounds(60, 440, 130, 40);

        botonRestaurar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        botonRestaurar.setText("Restaurar");
        botonRestaurar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonRestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRestaurarActionPerformed(evt);
            }
        });
        jPanel4.add(botonRestaurar);
        botonRestaurar.setBounds(260, 440, 140, 40);

        botonCancelar1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        botonCancelar1.setText("Cancelar");
        botonCancelar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCancelar1ActionPerformed(evt);
            }
        });
        jPanel4.add(botonCancelar1);
        botonCancelar1.setBounds(480, 440, 120, 40);

        getContentPane().add(jPanel4);
        jPanel4.setBounds(0, 0, 660, 510);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cajaCombinadaCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cajaCombinadaCategoriaActionPerformed
        // TODO add your handling code here:
        for (int i = 0; i < arregloCategoria.length; i++) {
            arregloCategoria[i] = false;
        }

        int a = cajaCombinadaCategoria.getSelectedIndex();
        arregloCategoria[a] = true;
        iconoCa.setIcon(iconos[a]);

    }//GEN-LAST:event_cajaCombinadaCategoriaActionPerformed

    private void campoTextoComentarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTextoComentarioActionPerformed
        // TODO add your handling code here:
        String comentario = campoTextoComentario.getText();
        String msjError = "";

        if (validadores.cadenaVacia(comentario)) {
            msjError = "Faltó el comentario";
        } else if (!validadores.validaCadena(40, comentario)) {
            msjError = "Comentario muy largo";
        }
        if (!msjError.equals("")) {
            JOptionPane.showMessageDialog(this, msjError,
                    "Error de entrada.",
                    JOptionPane.ERROR_MESSAGE);
            campoTextoComentario.requestFocus();
        } else {
            campoTextoFecha.requestFocus();
        }
    }//GEN-LAST:event_campoTextoComentarioActionPerformed

    private void campoTextoCantidad1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTextoCantidad1ActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        String cantidad = campoTextoCantidad1.getText();
        String msjError = "";
        if (validadores.cadenaVacia(cantidad)) {
            msjError = "Faltó la cantidad";
        } else {
            if (cantidad.contains(".")) {
                String r = cantidad.replaceAll("\\.", "");
                if (!validadores.validaEntero(r)) {
                    msjError = "La cantidad tiene caracteres invalidos";
                } else {
                    if (!validadores.validarDouble(cantidad)) {
                        msjError = "La cantidad tiene caracteres invalidos";
                    }
                }
            }
        }

        if (!msjError.equals("")) {
            JOptionPane.showMessageDialog(this, msjError,
                    "Error de entrada.",
                    JOptionPane.ERROR_MESSAGE);
            campoTextoCantidad1.requestFocus();
        } else {
            campoTextoComentario.requestFocus();
        }
    }//GEN-LAST:event_campoTextoCantidad1ActionPerformed

    private void botonAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonAceptarActionPerformed
       so.run();
        Thread hilo = Thread.currentThread();
        try {
            hilo.sleep(100);
        } catch (InterruptedException e) {
        }
        String msjError = "";
        String comentario = "";
        String fecha = "";
        String cantidad = "";
        int posError = 0;
        if (operacion == ConstantesGUI.AGREGAR || operacion == ConstantesGUI.ACTUALIZAR) {
            comentario = campoTextoComentario.getText();
            fecha = campoTextoFecha.getText();
            cantidad = campoTextoCantidad1.getText();
            if (validadores.cadenaVacia(comentario) || !validadores.validaCadena(20, comentario)) {
                msjError = validadores.cadenaVacia(comentario) ? "Comentario Vacio" : "Comentario muy largo";
                posError = 1;
            }
            if (validadores.cadenaVacia(fecha) || !validadores.validaFecha(fecha)) {
                msjError = validadores.cadenaVacia(fecha) ? "Faltó la fecha" : "La fecha no coincide con el formato";
                posError = 2;
            } else if (!validadores.cadenaVacia(fecha) && validadores.validaFecha(fecha)) {
                if (!validarDias(fecha)) {
                    msjError = "La fecha tiene campos invalidados(Dias o Meses que no existen)";
                    posError = 3;
                }
            }

            if (validadores.cadenaVacia(cantidad)) {
                msjError = "cantidad Vacia";
                posError = 4;
            } else {
                if (cantidad.contains(".")) {
                    String r = cantidad.replaceAll("\\.", "");
                    if (!validadores.validaEntero(r)) {
                        msjError = "La cantidad tiene caracteres invalidos";
                        posError = 5;
                    } else {
                        if (!validadores.validarDouble(cantidad)) {
                            msjError = "La cantidad tiene caracteres invalidos";
                            posError = 6;
                        }
                    }
                } else {
                    if (!validadores.validaEntero(cantidad)) {
                        msjError = "La cantidad tiene caracteres invalidos";
                        posError = 7;
                    }
                }
            }

            if (posError > 0) {
                JOptionPane.showMessageDialog(this, msjError,
                        "Error de entrada.",
                        JOptionPane.ERROR_MESSAGE);
                switch (posError) {
                    case 1:
                        campoTextoComentario.requestFocus();
                        break;
                    case 2:
                        campoTextoFecha.requestFocus();
                        break;
                    case 3:
                        campoTextoFecha.requestFocus();
                        break;
                    case 4:
                        campoTextoCantidad1.requestFocus();
                        break;
                    case 5:
                        campoTextoCantidad1.requestFocus();
                        break;
                    case 6:
                        campoTextoCantidad1.requestFocus();
                        break;
                    case 7:
                        campoTextoCantidad1.requestFocus();
                        break;
                }

            } else if (posError == 0) {
                int a = 0;
                for (int i = 0; i < arregloCategoria.length; i++) {
                    boolean b = arregloCategoria[i];
                    if (b == false) {
                        a++;
                    }
                }

                if (a == 6) {
                    arregloCategoria[cajaCombinadaCategoria.getSelectedIndex()] = true;
                }
//            Categoria dos =new Categoria(arregloCategoria[0],arregloCategoria[1],arregloCategoria[2],arregloCategoria[3],arregloCategoria[4],arregloCategoria[5],arregloCategoria[6]);
                egresos.setCategoria((String) cajaCombinadaCategoria.getSelectedItem());
                egresos.setCantidad(Double.valueOf(campoTextoCantidad1.getText()));
                egresos.setComentario(campoTextoComentario.getText());
                egresos.setFecha(new Fecha(campoTextoFecha.getText()));
                egresos.setTipoMovimiento("Egresos");
                respuesta.delete(0, respuesta.length());
                respuesta.append(ConstantesGUI.ACEPTAR);
                dispose();
            }
        }
    }//GEN-LAST:event_botonAceptarActionPerformed

    private void botonRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRestaurarActionPerformed
              so.run();
        Thread hilo = Thread.currentThread();
        try {
            hilo.sleep(100);
        } catch (InterruptedException e) {
        }
        if (operacion == ConstantesGUI.AGREGAR) {
            campoTextoCantidad1.setText("");
            campoTextoComentario.setText("");
            campoTextoFecha.setText("");
        }
        if (operacion == ConstantesGUI.ACTUALIZAR) {
            campoTextoCantidad1.setText(String.valueOf(egresos.getCantidad()));
            campoTextoComentario.setText(egresos.getComentario());
            campoTextoFecha.setText(egresos.getFecha().toString());

        }
    }//GEN-LAST:event_botonRestaurarActionPerformed

    private void botonCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCancelar1ActionPerformed
             so.run();
        Thread hilo = Thread.currentThread();
        try {
            hilo.sleep(100);
        } catch (InterruptedException e) {
        }
        dispose();
    }//GEN-LAST:event_botonCancelar1ActionPerformed

    private void campoTextoFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTextoFechaActionPerformed
        // TODO add your handling code here:
        String fecha = campoTextoFecha.getText();
        String msjError = "";

        if (validadores.cadenaVacia(fecha)) {
            msjError = "Faltó la fecha";
        } else if (!validadores.validaFecha(fecha)) {
            msjError = "La fecha no coincide con el formato.";
        } else if (validadores.validaFecha(fecha)) {
            if (!validarDias(fecha)) {
                msjError = "La fecha tiene campos invalidados(Dias o Meses que no existen)";
            }
        }
        if (!msjError.equals("")) {
            JOptionPane.showMessageDialog(this, msjError,
                    "Error de entrada.",
                    JOptionPane.ERROR_MESSAGE);
            campoTextoFecha.requestFocus();
        } else {
            botonAceptar.requestFocus();
        }
    }//GEN-LAST:event_campoTextoFechaActionPerformed

    /**
     * Metodo para valdiar los dias dde una fecha y que concuerden con los dias
     * del mes;
     *
     * @param fecha Fecha
     * @return si la fecha o no comple con los dias del mes
     */
    public boolean validarDias(String fecha) {
        int a = 0;
        int auxiliar = 1;
        String diaS = "";
        String mesS = "";
        String anhoS = "";
        int dia = 0;
        int mes = 0;
        int anho = 0;
        char array_caracteres[] = fecha.toCharArray();

        while (a < fecha.length()) {
            if (auxiliar == 1) {
                if (Character.isDigit(array_caracteres[a])) {
                    diaS += array_caracteres[a];
                } else {
                    a++;
                    auxiliar = 2;
                }
            }
            if (auxiliar == 2) {
                if (Character.isDigit(array_caracteres[a])) {
                    mesS += array_caracteres[a];
                } else {
                    a++;
                    auxiliar = 3;
                }
            }
            if (auxiliar == 3) {
                if (Character.isDigit(array_caracteres[a])) {
                    anhoS += array_caracteres[a];
                }
            }
            a++;
        }
        dia = Integer.valueOf(diaS);
        mes = Integer.valueOf(mesS);
        anho = Integer.valueOf(anhoS);
        if (anho % 4 == 0) {
            if (mes < 0 || mes > 12) {
                return false;
            } else {
                switch (mes) {
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:
                        if (dia < 0 || dia > 31) {
                            return false;
                        }
                        break;
                    case 2:
                        if (dia < 0 || dia > 29) {
                            return false;
                        }
                        break;
                    case 4:
                    case 6:
                    case 9:
                    case 11:
                        if (dia < 0 || dia > 30) {
                            return false;
                        }
                        break;
                    default:
                        break;
                }
            }
        } else {
            if (mes < 0 || mes > 12) {
                return false;
            } else {
                switch (mes) {
                    case 1:
                    case 3:
                    case 5:
                    case 7:
                    case 8:
                    case 10:
                    case 12:
                        if (dia < 0 || dia > 31) {
                            return false;
                        }
                        break;
                    case 2:
                        if (dia < 0 || dia > 28) {
                            return false;
                        }
                        break;
                    case 4:
                    case 6:
                    case 9:
                    case 11:
                        if (dia < 0 || dia > 30) {
                            return false;
                        }
                        break;
                    default:
                        break;
                }
            }
        }
        return true;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonAceptar;
    private javax.swing.JButton botonCancelar1;
    private javax.swing.JButton botonRestaurar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JComboBox<String> cajaCombinadaCategoria;
    private javax.swing.JTextField campoTextoCantidad1;
    private javax.swing.JTextField campoTextoComentario;
    private javax.swing.JTextField campoTextoFecha;
    private javax.swing.JLabel iconoCa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
    private Egresos egresos;
    private int operacion;
    private StringBuffer respuesta;
    private Validadores validadores = new Validadores();
}
