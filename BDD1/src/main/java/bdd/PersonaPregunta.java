package bdd;


public class PersonaPregunta {
    public int userId;
    public int pregId;
    public String respuesta;

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
