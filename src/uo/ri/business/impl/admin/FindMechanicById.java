package uo.ri.business.impl.admin;

import uo.ri.amp.persistence.MecanicoFinder;
import uo.ri.business.impl.Command;
import alb.util.BusinessException;

/**
 * Command que encuentra un mecánico por id
 * 
 * @author Daniel Machado Fernández
 * 
 */
public class FindMechanicById implements Command {

    private Long id;

    public FindMechanicById(Long id) {
	this.id = id;
    }

    public Object execute() throws BusinessException {

	return MecanicoFinder.findById(id);

    }

}
