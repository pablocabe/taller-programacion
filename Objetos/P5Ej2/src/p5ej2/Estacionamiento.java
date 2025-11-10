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
public class Estacionamiento {
    private String nombre;
    private String direccion;
    private int horaApertura;
    private int horaCierre;
    private int cantidadPisos;
    private int cantidadPlazas;
    private Auto [][] matrizEstacionamiento;
    
    public Estacionamiento (String nombre, String direccion){
        setNombre(nombre);
        setDireccion(direccion);
        setHoraApertura(8);
        setHoraCierre(21);
        setCantidadPisos(5);
        setCantidadPlazas(10);
        matrizEstacionamiento = new Auto [getCantidadPisos()][getCantidadPlazas()];
        inicializarMatriz();
    }
    
    public Estacionamiento (String nombre, String direccion, 
            int horaApertura, int horaCierre, int cantidadPisos, int cantidadPlazas){
        setNombre(nombre);
        setDireccion(direccion);
        setHoraApertura(horaApertura);
        setHoraCierre(horaCierre);
        setCantidadPisos(cantidadPisos);
        setCantidadPlazas(cantidadPlazas);
        matrizEstacionamiento = new Auto [getCantidadPisos()][getCantidadPlazas()];
        inicializarMatriz();
    }

    public void inicializarMatriz(){
        for (int i=0 ; i<getCantidadPisos() ; i++){
            for (int j=0 ; j<getCantidadPlazas() ; j++){
                matrizEstacionamiento[i][j] = null;
            }
        }
    }
    
    public void agregarAuto(Auto A, int X, int Y){
        matrizEstacionamiento[X-1][Y-1] = A;
    }
    
    public String buscarPatente (String patenteX){
        String aux = "Auto inexistente";
        int i=0, j;
        boolean encontre = false;
        while ((!encontre) && (i<getCantidadPisos())){
            j=0;
            while ((!encontre) && (j<getCantidadPlazas())){
                if ((matrizEstacionamiento[i][j] != null) && (matrizEstacionamiento[i][j].getPatente().equals(patenteX))){
                    encontre = true;
                    aux = "El auto se encuentra en el piso " + (i+1) + ", plaza " + (j+1);
                }
                else {
                    j++;
                }
            }
            if (!encontre) {
                i++;
            }
        }
        return aux;
    }
    
    // Bucle infinito por el i++ dentro del segundo while
    /* public String buscarPatente (String patenteX){
        String aux = "Auto inexistente";
        int i=0, j=0;
        boolean encontre = false;
        while ((!encontre) && (i<getCantidadPisos())){
            while ((!encontre) && (j<getCantidadPlazas())){
                if ((matrizEstacionamiento[i][j] != null) && (matrizEstacionamiento[i][j].getPatente().equals(patenteX))){
                    encontre = true;
                    aux = "El auto se encuentra en el piso " + (i+1) + ", plaza " + (j+1);
                }
                else {
                    j++;
                }
                if (j == getCantidadPlazas()){
                    j=0;
                    i++;
                }
            }
        }
        return aux;
    }
    */
    
    public int cantidadAutos (int plazaX){
        int aux = 0;
        for (int i=0 ; i<getCantidadPisos() ; i++){
            if (matrizEstacionamiento[i][plazaX-1] != null) {
                aux++;
            }
        }
        return aux;
    }

    @Override
    public String toString(){
        String aux;
        aux = "Comenzará la impresión del estacionamiento\n";
        for (int i=0 ; i<getCantidadPisos() ; i++){
            aux += "Se informará sobre el piso N°"+(i+1)+"\n";
            for (int j=0 ; j<getCantidadPlazas() ; j++){
                if (matrizEstacionamiento[i][j] != null){
                    aux += "Piso "+(i+1) + " Plaza "+(j+1)+ ": " + matrizEstacionamiento[i][j].toString();
                }
                else {
                    aux += "Piso "+(i+1) + " Plaza "+(j+1)+ ": Libre";
                }
                aux += "\n";
            }
        }
        return aux;
    }
    
    public int getCantidadPisos() {
        return cantidadPisos;
    }

    public void setCantidadPisos(int cantidadPisos) {
        this.cantidadPisos = cantidadPisos;
    }

    public int getCantidadPlazas() {
        return cantidadPlazas;
    }

    public void setCantidadPlazas(int cantidadPlazas) {
        this.cantidadPlazas = cantidadPlazas;
    }
            
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getHoraApertura() {
        return horaApertura;
    }

    public void setHoraApertura(int horaApertura) {
        this.horaApertura = horaApertura;
    }

    public int getHoraCierre() {
        return horaCierre;
    }

    public void setHoraCierre(int horaCierre) {
        this.horaCierre = horaCierre;
    }
}
