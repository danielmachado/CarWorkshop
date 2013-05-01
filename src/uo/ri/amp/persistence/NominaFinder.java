package uo.ri.amp.persistence;

import uo.ri.amp.model.Nomina;
import uo.ri.persistence.util.Jpa;

/**
 * Buscador de nóminas según unos parámetros, capa de persistencia
 * 
 * @author Daniel Machado Fernández
 * 
 */
public class NominaFinder {

    public static Nomina findNominaById(Long idNomina) {
	return Jpa.getManager().find(Nomina.class, idNomina);
    }

    public static Object findNominasByMecanicoId(Long idMecanico) {
	return Jpa.getManager()
		.createNamedQuery("Nomina.findNominasByMecanicoId")
		.setParameter(1, idMecanico).getResultList();
    }

    public static Nomina findNominaByMecanicoIdToDelete(Long idMecanico) {
	return (Nomina) Jpa.getManager()
		.createNamedQuery("Nomina.findNominaByMecanicoIdToDelete")
		.setParameter(1, idMecanico).getResultList().get(0);
    }

}
