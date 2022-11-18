package bdd;

import bdd.ui.RegistroPersonas;
import java.sql.*;


/**
 *
 */
public class BDD1 {

    public static void main(String[] args) throws SQLException {
         

        System.out.println("Preguntas:");
        for (var pregunta : new Preguntas(Conn.getInstance().getConn()).getAll()) {
            System.out.println("  > " + pregunta.toString());
        }

        System.out.println("Roles Negocio:");
        for (var rolNegocio : new RolesNegocio(Conn.getInstance().getConn()).getAll()) {
        }

//        System.out.println("Aplicativos");
//        for (var aplicativo : new Aplicativos((Conn.getInstance().connBD).getAll()) {
//            System.out.println("  > " + aplicativo.toString());
//        }
        
        var frame = new RegistroPersonas(new Preguntas(Conn.getInstance().getConn()).getAll(), new RolesNegocio(Conn.getInstance().getConn()).getAll(), new Aplicativos(Conn.getInstance().getConn()).getAll());
        frame.setVisible(true);
    }
}
