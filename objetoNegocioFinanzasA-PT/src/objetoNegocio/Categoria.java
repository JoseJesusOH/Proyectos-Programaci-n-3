/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetoNegocio;

/**
 *
 * @author luisg
 */
public class Categoria {

    private boolean rutina;
    private boolean transporte;
    private boolean familia;
    private boolean alimentacion;
    private boolean regalos;
    private boolean educacion;
    private boolean salud;

    /**
     * Constructor de la clase que inicializa los atributos de clase rutina,
     * transporte, familia, alimentacion, regalos, educacion y salud.
     *
     * @param rutina parámetro que inicializará el atributo rutina
     * @param transporte parámetro que inicializará el atributo transporte
     * @param familia parámetro que inicializará el atributo familia
     * @param alimentacion parámetro que inicializará el atributo alimentacion
     * @param regalos parámetro que inicializará el atributo regalos
     * @param educacion parámetro que inicializará el atributo educacion
     * @param salud parámetro que inicializará el atributo salud
     */
    public Categoria(boolean rutina, boolean transporte, boolean familia, boolean alimentacion, boolean regalos, boolean educacion, boolean salud) {
        this.rutina = rutina;
        this.transporte = transporte;
        this.familia = familia;
        this.alimentacion = alimentacion;
        this.regalos = regalos;
        this.educacion = educacion;
        this.salud = salud;
    }

    /**
     * Regresa el atributo rutina.
     *
     * @return El atributo rutina
     */
    public boolean getRutina() {
        return rutina;
    }

    /**
     * Le asigna un valor al atributo rutina.
     *
     * @param rutina parámetro que se le asignará al atributo rutina
     */
    public void setRutina(boolean rutina) {
        this.rutina = rutina;
    }

    /**
     * Regresa el atributo transporte.
     *
     * @return El atributo transporte
     */
    public boolean getTransporte() {
        return transporte;
    }

    /**
     * Le asigna un valor al atributo transporte.
     *
     * @param transporte parámetro que se le asignará al atributo transporte
     */
    public void setTransporte(boolean transporte) {
        this.transporte = transporte;
    }

    /**
     * Regresa el atributo familia.
     *
     * @return El atributo familia
     */
    public boolean getFamilia() {
        return familia;
    }

    /**
     * Le asigna un valor al atributo familia.
     *
     * @param familia parámetro que se le asignará al atributo familia
     */
    public void setFamilia(boolean familia) {
        this.familia = familia;
    }

    /**
     * Regresa el atributo alimentacion.
     *
     * @return El atributo alimentacion
     */
    public boolean getAlimentacion() {
        return alimentacion;
    }

    /**
     * Le asigna un valor al atributo alimentacion.
     *
     * @param alimentacion parámetro que se le asignará al atributo alimentacion
     */
    public void setAlimentacion(boolean alimentacion) {
        this.alimentacion = alimentacion;
    }

    /**
     * Regresa el atributo regalos.
     *
     * @return El atributo regalos
     */
    public boolean getRegalos() {
        return regalos;
    }

    /**
     * Le asigna un valor al atributo regalos.
     *
     * @param regalos parámetro que se le asignará al atributo regalos
     */
    public void setRegalos(boolean regalos) {
        this.regalos = regalos;
    }

    /**
     * Regresa el atributo educacion.
     *
     * @return El atributo educacion
     */
    public boolean getEducacion() {
        return educacion;
    }

    /**
     * Le asigna un valor al atributo educacion.
     *
     * @param educacion parámetro que se le asignará al atributo educacion
     */
    public void setEducacion(boolean educacion) {
        this.educacion = educacion;
    }

    /**
     * Regresa el atributo salud.
     *
     * @return El atributo salud
     */
    public boolean getSalud() {
        return salud;
    }

    /**
     * Le asigna un valor al atributo salud.
     *
     * @param salud parámetro que se le asignará al atributo salud
     */
    public void setSalud(boolean salud) {
        this.salud = salud;
    }
}
