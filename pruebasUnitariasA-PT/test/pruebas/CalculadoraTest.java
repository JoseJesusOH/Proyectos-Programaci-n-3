package pruebas;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.junit.Test;
import static org.junit.Assert.*;
import pruebasUnitarias.Calculadora;
import pruebasUnitarias.CalculadoraTest1;

/**
 *
 * @author josej
 */
public class CalculadoraTest {

    @Test
    public void testSuma() {
        Calculadora calculadora = new Calculadora();
        System.out.println("Prueba del metodo suma");
        double resultado = calculadora.suma(20.0, 30.0);
        assertEquals(50, resultado, 0);
    }

    @Test
    public void testResta() {
        Calculadora calculadora = new Calculadora();
        System.out.println("Prueba del metodo resta");
        double resultado = calculadora.resta(50.0, 30.0);
        assertEquals(20, resultado, 0);
    }

    @Test
    public void testFactorial() {
        Calculadora calculadora = new Calculadora();
        System.out.println("Prueba del metodo factorial");
        long resultado = calculadora.factorial(0);
        assertEquals(1, resultado);
        resultado = calculadora.factorial(5);
        assertEquals(120, resultado);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testFactorialException() {
        Calculadora calculadora = new Calculadora();
        System.out.println("Prueba del metodo factorial Excepcion");
        long resultado = calculadora.factorial(-3);

    }

    public CalculadoraTest() {
    }

}
