package uo.ri.business.impl.cash;

import java.util.List;

import uo.ri.business.impl.Command;
import uo.ri.model.Averia;
import uo.ri.model.Factura;
import uo.ri.persistence.AveriaFinder;
import uo.ri.persistence.FacturaFinder;
import uo.ri.persistence.util.Jpa;
import alb.util.BusinessException;

/**
 * Command que crea el importe a pagar en una factura
 * 
 * @author Daniel Machado Fernández
 * 
 */
public class CreateInvoiceFor implements Command {

    private List<Long> idsAveria;

    public CreateInvoiceFor(List<Long> idsAveria) {
	this.idsAveria = idsAveria;
    }

    public Factura execute() throws BusinessException {

	List<Averia> averias = AveriaFinder.findByIds(idsAveria);
	Factura factura = new Factura(averias);
	
	Long id = FacturaFinder.getNextInvoiceNumber();
	
	factura.setNumero(id);

	Jpa.getManager().persist(factura);

	return factura;
    }

}
