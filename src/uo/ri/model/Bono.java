package uo.ri.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Transient;

/**
 * Medio de pago de tipo Bono
 * 
 * @author Daniel Machado Fernández
 * 
 */
@Entity
@DiscriminatorValue("TBonos")
public class Bono extends MedioPago {

    private Double disponible;
    @Transient
    @Column(unique = true)
    private String codigo;

    public Bono() {
    }

    public Bono(Double acumulado, Cliente cliente, Double disponible,
	    String codigo) {
	super(acumulado, cliente);
	this.disponible = disponible;
	this.codigo = codigo;
    }

    @Override
    public String toString() {
	return "Bono [disponible=" + disponible + ", codigo=" + codigo + "]";
    }

    public double getDisponible() {
	return disponible;
    }

    public void setDisponible(double disponible) {
	this.disponible = disponible;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (!super.equals(obj))
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Bono other = (Bono) obj;
	if (codigo == null) {
	    if (other.codigo != null)
		return false;
	} else if (!codigo.equals(other.codigo))
	    return false;
	return true;
    }

}
