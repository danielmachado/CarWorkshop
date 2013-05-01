package uo.ri.ui.admin;

import alb.util.menu.BaseMenu;
import alb.util.menu.NotYetImplementedAction;

/**
 * Menú de repuestos
 * 
 * @author Daniel Machado Fernández
 * 
 */
public class RepuestosMenu extends BaseMenu {

    public RepuestosMenu() {
	menuOptions = new Object[][] {
		{ "Administrador > Gestión de repuestos", null },

		{ "Añadir repuesto", NotYetImplementedAction.class },
		{ "Modificar datos de repuesto", NotYetImplementedAction.class },
		{ "Eliminar repuesto", NotYetImplementedAction.class },
		{ "Listar repuestos", NotYetImplementedAction.class }, };
    }

}
