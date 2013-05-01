package uo.ri.amp.business.impl.mechanic;

import java.util.List;

import uo.ri.amp.model.Mecanico;
import uo.ri.amp.persistence.MecanicoFinder;
import uo.ri.business.impl.Command;

/**
 * Busca los mecanicos con contrato activo mediante un Command
 * 
 * @author Daniel Machado Fernández
 * 
 */
public class FindContratedMechanics implements Command {

    @Override
    public List<Mecanico> execute() {
	return MecanicoFinder.findAllContrated();
    }

}
