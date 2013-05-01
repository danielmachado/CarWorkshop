package uo.ri.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import uo.ri.model.types.SustitucionKey;

/**
 * Sustitución de un repuesto en una avería
 * 
 * @author Daniel Machado Fernández
 * 
 */
@Entity
@Table(name = "TSUSTITUCIONES")
@IdClass(SustitucionKey.class)
public class Sustitucion {

    private int cantidad;
    @Id
    @ManyToOne
    private Repuesto repuesto;
    @Id
    @ManyToOne
    private Intervencion intervencion;

    public Sustitucion() {
    }

    public Sustitucion(int cantidad, Repuesto repuesto,
	    Intervencion intervencion) {
	super();
	this.cantidad = cantidad;
	this.repuesto = repuesto;
	this.intervencion = intervencion;

	repuesto._getSustituciones().add(this);
	intervencion._getSustituciones().add(this);
    }

    public Sustitucion(Repuesto repuesto, Intervencion intervencion) {
	this.repuesto = repuesto;
	this.intervencion = intervencion;

	repuesto._getSustituciones().add(this);
	intervencion._getSustituciones().add(this);
    }

    public void unlink() {
	repuesto._getSustituciones().remove(this);
	intervencion._getSustituciones().remove(this);

	repuesto = null;
	intervencion = null;
    }

    public int getCantidad() {
	return cantidad;
    }

    public void setCantidad(int cantidad) {
	this.cantidad = cantidad;
    }

    @Override
    public String toString() {
	return "Sustitucion [cantidad=" + cantidad + "]";
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
		+ ((intervencion == null) ? 0 : intervencion.hashCode());
	result = prime * result
		+ ((repuesto == null) ? 0 : repuesto.hashCode());
	return result;
    }

    @Override
    public boolean equals(Object obj) {
	if (this == obj)
	    return true;
	if (obj == null)
	    return false;
	if (getClass() != obj.getClass())
	    return false;
	Sustitucion other = (Sustitucion) obj;
	if (intervencion == null) {
	    if (other.intervencion != null)
		return false;
	} else if (!intervencion.equals(other.intervencion))
	    return false;
	if (repuesto == null) {
	    if (other.repuesto != null)
		return false;
	} else if (!repuesto.equals(other.repuesto))
	    return false;
	return true;
    }

    public Intervencion getIntervencion() {
	return intervencion;
    }

    public Repuesto getRepuesto() {
	return repuesto;
    }

    public double getImporte() {
	return repuesto.getPrecio() * cantidad;
    }

}
