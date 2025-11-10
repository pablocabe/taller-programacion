/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial1;

/**
 *
 * @author Pablo
 */
public class BancoTradicional extends Banco{
    private String direccion;
    private String localidad;
    private int cantidadCuentasDolares;

    public BancoTradicional(String nombreBanco, int cantidadEmpleados, int maxCuentas, String direccion, String localidad){
        super(nombreBanco, cantidadEmpleados, maxCuentas);
        setDireccion(direccion);
        setLocalidad(localidad);
        setCantidadCuentasDolares(0);
    }
    
    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public int getCantidadCuentasDolares() {
        return cantidadCuentasDolares;
    }

    public void setCantidadCuentasDolares(int cantidadCuentasDolares) {
        this.cantidadCuentasDolares = cantidadCuentasDolares;
    }

    @Override
    public boolean agregarCuenta(Cuenta unaCuenta) {
        boolean aux = false;
        if (unaCuenta.getMoneda().equals("Dolares")){
            if (getCantidadCuentasDolares()<100){
                aux = super.agregarCuenta(unaCuenta);
            }
            else {
                aux = false;
            }
        }
        else {
            aux = super.agregarCuenta(unaCuenta);
        }
        return aux;
    }

    @Override
    public boolean puedeRecibirTarjeta(int CBUX) { // acá se podría hacer un (x and x) or (x and x)
        boolean aux = false;
        Cuenta cuentaAux = obtenerCuenta(CBUX);
        if (cuentaAux != null){
            if ((cuentaAux.getMoneda().equals("Dolares")) && (cuentaAux.getMonto()>500)){
                aux = true;
            }
            else if ((cuentaAux.getMoneda().equals("Pesos")) && (cuentaAux.getMonto()>70000)){
                aux = true;
            }
        }
        return aux;
    }

}
