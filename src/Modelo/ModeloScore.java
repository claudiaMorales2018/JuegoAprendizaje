
package Modelo;


public class ModeloScore {
 
Integer id_score;
Integer punteo_score;
Integer id_usuario;

public ModeloScore(){


}

    public ModeloScore(Integer id_score, Integer punteo_score, Integer id_usuario) {
        this.id_score = id_score;
        this.punteo_score = punteo_score;
        this.id_usuario = id_usuario;
    }

    public ModeloScore(Integer punteo_score, Integer id_usuario) {
        this.punteo_score = punteo_score;
        this.id_usuario = id_usuario;
    }

    public Integer getId_score() {
        return id_score;
    }

    public void setId_score(Integer id_score) {
        this.id_score = id_score;
    }

    public Integer getPunteo_score() {
        return punteo_score;
    }

    public void setPunteo_score(Integer punteo_score) {
        this.punteo_score = punteo_score;
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    @Override
    public String toString() {
        return "ModeloScore{" + "id_score=" + id_score + ", punteo_score=" + punteo_score + ", id_usuario=" + id_usuario + '}';
    }
    
}
