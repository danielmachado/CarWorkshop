package uo.ri.persistence;

import java.util.List;

import uo.ri.model.Averia;
import uo.ri.persistence.util.Jpa;

/**
 * Buscador de Averías según unos parámetros, capa de persistencia
 * 
 * @author Daniel Machado Fernández
 * 
 */
public class AveriaFinder {

    @SuppressWarnings("unchecked")
    public static List<Averia> findByIds(List<Long> idsAveria) {

	return (List<Averia>) Jpa.getManager()
		.createNamedQuery("Averia.findByIds")
		.setParameter(1, idsAveria).getResultList();
    }

    @SuppressWarnings("unchecked")
    public static List<Averia> findNoFacturadasByDni(String dni) {

	return (List<Averia>) Jpa.getManager()
		.createNamedQuery("Averia.findNoFacturadasByDni")
		.setParameter(1, dni).getResultList();
    }

}
