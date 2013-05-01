package uo.ri.amp.ui.admin.action.contract;

import uo.ri.amp.business.AdminService;
import uo.ri.conf.ServicesFactory;
import alb.util.BusinessException;
import alb.util.console.Console;
import alb.util.menu.Action;

/**
 * Presentación del borrado de un contrato
 * 
 * @author Daniel Machado Fernández
 * 
 */
public class DeleteContractAction implements Action {

    @Override
    public void execute() throws BusinessException {

	Long idContrato = Console.readLong("Id de contrato");

	AdminService as = ServicesFactory.getAdminService();
	as.deleteContract(idContrato);

	Console.println("Se ha eliminado el mecánico");
    }

}
