package uo.ri.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Pago en metálico de una factura
 * 
 * @author Daniel Machado Fernández
 * 
 */
@Entity
@DiscriminatorValue("TMetalico")
public class Metalico extends MedioPago {

    public Metalico(double acumulado, Cliente cliente) {
	super(acumulado, cliente);
    }

    public Metalico() {
    }

}
