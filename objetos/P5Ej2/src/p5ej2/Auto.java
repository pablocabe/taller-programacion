/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p5ej2;

/**
 *
 * @author Pablo
 */
public class Auto {
    private String nombreDueño;
    private String patente;
    
    public Auto (String nombreDueño, String patente){
        setNombreDueño(nombreDueño);
        setPatente(patente);
    }
    
    public String getNombreDueño() {
        return nombreDueño;
    }

    public void setNombreDueño(String nombre) {
        this.nombreDueño = nombre;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }
    
    @Override
    public String toString(){
      String aux = "Nombre del dueño: " + getNombreDueño() + ", Patente: " + getPatente();
      return aux;
    }
    
}
