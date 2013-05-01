package uo.ri.business.impl.cash;

import uo.ri.business.impl.Command;
import uo.ri.persistence.MedioPagoFinder;
import alb.util.BusinessException;

/**
 * Command para encontrar los métodos de pago de una factura
 * 
 * @author Daniel Machado Fernández
 * 
 */
public class FindPayMethodsForInvoice implements Command {

    private Long idFactura;

    public FindPayMethodsForInvoice(Long idFactura) {
	this.idFactura = idFactura;
    }

    @Override
    public Object execute() throws BusinessException {
	return MedioPagoFinder.findPaymentMeansByInvoiceId(idFactura);
    }

}
