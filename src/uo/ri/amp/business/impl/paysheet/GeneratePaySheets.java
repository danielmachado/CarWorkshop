package uo.ri.amp.business.impl.paysheet;

import java.util.List;

import uo.ri.amp.model.Contrato;
import uo.ri.amp.model.Nomina;
import uo.ri.amp.persistence.ContratoFinder;
import uo.ri.business.impl.Command;
import uo.ri.persistence.util.Jpa;
import alb.util.BusinessException;

/**
 * Genera las nóminas de los contratos activos en el sistema mediante un Command
 * 
 * @author Daniel Machado Fernández
 * 
 */
public class GeneratePaySheets implements Command {

    @Override
    public Object execute() throws BusinessException {

	List<Contrato> contratos = ContratoFinder.findActiveContracts();

	for (Contrato c : contratos) {
	    Nomina n = new Nomina();
	    c.addNomina(n);
	    // El metodo setUp, actualiza los valores de la nómina según un
	    // contrato
	    n.setUp();
	    Jpa.getManager().persist(n);
	}

	return null;
    }

}
