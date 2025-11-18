/*
Escriba un programa que instancie un proyecto con tres investigadores. Agregue dos
subsidios a cada investigador y otorgue los subsidios de uno de ellos. Luego imprima
todos los datos del proyecto en pantalla.
 */
package p5ej1;

import PaqueteLectura.Lector;

/**
 *
 * @author Pablo
 */
public class P5Ej1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Se ingresarán los datos de un proyecto");
        System.out.println("Ingrese el nombre del proyecto, su código y nombre del director");
        String nombreProyecto = Lector.leerString();
        int codigoProyecto = Lector.leerInt();
        String nombreDirector = Lector.leerString();
        Proyecto proyecto = new Proyecto (nombreProyecto, codigoProyecto, nombreDirector);
        System.out.println("Se ingresarán los datos de tres investigadores");
        String nombreInvestigador;
        int categoriaInvestigador;
        String especialidadInvestigador;
        for (int i=0 ; i<3 ; i++){
            System.out.println("Ingrese los datos del investigador N°" + (i+1) + ": nombre, categoria y especialidad");
            nombreInvestigador = Lector.leerString();
            categoriaInvestigador = Lector.leerInt();
            especialidadInvestigador = Lector.leerString();
            Investigador investigador = new Investigador
            (nombreInvestigador, categoriaInvestigador, especialidadInvestigador);
            System.out.println("Ingrese dos subsidios para el investigador N°" + (i+1));
            int monto;
            String motivo;
            for (int j=0 ; j<2 ; j++){
                System.out.println(" Ingrese los datos del subsidio: monto y motivo");
                monto = Lector.leerInt();
                motivo = Lector.leerString();
                Subsidio subsidio = new Subsidio (monto, motivo);
                investigador.agregarSubsidio(subsidio);
            }
            proyecto.agregarInvestigador(investigador);
        }
        System.out.println(proyecto.toString());
    }
}
