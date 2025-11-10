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
public abstract class Banco {
    private String nombreBanco;
    private int cantidadEmpleados;
    private Cuenta [] vectorCuentas;
    private int cuentasAgregadasDL;
    private int cuentasMaximasDF;

    public Banco (String nombreBanco, int cantidadEmpleados, int maxCuentas){
        setNombreBanco(nombreBanco);
        setCantidadEmpleados(cantidadEmpleados);
        setCuentasAgregadasDL(0);
        setCuentasMaximasDF(maxCuentas);
        vectorCuentas = new Cuenta [maxCuentas];
    }
    
    public boolean hayEspacio(){
        return (getCuentasAgregadasDL()<getCuentasMaximasDF());
    }

    public boolean agregarCuenta(Cuenta unaCuenta){
        boolean aux = false;
        if (hayEspacio()){
            vectorCuentas[getCuentasAgregadasDL()] = unaCuenta;
            setCuentasAgregadasDL(getCuentasAgregadasDL()+1);
            aux = true;
        }
        return aux;
    }
    
    public Cuenta obtenerCuenta (int CBUX){ // esto lo tengo que modularizar?
        Cuenta aux = null;
        int i=0;
        boolean encontre = false;
        while ((!encontre) && (i<getCuentasAgregadasDL())){
            if (vectorCuentas[i].getCBU() == CBUX){
                encontre = true;
                aux = vectorCuentas[i];
            }
            else {
                i++;
            }
        }
        return aux;
    }
    
    public void depositarDinero (int CBUX, double montoX){
        Cuenta cuentaAux = obtenerCuenta(CBUX);
        if (cuentaAux != null){
            cuentaAux.setMonto(cuentaAux.getMonto() + montoX);
            System.out.println("Se incrementó correctamente el monto de la cuenta");
        }
        else{
            System.out.println("No se encontró una cuenta con el CBU " + CBUX);
        }
    }
    
    public abstract boolean puedeRecibirTarjeta(int CBUX); // este está mal? repito parte del código en ambos
    
    public int getCuentasAgregadasDL() {
        return cuentasAgregadasDL;
    }

    public void setCuentasAgregadasDL(int cuentasAgregadas) {
        this.cuentasAgregadasDL = cuentasAgregadas;
    }

    public int getCuentasMaximasDF() {
        return cuentasMaximasDF;
    }

    public void setCuentasMaximasDF(int cuentasMaximasDF) {
        this.cuentasMaximasDF = cuentasMaximasDF;
    }
    
    public String getNombreBanco() {
        return nombreBanco;
    }

    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    public int getCantidadEmpleados() {
        return cantidadEmpleados;
    }

    public void setCantidadEmpleados(int cantidadEmpleados) {
        this.cantidadEmpleados = cantidadEmpleados;
    }
}
