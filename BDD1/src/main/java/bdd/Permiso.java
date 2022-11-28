package bdd;

import java.util.*;
import java.text.*;

public class Permiso {

    public int userId;
    public int rolnegId;
    public int appId;
    public Date fechaSolicitud;
    public Date fechaAutorizacion;
    public String estado;


    public Permiso(int userId,
            int rolnegId,
            int appId,
            Date fechaAutorizacion,
            String estado) {

        this.userId = userId;
        this.rolnegId = rolnegId;
        this.appId = appId;
        this.fechaSolicitud = new Date();
        this.fechaAutorizacion = null;
        this.estado = null;
    }
    
    public void autorizadoFecha(){
        this.fechaAutorizacion = new Date();
    }
    
    public void autorizar(){
        this.estado = "Autorizado";
    }
    
    public void denegar(){
        this.estado = "Denegado";
    }
}
