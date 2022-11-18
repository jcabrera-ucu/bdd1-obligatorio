package bdd;

import java.util.LinkedList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


public class DatosPersonaPregunta {
    private final Connection connection;
    
    public DatosPersonaPregunta(Connection connection) {
        this.connection = connection;
    }
    
    public List<PersonaPregunta> getAll() throws SQLException {
        LinkedList<PersonaPregunta> personaPregunta = new LinkedList<>();
        
        try (Statement st = connection.createStatement(); 
             ResultSet rs = st.executeQuery("SELECT userId, pregId, respuesta FROM PERSONAS_PREGUNTAS")) {
            
            while (rs.next()) {
                personaPregunta.add(new PersonaPregunta(
                    rs.getInt("userId"), 
                    rs.getInt("pregId"),
                    rs.getString("respuesta")
                ));
            }
        }
        
        return personaPregunta;
    }

    public void create(PersonaPregunta personaPregunta) throws SQLException {
        String sql = "INSERT INTO PERSONAS_PREGUNTAS(user_id, preg_id, respuesta) " +
                     "VALUES(?, ?, ?);";
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, personaPregunta.userId);
            st.setInt(2, personaPregunta.pregId);
            st.setString(3, personaPregunta.respuesta);

            st.execute();
        }
    }
}
