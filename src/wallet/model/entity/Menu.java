package wallet.model.entity;

import javax.swing.Icon;

public class Menu {

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Menu(Icon icon, String menuName) {
        this.icon = icon;
        this.menuName = menuName;
    }

    public Menu() {
    }

    private Icon icon;
    private String menuName;

}
