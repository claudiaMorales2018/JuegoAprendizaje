
package Modelo;


public class ModeloPrincipiante {
    int operador1;
    int operador2;
    int resultadoUsu,resultadoMetodo;
  
    
public ModeloPrincipiante(){
}    

    public int getOperador1() {
        return operador1;
    }

    public void setOperador1(int operador1) {
        this.operador1 = operador1;
    }

    public int getOperador2() {
        return operador2;
    }

    public void setOperador2(int operador2) {
        this.operador2 = operador2;
    }

    public int getResultadoUsu() {
        return resultadoUsu;
    }

    public void setResultadoUsu(int resultadoUsu) {
        this.resultadoUsu = resultadoUsu;
    }

    public int getResultadoMetodo() {
        return resultadoMetodo;
    }

    public void setResultadoMetodo(int resultadoMetodo) {
        this.resultadoMetodo = resultadoMetodo;
    }

    public ModeloPrincipiante(int operador1, int operador2, int resultadoUsu, int resultadoMetodo) {
        this.operador1 = operador1;
        this.operador2 = operador2;
        this.resultadoUsu = resultadoUsu;
        this.resultadoMetodo = resultadoMetodo;
    }

     public int suma() {
        int valor=0;
        valor = operador1 + operador2;
        return valor;
    }
  public int resta() {
        int valor=0;
        valor = operador1 - operador2;
        return valor;
    }
  public int multiplicacion() {
        int valor=0;
        valor = operador1 * operador2;
        return valor;
    }
  public int division() {
        int valor=0;
        if (operador2 > 0) valor = operador1 / operador2;     
        if (operador2 == 0) valor = 0;   
        return valor;
    }   
}
