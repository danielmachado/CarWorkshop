package uo.ri.amp.ui.admin;

import uo.ri.amp.ui.admin.action.paysheet.DeletePaySheetAction;
import uo.ri.amp.ui.admin.action.paysheet.GeneratePaySheetsAction;
import uo.ri.amp.ui.admin.action.paysheet.ListPaySheetsByMechanicAction;
import uo.ri.amp.ui.admin.action.paysheet.PaySheetDetailAction;
import alb.util.menu.BaseMenu;

/**
 * Menú de nóminas
 * 
 * @author Daniel Machado Fernández
 * 
 */
public class NominasMenu extends BaseMenu {

    public NominasMenu() {
	menuOptions = new Object[][] {
		{ "Administrador > Gestión de nóminas", null },

		{ "Generar nónimas del mes", GeneratePaySheetsAction.class },
		{ "Eliminar última nómina de mecánico",
			DeletePaySheetAction.class },
		{ "Detalle de la nómina", PaySheetDetailAction.class },
		{ "Listar nóminas por mecánico",
			ListPaySheetsByMechanicAction.class }, };
    }

}
