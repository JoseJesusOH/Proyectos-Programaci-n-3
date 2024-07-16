package pruebasUnitarias;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author josej
 */
public class Calculadora {

    public double suma(double x, double y) {
        return x + y;
    }

    public double resta(double x, double y) {
        return x - y;
    }

    public long factorial(int n) throws IllegalArgumentException {
        if (n < 0) {
            throw new IllegalArgumentException("Error parmtero negativo");
        }
        if (n == 0) {
            return 1;
        }
        long f = 1;
        for (; n > 0; n--) {
            f *= n;
        }
        return f;
    }
}
