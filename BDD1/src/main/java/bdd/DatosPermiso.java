package bdd;

import java.util.LinkedList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Date;

public class DatosPermiso {

    private final Connection connection;

    public DatosPermiso(Connection connection) {
        this.connection = connection;
    }

    public List<Permiso> getAll() throws SQLException {
        LinkedList<Permiso> permisos = new LinkedList<>();

        try ( Statement st = connection.createStatement();  ResultSet rs = st.executeQuery("SELECT user_id, "
                + "rol_neg_id, "
                + "app_id, "
                + "fecha_solicitud, "
                + "fecha_autorizacion, "
                + "estado "
                + "FROM PERMISOS")) {
            while (rs.next()) {
                permisos.add(new Permiso(
                        rs.getInt("user_id"),
                        rs.getInt("rol_neg_id"),
                        rs.getInt("app_id"),
                        new Date(rs.getDate("fecha_solicitud").getTime()),
                        new Date(rs.getDate("fecha_autorizacion").getTime()),
                        rs.getString("estado")
                ));
            }
        }

        return permisos;
    }

    public void create(Permiso permiso) throws SQLException {
        String sql = 
            "INSERT INTO PERMISOS(user_id, rol_neg_id, app_id, fecha_solicitud, fecha_autorizacion, estado) "
            + "VALUES(?, ?, ?, ?, ?, ?) ";

        try ( PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, permiso.userId);
            st.setInt(2, permiso.rolnegId);
            st.setInt(3, permiso.appId);
            st.setDate(4, new java.sql.Date(permiso.fechaSolicitud.getTime()));
            st.setDate(5, new java.sql.Date(permiso.fechaAutorizacion.getTime()));
            st.setString(6, permiso.estado);

            st.execute();
        }
    }
}
