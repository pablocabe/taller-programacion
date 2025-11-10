/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema2;

import PaqueteLectura.Lector;

/**
 *
 * @author Pablo
 */
public class P2Ej3a {
// en el 3b corregí varias cosas
    public static void main(String[] args) {
        Persona[][] matriz = new Persona[5][8];
        Persona p = new Persona();
        System.out.println("Comienza el casting");
        System.out.println("Ingrese el nombre");
        p.setNombre(Lector.leerString());
        System.out.println("Ingrese el DNI");
        p.setDNI(Lector.leerInt());
        System.out.println("Ingrese la edad");
        p.setEdad(Lector.leerInt());
        int j = 0, i = 0;
        while ((p.getNombre().equals("ZZZ")) && (i < 5)) {
            while ((p.getNombre().equals("ZZZ")) && (j < 8)) {
                matriz[i][j] = p;
                p = new Persona();
                System.out.println("Ingrese el nombre");
                p.setNombre(Lector.leerString());
                System.out.println("Ingrese el DNI");
                p.setDNI(Lector.leerInt());
                System.out.println("Ingrese la edad");
                p.setEdad(Lector.leerInt());
                j++;
            }
            if (p.getNombre().equals("ZZZ")) {
                i++;
                j = 0;
            }
        }
    }
}


/*
3- Se realizará un casting para un programa de TV. El casting durará a lo sumo 5 días y en
cada día se entrevistarán a 8 personas en distinto turno.
a) Simular el proceso de inscripción de personas al casting. A cada persona se le pide
nombre, DNI y edad y se la debe asignar en un día y turno de la siguiente manera: las
personas primero completan el primer día en turnos sucesivos, luego el segundo día y así
siguiendo. La inscripción finaliza al llegar una persona con nombre “ZZZ” o al cubrirse los
40 cupos de casting.
*/
