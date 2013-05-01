package uo.ri.amp.business.impl.mechanic;

import uo.ri.amp.model.Mecanico;
import uo.ri.business.impl.Command;
import uo.ri.persistence.util.Jpa;
import alb.util.BusinessException;

/**
 * Borra un mecanico según unas condiciones mediante un Command
 * 
 * @author Daniel Machado Fernández
 * 
 */
public class DeleteMechanic implements Command {

    private Long idMecanico;

    public DeleteMechanic(Long idMecanico) {
	this.idMecanico = idMecanico;
    }

    public Object execute() throws BusinessException {

	Mecanico m = Jpa.getManager().find(Mecanico.class, idMecanico);

	assertNotNull(m);
	assertCanBeDeleted(m);

	Jpa.getManager().remove(m);

	return null;

    }

    /*
     * Si no tiene contrato, ya no va a tener una nómina luego lo no hace falta
     * comprobarlo
     */
    private void assertCanBeDeleted(Mecanico m) throws BusinessException {
	if (m.getContratos().size() != 0) {
	    throw new BusinessException(
		    "No se puede borrar porque tiene Contratos");
	}

	if (m.getIntervenciones().size() != 0) {
	    throw new BusinessException(
		    "El mecanico no se puede borrar porque tiene Intervenciones");
	}
	if (m.getAsignadas().size() != 0) {
	    throw new BusinessException(
		    "El mecanico no se puede borrar porque tiene averias asignadas");
	}
    }

    private void assertNotNull(Mecanico m) throws BusinessException {
	if (m == null) {
	    throw new BusinessException("El mecanico no existe");
	}
    }

}
