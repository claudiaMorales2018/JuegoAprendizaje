package Controlador;

import Modelo.ModeloLogin;
import Controlador.*;


public class JuegoAprendizaje {


    
    public static void main(String[] args) {
        
        
      Vista.VLogin v = new Vista.VLogin();
      ModeloLogin m = new ModeloLogin();
      ControladorPrincipal c = new ControladorPrincipal(v,m);
        
      v.setVisible(true);     
   
    }
    
    
         
    
    
}
