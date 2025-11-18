/*
 1-A- Definir una clase para representar triángulos. Un triángulo se caracteriza por el
tamaño de sus 3 lados (double), el color de relleno (String) y el color de línea (String).
Provea un constructor que reciba todos los datos necesarios para iniciar el objeto.
Provea métodos para:
- Devolver/modificar el valor de cada uno de sus atributos (métodos get y set)
- Calcular el perímetro y devolverlo (método calcularPerimetro)
- Calcular el área y devolverla (método calcularArea)
 */
package tema3;

/**
 *
 * @author Pablo
 */
public class Triangulo {
    private double lado1 = 0;
    private double lado2 = 0;
    private double lado3 = 0;
    private String colorRelleno = "Deafult";
    private String colorLinea = "Default";
    
    public Triangulo (double unLado1, double unLado2, double unLado3, 
            String unColorRelleno, String unColorLinea) {
        lado1 = unLado1;
        lado2 = unLado2;
        lado3 = unLado3;
        colorRelleno = unColorRelleno;
        colorLinea = unColorLinea;
    }
    
    public Triangulo (){
        
    }
    
    public double getLado1(){
        return lado1;
    }
    
    public double getLado2(){
        return lado2;
    }
    
   public double getLado3(){
       return lado3;
   }
   
   public String getColorRelleno(){
       return colorRelleno;
   }
   
   public String getColorLinea(){
       return colorLinea;
   }
   
   public void setLado1 (double unLado1){
       lado1 = unLado1;
   }
   
   public void setLado2 (double unLado2){
       lado2 = unLado2;
   }
   
   public void setLado3 (double unLado3){
       lado3 = unLado3;
   }
   
   public void setColorRelleno (String unColorRelleno){
       colorRelleno = unColorRelleno;
   }
   
   public void setColorLinea (String unColorLinea){
       colorLinea = unColorLinea;
   }
   
   public double calcularPerimetro(){
       double aux = lado1 + lado2 + lado3;
       return aux;
   }
   
   public double calcularArea (){
       double s = (lado1+lado2+lado3) / 2;
       return Math.sqrt(s*(s - this.lado1)*(s - this.lado2)*(s - this.lado3));
   }
   
}
