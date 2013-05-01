package uo.ri.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Tipo del vehículo a reparar
 * 
 * @author Daniel Machado Fernández
 * 
 */
@Entity
@Table(name = "TTIPOSVEHICULO")
public class TipoVehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private double precioHora;

    @OneToMany(mappedBy = "tipo")
    private Set<Vehiculo> vehiculos = new HashSet<Vehiculo>();

    public TipoVehiculo() {
    }

    public TipoVehiculo(String nombre, double precioHora) {
	super();
	this.nombre = nombre;
	this.precioHora = precioHora;
    }

    public void addVehiculo(Vehiculo v) {
	v._setTipo(this);
	vehiculos.add(v);
    }

    public void removeVehiculo(Vehiculo v) {
	vehiculos.remove(v);
	v._setTipo(null);
    }

    public String getNombre() {
	return nombre;
    }

    public void setNombre(String nombre) {
	this.nombre = nombre;
    }

    public double getPrecioHora() {
	return precioHora;
    }

    public void setPrecioHora(double precioHora) {
	this.precioHora = precioHora;
    }

    public Long getId() {
	return id;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
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
	TipoVehiculo other = (TipoVehiculo) obj;
	if (nombre == null) {
	    if (other.nombre != null)
		return false;
	} else if (!nombre.equals(other.nombre))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "TipoVehiculo [nombre=" + nombre + ", precioHora=" + precioHora
		+ "]";
    }

    public Set<Vehiculo> getVehiculos() {
	return vehiculos;
    }

}
