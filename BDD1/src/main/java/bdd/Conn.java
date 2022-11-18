/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Singleton.java to edit this template
 */
package bdd;

import java.sql.*;

/**
 *
 * @author fede2
 */
public class Conn {

    private static Conn instance = getInstance();
    public java.sql.Connection connBD;
    
    private Conn() throws SQLException {
        try {
            String connectionString = "jdbc:postgresql://localhost:5432/postgres?user=postgres&password=postgres&ssl=false";
            this.connBD = DriverManager.getConnection(connectionString);
        } catch (SQLException x) {
            System.out.println("Algo ta mal");
        }

    }

    public static Conn getInstance() {
        try{
        if (instance == null) {
            instance = new Conn();
        }
        return instance;
        }catch(SQLException x){
            System.out.println("Algo ta mal");
            return null;
        }
    }
    
    public java.sql.Connection getConn(){
        return connBD;
    }

}
