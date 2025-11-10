/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p5ej3;

/**
 *
 * @author Pablo
 */
public abstract class Recital {
    private String nombreBanda;
    private String [] listaTemas;
    private int cantidadTemasDF;
    private int cantidadAgregadaDL;
    
    public Recital (String nombreBanda, int cantidadTemas){
        setNombreBranda(nombreBanda);
        listaTemas = new String [cantidadTemas];
        setCantidadTemasDF(cantidadTemas);
        setCantidadAgregadaDL(0);
    }

    public int getCantidadTemasDF() {
        return cantidadTemasDF;
    }

    public void setCantidadTemasDF(int cantidadTemasDF) {
        this.cantidadTemasDF = cantidadTemasDF;
    }

    public int getCantidadAgregadaDL() {
        return cantidadAgregadaDL;
    }

    public void setCantidadAgregadaDL(int cantidadAgregadaDL) {
        this.cantidadAgregadaDL = cantidadAgregadaDL;
    }
    
    public String getNombreBanda() {
        return nombreBanda;
    }

    public void setNombreBranda(String nombreBranda) {
        this.nombreBanda = nombreBranda;
    }
    
    public boolean hayLugar(){
        return (getCantidadAgregadaDL()<getCantidadTemasDF());
    }
    
    public void agregarTema (String nombreTema){
        if (hayLugar()){
            listaTemas[getCantidadAgregadaDL()] = nombreTema;
            setCantidadAgregadaDL(getCantidadAgregadaDL()+1);
        }
    }
    
    public void actuar(){
        for (int i=0 ; i<getCantidadAgregadaDL() ; i++){
            System.out.println("Y ahora tocaremos " + listaTemas[i] + "\n");
        }
    }
    
    public abstract double calcularCosto();
    
}
