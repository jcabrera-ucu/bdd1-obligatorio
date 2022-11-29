package bdd;

import java.util.LinkedList;
import java.util.List;

import java.sql.Connection;
// import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Date;

public class DatosSolicitudPermiso {

    private final Connection connection;

    public DatosSolicitudPermiso(Connection connection) {
        this.connection = connection;
    }

    public List<SolicitudPermiso> getAll() throws SQLException {
        LinkedList<SolicitudPermiso> permisos = new LinkedList<>();

        try ( Statement st = connection.createStatement();  ResultSet rs = st.executeQuery("SELECT user_id, "
                + "rol_neg_id, "
                + "app_id, "
                + "fecha_solicitud, "
                + "fecha_autorizacion, "
                + "estado, "
                + "nombres, "
                + "apellidos, "
                + "descripcion_rol_neg, "
                + "nombreapp"
                + "FROM solicitudes_permisos")) {
            while (rs.next()) {
                var fs = rs.getDate("fecha_solicitud");
                var fa = rs.getDate("fecha_autorizacion");
                
                permisos.add(new SolicitudPermiso(
                        new Permiso(
                                rs.getInt("user_id"),
                                rs.getInt("rol_neg_id"),
                                rs.getInt("app_id"),
                                fs != null ? new Date(fs.getTime()) : null,
                                fa != null ? new Date(fa.getTime()) : null,
                                rs.getString("estado")
                        ),
                        rs.getString("nombreapp"),
                        rs.getString("descripcion_rol_neg"),
                        rs.getString("nombres"),
                        rs.getString("apellidos")
                ));
            }
        }

        return permisos;
    }
}
