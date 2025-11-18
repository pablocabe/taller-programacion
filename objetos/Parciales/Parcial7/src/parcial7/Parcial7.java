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
public class Parcial7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AlumnoGrado alumnoGrado = new AlumnoGrado ("Pablo",43600403, 20,"Informática");
        AlumnoDoctorado alumnoDoctorado = new AlumnoDoctorado ("Matías", 1111111, 10, "Periodismo", "UNLP");
        
        Materia materia1 = new Materia("Matematica", 7, 21);
        Materia materia2 = new Materia ("Taller de Programación", 10, 18);
        
        alumnoGrado.agregarMateria(materia1);
        alumnoDoctorado.agregarMateria(materia2);
        
        System.out.println(alumnoGrado.toString());
        System.out.println(alumnoDoctorado.toString());
    }
    
}
