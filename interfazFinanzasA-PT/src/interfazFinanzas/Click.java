/*
 * Click.java
 * Creada el  de diciembre del 2021 21:11 PM
 */
package interfazFinanzas;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

/**
 *
 * @author josej
 */
public class Click extends Thread {

    URL click;
    AudioClip sondioClick;
    String direccion = "";

    public Click(String s) {
        this.direccion = s;
    }

    @Override
    public void run() {
        click = getClass().getResource(direccion);
        sondioClick = Applet.newAudioClip(click);
        sondioClick.play();
    }
}
