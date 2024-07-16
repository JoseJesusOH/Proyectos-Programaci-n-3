package pruebasunitariasparam;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import codigo.Comision;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author user
 */
//Prueba Unitaria Parametrizada
//Paso 1.
@RunWith(Parameterized.class)
public class ComisionTest {

//Paso 2.    
    double ventas;
    double comision;
    /**
    * Constructor de la clase parametrizada. Inicializa los
    * atributos con el parametro del metodo de prueba y
    * resultado
    *
    * @param ventas Parametro del metodo de prueba
    * @param comision Resultado del metodo de prueba
    */
 
    //Paso 3.
    public ComisionTest(double ventas, double comision) {
        this.ventas = ventas;
        this.comision = comision;
    }
    /**
    * Metodo que regresa una lista de los casos de prueba.
    * Cada elemento de la lista es una pareja parametro, resultado
    * @return
    */
    
 //Paso 4.   
    @Parameterized.Parameters
    public static Collection data() {
        //Object[venta][% c]
        return Arrays.asList(new Object[][] {
                            {0.0, 0.0},
                            {999.99, 0.000000000000000},
                            {1000.0, 25.000000000000000},
                            {4999.99, 124.999750000000006},
                            {5000.0, 250.000000000000000},
                            {9999.99, 499.999500000000012},
                            {10000.0, 750.000000000000000},
                            {49999.99, 3749.999249999999847},
                            {50000.0, 5000.000000000000000}
                            });
    }
    
    /**
    * Metodo de prueba del metodo getComision de la clase Comision.
    */
  //Paso 5.  
    @Test
    public void testGetComision() {
        System.out.println("Prueba parametrizada del método getComision(" + ventas + ")");
        Comision instance = new Comision();
        double result = instance.getComision(ventas);
        assertEquals(comision, result, 1e-15); //long 1e-15
    }
    
}
