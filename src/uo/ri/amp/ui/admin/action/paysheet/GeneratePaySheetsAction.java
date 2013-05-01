package uo.ri.amp.ui.admin.action.paysheet;

import uo.ri.amp.business.AdminService;
import uo.ri.conf.ServicesFactory;
import alb.util.BusinessException;
import alb.util.menu.Action;

/**
 * Presentación de la generación de las nóminas de los contratos en ACTIVO
 * 
 * @author Daniel Machado Fernández
 * 
 */
public class GeneratePaySheetsAction implements Action {

    @Override
    public void execute() throws BusinessException {

	AdminService as = ServicesFactory.getAdminService();

	as.generatePaySheets();

	System.out.println("Nóminas generadas");

    }

}
