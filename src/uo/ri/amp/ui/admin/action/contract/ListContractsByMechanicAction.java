package uo.ri.amp.ui.admin.action.contract;

import java.util.List;

import uo.ri.amp.business.AdminService;
import uo.ri.amp.model.Contrato;
import uo.ri.conf.ServicesFactory;
import alb.util.BusinessException;
import alb.util.console.Console;
import alb.util.menu.Action;

/**
 * Presentación del listado de contratos por mecánico
 * 
 * @author Daniel Machado Fernández
 * 
 */
public class ListContractsByMechanicAction implements Action {

    @Override
    public void execute() throws BusinessException {

	Long id = Console.readLong("ID Mecánico");

	AdminService as = ServicesFactory.getAdminService();
	List<Contrato> contratos = as.findMechanicContracts(id);

	Console.println("\nListado de contratos del mecánico\n");
	for (Contrato c : contratos) {
	    System.out.println(c);
	}

    }

}
