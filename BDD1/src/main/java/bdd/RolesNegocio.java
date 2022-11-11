package bdd;

import java.util.LinkedList;
import java.util.List;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


public class RolesNegocio {
    private final Connection connection;
    
    public RolesNegocio(Connection connection) {
        this.connection = connection;
    }
    
    public List<RolNegocio> getAll() throws SQLException {
        LinkedList<RolNegocio> rolesNegocio = new LinkedList<>();
        
        try (Statement st = connection.createStatement(); 
             ResultSet rs = st.executeQuery("SELECT * FROM ROLES_NEGOCIO")) {
            
            while (rs.next()) {
                rolesNegocio.add(new RolNegocio(
                    rs.getInt(1), 
                    rs.getString(2)
                ));
            }
        }
        
        return rolesNegocio;
    }
}