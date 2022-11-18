package bdd;

import java.util.LinkedList;
import java.util.List;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


public class DatosAplicativos {
    private final Connection connection;
    
    public DatosAplicativos(Connection connection) {
        this.connection = connection;
    }
    
    public List<Aplicativo> getAll() throws SQLException {
        LinkedList<Aplicativo> aplicativos = new LinkedList<>();
        
        try (Statement st = connection.createStatement(); 
             ResultSet rs = st.executeQuery("SELECT * FROM APLICATIVOS")) {
            
            while (rs.next()) {
                aplicativos.add(new Aplicativo(
                    rs.getInt(1), 
                    rs.getString(2)
                ));
            }
        }
        
        return aplicativos;
    }
}