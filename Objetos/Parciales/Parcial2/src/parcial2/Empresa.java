/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial2;

/**
 *
 * @author Pablo
 */
public class Empresa {
    private String nombreEmpresa;
    private String direccion;
    private Director director;
    private Encargado [] vectorEncargados;
    private int cantidadSucursalesDF;
    private int cantidadEncargadosAgregadosDL;
    
    public Empresa (String nombreEmpresa, String direccion, Director director, int cantidadSucursales){
        setNombreEmpresa(nombreEmpresa);
        setDireccion(direccion);
        setDirector(director);
        setCantidadSucursalesDF(cantidadSucursales);
        setCantidadEncargadosAgregadosDL(0);
        vectorEncargados = new Encargado [cantidadSucursales];
        for (int i=0 ; i<getCantidadSucursalesDF() ; i++){
            vectorEncargados[i] = null;
        }
    }
    
     public void asignarEncargado (Encargado encargado, int X){
         vectorEncargados[X] = encargado;
         setCantidadEncargadosAgregadosDL(getCantidadEncargadosAgregadosDL()+1);
     }
     
    @Override
    public String toString(){
        String aux = "Nombre " + getNombreEmpresa() + ", dirección " + getDireccion() + ".\n";
        aux += "Director: " + director.toString() + "\n";
        for (int i=0 ; i<getCantidadSucursalesDF() ; i++){
            if (vectorEncargados[i] != null){
                aux += "Sucursal N°" + (i+1) + ". Encargado: " + vectorEncargados[i].toString()+".\n";
            }
            else {
                aux += "La sucurusal N°" + (i+1) + " está libre";
            }
        }
        return aux;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public int getCantidadSucursalesDF() {
        return cantidadSucursalesDF;
    }

    public void setCantidadSucursalesDF(int cantidadSucursalesDF) {
        this.cantidadSucursalesDF = cantidadSucursalesDF;
    }

    public int getCantidadEncargadosAgregadosDL() {
        return cantidadEncargadosAgregadosDL;
    }

    public void setCantidadEncargadosAgregadosDL(int cantidadEncargadosAgregadosDL) {
        this.cantidadEncargadosAgregadosDL = cantidadEncargadosAgregadosDL;
    }
    
}
