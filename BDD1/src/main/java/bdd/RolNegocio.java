package bdd;


public class RolNegocio {
    private final int rolNegId;
    private final String descripcionRolNeg;
    
    public RolNegocio(int rolNegId, String descripcionRolNeg) {
        this.rolNegId = rolNegId;
        this.descripcionRolNeg = descripcionRolNeg;
    }
    
    public int getRolNegId() {
        return rolNegId;
    }
    
    public String getDescripcionRolNeg() {
        return descripcionRolNeg;
    }
    
    @Override
    public String toString() {
        return "RolNegocio(" + rolNegId + ", " + descripcionRolNeg + ")";
    }
}
