/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial7;
import PaqueteLectura.GeneradorAleatorio;
/**
 *
 * @author Pablo
 */
public class Alumno {
    private String nombreAlumno;
    private int DNI;
    private int cantidadMateriasDF;
    private int cantidadMateriasAgregadasDL;
    private Materia [] vectorMateriasAprobadas;
    
    
    public Alumno (String nombreAlumno, int DNI, int cantidadMaxima){
        this.nombreAlumno = nombreAlumno;
        this.DNI = DNI;
        this.cantidadMateriasDF = cantidadMaxima;
        this.cantidadMateriasAgregadasDL = 0;
        vectorMateriasAprobadas = new Materia [cantidadMaxima];
        for (int i=0 ; i<cantidadMateriasDF ; i++){
            vectorMateriasAprobadas[i] = null;
        }
    }
    
    public void agregarMateria (Materia unaMateria){
        vectorMateriasAprobadas[cantidadMateriasAgregadasDL] = unaMateria;
        cantidadMateriasAgregadasDL++;
    }
    
    public boolean aproboTesis (){
        boolean aux = false;
        int i=0;
        while ((!aux) && (i<cantidadMateriasAgregadasDL)){
            if (vectorMateriasAprobadas[i].esTesis()){
                aux = true;
            }
            i++;
        }
        return aux;
    }
    
    // No dice un mínimo de N materias, dice que puntualmente tiene que ser esa cantidad N, sino sería >=
    public boolean estaGraduado (int N){
        return ((N == cantidadMateriasAgregadasDL) && (aproboTesis()));
    }
    
    @Override
    public String toString(){
        String aux ="DNI " + this.DNI + "Nombre: " + this.nombreAlumno + ". Materias aprobadas: ";
        for (int i=0 ; i<cantidadMateriasAgregadasDL ; i++){
            aux += vectorMateriasAprobadas[i].toString();
        }
        aux += ". Está graduado: " + estaGraduado(GeneradorAleatorio.generarInt(5));
        return aux;
    }
}
