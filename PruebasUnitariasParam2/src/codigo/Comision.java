/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codigo;
/**
 *
 * @author user
 */
public class Comision {
    /**
* Este metodo calcula la comision obtenida por un vendedor
* dependiendo de sus ventas
*
* Monto de las ventas Porcentaje de Comisión
* Menos de $1,000.00 0.0%
* $1,000.00 a $4,999.99 2.5%
* $5,000.00 a $9,999.99 5.0%
* $10,000.00 a 49,999.00 7.5%
* $50,000.00 o más 10.0%
*
* @param ventas Ventas del vendedor
* @return Comision obtenida por el vendedor
*/
  
public double getComision(double ventas) {
    double porcentajeComision;
    if(ventas >= 50000.0) porcentajeComision = 0.1;
        else if(ventas >= 10000.0) porcentajeComision = 0.075;
        else if(ventas >= 5000.0) porcentajeComision = 0.05;
        else if(ventas >= 1000.0) porcentajeComision = 0.025;
        else porcentajeComision = 0.0;
        
        return porcentajeComision * ventas;
    }
}
