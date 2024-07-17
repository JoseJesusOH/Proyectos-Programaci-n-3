/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HilosIsalive;

/**
 *
 * @author KarinaCV
 */
public class PruebaHilos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NewThread ob1 = new NewThread("Uno");
        NewThread ob2 = new NewThread("Dos");
        NewThread ob3 = new NewThread("Tres");
        System.out.println("El hilo Uno esté vivo: " + ob1.t.isAlive());
        System.out.println("El hilo Dos esté vivo: " + ob2.t.isAlive());
        System.out.println("El hilo Tres esté vivo: " + ob3.t.isAlive());
        try {// espera hasta que terminen los otros hilos
            System.out.println("Espera finalización de los otros hilos.");
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupción del hilo principal");
        }
        System.out.println("El hilo Uno este vivo: " + ob1.t.isAlive());
        System.out.println("El hilo Dos este vivo " + ob2.t.isAlive());
        System.out.println("El hilo Tres este vivo: " + ob3.t.isAlive());
        System.out.println("Sale del hilo principal.");
    }

}
