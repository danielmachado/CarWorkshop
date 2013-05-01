package uo.ri.amp.ui.admin;

import alb.util.menu.BaseMenu;

/**
 * Menú principal
 * 
 * @author Daniel Machado Fernández
 * 
 */
public class MainMenu extends BaseMenu {

    public MainMenu() {
	menuOptions = new Object[][] { { "Administrador", null },
		{ "Gestión de mecánicos", MecanicosMenu.class },
		{ "Gestión de contratos", ContratosMenu.class },
		{ "Gestión de nóminas", NominasMenu.class } };
    }

    public static void main(String[] args) {
	new MainMenu().execute();
    }

}
