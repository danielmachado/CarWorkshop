package uo.ri.business.impl.cash;

import alb.util.BusinessException;
import uo.ri.business.impl.Command;
import uo.ri.persistence.AveriaFinder;

/**
 * Command que encuentra las averias por cliente
 * 
 * @author Daniel Machado Fernández
 * 
 */
public class FindRepairsByClient implements Command {

    private String dni;

    public FindRepairsByClient(String dni) {
	this.dni = dni;
    }

    @Override
    public Object execute() throws BusinessException {
	return AveriaFinder.findNoFacturadasByDni(dni);
    }

}
