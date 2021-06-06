package Modelo;

public class ModeloTipoUsuario {

    Integer id_tipo_usuario;
    String nombre_tipo_usuario;
    String Descripcion_tipo_usuario;

    public ModeloTipoUsuario() {

    }

    public ModeloTipoUsuario(Integer id_tipo_usuario, String nombre_tipo_usuario, String Descripcion_tipo_usuario) {
        this.id_tipo_usuario = id_tipo_usuario;
        this.nombre_tipo_usuario = nombre_tipo_usuario;
        this.Descripcion_tipo_usuario = Descripcion_tipo_usuario;
    }

    public ModeloTipoUsuario(String nombre_tipo_usuario, String Descripcion_tipo_usuario) {
        this.nombre_tipo_usuario = nombre_tipo_usuario;
        this.Descripcion_tipo_usuario = Descripcion_tipo_usuario;
    }

    public Integer getId_tipo_usuario() {
        return id_tipo_usuario;
    }

    public void setId_tipo_usuario(Integer id_tipo_usuario) {
        this.id_tipo_usuario = id_tipo_usuario;
    }

    public String getNombre_tipo_usuario() {
        return nombre_tipo_usuario;
    }

    public void setNombre_tipo_usuario(String nombre_tipo_usuario) {
        this.nombre_tipo_usuario = nombre_tipo_usuario;
    }

    public String getDescripcion_tipo_usuario() {
        return Descripcion_tipo_usuario;
    }

    public void setDescripcion_tipo_usuario(String Descripcion_tipo_usuario) {
        this.Descripcion_tipo_usuario = Descripcion_tipo_usuario;
    }

    @Override
    public String toString() {
        return  nombre_tipo_usuario ;
    }

}
