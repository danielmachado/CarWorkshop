package uo.ri.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import uo.ri.amp.model.Mecanico;
import uo.ri.model.types.IntervencionKey;

/**
 * Intervención de un mecánico en una avería
 * 
 * @author Daniel Machado Fernández
 * 
 */
@Entity
@Table(name = "TINTERVENCIONES")
@IdClass(IntervencionKey.class)
public class Intervencion {

    private int minutos;
    @Id
    @ManyToOne
    private Averia averia;
    @Id
    @ManyToOne
    private Mecanico mecanico;
    @OneToMany(mappedBy = "intervencion", fetch = FetchType.EAGER)
    private Set<Sustitucion> sustituciones = new HashSet<Sustitucion>();

    public Intervencion() {
    }

    public Intervencion(int minutos) {
	super();
	this.minutos = minutos;
    }

    public Intervencion(Mecanico mecanico, Averia averia) {
	this.mecanico = mecanico;
	this.averia = averia;

	mecanico._getIntervenciones().add(this);
	averia._getIntervenciones().add(this);
    }

    void _setAveria(Averia a) {
	this.averia = a;
    }

    public Averia getAveria() {
	return averia;
    }

    public void _setMecanico(Mecanico m) {
	this.mecanico = m;
    }

    public Mecanico getMecanico() {
	return mecanico;
    }

    public int getMinutos() {
	return minutos;
    }

    public void setMinutos(int minutos) {
	this.minutos = minutos;
    }

    @Override
    public String toString() {
	return "Intervencion [minutos=" + minutos + "]";
    }

    Set<Sustitucion> _getSustituciones() {
	return sustituciones;
    }

    public Set<Sustitucion> getSustituciones() {
	return Collections.unmodifiableSet(sustituciones);
    }

    public double getImporte() {
	double total = 0;

	for (Sustitucion s : sustituciones) {
	    total += s.getImporte();
	}

	return total + calcularManoObra();
    }

    public double calcularManoObra() {
	return (minutos / 60.0)
		* averia.getVehiculo().getTipo().getPrecioHora();
    }

    public void unlink() {
	mecanico._getIntervenciones().remove(this);
	averia._getIntervenciones().remove(this);

	mecanico = null;
	averia = null;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((averia == null) ? 0 : averia.hashCode());
	result = prime * result
		+ ((mecanico == null) ? 0 : mecanico.hashCode());
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
	Intervencion other = (Intervencion) obj;
	if (averia == null) {
	    if (other.averia != null)
		return false;
	} else if (!averia.equals(other.averia))
	    return false;
	if (mecanico == null) {
	    if (other.mecanico != null)
		return false;
	} else if (!mecanico.equals(other.mecanico))
	    return false;
	return true;
    }

}
