package uo.ri.amp.business.impl.contract;

import java.util.Set;

import uo.ri.amp.model.Contrato;
import uo.ri.amp.model.Mecanico;
import uo.ri.amp.model.types.ContratoStatus;
import uo.ri.business.impl.Command;
import uo.ri.persistence.util.Jpa;

/**
 * Agrega un contrato según un Command
 * 
 * @author Daniel Machado Fernández
 * 
 */
public class AddContract implements Command {

    private Contrato contrato;

    public AddContract(Contrato contrato) {
	this.contrato = contrato;
    }

    public Object execute() {

	Jpa.getManager().persist(contrato);

	Mecanico m = contrato.getMecanico();

	Set<Contrato> contratos = m._getContratos();

	// Si existen contratos, se asegura que se ponen a extinto y se
	// persisten
	for (Contrato c : contratos) {
	    if (c.getStatus() == ContratoStatus.ACTIVO) {
		c.setStatus(ContratoStatus.EXTINTO);
		Jpa.getManager().merge(c);
	    }
	}
	m.addContrato(contrato);

	return null;

    }

}
