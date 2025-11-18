/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial1;
import PaqueteLectura.Lector;
/**
 *
 * @author Pablo
 */
public class Parcial1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Se ingresará información sobre bancos");
        String nombreBanco;
        int cantidadEmpleados;
        int cantidadMaxima;
        
        System.out.println("Primero se ingresará información sobre un banco tradicional");
        System.out.println("Ingrese nombre del banco, cantidad de empleados y cantidad máxima de cuentas");
        nombreBanco = Lector.leerString();
        cantidadEmpleados = Lector.leerInt();
        cantidadMaxima = Lector.leerInt();
        System.out.println("Ingrese la dirección y localidad");
        String direccion = Lector.leerString();
        String localidad = Lector.leerString();
        BancoTradicional bancoTradicional = new BancoTradicional
        (nombreBanco, cantidadEmpleados, cantidadMaxima, direccion, localidad);
        
        for (int i=0 ; i<10 ; i++){
            System.out.println("Ingrese información sobre una cuenta");
            System.out.println("Ingrese CBU, alias, DNI y moneda");
            int CBU = Lector.leerInt();
            String alias = Lector.leerString();
            int DNI = Lector.leerInt();
            String moneda = Lector.leerString();
            Cuenta cuenta = new Cuenta (CBU, alias, DNI, moneda);
            bancoTradicional.agregarCuenta(cuenta); // acá tengo que informar true o false?
        }
        
        System.out.println("Ahora se ingresará información sobre un banco digital");
        System.out.println("Ingrese nombre del banco, cantidad de empleados y cantidad máxima de cuentas");
        nombreBanco = Lector.leerString();
        cantidadEmpleados = Lector.leerInt();
        cantidadMaxima = Lector.leerInt();
        System.out.println("Ingrese la dirección web");
        String direccionWeb = Lector.leerString();
        BancoDigital bancoDigital = new BancoDigital(nombreBanco, cantidadEmpleados, cantidadMaxima, direccionWeb);
        
        for (int i=0 ; i<10 ; i++){
            System.out.println("Ingrese información sobre una cuenta");
            System.out.println("Ingrese CBU, alias, DNI y moneda");
            int CBU = Lector.leerInt();
            String alias = Lector.leerString();
            int DNI = Lector.leerInt();
            String moneda = Lector.leerString();
            Cuenta cuenta = new Cuenta (CBU, alias, DNI, moneda);
            bancoDigital.agregarCuenta(cuenta); // acá tengo que informar true o false?
        }
        
        // incisos C y D en bancoTradicional
        int CBUX;
        double montoX;
        System.out.println("Ingrese el monto a incrementar y el CBU correspondiente");
        CBUX = Lector.leerInt();
        montoX = Lector.leerDouble();
        bancoTradicional.depositarDinero(CBUX, montoX);
        
        System.out.println("Ingrese el CBU del cual se revisará si puede asociar una tarjeta de crédito");
        CBUX = Lector.leerInt();
        if (bancoTradicional.puedeRecibirTarjeta(CBUX)){
            System.out.println("Puede recibir una tarjeta de crédito");
        }
        else {
            System.out.println("No puede recibir una tarjeta de crédito");
        }
        
        // incisos C y D en bancoDigital
        System.out.println("Ingrese el monto a incrementar y el CBU correspondiente");
        CBUX = Lector.leerInt();
        montoX = Lector.leerDouble();
        bancoDigital.depositarDinero(CBUX, montoX);
        System.out.println("Ingrese el CBU del cual se revisará si puede asociar una tarjeta de crédito");
        CBUX = Lector.leerInt();
        if (bancoDigital.puedeRecibirTarjeta(CBUX)){
            System.out.println("Puede recibir una tarjeta de crédito");
        }
        else {
            System.out.println("No puede recibir una tarjeta de crédito");
        }
    }
}
