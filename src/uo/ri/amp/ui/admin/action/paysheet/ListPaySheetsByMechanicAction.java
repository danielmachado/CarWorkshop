package uo.ri.amp.ui.admin.action.paysheet;

import java.util.List;

import uo.ri.amp.business.AdminService;
import uo.ri.amp.model.Nomina;
import uo.ri.conf.ServicesFactory;
import alb.util.BusinessException;
import alb.util.console.Console;
import alb.util.menu.Action;

/**
 * Presentación de un listado de las nóminas de un mecánico
 * 
 * @author Daniel Machado Fernández
 * 
 */
public class ListPaySheetsByMechanicAction implements Action {

    @Override
    public void execute() throws BusinessException {

	Long idMecanico = Console.readLong("ID Mecanico");

	AdminService as = ServicesFactory.getAdminService();
	List<Nomina> nominas = as.findPaySheetsByMechanicId(idMecanico);

	System.out.println("Listado de nóminas ");
	for (Nomina n : nominas) {
	    System.out.println(n.shortString());
	    ;
	}

    }

}
