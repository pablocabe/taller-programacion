/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial7;

/**
 *
 * @author Pablo
 */
public class AlumnoDoctorado extends Alumno{
    private String tituloUniversitario;
    private String universidadOrigen;
    
    public AlumnoDoctorado(String nombreAlumno, int DNI, int cantidadMaxima, 
           String tituloUniversitario, String universidadOrigen){
        super(nombreAlumno, DNI, cantidadMaxima);
        this.tituloUniversitario = tituloUniversitario;
        this.universidadOrigen = universidadOrigen;
    }
    
    @Override
    public String toString(){
        String aux = super.toString();
        aux += ". Título: " + this.tituloUniversitario + ". Universidad de origen: " + this.universidadOrigen;
        return aux;
    }
}
