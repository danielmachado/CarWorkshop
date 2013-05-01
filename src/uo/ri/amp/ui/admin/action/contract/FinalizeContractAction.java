package uo.ri.amp.ui.admin.action.contract;

import java.util.Date;

import uo.ri.amp.business.AdminService;
import uo.ri.amp.model.Contrato;
import uo.ri.amp.model.types.ContratoStatus;
import uo.ri.conf.ServicesFactory;
import alb.util.BusinessException;
import alb.util.console.Console;
import alb.util.date.DateUtil;
import alb.util.menu.Action;

/**
 * Presentación de la finalización de un contrato (paso a Extinto)
 * 
 * @author Daniel Machado Fernández
 * 
 */
public class FinalizeContractAction implements Action {

    @Override
    public void execute() throws BusinessException {

	Long id = Console.readLong("ID Contrato");

	Date date = DateUtil.today();

	if (DateUtil.isFirstDayOfMonth(date) == true)
	    date = DateUtil.addDays(date, 1);

	while (!DateUtil.isFirstDayOfMonth(date)) {
	    date = DateUtil.addDays(date, 1);
	}

	AdminService as = ServicesFactory.getAdminService();
	Contrato c = as.findContractById(id);
	c.setFechaFin(date);
	c.setStatus(ContratoStatus.EXTINTO);

	as.updateContract(c);

	System.out.println("Contrato finalizado, su liquidación: "
		+ c.getPagaLiquidacion());

    }

}
