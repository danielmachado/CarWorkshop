package uo.ri.business.impl.admin;

import uo.ri.amp.model.Mecanico;
import uo.ri.business.impl.Command;
import uo.ri.persistence.util.Jpa;
import alb.util.BusinessException;

/**
 * Command que actualiza un mecánico
 * 
 * @author Daniel Machado Fernández
 * 
 */
public class UpdateMechanic implements Command {

    private Mecanico mecanico;

    public UpdateMechanic(Mecanico mecanico) {
	this.mecanico = mecanico;
    }

    public Object execute() throws BusinessException {

	return Jpa.getManager().merge(mecanico);

    }

}
