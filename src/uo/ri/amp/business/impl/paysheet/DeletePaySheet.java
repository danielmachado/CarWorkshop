package uo.ri.amp.business.impl.paysheet;

import uo.ri.amp.model.Nomina;
import uo.ri.amp.persistence.NominaFinder;
import uo.ri.business.impl.Command;
import uo.ri.persistence.util.Jpa;
import alb.util.BusinessException;

/**
 * Borra la última nómina (fecha más reciente) de un mecánico mediante un
 * Command
 * 
 * @author Daniel Machado Fernández
 * 
 */
public class DeletePaySheet implements Command {

    private Long idMecanico;

    public DeletePaySheet(Long idMecanico) {
	this.idMecanico = idMecanico;
    }

    // Se buscará la nómina más reciente registrada, que es la que se puede
    // borrar
    @Override
    public Object execute() throws BusinessException {

	Nomina n = NominaFinder.findNominaByMecanicoIdToDelete(idMecanico);

	assertCanBeDeleted(n);

	Jpa.getManager().remove(n);

	return null;
    }

    private void assertCanBeDeleted(Nomina n) throws BusinessException {
	if (n == null)
	    throw new BusinessException("No existen nóminas que borrar");

    }

}
