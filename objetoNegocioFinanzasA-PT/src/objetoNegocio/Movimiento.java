/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetoNegocio;

import objetosServicio.Fecha;

/**
 *
 * @author luisg
 */
public class Movimiento {

    protected double cantidad;
    protected Fecha fecha;
    protected String comentario;

    /**
     * Constructor de la clase que inicializa los atributos de clase cantidad,
     * fecha y comentario.
     *
     * @param cantidad parámetro que inicializará el atributo cantidad
     * @param fecha parámetro que inicializará el atributo fecha
     * @param comentario parámetro que inicializará el atributo comentario
     */
    public Movimiento(double cantidad, Fecha fecha, String comentario) {
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.comentario = comentario;
    }

    /**
     * Regresa el atributo cantidad.
     *
     * @return El atributo cantidad
     */
    public double getCantidad() {
        return cantidad;
    }

    /**
     * Le asigna un valor al atributo cantidad.
     *
     * @param cantidad parámetro que se le asignará al atributo cantidad
     */
    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Regresa el atributo fecha.
     *
     * @return El atributo fecha
     */
    public Fecha getFecha() {
        return fecha;
    }

    /**
     * Le asigna un valor al atributo fecha.
     *
     * @param fecha parámetro que se le asignará al atributo fecha
     */
    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    /**
     * Regresa el atributo comentario.
     *
     * @return El atributo comentario
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * Le asigna un valor al atrinuto comentario.
     *
     * @param comentario parámetro que se le asignará al atributo comentario
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
