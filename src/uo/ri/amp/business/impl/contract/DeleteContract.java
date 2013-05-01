package uo.ri.amp.business.impl.contract;

import alb.util.BusinessException;
import uo.ri.amp.model.Contrato;
import uo.ri.amp.model.types.ContratoStatus;
import uo.ri.business.impl.Command;
import uo.ri.persistence.util.Jpa;

/**
 * Borra un contrato mediante un Command
 * 
 * @author Daniel Machado Fernández
 * 
 */
public class DeleteContract implements Command {

    private Long idContrato;

    public DeleteContract(Long idContrato) {
	this.idContrato = idContrato;
    }

    /*
     * Se pone a Extinto, si luego se puede borrar, se borrará
     */
    @Override
    public Object execute() throws BusinessException {

	Contrato con = Jpa.getManager().find(Contrato.class, idContrato);

	con.setStatus(ContratoStatus.EXTINTO);
	Jpa.getManager().merge(con);

	assertCanBeDeleted(con);

	Jpa.getManager().remove(con);
	return null;
    }

    private void assertCanBeDeleted(Contrato con) throws BusinessException {

	if (con.getMecanico().getIntervenciones().size() != 0)
	    throw new BusinessException(
		    "No se puede borrar el contrato por tener intervenciones activas");
	if (con.getMecanico().getAsignadas().size() != 0)
	    throw new BusinessException(
		    "No se puede borrar el contrato por tener averias asignadas");
	if (con.getNominas().size() != 0)
	    throw new BusinessException(
		    "No se puede borrar el contrato por tener nóminas asignadas");

    }

}
