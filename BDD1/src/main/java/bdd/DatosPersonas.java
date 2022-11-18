package bdd;

import java.util.LinkedList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
                                                    "hashpwd FROM PERSONAS")) {
            while (rs.next()) {
                personas.add(new Persona(
                    rs.getInt("user_id"), 
                    rs.getString("nombres"),
                    rs.getString("apellidos"),
                    rs.getString("direccion"),
                    rs.getString("ciudad"),
                    rs.getString("departamento"),
                    rs.getString("hashpwd")
                ));
            }
        }
        
        return personas;
    }

    public void save(Persona persona) throws SQLException {
        if (persona.userId == null) {
            create(persona);
        } else {
            update(persona);
        }
    }

    private void create(Persona persona) throws SQLException {
        String sql = "INSERT INTO PERSONAS(nombres, apellidos, direccion, ciudad, departamento, hashpwd) " +
                     "VALUES(?, ?, ?, ?, ?, ?);";
        try (PreparedStatement st = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            st.setString(1, persona.nombres);
            st.setString(2, persona.apellidos);
            st.setString(3, persona.direccion);
            st.setString(4, persona.ciudad);
            st.setString(5, persona.departamento);
            st.setString(6, persona.hashpwd);

            if (persona.hashpwd == null || persona.hashpwd.isBlank()) {
                throw new RuntimeException("FIXME");
            }

            st.execute();
            
            ResultSet rs = st.getGeneratedKeys();            
            while (rs.next()) {
                persona.userId = rs.getInt(1);
            }
        }
    }
    
    private void update(Persona persona) throws SQLException {
        String sql = "UPDATE PERSONAS " +
                     "SET nombres = ? " +
                     "SET apellidos = ? " +
                     "SET direccion = ? " +
                     "SET ciudad = ? " +
                     "SET departamento = ? " +
                     "SET hashpwd = ? " +
                     "WHERE userId = ?";
        
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setString(1, persona.nombres);
            st.setString(2, persona.apellidos);
            st.setString(3, persona.direccion);
            st.setString(4, persona.ciudad);
            st.setString(5, persona.departamento);
            st.setString(6, persona.hashpwd);
            st.setInt(7, persona.userId);

            st.execute();
        }
    }
}
