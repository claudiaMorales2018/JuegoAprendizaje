
package Modelo;


public class ModeloAvanzado {
    
    
public ModeloAvanzado(){
}      
    String palabra;
    String resultado;
    int valor1;

 public String traducir(String palabra){
        
     

    if (palabra == "Alegria") {
            resultado = "happy";
        }
        if (palabra == "Amor") {
            resultado = "Love";
        }
        if (palabra == "Paz") {
            resultado = "Peace";
        }  
    return resultado;
  
}

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public int getValor1() {
        return valor1;
    }

    public void setValor1(int valor1) {
        this.valor1 = valor1;
    }

    public ModeloAvanzado(String palabra, String resultado, int valor1) {
        this.palabra = palabra;
        this.resultado = resultado;
        this.valor1 = valor1;
    }
    
    
    
    
    
    
    
}