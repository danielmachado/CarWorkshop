package uo.ri.amp.ui.admin;

import uo.ri.amp.ui.admin.action.mechanic.DeleteMechanicAction;
import uo.ri.amp.ui.admin.action.mechanic.ListContratedMechanicsAction;
import uo.ri.amp.ui.admin.action.mechanic.ListMechanicsAction;
import uo.ri.ui.admin.action.AddMechanicAction;
import uo.ri.ui.admin.action.UpdateMechanicAction;
import alb.util.menu.BaseMenu;

/**
 * Menú de mecánicos
 * 
 * @author Daniel Machado Fernández
 * 
 */
public class MecanicosMenu extends BaseMenu {

    public MecanicosMenu() {
	menuOptions = new Object[][] {
		{ "Administrador > Gestión de mecánicos", null },

		{ "Añadir mecánico", AddMechanicAction.class },
		{ "Modificar datos de mecánico", UpdateMechanicAction.class },
		{ "Eliminar mecánico", DeleteMechanicAction.class },
		{ "Listar mecánicos contratos",
			ListContratedMechanicsAction.class },
		{ "Listar mecánicos registrados", ListMechanicsAction.class }, };
    }

}
