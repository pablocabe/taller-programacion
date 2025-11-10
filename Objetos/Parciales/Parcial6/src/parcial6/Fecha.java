/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial6;
/**
 *
 * @author Pablo
 */
public class Fecha {
    private Alumno [][] matrizSalas;
    private int cantidadSalas;
    private int cantidadMaximaAlumnos;
    private int [] vector;
    
    public Fecha (int N, int M){
        matrizSalas = new Alumno [N][M];
        this.cantidadSalas = N;
        this.cantidadMaximaAlumnos = M;
        
        for (int i=0 ; i<cantidadSalas ; i++){
            for (int j=0 ; j<cantidadMaximaAlumnos ; j++){
                matrizSalas[i][j] = null;
            }
        }
        
        this.vector = new int [cantidadSalas];
        for (int i=0 ; i<cantidadSalas ; i++){
            vector[i] = 0;
        }
    }
    
    public void agregarAlumno (int X, Alumno unAlumno){
        matrizSalas[X-1][vector[X-1]] = unAlumno;
        vector[X-1]++;
    }
    
    public void asignarTemaSala(int sala, int m){
        for (int j=0 ; j <vector[sala] ; j++){ // no puede ser null gracias al vector
            matrizSalas[sala][j].asignarTemaAlumno(m);
        }
    }
    
    public void asignarTemas (int m){
        for (int i=0 ; i<cantidadSalas ; i++){
            asignarTemaSala(i, m);
        }
    }
    
    public String stringTemaT (int T){
        String aux = "Alumnos que rindieron el tema " + T;
        for (int i=0 ; i<cantidadSalas ; i++){
            for (int j=0 ; j<vector[i] ; j++){
                if (matrizSalas[i][j].rindeTemaT(T)){
                    aux += matrizSalas[i][j].toString() + "\n";
                }
            }
        }
        return aux;
    }
}
