/*
Realice un programa que instancie un evento ocasional y una gira, cargando la
información necesaria. Luego, para ambos, imprima el costo e invoque al mensaje actuar.
 */
package p5ej3;
import PaqueteLectura.Lector;
/**
 *
 * @author Pablo
 */
public class P5Ej3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Se cargará información sobre un evento ocasional y una gira");
        String nombreBanda;
        int cantidadTemas;
        
        System.out.println("Primero se ingresará información sobre el evento ocasional");
        System.out.println("Ingrese nombre de la banda y cantidad de temas");
        // en ninguna parte el enunciado dice que se trata de la misma banda en el evento y la gira a cargar
        nombreBanda = Lector.leerString();
        cantidadTemas = Lector.leerInt();
        System.out.println("Ingrese motivo, nombre del contratante y el día del evento ocasional");
        String motivo = Lector.leerString();
        String nombreContratante = Lector.leerString();
        int diaEventoOcasional = Lector.leerInt();
        EventoOcasional eventoOcasional = new EventoOcasional
        (nombreBanda, cantidadTemas, motivo, nombreContratante, diaEventoOcasional);
        
        System.out.println("Ingrese el nombre de cada tema");
        for (int i=0 ; i < eventoOcasional.getCantidadTemasDF() ; i++){
            String nombreTema = Lector.leerString();
            eventoOcasional.agregarTema(nombreTema);
        }
        
        System.out.println("Ahora se ingresará información sobre la gira");
        System.out.println("Ingrese nombre de la banda y cantidad de temas");
        nombreBanda = Lector.leerString();
        cantidadTemas = Lector.leerInt();
        System.out.println("Ingrese nombre de la gira y cantidad de fechas, ");
        String nombreGira = Lector.leerString();
        int cantidadFechas = Lector.leerInt();
        Gira gira = new Gira (nombreBanda, cantidadTemas, nombreGira, cantidadFechas);
        
        System.out.println("Ingrese el nombre de cada tema");
        for (int i=0 ; i < gira.getCantidadTemasDF() ; i++){
            String nombreTema = Lector.leerString();
            gira.agregarTema(nombreTema);
        }
        
        System.out.println("Ahora se ingresará información sobre las fechas de la gira");
        for (int i=0 ; i<gira.getCantidadFechasDF() ; i++){
            System.out.println("Ingrese ciudad y día de la gira en la Fecha N°" + (i+1));
            String ciudad = Lector.leerString();
            int diaGira = Lector.leerInt();
            Fecha fecha = new Fecha (ciudad, diaGira);
            gira.agregarFecha(fecha);
        }
        
        System.out.println("Costo del evento ocasional: " + eventoOcasional.calcularCosto());
        System.out.println("Costo de la gira: " + gira.calcularCosto());
        eventoOcasional.actuar();
        gira.actuar();
    }
    
}
