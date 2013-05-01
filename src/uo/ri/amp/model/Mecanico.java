package uo.ri.amp.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import uo.ri.model.Averia;
import uo.ri.model.Intervencion;

/**
 * Mecanico modificado para la ampliación de nóminas
 * 
 * @author Daniel Machado Fernández
 * 
 */
@Entity
@Table(name = "TMECANICOS")
public class Mecanico {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private String apellidos;

    @OneToMany(mappedBy = "mecanico")
    private Set<Averia> averias = new HashSet<Averia>();
    @OneToMany(mappedBy = "mecanico", fetch = FetchType.EAGER)
    private Set<Intervencion> intervenciones = new HashSet<Intervencion>();
    @OneToMany(mappedBy = "mecanico", fetch = FetchType.EAGER)
    private Set<Contrato> contratos = new HashSet<Contrato>();

    public Mecanico() {
    }

    public Mecanico(String nombre, String apellidos) {
	super();
	this.nombre = nombre;
	this.apellidos = apellidos;
    }

    public void addAveria(Averia a) {
	a._setMecanico(this);
	averias.add(a);
    }

    public void removeAveria(Averia a) {
	averias.remove(a);
	a._setMecanico(null);
    }

    public void addIntervencion(Intervencion i) {
	i._setMecanico(this);
	intervenciones.add(i);
    }

    public void removeIntervencion(Intervencion i) {
	intervenciones.remove(i);
	i._setMecanico(null);
    }

    public void addContrato(Contrato c) {
	c._setMecanico(this);
	contratos.add(c);
    }

    public void removeContrato(Contrato c) {
	contratos.remove(c);
	c._setMecanico(null);
    }

    public Long getId() {
	return id;
    }

    public String getNombre() {
	return nombre;
    }

    public void setNombre(String nombre) {
	this.nombre = nombre;
    }

    public String getApellidos() {
	return apellidos;
    }

    public void setApellidos(String apellidos) {
	this.apellidos = apellidos;
    }

    public Set<Averia> getAsignadas() {
	return Collections.unmodifiableSet(averias);
    }

    /*
     * Previamente estaba con visibilidad package, debido a que sólo debía ser
     * modificable por las clases asociativas pero al realizar la ampliación se
     * ha tenido que trasladar aquí
     */
    public Set<Intervencion> _getIntervenciones() {
	return intervenciones;
    }

    public Set<Intervencion> getIntervenciones() {
	return Collections.unmodifiableSet(intervenciones);
    }

    public Set<Contrato> getContratos() {
	return Collections.unmodifiableSet(contratos);
    }

    public Set<Contrato> _getContratos() {
	return contratos;
    }

    @Override
    public String toString() {
	return "Mecanico [nombre=" + nombre + ", apellidos=" + apellidos + "]";
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
		+ ((apellidos == null) ? 0 : apellidos.hashCode());
	result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
	Mecanico other = (Mecanico) obj;
	if (apellidos == null) {
	    if (other.apellidos != null)
		return false;
	} else if (!apellidos.equals(other.apellidos))
	    return false;
	if (nombre == null) {
	    if (other.nombre != null)
		return false;
	} else if (!nombre.equals(other.nombre))
	    return false;
	return true;
    }

}
