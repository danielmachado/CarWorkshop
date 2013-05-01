package uo.ri.amp.persistence;

import java.util.List;

import uo.ri.amp.model.Mecanico;
import uo.ri.persistence.util.Jpa;

/**
 * Busca mecánicos según unos parámetros, capa de persistencia
 * 
 * @author Daniel Machado Fernández
 * 
 */
public class MecanicoFinder {

    public static Mecanico findById(Long id) {

	return Jpa.getManager().find(Mecanico.class, id);
    }

    @SuppressWarnings("unchecked")
    public static List<Mecanico> findAll() {

	return Jpa.getManager().createNamedQuery("Mecanico.findAll")
		.getResultList();
    }

    @SuppressWarnings("unchecked")
    public static List<Mecanico> findAllContrated() {
	return Jpa.getManager().createNamedQuery("Mecanico.findAllContrated")
		.getResultList();
    }

}
