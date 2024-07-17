/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HiloSincrinizado;

/**
 *
 * @author KarinaCV
 */
public class Callme {

    public synchronized void call(String msg) {
        System.out.print("[" + msg);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("Interrumpido");
        }
        System.out.println("]");
    }
}
