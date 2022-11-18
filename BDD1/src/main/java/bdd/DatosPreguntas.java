package bdd;

import java.util.LinkedList;
import java.util.List;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


public class DatosPreguntas {
    private final Connection connection;
    
    public DatosPreguntas(Connection connection) {
        this.connection = connection;
    }
    
    public List<Pregunta> getAll() throws SQLException {
        LinkedList<Pregunta> preguntas = new LinkedList<>();
        
        try (Statement st = connection.createStatement(); 
             ResultSet rs = st.executeQuery("SELECT * FROM preguntas")) {
            
            while (rs.next()) {
                preguntas.add(new Pregunta(
                    rs.getInt(1), 
                    rs.getString(2)
                ));
            }
        }
        
        return preguntas;
    }
}
