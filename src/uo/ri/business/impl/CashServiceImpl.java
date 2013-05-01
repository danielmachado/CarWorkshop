package uo.ri.business.impl;

import java.util.List;
import java.util.Map;

import uo.ri.business.CashService;
import uo.ri.business.impl.cash.CreateInvoiceFor;
import uo.ri.business.impl.cash.FindInvoice;
import uo.ri.business.impl.cash.FindPayMethodsForInvoice;
import uo.ri.business.impl.cash.FindRepairsByClient;
import uo.ri.business.impl.cash.SettleInvoice;
import uo.ri.model.Averia;
import uo.ri.model.Factura;
import uo.ri.model.MedioPago;
import alb.util.BusinessException;

/**
 * Implementación de la fachada de la caja de facturación
 * 
 * @author Daniel Machado Fernández
 * 
 */
public class CashServiceImpl implements CashService {

    private CommandExecutor executor = new CommandExecutor();

    @Override
    public Factura createInvoiceFor(List<Long> idsAveria)
	    throws BusinessException {

	return (Factura) executor.execute(new CreateInvoiceFor(idsAveria));
    }

    @Override
    public Factura findInvoice(Long numeroFactura) throws BusinessException {
	return (Factura) executor.execute(new FindInvoice(numeroFactura));
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<MedioPago> findPayMethodsForInvoice(Long idFactura)
	    throws BusinessException {

	return (List<MedioPago>) executor.execute(new FindPayMethodsForInvoice(
		idFactura));
    }

    @Override
    public void settleInvoice(Long idFactura, Map<Long, Double> cargos)
	    throws BusinessException {
	executor.execute(new SettleInvoice(idFactura, cargos));
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Averia> findRepairsByClient(String dni)
	    throws BusinessException {
	return (List<Averia>) executor.execute(new FindRepairsByClient(dni));
    }

}
