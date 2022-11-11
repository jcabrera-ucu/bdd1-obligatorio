package bdd;


public class Aplicativo {
    private final int appId;
    private final String nombreapp;
    
    public Aplicativo(int appId, String nombreapp) {
        this.appId = appId;
        this.nombreapp = nombreapp;
    }
    
    public int getAppId() {
        return appId;
    }
    
    public String getNombreApp() {
        return nombreapp;
    }
    
    @Override
    public String toString() {
        return "Aplicativo(" + appId + ", " + nombreapp + ")";
    }
}
