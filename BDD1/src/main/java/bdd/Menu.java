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
}
