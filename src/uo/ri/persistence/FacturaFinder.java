package uo.ri.persistence;

import uo.ri.model.Factura;
import uo.ri.persistence.util.Jpa;

/**
 * Buscador de facturas según unos parámetros, capa de persistencia
 * 
 * @author Daniel Machado Fernández
 * 
 */
public class FacturaFinder {

    public static Factura findByNumber(Long numero) {

	return (Factura) Jpa.getManager()
		.createNamedQuery("Factura.findByNumber")
		.setParameter(1, numero);
    }

    public static Factura findById(Long id) {

	return (Factura) Jpa.getManager().createNamedQuery("Factura.findById")
		.setParameter(1, id);
    }

    public static Long getNextInvoiceNumber() {

	return (Long) Jpa.getManager()
		.createNamedQuery("Factura.getNextInvoiceNumber")
		.getSingleResult();
    }

}
