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
public class P2Ej2 {

    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        int DF = 15;
        Persona [] vector = new Persona [DF];
        int i=0;
        Persona p = new Persona();
        p.setNombre(GeneradorAleatorio.generarString(GeneradorAleatorio.generarInt(4)+1));
        p.setDNI(GeneradorAleatorio.generarInt(500000000));
        p.setEdad(GeneradorAleatorio.generarInt(90));
        int cantidad65 = 0;
        Persona menorDNI = p;
        while ((p.getEdad() != 0) && (i < DF)) {
            vector[i] = p;
            if (p.getDNI()<menorDNI.getDNI()){
                menorDNI = p;
            }
            if (p.getEdad()>65) {
                cantidad65++;
            }
            p = new Persona();
            p.setNombre(GeneradorAleatorio.generarString(GeneradorAleatorio.generarInt(4)+1));
            p.setDNI(GeneradorAleatorio.generarInt(500000000));
            
            p.setEdad(GeneradorAleatorio.generarInt(90));
            i++;
        }
        System.out.println("La cantidad de personas mayores de 65 años es: " + cantidad65);
        System.out.println(menorDNI.toString());
        // solo para chequear imprimo todo el vector
        for (i=0; i<15; i++){
            System.out.println(vector[i].toString());
        }

    }
}

/*
2- Utilizando la clase Persona. Realice un programa que almacene en un vector a lo sumo
15 personas. La información (nombre, DNI, edad) se debe generar aleatoriamente hasta
obtener edad 0. Luego de almacenar la información:
- Informe la cantidad de personas mayores de 65 años.
- Muestre la representación de la persona con menor DNI.
 */
