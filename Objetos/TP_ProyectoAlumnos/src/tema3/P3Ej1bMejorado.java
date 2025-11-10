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
public class P3Ej1bMejorado {
    public static void main(String[] args) {
        System.out.println("Ingrese en orden el lado 1, lado 2, lado 3, color de relleno y color de línea");
        Triangulo triangulo = new Triangulo(Lector.leerDouble(), Lector.leerDouble(),
                Lector.leerDouble(), Lector.leerString(), Lector.leerString());
        System.out.println("El perímetro del triángulo es: " + triangulo.calcularPerimetro());
        System.out.println("El área del triángulo es: " + triangulo.calcularArea());
    }
}
