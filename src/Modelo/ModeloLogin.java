
package Modelo;


public class ModeloLogin {
    
 String user;
 String password;
 String password2;
 String tipousuario;
 Integer punteo;    
    
    

    public ModeloLogin() {
        
    }
    
   public ModeloLogin(String password, String password2) {
        this.password = password;
        this.password2 = password2;
    }

      public ModeloLogin(String tipousuario) {
        this.tipousuario = tipousuario;
         
    }
   
      public ModeloLogin(Integer punteo) {
        this.punteo = punteo;
         
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

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getTipousuario() {
        return tipousuario;
    }

    public void setTipousuario(String tipousuario) {
        this.tipousuario = tipousuario;
    }

    public Integer getPunteo() {
        return punteo;
    }

    public void setPunteo(Integer punteo) {
        this.punteo = punteo;
    }  
   
}
