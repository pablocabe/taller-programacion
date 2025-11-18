/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema2;
import PaqueteLectura.GeneradorAleatorio;
/**
 *
 * @author Pablo
 */
public class P2Ej2mejorado {
     public static void main(String[] args) {
         GeneradorAleatorio.iniciar();
         int dF = 15;
         int dL = 0;
         Persona [] vector = new Persona [dF];
         System.out.println("Se ingresará la primera edad");
         int edad = GeneradorAleatorio.generarInt(100);
         while ((edad != 0) && (dL < dF)) {
             String nombre = GeneradorAleatorio.generarString(5);
             int DNI = GeneradorAleatorio.generarInt(40);
             vector [dL] = new Persona (nombre, DNI, edad);
             System.out.println(vector[dL].toString());
             dL++;
             edad = GeneradorAleatorio.generarInt(100);
         }
         if (dL == dF) {
             System.out.println("La carga de datos finalizó porque alcanzó 15 personas");
         } else {
             System.out.println("La carga de datos finalizó porque se ingresó la edad 0");
         }
         // Se almacenó la información
         int mayores65 = 0;
         int DNImenor = 999;
         Persona menor = null;
         for (int i=0 ; i<dL ; i++) {
             if (vector[i].getEdad()>65) {
                 mayores65++;
             }
             if (vector[i].getDNI() < DNImenor){
                 DNImenor = vector[i].getDNI();
                 menor = vector[i];
             }
         }
         System.out.println("La cantidad de personas mayores de 65 años es: " + mayores65);
         if (menor != null) {
             System.out.println(menor.toString());
         } else
             System.out.println("El vector está vacío");
     }
}


/*
2- Utilizando la clase Persona. Realice un programa que almacene en un vector a lo sumo
15 personas. La información (nombre, DNI, edad) se debe generar aleatoriamente hasta
obtener edad 0. Luego de almacenar la información:
- Informe la cantidad de personas mayores de 65 años.
- Muestre la representación de la persona con menor DNI.
 */