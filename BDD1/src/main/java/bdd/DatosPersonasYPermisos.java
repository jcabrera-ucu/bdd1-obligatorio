/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bdd;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author ucu
 */
public class DatosPersonasYPermisos {
    public class PersonaYPermisos {
        public Persona persona;
        public List<Aplicativo> aplicativos;
        public List<Menu> menus;
    }

    private final Connection connection;

    public DatosPersonasYPermisos(Connection conn) {
        this.connection = conn;
    }
    
    public PersonaYPermisos getById(int userId) throws SQLException {
        var result = new PersonaYPermisos();
        result.aplicativos = new LinkedList<>();
        result.menus = new LinkedList<>();

        String sql =
            "SELECT user_id, " +
            "       nombres, " +
            "       apellidos, " +
            "       direccion, " +
            "       ciudad, " +
            "       departamento, " +
            "       hashpwd, " +
            "       app_id, " +
            "       nombreapp, " + 
            "       menu_id, " +
            "       descripcion_menu " +
            "FROM personas_y_permisos " +
            "WHERE user_id = ?";

        try (PreparedStatement st = connection.prepareStatement(sql)) {
            st.setInt(1, userId);

            ResultSet rs = st.executeQuery();

            while (rs.next()) {
                result.persona = new Persona(
                    rs.getInt("user_id"), 
                    rs.getString("nombres"),
                    rs.getString("apellidos"),
                    rs.getString("direccion"),
                    rs.getString("ciudad"),
                    rs.getString("departamento"),
                    rs.getString("hashpwd")
                );

                result.aplicativos.add(new Aplicativo(rs.getInt("app_id"), rs.getString("nombreapp")));
                result.menus.add(new Menu(rs.getInt("menu_id"), rs.getInt("app_id"), rs.getString("descripcion_menu")));
            }
        }

        return result;
    }
}
