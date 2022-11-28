package bdd;

import bdd.ui.RegistroPersonas;
import java.sql.*;


/**
 *
 */
public class BDD1 {

    public static void main(String[] args) throws SQLException {

        var datosPersonas = new DatosPersonas(Conn.getInstance().getConn());
        var datosPreguntas = new DatosPreguntas(Conn.getInstance().getConn());
        var datosPersonaPregunta = new DatosPersonaPregunta(Conn.getInstance().getConn());
        var datosAplicativos = new DatosAplicativos(Conn.getInstance().getConn());
        var datosRolNegocio = new DatosRolNegocio(Conn.getInstance().getConn());
        
        
        var frame = new RegistroPersonas(
            datosPersonas,
            datosPersonaPregunta,
            datosPreguntas.getAll(),
            datosRolNegocio.getAll(),
            datosAplicativos.getAll()
         );

         frame.setVisible(true);
    }
}
