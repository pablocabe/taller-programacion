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
public class Cuenta {
    private int CBU;
    private String alias;
    private int DNI;
    private String moneda;
    private double monto;

	public Cuenta(int CBU, String alias, int DNI, String moneda) {
		this.CBU = CBU;
		this.alias = alias;
		this.DNI = DNI;
		this.moneda = moneda;
		this.monto = 0;
	}
	
	public void ingresarDinero(double montoX) {
		this.monto += montoX;
	}

	boolean puedeRecibirTarjeta() {
		return ((this.moneda.equals("Dolares")) && (this.monto > 500)) ||
				((this.moneda.equals("Pesos")) && (this.monto >70000));
		
		/*boolean aux = false;
		if ((this.moneda.equals("Dolares")) && (this.monto > 500)){
			aux = true;
		}
		else if ((this.moneda.equals("Pesos")) && (this.monto >70000)){
			aux = true;
		}
		return aux;*/
	}
	
	boolean esMoneda(String moneda) {
		return this.moneda.equals(moneda);
	} 
}
