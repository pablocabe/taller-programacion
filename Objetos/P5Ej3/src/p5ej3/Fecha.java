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
public class Fecha {
    private String ciudad;
    private int diaGira;
    
    public Fecha (String ciudad, int diaGira){
        setCiudad(ciudad);
        setDiaGira(diaGira);
    }
    
    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getDiaGira() {
        return diaGira;
    }

    public void setDiaGira(int diaGira) {
        this.diaGira = diaGira;
    }
    
    
}
