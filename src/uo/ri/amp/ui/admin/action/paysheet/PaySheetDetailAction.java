package uo.ri.amp.ui.admin.action.paysheet;

import uo.ri.amp.business.AdminService;
import uo.ri.amp.model.Nomina;
import uo.ri.conf.ServicesFactory;
import alb.util.BusinessException;
import alb.util.console.Console;
import alb.util.menu.Action;

/**
 * Presentación de un detalle de una nómina concreta
 * 
 * @author Daniel Machado Fernández
 * 
 */
public class PaySheetDetailAction implements Action {

    @Override
    public void execute() throws BusinessException {

	Long id = Console.readLong("ID Nomina");

	AdminService as = ServicesFactory.getAdminService();

	Nomina n = as.findPaySheetById(id);

	System.out.println("Nomina: ");

	System.out.println(n);

    }

}
