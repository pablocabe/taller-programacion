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
public class EventoOcasional extends Recital{
    private String motivo;
    private String nombreContratante;
    private int diaEventoOcasional;
    
    public EventoOcasional (String nombreBanda, int cantidadTemas, String motivo, String nombreContratante, int diaEventoOcasional){
        super(nombreBanda, cantidadTemas);
        setMotivo(motivo);
        setNombreContratante(nombreContratante);
        setDiaEventoOcasional(diaEventoOcasional);
    }
    
    /*@Override
    public void actuar(){
        switch (getMotivo()) {
            case "Beneficiencia":
                System.out.println("Recuerden colaborar con" + getNombreContratante());
                break;
            case "TV":
                System.out.println("Saludos amigos televidentes");
                break;
            default:
                System.out.println("Un feliz cumpleaños para " + getNombreContratante());
                break;
        }
        super.actuar();
    }
    */
        
    @Override
    public void actuar(){
        if (getMotivo().equals("Beneficiencia")){
            System.out.println("Recuerden colaborar con" + getNombreContratante());
        }
        else if (getMotivo().equals("TV")){
            System.out.println("Saludos amigos televidentes");
        }
        else {
            System.out.println("Un feliz cumpleaños para " + getNombreContratante());
        }
        super.actuar();
    }
    
    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getNombreContratante() {
        return nombreContratante;
    }

    public void setNombreContratante(String nombreContratante) {
        this.nombreContratante = nombreContratante;
    }

    public int getDiaEventoOcasional() {
        return diaEventoOcasional;
    }

    public void setDiaEventoOcasional(int diaEventoOcasional) {
        this.diaEventoOcasional = diaEventoOcasional;
    }

    @Override
    public double calcularCosto() {
        double aux;
        if (getMotivo().equals("Beneficiencia")){
            aux = 0;
        }
        else if (getMotivo().equals("TV")){
            aux = 50000;
        }
        else {
            aux = 150000;
        }
        return aux;
    }
    
}
