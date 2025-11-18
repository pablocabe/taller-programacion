/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1;
import PaqueteLectura.Lector;
/**
 *
 * @author Pablo
 */
public class P1Ej2 {
    public static void main(String[] args) {
        int DF = 15;
        double [] vector = new double [DF];
        int i, cantidad = 0;
        double altura, alturaPromedio, alturaTotal = 0.0;
        for (i=0; i<DF ; i++) {
            altura = Lector.leerDouble();
            vector[i] = altura;
            alturaTotal = alturaTotal + altura;
        }
        alturaPromedio = alturaTotal / DF;
        System.out.println ("La altura promedio es: " + alturaPromedio);
        for (i=0; i<DF; i++) {
            if (vector[i] > alturaPromedio)
                cantidad++;
        }
        System.out.println ("La cantidad por encima del promedio es: " + cantidad);
    }
}

/**
 * 2- Escriba un programa que lea las alturas de los 15 jugadores de un equipo de
básquet y las almacene en un vector. Luego informe:
- la altura promedio
- la cantidad de jugadores con altura por encima del promedio
NOTA: Dispone de un esqueleto para este programa en Ej02Jugadores.java
 */