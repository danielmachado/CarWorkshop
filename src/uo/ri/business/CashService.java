package uo.ri.business;

import java.util.List;
import java.util.Map;

import uo.ri.model.Averia;
import uo.ri.model.Factura;
import uo.ri.model.MedioPago;
import alb.util.BusinessException;

/**
 * Interface de la fachada de la caja de facturación
 * 
 * @author Daniel Machado Fernández
 * 
 */
public interface CashService {

    Factura createInvoiceFor(List<Long> idsAveria) throws BusinessException;

    Factura findInvoice(Long numeroFactura) throws BusinessException;

    List<MedioPago> findPayMethodsForInvoice(Long idFactura)
	    throws BusinessException;

    void settleInvoice(Long idFactura, Map<Long, Double> cargos)
	    throws BusinessException;

    List<Averia> findRepairsByClient(String dni) throws BusinessException;

    // resto de métodos que faltan...

}
