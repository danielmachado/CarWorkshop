package uo.ri.amp.ui.admin.action.paysheet;

import uo.ri.amp.business.AdminService;
import uo.ri.conf.ServicesFactory;
import alb.util.BusinessException;
import alb.util.console.Console;
import alb.util.menu.Action;

/**
 * Presentación del borrado de la última nómina de un mecánico
 * 
 * @author Daniel Machado Fernández
 * 
 */
public class DeletePaySheetAction implements Action {

    @Override
    public void execute() throws BusinessException {
	Long id = Console.readLong("ID del mecánico");

	AdminService as = ServicesFactory.getAdminService();

	as.deletePaySheet(id);

	System.out.println("Nómina eliminada");

    }

}
