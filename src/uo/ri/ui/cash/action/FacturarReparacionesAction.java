package uo.ri.ui.cash.action;

import java.util.ArrayList;
import java.util.List;

import uo.ri.business.CashService;
import uo.ri.conf.ServicesFactory;
import uo.ri.model.Factura;
import uo.ri.ui.util.Printer;
import alb.util.BusinessException;
import alb.util.console.Console;
import alb.util.menu.Action;

/**
 * Presentación de una factuación de reparaciones
 * 
 * @author Daniel Machado Fernández
 * 
 */
public class FacturarReparacionesAction implements Action {

    @Override
    public void execute() throws BusinessException {
	List<Long> idsAveria = new ArrayList<Long>();

	// pedir las averias a incluir en la factura
	do {
	    Long id = Console.readLong("ID de averia");
	    idsAveria.add(id);
	} while (masAverias());

	CashService cs = ServicesFactory.getCashService();
	Factura factura = cs.createInvoiceFor(idsAveria);

	Printer.printInvoice(factura);
    }

    private boolean masAverias() {
	return Console.readString("¿Añadir más averias? (s/n) ")
		.equalsIgnoreCase("s");
    }

}
