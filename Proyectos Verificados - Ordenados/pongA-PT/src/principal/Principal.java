/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import clases.Ventana;
import javax.swing.JFrame;

/**
 *
 * @author HOME
 */
public class Principal {
    public static void main(String[] args) {
        Ventana ventana = new Ventana();
        ventana.setVisible(true);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
public class Paleta {
    public int y;
    public int alto;
    
   
    public Paleta(int y, int alto) {
        this.y = y;
        this.alto = alto;
        
    }
}

public class Pelota {
    public int x;
    public int y;
    public int veloX;
    public int veloY;
   
    public Pelota(int x, int y, int veloX, int veloY) {
        this.x = x;
        this.y = y;
        this.veloX = veloX;
        this.veloY = veloY;
    }
}
}

