package uo.ri.amp.ui.admin;

import uo.ri.amp.ui.admin.action.contract.AddContractAction;
import uo.ri.amp.ui.admin.action.contract.DeleteContractAction;
import uo.ri.amp.ui.admin.action.contract.FinalizeContractAction;
import uo.ri.amp.ui.admin.action.contract.ListContractsByMechanicAction;
import uo.ri.amp.ui.admin.action.contract.UpdateContractAction;
import alb.util.menu.BaseMenu;

/**
 * Menú de los contratos
 * 
 * @author Daniel Machado Fernández
 * 
 */
public class ContratosMenu extends BaseMenu {

    public ContratosMenu() {
	menuOptions = new Object[][] {
		{ "Administrador > Gestión de contratos", null },

		{ "Añadir contrato", AddContractAction.class },
		{ "Modificar contrato", UpdateContractAction.class },
		{ "Eliminar contrato", DeleteContractAction.class },
		{ "Finalizar contrato", FinalizeContractAction.class },
		{ "Listar contrato por mecanico",
			ListContractsByMechanicAction.class }, };
    }

}
