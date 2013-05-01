package uo.ri.amp.business.impl.paysheet;

import alb.util.BusinessException;
import uo.ri.amp.persistence.NominaFinder;
import uo.ri.business.impl.Command;

/**
 * Busca una nómina por Id mediante un Command
 * 
 * @author Daniel Machado Fernández
 * 
 */
public class FindPaySheetById implements Command {

    private Long idNomina;

    public FindPaySheetById(Long idNomina) {
	this.idNomina = idNomina;
    }

    @Override
    public Object execute() throws BusinessException {
	return NominaFinder.findNominaById(idNomina);
    }

}
