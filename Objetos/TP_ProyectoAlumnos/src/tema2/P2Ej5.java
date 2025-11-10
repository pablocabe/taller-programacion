/*
 5- Se dispone de la clase Partido (en la carpeta tema2). Un objeto partido representa un
encuentro entre dos equipos (local y visitante). Un objeto partido puede crearse sin
valores iniciales o enviando en el mensaje de creación el nombre del equipo local, el
nombre del visitante, la cantidad de goles del local y del visitante (en ese orden). Un objeto
partido sabe responder a los siguientes mensajes:

getLocal() retorna el nombre (String) del equipo local
getVisitante() retorna el nombre (String) del equipo visitante
getGolesLocal() retorna la cantidad de goles (int) del equipo local
getGolesVisitante() retorna la cantidad de goles (int) del equipo visitante
setLocal(X) modifica el nombre del equipo local al “String” X
setVisitante(X) modifica el nombre del equipo visitante al “String” X
setGolesLocal(X) modifica la cantidad de goles del equipo local al “int” X
setGolesVisitante(X) modifica la cantidad de goles del equipo visitante al “int” X
hayGanador() retorna un boolean que indica si hubo (true) o no hubo (false) ganador
getGanador() retorna el nombre (String) del ganador del partido (si no hubo retorna
un String vacío).
hayEmpate() retorna un boolean que indica si hubo (true) o no hubo (false) empate

Implemente un programa que cargue un vector con a lo sumo 20 partidos disputados en
el campeonato. La información de cada partido se lee desde teclado hasta ingresar uno con
nombre de visitante “ZZZ” o alcanzar los 20 partidos. Luego de la carga:
- Para cada partido, armar e informar una representación String del estilo:
{EQUIPO-LOCAL golesLocal VS EQUIPO-VISITANTE golesVisitante }
- Calcular e informar la cantidad de partidos que ganó River.
- Calcular e informar el total de goles que realizó Boca jugando de local.
 */
package tema2;
import PaqueteLectura.Lector;
/**
 *
 * @author Pablo
 */
public class P2Ej5 {
    public static void main(String[] args) {
        int dF = 20;
        // Cada posición representa un partido
        Partido [] vector = new Partido [dF];
        int dL = 0;
        System.out.println("Ingrese el nombre del equipo local");
        String equipoL = Lector.leerString();
        System.out.println("Ingrese el nombre del equipo visitante");
        String equipoV = Lector.leerString();
        while ((!equipoV.equals("ZZZ")) && (dL < dF)){
            System.out.println("Ingrese goles del local");
            int golL = Lector.leerInt();
            System.out.println("Ingrese goles del visitante");
            int golV = Lector.leerInt();
            vector[dL] = new Partido (equipoL, equipoV, golL, golV);
            dL++;
            System.out.println("Ingrese el nombre del equipo local");
            equipoL = Lector.leerString();
            System.out.println("Ingrese el nombre del equipo visitante");
            equipoV = Lector.leerString();
        }
        int victoriasRiver = 0;
        int golesBocaLocal = 0;
        for (int i=0 ; i<dL ; i++) {
            System.out.println(vector[i].getLocal()+" "+ vector[i].getGolesLocal()+
                    " VS " + vector[i].getVisitante()+" "+ vector[i].getGolesVisitante());
            if (vector[i].getGanador().equals("River")){
                victoriasRiver++;
            }
            if (vector[i].getLocal().equals("Boca")) {
                golesBocaLocal = golesBocaLocal + vector[i].getGolesLocal();
            }
        }
        System.out.println("La cantidad de victorias de River es: " + victoriasRiver);
        System.out.println("La cantidad de goles de Boca como local es: " + golesBocaLocal);
    }
}