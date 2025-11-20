/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial9;

/**
 *
 * @author Pablo
 */
public class Estacionamiento {
    private String direccion;
    private double costoHora;
    private Vehiculo [] [] matrizEstacionamiento; // S sectores y V vehículos por sector
    private int cantidadSectores;
    private int cantidadVehiculos;
    
    public Estacionamiento(String direccion, double costoHora, int S, int V){
        this.direccion = direccion;
        this.costoHora = costoHora;
        this.cantidadSectores = S;
        this.cantidadVehiculos = V;
        matrizEstacionamiento = new Vehiculo [S][V];
        inicializarMatriz();
    }
    
    public void inicializarMatriz(){
        for (int i=0 ; i<cantidadSectores ; i++){
            for (int j=0 ; j<cantidadVehiculos ; j++){
                matrizEstacionamiento[i][j] = null;
            }
        }
    }
    
    // Se asume que están X e Y están en el rango y hay espacio
    public void registrarVehiculo (int X, int Y, Vehiculo unVehiculo){
        matrizEstacionamiento[X-1][Y-1] = unVehiculo;
    }
    
    
    public String liberarLugares (String marcaM, int sectorX){
        String aux = "Los siguientes vehículos ya no tienen acceso: \n";
        for (int j=0 ; j<cantidadVehiculos ; j++){
            if ((matrizEstacionamiento[sectorX-1][j] != null) && (matrizEstacionamiento[sectorX-1][j].esMarcaM(marcaM))) {
                aux += matrizEstacionamiento[sectorX-1][j].toString();
                matrizEstacionamiento[sectorX-1][j] = null;
            }
        }
        return aux;
    }
    
    public int obtenerMayorRecaudacion(){
        int maxSector = -1;
        double cantidadMaxima = -1;
        double cantidadActual;
        for (int i=0 ; i<cantidadSectores ; i++){
            cantidadActual = 0;
            for (int j=0 ; j<cantidadVehiculos ; j++){
                if (matrizEstacionamiento[i][j] != null){
                    cantidadActual += (matrizEstacionamiento[i][j].getHorasEstacionado() * costoHora);
                }
            }
            if (cantidadActual > cantidadMaxima){
                cantidadMaxima = cantidadActual;
                maxSector = (i+1);
            }
        }
        return (maxSector);
    }
    
    @Override
    public String toString(){
        String aux = "Estacionamiento: dirección " + this.direccion + ", costo por hora " + this.costoHora + "\n";
        for (int i=0 ; i<cantidadSectores ; i++){
            aux += "Sector" + (i+1) + "\n";
            for (int j=0 ; j<cantidadVehiculos ; j++){
                if (matrizEstacionamiento[i][j] == null){
                    aux += "Lugar " + (j+1) + ": está libre \n";
                }
                else {
                    aux += "Lugar " + (j+1) + ": " + matrizEstacionamiento[i][j].toString();
                }
            }
        }
        return aux;
    }
}

