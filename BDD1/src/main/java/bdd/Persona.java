package bdd;

// import java.sql.*;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 */
public class Persona {

    public int userId;
    public String nombres;
    public String apellidos;
    public String direccion;
    public String ciudad;
    public String departamento;
    public String hashpwd;
    


    public Persona(int userId, 
                   String nombres, 
                   String apellidos, 
                   String direccion, 
                   String ciudad, 
                   String departamento, 
                   String hashpwd) {

        this.userId = userId;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.departamento = departamento;
        this.hashpwd = hashpwd;
    }
    
    public void setPassword(String pwd) {
        hashpwd = BCrypt.hashpw(pwd, BCrypt.gensalt());
    }
}