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
public class PruebaSyncHilo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Callme target = new Callme();
        Caller ob1 = new Caller(target, "Hola");
        Caller ob2 = new Caller(target, "Mundo");
        Caller ob3 = new Caller(target, "Sincronizado");
        try {
            ob1.t.join();
            ob2.t.join();
            ob3.t.join();
        } catch (InterruptedException e) {
            System.out.println("Interrumpido");
        }
    }

}
