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

import uo.ri.model.types.Address;

/**
 * Cliente
 * 
 * @author Daniel Machado Fernández
 * 
 */
@Entity
@Table(name = "TCLIENTES")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String dni;
    private String nombre;
    private String apellidos;
    private Address direccion;

    @OneToMany(mappedBy = "cliente")
    private Set<Vehiculo> vehiculos = new HashSet<Vehiculo>();
    @OneToMany(mappedBy = "cliente")
    private Set<MedioPago> medios = new HashSet<MedioPago>();

    public Cliente() {
    }

    public Cliente(String dni, String nombre, String apellidos,
	    Address direccion) {
	super();
	this.dni = dni;
	this.nombre = nombre;
	this.apellidos = apellidos;
	this.direccion = direccion;
    }

    public Cliente(String nombre, String apellidos, String dni) {
	this.nombre = nombre;
	this.apellidos = apellidos;
	this.dni = dni;
    }

    public void addVehiculo(Vehiculo v) {
	v._setCliente(this);
	vehiculos.add(v);
    }

    public void removeVehiculo(Vehiculo v) {
	vehiculos.remove(v);
	v._setCliente(null);
    }

    public void addMedioPago(MedioPago m) {
	m._setCliente(this);
	medios.add(m);
    }

    public void removeMedioPago(MedioPago m) {
	medios.remove(m);
	m._setCliente(null);
    }

    public String getDni() {
	return dni;
    }

    public void setDni(String dni) {
	this.dni = dni;
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

    public Address getDireccion() {
	return direccion;
    }

    public void setDireccion(Address direccion) {
	this.direccion = direccion;
    }

    public Long getId() {
	return id;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((dni == null) ? 0 : dni.hashCode());
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
	Cliente other = (Cliente) obj;
	if (dni == null) {
	    if (other.dni != null)
		return false;
	} else if (!dni.equals(other.dni))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "Cliente [dni=" + dni + ", nombre=" + nombre + ", apellidos="
		+ apellidos + ", direccion=" + direccion + "]";
    }

    public Set<Vehiculo> getVehiculos() {
	return Collections.unmodifiableSet(vehiculos);
    }

    public Set<MedioPago> getMediosPago() {
	return Collections.unmodifiableSet(medios);
    }

}
