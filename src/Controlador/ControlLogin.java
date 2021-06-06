
package Controlador;
import Modelo.Conectar;
import Modelo.ModeloLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ControlLogin {
 
 
  Conectar con;
       

    public ControlLogin() {
        con = new Conectar();

    }

    
 //Recuperar password de usuario ingresado
    public ModeloLogin readUsuarioSistema(String usuarioingresado, String passingresado) {
       ModeloLogin ML = new ModeloLogin();
        try {
            String sql = "SELECT password FROM tbl_usuario WHERE user=? and password=?";
            PreparedStatement ps = con.Conectarbd().prepareStatement(sql);
            ps.setString(1, usuarioingresado);
            ps.setString(2, passingresado);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                ML.setPassword2(rs.getString("password"));  
            }
            ps.close();
            ps = null;
            con.Desconectarbd();

        } catch (SQLException ex) {
           System.out.println("Fallo lectura Tabla Usuario: validar contraseña");
        }
          
        return ML;
    }

    //Recuperar tipo de usuario del usuario ingresado
    public ModeloLogin readTipoUsuario(String usuarioingresado) {
       ModeloLogin ML = new ModeloLogin();
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
    
    //Recuperar tipo de usuario del usuario ingresado
    public ModeloLogin readPunteo(String usuarioingresado) {
       ModeloLogin ML = new ModeloLogin();
        try {

            String sql = "SELECT tbl_score.punteo_score FROM tbl_score INNER JOIN tbl_usuario ON tbl_score.id_usuario = tbl_usuario.id_usuario WHERE tbl_usuario.user=?";
            PreparedStatement ps = con.Conectarbd().prepareStatement(sql);
            ps.setString(1, usuarioingresado);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ML.setPunteo(rs.getInt("tbl_score.punteo_score"));                             
            }
            ps.close();
            ps = null;
            con.Desconectarbd();

        } catch (SQLException ex) {
           System.out.println("Fallo lectura Tabla Usuario: obtener punteo");
        }
        return ML;
    }
       
   
    
}
