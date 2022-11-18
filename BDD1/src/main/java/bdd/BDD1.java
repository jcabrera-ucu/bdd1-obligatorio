package bdd;

import bdd.ui.RegistroPersonas;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 */
public class BDD1 {

    public static void main(String[] args) throws SQLException {
//         
//
//        System.out.println("Preguntas:");
//        for (var pregunta : new Preguntas(Conn.getInstance().getConn()).getAll()) {
//            System.out.println("  > " + pregunta.toString());
//        }
//
//        System.out.println("Roles Negocio:");
//        for (var rolNegocio : new RolesNegocio(Conn.getInstance().getConn()).getAll()) {
//        }
//
////        System.out.println("Aplicativos");
////        for (var aplicativo : new Aplicativos((Conn.getInstance().connBD).getAll()) {
////            System.out.println("  > " + aplicativo.toString());
////        }


        var datosPersonas = new DatosPersonas(Conn.getInstance().getConn());
        var datosPreguntas = new DatosPreguntas(Conn.getInstance().getConn());
        var datosPersonaPregunta = new DatosPersonaPregunta(Conn.getInstance().getConn());
        var datosAplicativos = new DatosAplicativos(Conn.getInstance().getConn());
        var datosRolNegocio = new DatosRolNegocio(Conn.getInstance().getConn());

        var frame = new RegistroPersonas(
            datosPreguntas.getAll(),
            datosRolNegocio.getAll(),
            datosAplicativos.getAll()
        );

        frame.setVisible(true);
    }
}
