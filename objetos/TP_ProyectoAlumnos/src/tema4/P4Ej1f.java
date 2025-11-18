/*
F- Realizar un programa que instancie un triángulo y un círculo. Muestre en consola la
representación String de cada uno. Pruebe el funcionamiento del método despintar.
 */
package tema4;

import PaqueteLectura.Lector;

/**
 *
 * @author Pablo
 */
public class P4Ej1f {
    public static void main(String[] args) {
        System.out.println("Ingrese las medidas de los tres lados del triángulo");
        double lado1 = Lector.leerDouble();
        double lado2 = Lector.leerDouble();
        double lado3 = Lector.leerDouble();
        System.out.println("Ingrese el color de línea y de relleno del triángulo");
        String colorLinea = Lector.leerString();
        String colorRelleno = Lector.leerString();
        Triangulo triangulo = new Triangulo (lado1, lado2, lado3, colorLinea, colorRelleno);
        
        // Otra forma: triangulo = new Triangulo(Lector.leerDouble(), 
        // Lector.leerDouble(), Lector.leerDouble(), Lector.leerString(), Lector.leerString());
        
        System.out.println("Ingrese el radio del círculo");
        double radio = Lector.leerDouble();
        System.out.println("Ingrese el color de línea y de relleno del círculo");
        colorLinea = Lector.leerString();
        colorRelleno = Lector.leerString();
        Circulo circulo = new Circulo (radio, colorLinea, colorRelleno);
        
        System.out.println(triangulo.toString());
        System.out.println(circulo.toString());
        
        triangulo.despintarFigura();
        System.out.println(triangulo.toString());
    }
}
