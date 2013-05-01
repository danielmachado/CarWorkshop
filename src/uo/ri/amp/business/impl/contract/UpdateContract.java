package uo.ri.amp.business.impl.contract;

import alb.util.BusinessException;
import uo.ri.amp.model.Contrato;
import uo.ri.business.impl.Command;
import uo.ri.persistence.util.Jpa;

/**
 * Actualiza un contrato mediante un Command
 * 
 * @author Daniel Machado Fernández
 * 
 */
public class UpdateContract implements Command {

    private Contrato con;

    public UpdateContract(Contrato con) {
	this.con = con;
    }

    @Override
    public Object execute() throws BusinessException {

	Jpa.getManager().merge(con);

	return null;
    }

}
