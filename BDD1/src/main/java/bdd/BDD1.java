package bdd;

import java.sql.*;


/**
 *
 */
public class BDD1 {

    public static void main(String[] args) throws SQLException {
        
        String connectionString = "jdbc:postgresql://localhost:5432/postgres?user=postgres&password=postgres&ssl=false";
        
        Connection conn = DriverManager.getConnection(connectionString);  

        System.out.println("Preguntas:");
        for (var pregunta : new Preguntas(conn).getAll()) {
            System.out.println("  > " + pregunta.toString());
        }

        System.out.println("Roles Negocio:");
        for (var rolNegocio : new RolesNegocio(conn).getAll()) {
            System.out.println("  > " + rolNegocio.toString());
        }

        System.out.println("Aplicativos");
        for (var aplicativo : new Aplicativos(conn).getAll()) {
            System.out.println("  > " + aplicativo.toString());
        }
    }
}
