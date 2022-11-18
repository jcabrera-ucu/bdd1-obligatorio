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
    
    public Persona getById(int id) throws SQLException {
        String sql = "SELECT user_id, " +
                            "nombres, " +
                            "apellidos, " +
                            "direccion, " +
                            "ciudad, " +
                            "departamento, " +
                            "hashpwd " +
                        "FROM PERSONAS " +
                        "WHERE user_id = ?";

        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new Persona(
                    rs.getInt("user_id"), 
                    rs.getString("nombres"),
                    rs.getString("apellidos"),
                    rs.getString("direccion"),
                    rs.getString("ciudad"),
                    rs.getString("departamento"),
                    rs.getString("hashpwd")
                );
            }
        }
        
        return null;
    }

    public void updateOrCreate(Persona persona) throws SQLException {
        String sql = "INSERT INTO PERSONAS(user_id, nombres, apellidos, direccion, ciudad, departamento, hashpwd) " +
                     "VALUES(?, ?, ?, ?, ?, ?, ?) " + 
                     "ON CONFLICT(user_id) DO UPDATE SET " +
                     "nombres = EXCLUDED.nombres, " +
                     "apellidos = EXCLUDED.apellidos, " +
                     "direccion = EXCLUDED.direccion, " +
                     "ciudad = EXCLUDED.ciudad, " +
                     "departamento = EXCLUDED.departamento, " +
                     "hashpwd = EXCLUDED.hashpwd";
        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, persona.userId);
            st.setString(2, persona.nombres);
            st.setString(3, persona.apellidos);
            st.setString(4, persona.direccion);
            st.setString(5, persona.ciudad);
            st.setString(6, persona.departamento);
            st.setString(7, persona.hashpwd);

            if (persona.hashpwd == null || persona.hashpwd.isBlank()) {
                throw new RuntimeException("FIXME");
            }

            st.execute();
        }
    }
}
