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
public class Proyecto {
    private String nombre;
    private int codigo;
    private String nombreDirector;
    private Investigador [] vectorInvestigadores;
    private int cantidadInvestigadores;
    
    public Proyecto (String nombre, int codigo, String nombreDirector){
        setNombre(nombre);
        setCodigo(codigo);
        setNombreDirector(nombreDirector);
        setCantidadInvestigadores(0); // tengo que hacer este set o puedo aisgnarlo directo? Cambiaría el agregarInvestigador
        vectorInvestigadores = new Investigador [50];
    }

    public int getCantidadInvestigadores() {
        return cantidadInvestigadores;
    }

    public void setCantidadInvestigadores(int cantidadInvestigadores) {
        this.cantidadInvestigadores = cantidadInvestigadores;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombreDirector() {
        return nombreDirector;
    }

    public void setNombreDirector(String nombreDirector) {
        this.nombreDirector = nombreDirector;
    }
    // 
    public void agregarInvestigador(Investigador unInvestigador){
        if (this.getCantidadInvestigadores() < 50){
            vectorInvestigadores [getCantidadInvestigadores()] = unInvestigador;
            setCantidadInvestigadores(getCantidadInvestigadores()+ 1);
        }
    }
    
    /* Rendimiento y claridad: Usar getCantidadInvestigadores() y setCantidadInvestigadores() 
    puede ser menos eficiente en comparación con acceder directamente a la variable cantInvestigadores,
    ya que implica llamar a métodos adicionales. Sin embargo, en un contexto donde quieres encapsular 
    el acceso a las variables privadas (como en buenas prácticas de OOP), esto puede hacer que el código 
    sea más modular y más fácil de mantener.
    */
    
    public double dineroTotalOtorgado(){
        double aux = 0;
        for (int i=0 ; i<getCantidadInvestigadores() ; i++){
            aux += vectorInvestigadores[i].dineroInvestigadorOtorgado();
        }
        return aux;
    }
    
    public void otorgarTodos(String nombre_completo){
        int i = 0;
        while ((i<getCantidadInvestigadores()) && (!vectorInvestigadores[i].getNombre().equals(nombre_completo))){
            i++;
        }
        if (i<getCantidadInvestigadores()){
            vectorInvestigadores[i].otorgarSubsidios();
        }
    }
    
    @Override
    public String toString(){
        String aux = "Nombre del proyecto: " + getNombre() + 
                ", codigo: " + getCodigo() + 
                ", nombre del director: " + getNombreDirector() +
                ", dinero total otorgado del proyecto: " + this.dineroTotalOtorgado();
        aux += ".\nInformacion sobre cada investigador:\n";
        for (int i=0 ; i<getCantidadInvestigadores() ; i++){
            aux += vectorInvestigadores[i].toString();
            aux += "\n";
        }
        return aux;
    }
}
