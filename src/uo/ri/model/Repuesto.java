package uo.ri.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Repuesto empleado en una avería
 * 
 * @author Daniel Machado Fernández
 * 
 */
@Entity
@Table(name = "TREPUESTOS")
public class Repuesto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Transient
    @Column(unique = true)
    private String codigo;
    @Column(name = "nombre")
    private String descripcion;
    private double precio;

    @OneToMany(mappedBy = "repuesto")
    private Set<Sustitucion> sustituciones = new HashSet<Sustitucion>();

    public Repuesto() {
    }

    public Repuesto(String codigo, String descripcion, double precio) {
	super();
	this.codigo = codigo;
	this.descripcion = descripcion;
	this.precio = precio;
    }

    public Repuesto(String descripcion, double precio) {
	this.descripcion = descripcion;
	this.precio = precio;
    }

    public String getCodigo() {
	return codigo;
    }

    public void setCodigo(String codigo) {
	this.codigo = codigo;
    }

    public Long getId() {
	return id;
    }

    public String getDescripcion() {
	return descripcion;
    }

    public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
    }

    public double getPrecio() {
	return precio;
    }

    public void setPrecio(double precio) {
	this.precio = precio;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
	Repuesto other = (Repuesto) obj;
	if (codigo == null) {
	    if (other.codigo != null)
		return false;
	} else if (!codigo.equals(other.codigo))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "Repuesto [codigo=" + codigo + ", descripcion=" + descripcion
		+ ", precio=" + precio + "]";
    }

    Set<Sustitucion> _getSustituciones() {
	return sustituciones;
    }

    public Set<Sustitucion> getSustituciones() {
	return Collections.unmodifiableSet(sustituciones);
    }

}
