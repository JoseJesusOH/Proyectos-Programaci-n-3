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
public class clicker implements Runnable {

    int click = 0;
    Thread t;
    private volatile boolean running = true;

    public clicker(int p) {
        t = new Thread(this);
        t.setPriority(p);
    }

    @Override
    public void run() {
        while (running) {
            click++;
        }
    }

    public void stop() {
        running = false;
    }

    public void start() {
        t.start();
    }

}
