/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial2;
import PaqueteLectura.Lector;
/**
 *
 * @author Pablo
 */
public class Parcial2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Se ingresará información sobre una empresa");
        System.out.println("Ingrese nombre, dirección y cantidad de sucursales");
        String nombreEmpresa = Lector.leerString();
        String direccion = Lector.leerString();
        int cantidadSucursales = Lector.leerInt();
        
        String nombre;
        int DNI;
        int añoIngreso;
        double sueldoBasico;
        
        System.out.println("Ingrese información sobre su director");
        System.out.println("Nombre, DNI, año de ingreso, sueldo básico y monto de viáticos");
        nombre = Lector.leerString();
        DNI = Lector.leerInt();
        añoIngreso = Lector.leerInt();
        sueldoBasico = Lector.leerDouble();
        double montoViaticos = Lector.leerDouble();
        Director director = new Director (nombre, DNI, añoIngreso, sueldoBasico, montoViaticos);
        Empresa empresa = new Empresa (nombreEmpresa, direccion, director, cantidadSucursales);
        
        System.out.println("Se ingresará información sobre los encargados");
        for (int i=0 ; i<(cantidadSucursales-1) ; i++){ // Para que la última se imprima libre
            System.out.println("Ingrese información sobre el encargado N°" + (i+1));
            System.out.println("Nombre, DNI, año de ingreso, sueldo básico y cantidad de empleados");
            nombre = Lector.leerString();
            DNI = Lector.leerInt();
            añoIngreso = Lector.leerInt();
            sueldoBasico = Lector.leerDouble();
            int cantidadEmpleados = Lector.leerInt();
            Encargado encargado = new Encargado (nombre, DNI, añoIngreso, sueldoBasico, cantidadEmpleados);
            empresa.asignarEncargado(encargado, i);
        }
        System.out.println("Finalizó la carga de Encargados");
        System.out.println(empresa.toString());
    }
    
}
