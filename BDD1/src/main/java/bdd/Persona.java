/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bdd;

import java.sql.*;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author fede2
 */
public class Persona {

    private final int userId;
    private final String nombres;
    private final String apellido;
    private final String direccion;
    private final String ciudad;
    private final String departamento;
    private final String hashpwd;
    


    public Persona(int userId, String nombres, String apellido, String direccion, String ciudad, String departamento, String hashpwd) {
        this.userId = userId;
        this.nombres = nombres;
        this.apellido = apellido;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.departamento = departamento;
        String hashed = BCrypt.hashpw(hashpwd, BCrypt.gensalt());
        this.hashpwd = hashed;
    }

    public void cargarADB() throws SQLException{
        Connection connection = (Connection) Conn.getInstance();
        try (Statement st = connection.createStatement();
             ResultSet rs = st.executeQuery("INSERT INTO PERSONAS VALUES ('" + userId + "', '"+ nombres +"', '"+apellido+
                     "', '"+direccion+"', '"+ciudad+"', '"+departamento+"', '"+hashpwd+"');")) {
           
            }
        }  
    }
