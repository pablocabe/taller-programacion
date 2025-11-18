/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial4;

/**
 *
 * @author Pablo
 */
public class Funcion {
    private String titulo;
    private int fecha;
    private int hora;
    private Butaca [][] matrizSala;
    private int filas;
    private int butacas;
    
    public Funcion(String titulo, int fecha, int hora, int filas, int butacas){
        this.titulo = titulo;
        this.fecha = fecha;
        this.hora = hora;
        this.filas = filas;
        this.butacas = butacas;
        matrizSala = new Butaca [filas][butacas];
        for (int i=0 ; i<filas ; i++){
            for (int j=0 ; j<butacas ; j++){
                matrizSala[i][j] = new Butaca ("Butaca "+(i+1)+(j+1), 800+(100*(i+1)));
            }
        }
    }
    
    public double ocuparButaca (int F, int B){
        if (! matrizSala [F-1][B-1].estaOcupada()){
            matrizSala[F-1][B-1].ocuparButaca();
            return matrizSala[F-1][B-1].obtenerPrecio();
        }
        else {
            return 0;
        }
    }
    
    public void desocuparFila (int F){
        for (int i=0 ; i<butacas ; i++){
            if (! matrizSala[F-1][i].estaOcupada()){
                matrizSala[F-1][i].desocuparButaca();
            }
        }
    }
    
    public String obtenerColumna (int B){
        String aux = "Representación de la columna " + (B-1);
        for (int i=0 ; i<filas ; i++){
            aux += matrizSala[i][B-1].toString() + "\n";
        }
        return aux;
    }
    
    @Override
    public String toString (){
        String aux = "Título: " + this.titulo + ", fecha: " + this.fecha +
                ", hora: " + this.hora + ". Representación de las butacas: \n";
        for (int i=0 ; i<filas ; i++){
            for (int j=0 ; j<butacas ; j++){
                matrizSala[i][j].toString();
            }
        }
        return aux;
    }
    
}
