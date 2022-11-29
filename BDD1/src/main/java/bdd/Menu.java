package bdd;


public class Menu {
    public final int menuId;
    public final int appId;
    public final String descripcionMenu;
    
    public Menu(int menuId, int appId, String desc) {
        this.menuId = menuId;
        this.appId = appId;
        this.descripcionMenu = desc;
    }
    
    /**
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        
        if (o instanceof Menu m) {
            return menuId == m.menuId;
        }
        
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.menuId;
        return hash;
    }
}
