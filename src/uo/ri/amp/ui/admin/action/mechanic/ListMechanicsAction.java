package uo.ri.amp.ui.admin.action.mechanic;

import java.util.List;

import uo.ri.amp.business.AdminService;
import uo.ri.amp.model.Mecanico;
import uo.ri.conf.ServicesFactory;
import uo.ri.ui.util.Printer;
import alb.util.BusinessException;
import alb.util.console.Console;
import alb.util.menu.Action;

/**
 * Presentación del listado de todos los mecánicos registrados
 * 
 * @author Daniel Machado Fernández
 * 
 */
public class ListMechanicsAction implements Action {

    @Override
    public void execute() throws BusinessException {

	AdminService as = ServicesFactory.getAdminService();
	List<Mecanico> mechanics = as.findAllMechanics();

	Console.println("\nListado de mecánicos registrados\n");
	for (Mecanico m : mechanics) {
	    Printer.printMechanic(m);
	}

    }
}
