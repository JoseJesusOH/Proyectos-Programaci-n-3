/*
 * DlgInteres.java
 * Creada el 2 de diciembre del 2021 21:11 PM
 */
package interfazFinanzas;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import validores.Validadores;

/**
 * Cuadro de dialogo que tiene la funcional de una calculadora de interes
 * compuesto..
 *
 * @author Pacheco, Orozco y Cervantes
 */
public final class DlgInteres extends javax.swing.JDialog {
    Click so = new Click("/recursos/click1.wav");

    ImageIcon a = new ImageIcon(getClass().getResource("/recursos/aceptar-el-contorno-del-boton-circular.png"));
    ImageIcon b = new ImageIcon(getClass().getResource("/recursos/rehacer-simbolo-de-flecha.png"));
    ImageIcon c = new ImageIcon(getClass().getResource("/recursos/error.png"));
    ImageIcon d = new ImageIcon(getClass().getResource("/recursos/save.png"));
    ImageIcon e = new ImageIcon(getClass().getResource("/recursos/eliminar.png"));
    ImageIcon[] ar = {a, b, c, d, e};
    private ImageIcon imagen;
    private Icon icono;
    private Validadores validadores = new Validadores();
    double depInicial, aport, tiempo, aportTotal, interes, tasaInteres, interesAcum, total;

    /**
     * Creates new form DlgInteres
     *
     * @param parent Parent
     * @param title Titulo
     * @param modal Modal
     */
    public DlgInteres(java.awt.Frame parent, String title, boolean modal) {
        super(parent, title, modal);
        initComponents();
        botonRestaurar.setIcon(ar[1]);
        botonCalcular.setIcon(ar[0]);
        setSize(675, 495);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        campoTextoDepositoInicial = new javax.swing.JTextField();
        campoTextoInteresAnual = new javax.swing.JTextField();
        campoTextoAñosInvertir = new javax.swing.JTextField();
        campoTextoAportacionesAdicionales = new javax.swing.JTextField();
        botonCalcular = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabelDepositosAcum = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabelInteresAcumulado = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabelTotal = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        depositoInicialPrint = new javax.swing.JLabel();
        depositoPrint = new javax.swing.JTextField();
        aportacionesPrint = new javax.swing.JTextField();
        interesPrint = new javax.swing.JTextField();
        totalPrint = new javax.swing.JTextField();
        botonRestaurar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Calculadora de Interes Compuesto");
        setBackground(new java.awt.Color(102, 255, 102));
        setResizable(false);
        setSize(new java.awt.Dimension(671, 467));
        getContentPane().setLayout(null);
        getContentPane().add(jLabel15);
        jLabel15.setBounds(291, 533, 0, 0);
        getContentPane().add(jLabel17);
        jLabel17.setBounds(459, 539, 0, 0);

        jPanel1.setBackground(new java.awt.Color(194, 194, 194));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel1.setText("        Calculadora de Interes Compuesto");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(40, 10, 580, 38);

        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel2.setText("Deposito Inicial");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(20, 40, 119, 21);

        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel3.setText("Tasa de Interes Anual");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(20, 110, 166, 21);

        jLabel4.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel4.setText("Anualmente");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(jLabel4);
        jLabel4.setBounds(50, 250, 100, 40);

        jLabel6.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel6.setText("Años a Invertir");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(20, 170, 112, 21);

        campoTextoDepositoInicial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTextoDepositoInicialActionPerformed(evt);
            }
        });
        jPanel1.add(campoTextoDepositoInicial);
        campoTextoDepositoInicial.setBounds(20, 70, 171, 31);

        campoTextoInteresAnual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTextoInteresAnualActionPerformed(evt);
            }
        });
        jPanel1.add(campoTextoInteresAnual);
        campoTextoInteresAnual.setBounds(20, 130, 171, 31);

        campoTextoAñosInvertir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTextoAñosInvertirActionPerformed(evt);
            }
        });
        jPanel1.add(campoTextoAñosInvertir);
        campoTextoAñosInvertir.setBounds(20, 190, 171, 31);

        campoTextoAportacionesAdicionales.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTextoAportacionesAdicionalesActionPerformed(evt);
            }
        });
        jPanel1.add(campoTextoAportacionesAdicionales);
        campoTextoAportacionesAdicionales.setBounds(20, 320, 171, 31);

        botonCalcular.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        botonCalcular.setText("Calcular");
        botonCalcular.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonCalcular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCalcularActionPerformed(evt);
            }
        });
        jPanel1.add(botonCalcular);
        botonCalcular.setBounds(30, 370, 140, 40);

        jPanel2.setBackground(new java.awt.Color(133, 137, 133));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.setLayout(null);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/DepositoInicial.PNG"))); // NOI18N
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel9);
        jLabel9.setBounds(60, 60, 79, 75);

        jLabel10.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.highlight"));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/DepositoAcumulado.PNG"))); // NOI18N
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel10);
        jLabel10.setBounds(280, 60, 71, 75);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/InteresAcumulado.PNG"))); // NOI18N
        jLabel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel11);
        jLabel11.setBounds(60, 220, 80, 73);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/Total.PNG"))); // NOI18N
        jLabel12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel12);
        jLabel12.setBounds(290, 230, 76, 67);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("   Deposito Inicial");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel7);
        jLabel7.setBounds(30, 20, 140, 30);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Aportaciones Acumuladas ");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel8);
        jLabel8.setBounds(230, 30, 190, 20);

        jLabel13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText(" Interes Acumulado ");
        jLabel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel13);
        jLabel13.setBounds(30, 190, 150, 19);

        jLabel14.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("       Total ");
        jLabel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jLabel14);
        jLabel14.setBounds(280, 200, 120, 20);

        jLabelDepositosAcum.setBackground(new java.awt.Color(0, 0, 0));
        jLabelDepositosAcum.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabelDepositosAcum.setText("$");
        jPanel2.add(jLabelDepositosAcum);
        jLabelDepositosAcum.setBounds(210, 140, 20, 30);

        jTextField1.setBackground(new java.awt.Color(14, 145, 145));
        jTextField1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jTextField1);
        jTextField1.setBounds(280, 200, 120, 100);

        jTextField2.setBackground(new java.awt.Color(153, 0, 153));
        jTextField2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jTextField2);
        jTextField2.setBounds(30, 20, 140, 120);

        jLabelInteresAcumulado.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabelInteresAcumulado.setText("$");
        jPanel2.add(jLabelInteresAcumulado);
        jLabelInteresAcumulado.setBounds(10, 300, 30, 30);

        jTextField3.setBackground(new java.awt.Color(153, 153, 0));
        jTextField3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.add(jTextField3);
        jTextField3.setBounds(230, 30, 190, 110);

        jLabelTotal.setBackground(new java.awt.Color(204, 204, 204));
        jLabelTotal.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabelTotal.setText("$");
        jPanel2.add(jLabelTotal);
        jLabelTotal.setBounds(260, 300, 20, 30);

        jTextField4.setBackground(new java.awt.Color(153, 51, 0));
        jTextField4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField4);
        jTextField4.setBounds(30, 190, 150, 110);

        depositoInicialPrint.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        depositoInicialPrint.setText("$");
        jPanel2.add(depositoInicialPrint);
        depositoInicialPrint.setBounds(10, 140, 20, 30);

        depositoPrint.setEditable(false);
        depositoPrint.setBackground(new java.awt.Color(153, 153, 153));
        depositoPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depositoPrintActionPerformed(evt);
            }
        });
        jPanel2.add(depositoPrint);
        depositoPrint.setBounds(30, 139, 140, 30);

        aportacionesPrint.setEditable(false);
        aportacionesPrint.setBackground(new java.awt.Color(153, 153, 153));
        aportacionesPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aportacionesPrintActionPerformed(evt);
            }
        });
        jPanel2.add(aportacionesPrint);
        aportacionesPrint.setBounds(230, 140, 190, 30);

        interesPrint.setEditable(false);
        interesPrint.setBackground(new java.awt.Color(153, 153, 153));
        interesPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                interesPrintActionPerformed(evt);
            }
        });
        jPanel2.add(interesPrint);
        interesPrint.setBounds(30, 300, 150, 30);

        totalPrint.setEditable(false);
        totalPrint.setBackground(new java.awt.Color(153, 153, 153));
        totalPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalPrintActionPerformed(evt);
            }
        });
        jPanel2.add(totalPrint);
        totalPrint.setBounds(280, 300, 120, 30);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(230, 70, 430, 350);

        botonRestaurar.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        botonRestaurar.setText("Restaurar");
        botonRestaurar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botonRestaurar.setMaximumSize(new java.awt.Dimension(77, 30));
        botonRestaurar.setMinimumSize(new java.awt.Dimension(77, 30));
        botonRestaurar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonRestaurarActionPerformed(evt);
            }
        });
        jPanel1.add(botonRestaurar);
        botonRestaurar.setBounds(30, 420, 140, 40);

        jLabel5.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel5.setText("Aportes Adicionales");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(20, 290, 153, 21);

        jLabel16.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        jLabel16.setText("Frecuencia Anual de Interes");
        jPanel1.add(jLabel16);
        jLabel16.setBounds(10, 230, 220, 21);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 670, 470);

        pack();
    }// </editor-fold>//GEN-END:initComponents
  /**
     * Evento del campo de texto deposito inicial
     *
     * @param evt Evento
     */
    private void campoTextoDepositoInicialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTextoDepositoInicialActionPerformed
        String deposito = campoTextoDepositoInicial.getText();
        String msjError = "";
        if (validadores.cadenaVacia(deposito)) {
            msjError = "Faltó el deposito inicial";
        } else {
            if (deposito.contains(".")) {
                String r = deposito.replaceAll("\\.", "");
                if (!validadores.validaEntero(r)) {
                    msjError = "El deposito inicial tiene caracteres invalidos";
                } else {
                    if (!validadores.validarDouble(deposito)) {
                        msjError = "El deposito inicial tiene caracteres invalidos";
                    }
                }
            }
        }

        if (!msjError.equals("")) {
            JOptionPane.showMessageDialog(this, msjError,
                    "Error de entrada.",
                    JOptionPane.ERROR_MESSAGE);
            campoTextoDepositoInicial.requestFocus();
        } else {
            campoTextoInteresAnual.requestFocus();
        }
    }//GEN-LAST:event_campoTextoDepositoInicialActionPerformed
    /**
     * Evento del campo de texto interes anual.
     *
     * @param evt Evento
     */
    private void campoTextoInteresAnualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTextoInteresAnualActionPerformed
        String interes = campoTextoInteresAnual.getText();
        String msjError = "";
        if (validadores.cadenaVacia(interes)) {
            msjError = "Faltó el interes anual";
        } else {
            if (interes.contains(".")) {
                String r = interes.replaceAll("\\.", "");
                if (!validadores.validaEntero(r)) {
                    msjError = "El interes anueal tiene caracteres invalidos";
                } else {
                    if (!validadores.validarDouble(interes)) {
                        msjError = "El interes anual tiene caracteres invalidos";
                    }
                }
            }
        }

        if (!msjError.equals("")) {
            JOptionPane.showMessageDialog(this, msjError,
                    "Error de entrada.",
                    JOptionPane.ERROR_MESSAGE);
            campoTextoInteresAnual.requestFocus();
        } else {
            campoTextoAñosInvertir.requestFocus();
        }
    }//GEN-LAST:event_campoTextoInteresAnualActionPerformed
    /**
     * Evento del campo de texto años a invertir.
     *
     * @param evt Evento
     */
    private void campoTextoAñosInvertirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTextoAñosInvertirActionPerformed
        String anhos = campoTextoAñosInvertir.getText();
        String msjError = "";
        if (validadores.cadenaVacia(anhos)) {
            msjError = "Faltaron los años a invertir";
        } else if (!validadores.validaEntero(anhos)) {
            msjError = "Solo se permiten enteros";
        }

        if (!msjError.equals("")) {
            JOptionPane.showMessageDialog(this, msjError,
                    "Error de entrada.",
                    JOptionPane.ERROR_MESSAGE);
            campoTextoAñosInvertir.requestFocus();
        } else {
            campoTextoAportacionesAdicionales.requestFocus();
        }
    }//GEN-LAST:event_campoTextoAñosInvertirActionPerformed
    /**
     * Evento del campo de texto aportacionesl.
     *
     * @param evt Evento
     */
    private void campoTextoAportacionesAdicionalesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTextoAportacionesAdicionalesActionPerformed
        String aportaciones = campoTextoAportacionesAdicionales.getText();
        String msjError = "";
        if (validadores.cadenaVacia(aportaciones)) {
            msjError = "Faltaron las aportaciones adicionales";
        } else {
            if (aportaciones.contains(".")) {
                String r = aportaciones.replaceAll("\\.", "");
                if (!validadores.validaEntero(r)) {
                    msjError = "Las aportaciones adicionales tienen caracteres invalidos";
                } else {
                    if (!validadores.validarDouble(aportaciones)) {
                        msjError = "Las aportaciones adicionales tienen caracteres invalidos";
                    }
                }
            }
        }

        if (!msjError.equals("")) {
            JOptionPane.showMessageDialog(this, msjError,
                    "Error de entrada.",
                    JOptionPane.ERROR_MESSAGE);
            campoTextoAportacionesAdicionales.requestFocus();
        } else {
            botonCalcular.requestFocus();
        }
    }//GEN-LAST:event_campoTextoAportacionesAdicionalesActionPerformed
    /**
     * Boton que realiza los calculos, y valida campos.
     *
     * @param evt Evento
     */
    private void botonCalcularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCalcularActionPerformed
        // TODO add your handling code here
       so.run();
        Thread hilo = Thread.currentThread();
        try {
            hilo.sleep(100);
        } catch (InterruptedException e) {
        }
        String msjError = "";
        String depositoInicial = campoTextoDepositoInicial.getText();
        String tasa = campoTextoInteresAnual.getText();
        String añosInvertir = campoTextoAñosInvertir.getText();
        String aportes = campoTextoAportacionesAdicionales.getText();
        int posError = 0;
        if (validadores.cadenaVacia(aportes)) {
            msjError = "Los aportes estan vacio";
            posError = 4;
        } else {
            if (aportes.contains(".")) {
                String r = aportes.replaceAll("\\.", "");
                if (!validadores.validaEntero(aportes)) {
                    msjError = "El aporte tiene caracteres invalidos";
                    posError = 4;
                } else {
                    if (!validadores.validarDouble(aportes)) {
                        msjError = "El aporte tiene caracteres invalidos";
                        posError = 4;
                    }
                }
            } else {
                if (!validadores.validaEntero(aportes)) {
                    msjError = "El aporte tiene caracteres invalidos";
                    posError = 4;
                }
            }
        }

        if (validadores.cadenaVacia(añosInvertir)) {
            msjError = "El año a invertir esta vacio";
            posError = 3;
        } else {
            if (añosInvertir.contains(".")) {
                String r = añosInvertir.replaceAll("\\.", "");
                if (!validadores.validaEntero(añosInvertir)) {
                    msjError = "Los años a invertir tienen caracteres invalidos";
                    posError = 3;
                } else {
                    if (!validadores.validarDouble(añosInvertir)) {
                        msjError = "Los años a invertir tienen caracteres invalidos";
                        posError = 3;
                    }
                }
            } else {
                if (!validadores.validaEntero(añosInvertir)) {
                    msjError = "Los años a invertir tienen caracteres invalidos";
                    posError = 3;
                }
            }
        }

        if (validadores.cadenaVacia(depositoInicial)) {
            msjError = "Deposito inicial vacio";
            posError = 1;
        } else {
            if (depositoInicial.contains(".")) {
                String r = depositoInicial.replaceAll("\\.", "");
                if (!validadores.validaEntero(depositoInicial)) {
                    msjError = "El deposito inicial tiene caracteres invalidos";
                    posError = 1;
                } else {
                    if (!validadores.validarDouble(depositoInicial)) {
                        msjError = "El deposito inicial tiene caracteres invalidos";
                        posError = 1;
                    }
                }
            } else {
                if (!validadores.validaEntero(depositoInicial)) {
                    msjError = "El deposito inicial tiene caracteres invalidos";
                    posError = 1;
                }
            }
        }

        if (validadores.cadenaVacia(tasa)) {
            msjError = "Tasa vacia";
            posError = 2;
        } else {
            if (tasa.contains(".")) {
                String r = tasa.replaceAll("\\.", "");
                if (!validadores.validaEntero(tasa)) {
                    msjError = "La tasa tiene caracteres invalidos";
                    posError = 2;
                } else {
                    if (!validadores.validarDouble(tasa)) {
                        msjError = "La tasa tiene caracteres invalidos";
                        posError = 2;
                    }
                }
            } else {
                if (!validadores.validaEntero(tasa)) {
                    msjError = "La tasa tiene caracteres invalidos";
                    posError = 2;
                }
            }
        }

        if (posError > 0) {
            JOptionPane.showMessageDialog(this, msjError,
                    "Error de entrada.",
                    JOptionPane.ERROR_MESSAGE);
            switch (posError) {
                case 1:
                    campoTextoDepositoInicial.requestFocus();
                    break;
                case 2:
                    campoTextoInteresAnual.requestFocus();
                    break;
                case 3:
                    campoTextoAñosInvertir.requestFocus();
                    break;
                case 4:
                    campoTextoAportacionesAdicionales.requestFocus();
                    break;
            }

        } else {
            depInicial = Double.parseDouble(campoTextoDepositoInicial.getText());
            aport = Double.parseDouble(campoTextoAportacionesAdicionales.getText());
            tiempo = Double.parseDouble(campoTextoAñosInvertir.getText());
            interes = Double.parseDouble(campoTextoInteresAnual.getText());

            tasaInteres = interes / 100;
            aportTotal = aport * tiempo;
            total = (depInicial * Math.pow(1 + (tasaInteres / 12), 12 * tiempo)) + aportTotal;
            interesAcum = total - depInicial;
            depositoPrint.setText(String.valueOf(campoTextoDepositoInicial.getText()));
            aportacionesPrint.setText(String.valueOf((String.format("%.3f", aportTotal))));
            interesPrint.setText(String.valueOf((String.format("%.3f", interesAcum))));
            totalPrint.setText(String.valueOf((String.format("%.3f", total))));
        }
    }//GEN-LAST:event_botonCalcularActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed
    /**
     * Boton que restura los campos.
     *
     * @param evt Evento
     */
    private void botonRestaurarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonRestaurarActionPerformed
               so.run();
        Thread hilo = Thread.currentThread();
        try {
            hilo.sleep(100);
        } catch (InterruptedException e) {
        }
        campoTextoAportacionesAdicionales.setText("");
        campoTextoAñosInvertir.setText("");
        campoTextoDepositoInicial.setText("");
        campoTextoInteresAnual.setText("");
        depositoPrint.setText("");
        aportacionesPrint.setText("");
        interesPrint.setText("");
        totalPrint.setText("");
    }//GEN-LAST:event_botonRestaurarActionPerformed

    private void depositoPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_depositoPrintActionPerformed

    }//GEN-LAST:event_depositoPrintActionPerformed

    private void aportacionesPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aportacionesPrintActionPerformed

    }//GEN-LAST:event_aportacionesPrintActionPerformed

    private void interesPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_interesPrintActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_interesPrintActionPerformed

    private void totalPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalPrintActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalPrintActionPerformed
//


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField aportacionesPrint;
    private javax.swing.JButton botonCalcular;
    private javax.swing.JButton botonRestaurar;
    private javax.swing.JTextField campoTextoAportacionesAdicionales;
    private javax.swing.JTextField campoTextoAñosInvertir;
    private javax.swing.JTextField campoTextoDepositoInicial;
    private javax.swing.JTextField campoTextoInteresAnual;
    private javax.swing.JLabel depositoInicialPrint;
    private javax.swing.JTextField depositoPrint;
    private javax.swing.JTextField interesPrint;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelDepositosAcum;
    private javax.swing.JLabel jLabelInteresAcumulado;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField totalPrint;
    // End of variables declaration//GEN-END:variables
}