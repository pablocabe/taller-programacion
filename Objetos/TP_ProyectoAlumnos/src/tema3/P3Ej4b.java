/*
 4-A- Un hotel posee N habitaciones. De cada habitación conoce costo por noche, si está
ocupada y, en caso de estarlo, guarda el cliente que la reservó (nombre, DNI y edad).
(i) Genere las clases necesarias. Para cada una provea métodos getters/setters adecuados.
(ii) Implemente los constructores necesarios para iniciar: los clientes a partir de nombre,
DNI, edad; el hotel para N habitaciones, cada una desocupada y con costo aleatorio e/ 2000
y 8000.
(iii) Implemente en las clases que corresponda todos los métodos necesarios para:
- Ingresar un cliente C en la habitación número X. Asuma que X es válido (es decir, está
en el rango 1..N) y que la habitación está libre.
- Aumentar el precio de todas las habitaciones en un monto recibido.
- Obtener la representación String del hotel, siguiendo el formato:
{Habitación 1: costo, libre u ocupada, información del cliente si está ocupada}
…
{Habitación N: costo, libre u ocupada, información del cliente si está ocupada}
B- Realice un programa que instancie un hotel, ingrese clientes en distintas habitaciones,
muestre el hotel, aumente el precio de las habitaciones y vuelva a mostrar el hotel.
 */
package tema3;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

/**
 *
 * @author Pablo
 */
public class P3Ej4b {
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        int numeroHabitaciones;
        System.out.println("Ingrese la cantidad de habitaciones que posee el hotel:");
        numeroHabitaciones = Lector.leerInt();
        Hotel hotel = new Hotel (numeroHabitaciones);
        for (int i=0 ; i<numeroHabitaciones ; i++){
            Cliente C = new Cliente (GeneradorAleatorio.generarString(5),
                    GeneradorAleatorio.generarInt(1000), GeneradorAleatorio.generarInt(100));
            hotel.agregarCliente(C, i);
        }
        System.out.println(hotel.toString(numeroHabitaciones));
        System.out.println("Ingrese el aumento que recibirán las habitaciones");
        double monto = Lector.leerDouble();
        hotel.aumentarPrecios(monto, numeroHabitaciones);
        System.out.println(hotel.toString(numeroHabitaciones));
    }
}
