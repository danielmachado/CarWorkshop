package uo.ri.amp.ui.admin.action.mechanic;

import uo.ri.amp.business.AdminService;
import uo.ri.conf.ServicesFactory;
import alb.util.BusinessException;
import alb.util.console.Console;
import alb.util.menu.Action;

/**
 * Presentación del borrado de un mecánico si no tiene "cargas"
 * 
 * @author Daniel Machado Fernández
 * 
 */
public class DeleteMechanicAction implements Action {

    @Override
    public void execute() throws BusinessException {

	Long idMecanico = Console.readLong("Id de mecánico");

	AdminService as = ServicesFactory.getAdminService();
	as.deleteMechanic(idMecanico);

	Console.println("Se ha eliminado el mecánico");
    }

}
