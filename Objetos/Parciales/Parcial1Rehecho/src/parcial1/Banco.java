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
        this.nombreBanco = nombreBanco;
        this.cantidadEmpleados = cantidadEmpleados;
        this.cuentasAgregadasDL = 0;
		this.cuentasMaximasDF = maxCuentas;
        vectorCuentas = new Cuenta [maxCuentas];
    }
    
    public boolean hayEspacio(){
        return (this.cuentasAgregadasDL < this.cuentasMaximasDF);
    }

    public boolean agregarCuenta(Cuenta unaCuenta){
		if (!hayEspacio()) return false;
		vectorCuentas[this.cuentasAgregadasDL] = unaCuenta;
		this.cuentasAgregadasDL++;
		return true;
    }
    
    public Cuenta obtenerCuenta (int CBUX){ // esto lo tengo que modularizar?
        Cuenta aux = null;
        int i=0;
        boolean encontre = false;
        while ((!encontre) && (i<this.cuentasAgregadasDL)){
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
			cuentaAux.ingresarDinero(montoX);
            // cuentaAux.setMonto(cuentaAux.getMonto() + montoX);
            System.out.println("Se incrementó correctamente el monto de la cuenta");
        }
        else{
            System.out.println("No se encontró una cuenta con el CBU " + CBUX);
        }
    }
    
    public abstract boolean puedeRecibirTarjeta(int CBUX); // este está mal? repito parte del código en ambos
}
