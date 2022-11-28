package bdd;


public class RolAplicativo {
    private final int rolId;
    private final int appId;
    private final String descripcionRol;
    
    public RolAplicativo(int rolId, int appId, String descripcion) {
        this.rolId = rolId;
        this.appId = appId;
        this.descripcionRol = descripcion;
    }
    
    public int getRolId() {
        return rolId;
    }
    
    public int getAppId() {
        return appId;
    }
    
    public String getDescripcion() {
        return descripcionRol;
    }
}
