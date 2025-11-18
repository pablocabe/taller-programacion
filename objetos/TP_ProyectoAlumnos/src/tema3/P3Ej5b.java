/*
 5-A- Definir una clase para representar círculos. Los círculos se caracterizan por su radio
(double), el color de relleno (String) y el color de línea (String).
Provea un constructor que reciba todos los datos necesarios para iniciar el objeto.
Provea métodos para:
- Devolver/modificar el valor de cada uno de sus atributos (métodos get y set)
- Calcular el perímetro y devolverlo (método calcularPerimetro)
- Calcular el área y devolverla (método calcularArea)
B- Realizar un programa que instancie un círculo, le cargue información leída de teclado e
informe en consola el perímetro y el área.
NOTA: la constante PI es Math.PI
 */
package tema3;
import PaqueteLectura.Lector;
/**
 *
 * @author Pablo
 */
public class P3Ej5b {
    public static void main(String[] args) {
        System.out.println("Ingrese el radio del círculo");
        double radio = Lector.leerDouble();
        System.out.println("Ingrese el color de relleno del círculo");
        String colorRelleno = Lector.leerString();
        System.out.println("Ingrese el color de línea del círculo");
        String colorLinea = Lector.leerString();
        Circulo circulo = new Circulo (radio, colorRelleno, colorLinea);
        System.out.println("El perímetro del círculo es: " + circulo.calcularPerimetro());
        System.out.println("El área del círculo es: " + circulo.calcularArea());
    }
}
