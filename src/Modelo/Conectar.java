package Modelo;

import java.sql.*;

public class Conectar {
 
Connection Conectar;

    String bd = "bd_juegoaprendizajes";
    String url = "jdbc:mysql://localhost/" + bd;
    String user = "root";
    String pass = "";
    
    public Connection Conectarbd() {
   
     try {
              Class.forName("com.mysql.jdbc.Driver");
             Conectar =DriverManager.getConnection(url,user,pass);
             System.out.println("Se conecto");
            
        } catch (ClassNotFoundException |SQLException ex) {
            System.out.println(" no se conecto");  
      
    }        return Conectar;


}
 
      
    
 



 public void Desconectarbd(){
     
     
     try {
         Conectar.close();
         System.out.println("Se desconecto");
     } catch (SQLException ex) {
         System.out.println("no se pudo cerrar conexion a la base de datos");
     }
     
 }
    
    

}