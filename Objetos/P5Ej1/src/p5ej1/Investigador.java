/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p5ej1;

/**
 *
 * @author Pablo
 */
public class Investigador {
    private String nombre;
    private int categoria;
    private String especialidad;
    private int cantidadSubsidios;
    private Subsidio [] vectorSubsidios;
    
    public Investigador (String nombre, int categoria, String especialidad){
        setNombre(nombre);
        setCategoria(categoria);
        setEspecialidad(especialidad);
        setCantidadSubsidios(0);
        vectorSubsidios = new Subsidio [5];
    }

    public int getCantidadSubsidios() {
        return cantidadSubsidios;
    }

    public void setCantidadSubsidios(int cantidadSubsidios) {
        this.cantidadSubsidios = cantidadSubsidios;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    public void agregarSubsidio(Subsidio unSubsidio){
        if (this.getCantidadSubsidios() < 5) {
            vectorSubsidios[getCantidadSubsidios()] = unSubsidio;
            setCantidadSubsidios(getCantidadSubsidios()+1);
        }
    }
    
    public double dineroInvestigadorOtorgado (){
        double aux = 0;
        for (int i=0 ; i<getCantidadSubsidios() ; i++){
            aux += vectorSubsidios[i].getMontoPedido();
            //aux += vectorSubsidios[i].dineroSubsidioOtorgado();
        }
        return aux;
    }
    
    public void otorgarSubsidios(){
        for (int i=0; i<getCantidadSubsidios() ; i++){
            if(!vectorSubsidios[i].isOtorgado()){
                vectorSubsidios[i].setOtorgado(true);
            }
        }
    }
    
    @Override
    public String toString(){
        String aux = "Nombre: " + getNombre() + 
                ", especialidad: " + getEspecialidad() +
                ", total de dinero de sus subsidios otorgados: " + this.dineroInvestigadorOtorgado();
        return aux;
    }
}
