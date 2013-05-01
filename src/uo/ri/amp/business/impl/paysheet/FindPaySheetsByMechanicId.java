package uo.ri.amp.business.impl.paysheet;

import alb.util.BusinessException;
import uo.ri.amp.persistence.NominaFinder;
import uo.ri.business.impl.Command;

/**
 * Encuentra las nóminas según un id de mecánico mediante un Command
 * 
 * @author Daniel Machado Fernández
 * 
 */
public class FindPaySheetsByMechanicId implements Command {

    private Long idMecanico;

    public FindPaySheetsByMechanicId(Long idMecanico) {
	this.idMecanico = idMecanico;
    }

    @Override
    public Object execute() throws BusinessException {
	return NominaFinder.findNominasByMecanicoId(idMecanico);
    }

}
