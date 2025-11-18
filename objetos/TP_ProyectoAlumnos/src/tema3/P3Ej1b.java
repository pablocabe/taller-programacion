/*
 1-A- Definir una clase para representar triángulos. Un triángulo se caracteriza por el
tamaño de sus 3 lados (double), el color de relleno (String) y el color de línea (String).
Provea un constructor que reciba todos los datos necesarios para iniciar el objeto.
Provea métodos para:
- Devolver/modificar el valor de cada uno de sus atributos (métodos get y set)
- Calcular el perímetro y devolverlo (método calcularPerimetro)
- Calcular el área y devolverla (método calcularArea)
B- Realizar un programa que instancie un triángulo, le cargue información leída desde
teclado e informe en consola el perímetro y el área.
 */
package tema3;
import PaqueteLectura.Lector;
/**
 *
 * @author Pablo
 */
public class P3Ej1b {
    public static void main(String[] args) {
        Triangulo triangulo = new Triangulo();
        System.out.println("Ingrese el valor del lado 1");
        triangulo.setLado1(Lector.leerDouble());
        System.out.println("Ingrese el valor del lado 2");
        triangulo.setLado2(Lector.leerDouble());
        System.out.println("Ingrese el valor del lado 3");
        triangulo.setLado3(Lector.leerDouble());
        System.out.println("Ingrese el color de relleno");
        triangulo.setColorRelleno(Lector.leerString());
        System.out.println("Ingrese el color de línea");
        triangulo.setColorLinea(Lector.leerString());
        System.out.println("El perímetro del triángulo es: " + triangulo.calcularPerimetro());
        System.out.println("El área del triángulo es: " + triangulo.calcularArea());
    }
}
