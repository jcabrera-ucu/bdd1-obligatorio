package bdd;


public class PersonaPregunta {
    public Integer userId;
    public Integer pregId;
    public String respuesta;
    
    public PersonaPregunta(String respuesta) {
        this.userId = null;
        this.pregId = null;
        this.respuesta = respuesta;
    }

    public PersonaPregunta(int userId, int pregId, String respuesta) {
        this.userId = userId;
        this.pregId = pregId;
        this.respuesta = respuesta;
    }
        
    @Override
    public String toString() {
        return "PersonaPregunta(" + userId + ", " + pregId + ", " + respuesta + ")";
    }
}
