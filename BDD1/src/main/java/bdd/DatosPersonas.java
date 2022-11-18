package bdd;

import java.util.LinkedList;
import java.util.List;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


public class DatosPersonas {
    private final Connection connection;
    
    public DatosPersonas(Connection connection) {
        this.connection = connection;
    }
    
    public List<Persona> getAll() throws SQLException {
        LinkedList<Persona> personas = new LinkedList<>();
        
        try (Statement st = connection.createStatement(); 
             ResultSet rs = st.executeQuery("SELECT user_id, " +
                                                    "nombres, " +
                                                    "apellidos, " +
                                                    "direccion, " +
                                                    "ciudad, " +
                                                    "departamento, " +
                                                    "hashpwd FROM personas")) {
            while (rs.next()) {
                personas.add(new Persona(
                    rs.getInt(1), 
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getString(7)
                ));
            }
        }
        
        return personas;
    }
}
