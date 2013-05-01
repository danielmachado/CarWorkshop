package uo.ri.amp.business.impl.contract;

import uo.ri.amp.persistence.ContratoFinder;
import uo.ri.business.impl.Command;
import alb.util.BusinessException;

/**
 * Busca un contrato por ID mediante un Command
 * 
 * @author Daniel Machado Fernández
 * 
 */
public class FindContractById implements Command {

    private Long id;

    public FindContractById(Long id) {
	this.id = id;
    }

    @Override
    public Object execute() throws BusinessException {

	return ContratoFinder.findById(id);
    }

}
