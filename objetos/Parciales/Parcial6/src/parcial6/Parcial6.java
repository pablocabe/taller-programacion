/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial6;

/**
 *
 * @author Pablo
 */
public class Parcial6 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Fecha fecha = new Fecha (2, 4);
        Alumno alumno1 = new Alumno ("Pablo", 43600403);
        Alumno alumno2 = new Alumno ("Matías", 1111111);
        Alumno alumno3 = new Alumno ("Valentín", 22222);
        Alumno alumno4 = new Alumno ("Jose", 777777);
        fecha.agregarAlumno(1, alumno1);
        fecha.agregarAlumno(2, alumno2);
        fecha.agregarAlumno(1, alumno3);
        fecha.agregarAlumno(2, alumno4);
        
        fecha.asignarTemas(3);
        
        System.out.println(fecha.stringTemaT(2));
    }
    
}
