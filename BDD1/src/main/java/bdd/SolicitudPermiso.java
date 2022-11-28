package bdd;

import java.util.*;

public class SolicitudPermiso {

    public Permiso permiso;
    public String nombreapp;
    public String descripcion_rol_neg;
    public String nombres;
    public String apellidos;

    public SolicitudPermiso(Permiso permiso, String nombreapp, String desc, String nombre, String apellidos) {
        this.permiso = permiso;
        this.nombreapp = nombreapp;
        this.descripcion_rol_neg = desc;
        this.nombres = nombre;
        this.apellidos = apellidos;
    }
}
