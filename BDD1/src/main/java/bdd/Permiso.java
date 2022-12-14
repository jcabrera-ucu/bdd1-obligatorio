package bdd;

import java.util.*;

public class Permiso {

    public int userId;
    public int rolnegId;
    public int appId;
    public Date fechaSolicitud;
    public Date fechaAutorizacion;
    public String estado;

    public Permiso(int userId, int rolnegId, int appId, Date fechaSolicitud, Date fechaAutorizacion, String estado){
        this.userId = userId;
        this.rolnegId = rolnegId;
        this.appId = appId;
        this.fechaSolicitud = fechaSolicitud;
        this.fechaAutorizacion = fechaAutorizacion;
        this.estado = estado;
    }
    
    public Permiso(int userId, int rolnegId, int appId) {

        this.userId = userId;
        this.rolnegId = rolnegId;
        this.appId = appId;
        this.fechaSolicitud = new Date();
        this.fechaAutorizacion = null;
        this.estado = "Pendiente";
    }
    
    public void autorizar(){
        this.estado = "Autorizado";
        this.fechaAutorizacion = new Date();

    }
    
    public void denegar(){
        this.estado = "Rechazado";
        this.fechaAutorizacion = new Date();

    }
}
