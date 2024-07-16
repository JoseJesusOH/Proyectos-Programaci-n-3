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
public class Ingresos extends Movimiento {

    private String tipoMovimiento;

    /**
     * Constructor de la clase que inicializa los atributos de clase cantidad,
     * fecha, comentario y tipoMovimiento.
     *
     * @param cantidad parámetro que inicializará el atributo cantidad
     * @param fecha parámetro que inicializará el atributo fecha
     * @param comentario parámetro que inicializará el atributo comentario
     * @param tipoMovimiento parámetro que inicializará el atributo
     * tipoMovimiento
     */
    public Ingresos(double cantidad, Fecha fecha, String comentario, String tipoMovimiento) {
        super(cantidad, fecha, comentario);
        this.tipoMovimiento = tipoMovimiento;
    }

    /**
     * Regresa el atributo tipoMovimiento.
     *
     * @return El atributo tipoMovimiento
     */
    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    /**
     * Le asigna un valor al atributo tipoMovimiento.
     *
     * @param tipoMovimiento parámetro que se le asignará al atributo
     * tipoMovimiento
     */
    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }
}
