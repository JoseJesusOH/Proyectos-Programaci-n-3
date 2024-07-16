/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PrioridadHilos;

/**
 *
 * @author KarinaCV
 */
public class PruebaHiloPrioridad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        clicker hi = new clicker(Thread.NORM_PRIORITY + 2);
        clicker lo = new clicker(Thread.MIN_PRIORITY);
        lo.start();
        hi.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("Hilo principal interrumpido.");
        }
        lo.stop();
        hi.stop();
        try {
            hi.t.join();
            lo.t.join();
        } catch (InterruptedException e) {
            System.out.println("InterruptedException capturada");
        }
        System.out.println("Hilo de prioridad baja: " + lo.click);
        System.out.println("Hilo de prioridad alta: " + hi.click);
    }

}
