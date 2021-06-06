
package Controlador;
import Modelo.Conectar;
import Modelo.ModeloCrudUsuario;
import Vista.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;

public class ControlCrudusuario {
    
 Conectar c;

    public ControlCrudusuario() {
        c = new Conectar();
    }    
  
 public static VCrudUsuario Vcrud = new VCrudUsuario();
     
 //Crear nuevos usuarios del sistema
 public boolean crearUsuario(ModeloCrudUsuario B) {

      String sql = "INSERT INTO tbl_usuario (nombre_usuario,apellido_usuario,edad_usuario,user,password,id_estado,id_tipo_usuario)VALUES(?,?,?,?,?,?,?) ";
        try {
            PreparedStatement ps =c.Conectarbd().prepareStatement(sql);
            System.out.println(ps);
            ps.setString(1, B.getNombre_usuario());
            ps.setString(2, B.getApellido_usuario());
            ps.setInt(3, B.getEdad_usuario());
            ps.setString(4, B.getUser());
            ps.setString(5, B.getPassword());
            ps.setInt(6, B.getId_estado());
            ps.setInt(7, B.getId_tipo_usuario());
            System.out.println(ps);
            ps.execute();
            ps.close();
            ps = null;
            c.Desconectarbd();
            return true;

        } catch (SQLException ex) {
            System.out.println("No se Inserto usuarios");
            return false;

        }   
    }   

  
 //Array usuarios del sistema 
 public  ArrayList<ModeloCrudUsuario> LeerListausuario() {
      //  ArrayList<ModeloCrudUsuario> modelo = new ArrayList<ModeloCrudUsuario>();
      ArrayList LeerListausuario = new ArrayList();
      ModeloCrudUsuario MCrud;
        try {

            String sql = "SELECT * FROM tbl_usuario";

            PreparedStatement ps = c.Conectarbd().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ModeloCrudUsuario B = new ModeloCrudUsuario();
                B.setId_usuario(rs.getInt(1));
                B.setNombre_usuario(rs.getString(2));
                B.setApellido_usuario(rs.getString(3));
                B.setEdad_usuario(rs.getInt(4));
                B.setUser(rs.getString(5));
                B.setPassword(rs.getString(6));
                B.setId_estado(rs.getInt(7));
                B.setId_tipo_usuario(rs.getInt(8));
                
             LeerListausuario.add(B);
            }
            ps.close();
            ps = null;
            c.Desconectarbd();

        } catch (SQLException ex) {
            System.out.println("Fallo la lectura");
        }
        return LeerListausuario;
        
    }
 
 
  //Actualizar usuarios del sistema 
  public boolean ActualizarUsuario (ModeloCrudUsuario B ){
  
   String sql = "UPDATE  tbl_usuario SET nombre_usuario=?,apellido_usuario=?,edad_usuario=?,user=?,password=?, id_estado=?,id_tipo_usuario=? WHERE id_usuario=? ";
        try {
            PreparedStatement ps = c.Conectarbd().prepareStatement(sql);
            ps.setString(1, B.getNombre_usuario());
            ps.setString(2, B.getApellido_usuario());
            ps.setInt(3, B.getEdad_usuario());
            ps.setString(4, B.getUser());
            ps.setString(5, B.getPassword());
            ps.setInt(6, B.getId_estado());
            ps.setInt(7, B.getId_tipo_usuario());
            ps.setInt(8, B.getId_usuario());
            
            ps.execute();
            ps.close();
            ps = null;
            c.Desconectarbd();
            return true;

        } catch (SQLException ex) {
            return false;

        }
  
  } 
  
 //Mostrar Usuario del Sistema - Evento Mouse
 public ModeloCrudUsuario MostrarUsuario(int id) {
       ModeloCrudUsuario B= new ModeloCrudUsuario();
        try {

            String sql = "SELECT * FROM tbl_usuario  WHERE id_usuario=?";
            PreparedStatement ps = c.Conectarbd().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                B.setId_usuario(rs.getInt("id_usuario"));
                B.setNombre_usuario(rs.getString("nombre_usuario"));
                B.setApellido_usuario(rs.getString("apellido_usuario"));
                B.setEdad_usuario(rs.getInt("edad_usuario"));
                B.setUser(rs.getString("user"));
                B.setPassword(rs.getString("password"));
                B.setId_estado(rs.getInt("id_estado"));
                B.setId_tipo_usuario(rs.getInt("id_tipo_usuario"));
                        
            }
            ps.close();
            ps = null;
            c.Desconectarbd();

        } catch (SQLException ex) {
            System.out.println("Fallo la lectura Usuarios");
        }
        return B;
    }
  
 
  //Suprimir Usuario del Sistema  
   public  boolean eliminarUsuario (int id){
    
        try {
            String sql="DELETE FROM tbl_usuario WHERE id_usuario=? ";
            PreparedStatement ps=c.Conectarbd().prepareStatement(sql);
            ps.setInt(1, id);                   
            ps.execute();
            ps.close();
            ps=null;
            c.Desconectarbd();
            return true;
        } catch (SQLException ex) {
          return false;
        }
    }
 
 
 public void ConsultarEstados(JComboBox cbox_estados) {
     
        
        try {

            String sql = "SELECT distinct id_estado FROM tbl_estado ORDER BY id_estado ASC";

            PreparedStatement ps = c.Conectarbd().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cbox_estados.addItem(rs.getInt("id_estado"));                             
            }
            ps.close();
            ps = null;
            c.Desconectarbd();

        } catch (SQLException ex) {
            System.out.println("Fallo la lectura de estados");
        }
        
    }
 
 public void ConsultarTipos(JComboBox cbox_tipos) {
     
        
        try {

            String sql = "SELECT distinct id_tipo_usuario FROM tbl_tipo_usuario ORDER BY id_tipo_usuario ASC";

            PreparedStatement ps = c.Conectarbd().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cbox_tipos.addItem(rs.getInt("id_tipo_usuario"));                             
            }
            ps.close();
            ps = null;
            c.Desconectarbd();

        } catch (SQLException ex) {
            System.out.println("Fallo la lectura de tipos de usuarios");
        }
        
    }
 
 
 public boolean crearScore(ModeloCrudUsuario B) {

      String sql = "INSERT INTO tbl_score (punteo_score,id_usuario)VALUES(0,?) ";
        try {
            PreparedStatement ps =c.Conectarbd().prepareStatement(sql);
            System.out.println(ps);
            ps.setInt(1, B.getId_usuario());
            ps.execute();
            ps.close();
            ps = null;
            c.Desconectarbd();
            return true;

        } catch (SQLException ex) {
            System.out.println("No se Inserto score");
            return false;

        }   
    } 
 
 
 public  boolean eliminarScore (int id){
    
        try {
            String sql="DELETE FROM tbl_score WHERE id_usuario=? ";
            PreparedStatement ps=c.Conectarbd().prepareStatement(sql);
            ps.setInt(1, id);                   
            ps.execute();
            ps.close();
            ps=null;
            c.Desconectarbd();
            return true;
        } catch (SQLException ex) {
          return false;
        }
    }
 
 public ModeloCrudUsuario readEstadoNombre(int id2) {
       ModeloCrudUsuario C = new ModeloCrudUsuario();
        try {

            String sql2 = "SELECT nombre_estado FROM tbl_estado  WHERE id_estado=?";
            PreparedStatement ps2 = c.Conectarbd().prepareStatement(sql2);
            ps2.setInt(1, id2);
            ResultSet rs2 = ps2.executeQuery();
            while (rs2.next()) {
                C.setNombre_estado(rs2.getString("nombre_estado"));
            }
            ps2.close();
            ps2 = null;
            c.Desconectarbd();

        } catch (SQLException ex) {
            System.out.println("Fallo la lectura de Nombre del Estado");
        }
        return C;
    }
 
 public ModeloCrudUsuario readTipoUsuarioNombre(int id) {
       ModeloCrudUsuario B = new ModeloCrudUsuario();
        try {

            String sql = "SELECT nombre_tipo_usuario FROM tbl_tipo_usuario  WHERE id_tipo_usuario=?";
            PreparedStatement ps = c.Conectarbd().prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                B.setNombre_Tusuario(rs.getString("nombre_tipo_usuario"));
            }
            ps.close();
            ps = null;
            c.Desconectarbd();

        } catch (SQLException ex) {
            System.out.println("Fallo la lectura de Nombre Tipo Usuario");
        }
        return B;
    }
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 


    
    
    
}
