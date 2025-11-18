/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

/**
 *
 * @author Pablo
 */
public class Estacion {
    private String nombre;
    private double latitud;
    private double longitud;
    private int cantidadAnios;
    private int primerAnio;
    
    public Estacion (String nombre, double latitud, double longitud, int cantidadAnios, int primerAnio){
        setNombre(nombre);
        setLatitud(latitud);
        setLongitud(longitud);
        setCantidadAnios(cantidadAnios);
        setPrimerAnio(primerAnio);
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public int getCantidadAnios() {
        return cantidadAnios;
    }

    public void setCantidadAnios(int cantidadAnios) {
        this.cantidadAnios = cantidadAnios;
    }

    public int getPrimerAnio() {
        return primerAnio;
    }

    public void setPrimerAnio(int primerAnio) {
        this.primerAnio = primerAnio;
    }
}
