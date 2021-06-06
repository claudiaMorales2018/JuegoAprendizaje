
package Modelo;


public class ModeloCrudUsuario {

Integer id_usuario;
String nombre_usuario;
String apellido_usuario;
Integer edad_usuario;
String user;
String password;
Integer id_estado;
Integer id_tipo_usuario;
String nombre_estado;
String nombre_tipo_usuario;

public ModeloCrudUsuario(){
    

}

    public ModeloCrudUsuario(Integer id_usuario, String nombre_usuario, String apellido_usuario, Integer edad_usuario, String user, String password, Integer id_estado, Integer id_tipo_usuario) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.apellido_usuario = apellido_usuario;
        this.edad_usuario = edad_usuario;
        this.user = user;
        this.password = password;
        this.id_estado = id_estado;
        this.id_tipo_usuario = id_tipo_usuario;
    }

    public ModeloCrudUsuario(String nombre_usuario, String apellido_usuario, Integer edad_usuario, String user, String password, Integer id_estado, Integer id_tipo_usuario) {
        this.nombre_usuario = nombre_usuario;
        this.apellido_usuario = apellido_usuario;
        this.edad_usuario = edad_usuario;
        this.user = user;
        this.password = password;
        this.id_estado = id_estado;
        this.id_tipo_usuario = id_tipo_usuario;
    }

      
    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getApellido_usuario() {
        return apellido_usuario;
    }

    public void setApellido_usuario(String apellido_usuario) {
        this.apellido_usuario = apellido_usuario;
    }

    public Integer getEdad_usuario() {
        return edad_usuario;
    }

    public void setEdad_usuario(Integer edad_usuario) {
        this.edad_usuario = edad_usuario;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getId_estado() {
        return id_estado;
    }

    public void setId_estado(Integer id_estado) {
        this.id_estado = id_estado;
    }

    public Integer getId_tipo_usuario() {
        return id_tipo_usuario;
    }

    public void setId_tipo_usuario(Integer id_tipo_usuario) {
        this.id_tipo_usuario = id_tipo_usuario;
    }

      public void setNombre_estado(String nombre_estado) {
        this.nombre_estado = nombre_estado;
    }
    
      public String getNombre_estado() {
        return nombre_estado;
    }
      
      public void setNombre_Tusuario(String nombre_tipo_usuario) {
    this.nombre_tipo_usuario = nombre_tipo_usuario;
}

     public String getNombre_Tusuario() {
        return nombre_tipo_usuario;
    }
      
    @Override
    public String toString() {
        return "ModeloUsuario{" + "id_usuario=" + id_usuario + ", nombre_usuario=" + nombre_usuario + ", apellido_usuario=" + apellido_usuario + ", edad_usuario=" + edad_usuario + ", user=" + user + ", password=" + password + ", id_estado=" + id_estado + ", id_tipo_usuario=" + id_tipo_usuario + '}';
    }

    
}
