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
public class Gira extends Recital{
    private String nombreGira;
    private Fecha [] listaFechas;
    private int actual;
    private int cantidadFechasAgregadasDL;
    private int cantidadFechasDF;
    
    public Gira (String nombreBanda, int cantidadTemas,String nombreGira, int cantidadFechas){
        super(nombreBanda, cantidadTemas);
        setNombreGira(nombreGira);
        listaFechas = new Fecha [cantidadFechas];
        setCantidadFechasDF(cantidadFechas);
        setCantidadFechasAgregadasDL(0);
        setActual(0);
    }
    
    @Override
    public void actuar(){
        System.out.println("Buenas noches " + listaFechas[actual].getCiudad()+ "\n");
        super.actuar();
        setActual(getActual()+1);
    }

    public void agregarFecha (Fecha fecha){
        listaFechas[getCantidadAgregadaDL()] = fecha;
        setCantidadFechasAgregadasDL(getCantidadFechasAgregadasDL()+1);
    }

    public int getCantidadFechasAgregadasDL() {
        return cantidadFechasAgregadasDL;
    }

    public void setCantidadFechasAgregadasDL(int cantidadFechasAgregadasDL) {
        this.cantidadFechasAgregadasDL = cantidadFechasAgregadasDL;
    }

    public int getCantidadFechasDF() {
        return cantidadFechasDF;
    }

    public void setCantidadFechasDF(int cantidadFechasMaximasDF) {
        this.cantidadFechasDF = cantidadFechasMaximasDF;
    }
    
    public String getNombreGira() {
        return nombreGira;
    }

    public void setNombreGira(String nombreGira) {
        this.nombreGira = nombreGira;
    }

    public int getActual() {
        return actual;
    }

    public void setActual(int actual) {
        this.actual = actual;
    }

    @Override
    public double calcularCosto() {
        double aux;
        aux = (getCantidadFechasAgregadasDL()) * 30000;
        return aux;
    }
}
