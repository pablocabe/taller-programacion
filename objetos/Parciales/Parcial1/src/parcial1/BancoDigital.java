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
public class BancoDigital extends Banco{
    private String direccionWeb;

    public BancoDigital (String nombreBanco, int cantidadEmpleados, int maxCuentas,String direccionWeb){
        super(nombreBanco, cantidadEmpleados, maxCuentas);
        setDireccionWeb(direccionWeb);
    }
    public String getDireccionWeb() {
        return direccionWeb;
    }

    public void setDireccionWeb(String direccionWeb) {
        this.direccionWeb = direccionWeb;
    }

    @Override
    public boolean agregarCuenta(Cuenta unaCuenta) {
        boolean aux = false;
        aux = super.agregarCuenta(unaCuenta);
        return aux;
    }

    @Override
    public boolean puedeRecibirTarjeta(int CBUX) {
        boolean aux = false;
        Cuenta cuentaAux = obtenerCuenta(CBUX);
        if (cuentaAux != null){
            if ((cuentaAux.getMoneda().equals("Pesos")) && (cuentaAux.getMonto()>100000)){
                aux = true;
            }
        }
        return aux;
    }
    
    
}
