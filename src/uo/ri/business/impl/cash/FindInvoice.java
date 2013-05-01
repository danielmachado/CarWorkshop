package uo.ri.business.impl.cash;

import alb.util.BusinessException;
import uo.ri.business.impl.Command;
import uo.ri.persistence.FacturaFinder;

/**
 * Command que encuentra una factura por id
 * 
 * @author Daniel Machado Fernández
 * 
 */
public class FindInvoice implements Command {

    private Long numeroFactura;

    public FindInvoice(Long numeroFactura) {
	this.numeroFactura = numeroFactura;
    }

    @Override
    public Object execute() throws BusinessException {

	return FacturaFinder.findByNumber(numeroFactura);
    }

}
