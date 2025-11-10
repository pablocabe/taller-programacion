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
public class AlumnoGrado extends Alumno{
    private String carrera;
    
    public AlumnoGrado (String nombreAlumno, int DNI, int cantidadMaxima, String carrera){
        super(nombreAlumno, DNI, cantidadMaxima);
        this.carrera = carrera;
    }
    
    @Override
    public String toString(){
        String aux = super.toString();
        aux += ". Carrera: " + this.carrera;
        return aux;
    }
}
