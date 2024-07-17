/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author josej
 */
public class Animacion extends JFrame {

    public Animacion() {
        JPanel contenPane;
        JLabel headerLabel = new JLabel();
        nvoPanel p = new nvoPanel();
        miHilo hilo = new miHilo(p);
        contenPane = (JPanel) getContentPane();
        p.setBackground(Color.WHITE);
        contenPane.add(p);
        setSize(600, 240);
        setVisible(true);
        try {
            setTitle("Snoopy");
            headerLabel.setFont(new java.awt.Font("Comic Sans MS", Font.BOLD, 16));
            headerLabel.setText("Creado por:\n" + "Jose Jesus");
            contenPane.add(headerLabel, java.awt.BorderLayout.NORTH);
this.setVisible(true);
        } catch (Exception e) {
        e.printStackTrace();
        }
        hilo.start();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
     new Animacion();
    }

}
