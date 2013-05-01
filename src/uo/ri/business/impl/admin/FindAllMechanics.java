package uo.ri.business.impl.admin;

import java.util.List;

import uo.ri.amp.model.Mecanico;
import uo.ri.amp.persistence.MecanicoFinder;
import uo.ri.business.impl.Command;

/**
 * Command que encuentra todos los mecánicos
 * 
 * @author Daniel Machado Fernández
 * 
 */
public class FindAllMechanics implements Command {

    public List<Mecanico> execute() {

	return MecanicoFinder.findAll();

    }

}
