package uo.ri.amp.persistence;

import java.util.List;

import uo.ri.amp.model.Contrato;
import uo.ri.persistence.util.Jpa;

/**
 * Buscador de Contratos según unos parámetros, capa de persistencia
 * 
 * @author Daniel Machado Fernández
 * 
 */
public class ContratoFinder {

    public static Contrato findById(Long id) {
	return Jpa.getManager().find(Contrato.class, id);
    }

    @SuppressWarnings("unchecked")
    public static List<Contrato> findByMechanicId(Long idMecanico) {
	return Jpa.getManager()
		.createNamedQuery("Contrato.findMechanicContracts")
		.setParameter(1, idMecanico).getResultList();
    }

    @SuppressWarnings("unchecked")
    public static List<Contrato> findActiveContracts() {
	return Jpa.getManager()
		.createNamedQuery("Contrato.findActiveContracts")
		.getResultList();
    }

}
