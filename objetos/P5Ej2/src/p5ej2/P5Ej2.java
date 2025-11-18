/*
Realice un programa que instancie un estacionamiento con 3 pisos y 3 plazas por piso.
Registre 6 autos en el estacionamiento en distintos lugares.
Muestre la representación String del estacionamiento en consola.
Muestre la cantidad de autos ubicados en la plaza 1.
Lea una patente por teclado e informe si dicho auto se encuentra en el estacionamiento
o no. En caso de encontrarse, la información a imprimir es el piso y plaza que ocupa
 */
package p5ej2;
import PaqueteLectura.Lector;
/**
 *
 * @author Pablo
 */
public class P5Ej2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Se ingresará información sobre un estacionamiento");
        System.out.println("Ingrese el nombre y dirección del estacionamiento");
        String nombreEstacionamiento = Lector.leerString();
        String direccionEstacionamiento = Lector.leerString();
        System.out.println("Ingrese el horario de apertura y cierre");
        int apertura = Lector.leerInt();
        int cierre = Lector.leerInt();
        System.out.println("Ingrese la cantidad de pisos y plazas");
        int pisos = Lector.leerInt();
        int plazas = Lector.leerInt();
        Estacionamiento estacionamiento = new Estacionamiento (nombreEstacionamiento, 
                        direccionEstacionamiento, apertura, cierre, pisos, plazas);
        System.out.println("Se ingresará informaciones sobre 6 autos");
        int piso, plaza;
        String nombreDueño, patente;
        for (int i=0 ; i<6 ; i++){
            System.out.println("Ingrese nombre del dueño y patente del auto");
            nombreDueño = Lector.leerString();
            patente = Lector.leerString();
            Auto auto = new Auto (nombreDueño, patente);
            System.out.println("Ingrese el piso y plaza donde se ubica");
            piso = Lector.leerInt();
            plaza = Lector.leerInt();
            estacionamiento.agregarAuto(auto, piso, plaza);
        }
        System.out.println("\n");
        System.out.println(estacionamiento.toString());
        System.out.println("\n");
        System.out.println("Ingrese la plaza de la cual se contabilizarán los autos");
        int plazaX = Lector.leerInt();
        System.out.println("La cantidad de autos es: " + estacionamiento.cantidadAutos(plazaX));
        System.out.println("Ingrese la patente que se buscará en el estacionamiento");
        String patenteX = Lector.leerString();
        System.out.println(estacionamiento.buscarPatente(patenteX));
    }
    
}
