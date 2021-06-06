
package Controlador;

import Modelo.Conectar;
import Modelo.ModeloMenu;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ControlMenu {
 
     Conectar con;
    
     public ControlMenu() {
        con = new Conectar();}
  
         //Recuperar tipo de usuario del usuario ingresado
    public ModeloMenu readTipoUsuario(String usuarioingresado) {
       ModeloMenu ML = new ModeloMenu();
       String NombreTusuario = "";
        try {

            String sql = "SELECT tbl_tipo_usuario.nombre_tipo_usuario FROM tbl_tipo_usuario INNER JOIN tbl_usuario ON tbl_tipo_usuario.id_tipo_usuario = tbl_usuario.id_tipo_usuario\n" +
"WHERE tbl_usuario.user=?";
            PreparedStatement ps = con.Conectarbd().prepareStatement(sql);
            ps.setString(1, usuarioingresado);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                NombreTusuario =  rs.getString("tbl_tipo_usuario.nombre_tipo_usuario");
                ML.setTipousuario(rs.getString("tbl_tipo_usuario.nombre_tipo_usuario"));                             
            }
            ps.close();
            ps = null;
            con.Desconectarbd();

        } catch (SQLException ex) {
            System.out.println("Fallo lectura Tabla Usuario: obtener tipo usuario");
        }
        return ML;
   
    }
     
}
