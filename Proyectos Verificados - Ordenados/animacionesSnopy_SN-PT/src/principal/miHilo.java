/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author josej
 */
public class miHilo extends Thread {
    
    Image img[];
    String args[] = {"Snoopy1.gif", "Snoopy2.gif", "Snoopy3.gif", "Snoopy4.gif"};
    nvoPanel jp;
    int z = 0;
    int y = 5;
    int tiempo = 400;
    int x = 0;
    
    public miHilo(nvoPanel p) {
        img = new Image[args.length];
        for (int y = 0; y < args.length; y++) {
            img[y] = Toolkit.getDefaultToolkit().createImage(args[y]);
        }
        jp = p;
        System.out.println("Imagen: " + jp);
    }
    
    public miHilo(nvoPanel p, int x) {
        this(p);
        this.x = x;
    }
    
    @Override
    public void run() {
        while (true) {
            jp.getGraphics().drawImage(img[z], x, y, jp);
            z++;
            if (z == args.length) {
                z = 0;
            }
            if (x >= jp.getWidth()) {
                x = -50;
            } else {
                x += 30;
            }
            try {
                sleep(tiempo);
            } catch (InterruptedException e) {
            }
            jp.update(jp.getGraphics());
        }
    }
}
