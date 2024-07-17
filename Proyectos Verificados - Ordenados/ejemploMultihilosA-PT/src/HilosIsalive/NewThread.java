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
public class NewThread implements Runnable {

    String name; // nombre del hilo
    Thread t;

    NewThread(String threadname) {
        name = threadname;
        t = new Thread(this, name);
        System.out.println("Nuevo hilo: " + t);
        t.start(); // Comienza el hilo
    }

    @Override
    public void run() {
        try {
            for (int i = 5; i > 0; i--) {
                System.out.println(name + ": " + i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupción del hilo" + name);
        }
        System.out.println("Sale del hilo " + name);
    }
}


