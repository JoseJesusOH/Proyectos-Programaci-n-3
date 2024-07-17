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
public class CalculadoraTest1 {

    private int numErrores = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CalculadoraTest1 ct = new CalculadoraTest1();
        try {
            ct.testSuma();
        } catch (Exception e) {
            ct.numErrores++;
            e.printStackTrace();
        }
        try {
            ct.testResta();
        } catch (Exception e) {
            ct.numErrores++;
            e.printStackTrace();
        }
        try {
            ct.testFactorial();
        } catch (Exception e) {
            ct.numErrores++;
            e.printStackTrace();
        }
        try {
            ct.testFactorialException();
        } catch (Exception e) {
            ct.numErrores++;
            e.printStackTrace();
        }
        if (ct.numErrores > 0) {
            throw new RuntimeException("Tenemos " + ct.numErrores + " error(es)");
        }
    }

    public void testSuma() {
        Calculadora calculadora = new Calculadora();
        System.out.println("Prueba del metodo suma");
        double resultado = calculadora.suma(20.0, 30.0);
        if (resultado != 50) {
            throw new RuntimeException("Error el valor esperado 50.0 " + resultado);
        }
    }

    public void testResta() {
        Calculadora calculadora = new Calculadora();
        System.out.println("Prueba del metodo resta");
        double resultado = calculadora.resta(50.0, 30.0);
        if (resultado != 20) {
            throw new RuntimeException("Error el valor esperado 20.0 " + resultado);
        }
    }

    public void testFactorial() {
        Calculadora calculadora = new Calculadora();
        System.out.println("Prueba del metodo factorial");
        long resultado = calculadora.factorial(0);
        if (resultado != 1) {
            throw new RuntimeException("Error el valor esperado 1 " + resultado);
        }
        resultado = calculadora.factorial(5);
        if (resultado != 120) {
            throw new RuntimeException("Error valor esperado 120 " + resultado);
        }
    }

    public void testFactorialException() {
        Calculadora calculadora = new Calculadora();
        long resultado;
        System.out.println("Prueba de excepcion metodo factorial");
        try {
            resultado = calculadora.factorial(-3);
            throw new RuntimeException("Error no lanzo excepcion IlegalArgumentException");
        } catch (IllegalArgumentException e) {
        }
    }
}
