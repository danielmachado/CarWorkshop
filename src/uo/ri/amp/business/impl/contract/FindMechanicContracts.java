package uo.ri.amp.business.impl.contract;

import java.util.List;

import uo.ri.amp.model.Contrato;
import uo.ri.amp.persistence.ContratoFinder;
import uo.ri.business.impl.Command;
import alb.util.BusinessException;

/**
 * Busca los contratos de un mecánico mediante un Command
 * 
 * @author Daniel Machado Fernández
 * 
 */
public class FindMechanicContracts implements Command {

    private Long idMecanico;

    public FindMechanicContracts(Long idMecanico) {
	this.idMecanico = idMecanico;
    }

    @Override
    public List<Contrato> execute() throws BusinessException {
	return ContratoFinder.findByMechanicId(idMecanico);
    }

}
