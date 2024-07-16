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
public class Egresos extends Movimiento {

    private String tipoMovimiento;
    private Categoria categoria;

    public Egresos(double cantidad, Fecha fecha, String comentario, String tipoMovimiento, Categoria categoria) {
        super(cantidad, fecha, comentario);
        this.tipoMovimiento = tipoMovimiento;
        this.categoria = categoria;
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

    /**
     * Regresa el atributo categoria.
     *
     * @return El atributo categoria
     */
    public Categoria getCategoria() {
        return categoria;
    }

    /**
     * Le asigna un valor al atributo categoria.
     *
     * @param categoria parámetro que se le asignará al atributo categoria
     */
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
