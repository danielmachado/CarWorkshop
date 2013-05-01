package uo.ri.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Vehículo a reparar
 * 
 * @author Daniel Machado Fernández
 * 
 */
@Entity
@Table(name = "TVEHICULOS")
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String matricula;
    private String marca;
    private String modelo;
    @Column(name = "num_averias")
    private int numAverias;

    @ManyToOne
    private Cliente cliente;
    @ManyToOne
    private TipoVehiculo tipo;
    @OneToMany(mappedBy = "vehiculo")
    private Set<Averia> averias = new HashSet<Averia>();

    public Vehiculo() {
    }

    public Vehiculo(String matricula, String modelo, String marca) {
	super();
	this.matricula = matricula;
	this.marca = marca;
	this.modelo = modelo;
	numAverias = 0;
    }

    public void addAveria(Averia a) {
	numAverias++;
	a._setVehiculo(this);
	averias.add(a);
    }

    public void removeAveria(Averia a) {
	numAverias--;
	averias.remove(a);
	a._setVehiculo(null);
    }

    void _setCliente(Cliente c) {
	this.cliente = c;
    }

    public Cliente getCliente() {
	return cliente;
    }

    public String getMatricula() {
	return matricula;
    }

    public void setMatricula(String matricula) {
	this.matricula = matricula;
    }

    public String getMarca() {
	return marca;
    }

    public void setMarca(String marca) {
	this.marca = marca;
    }

    public String getModelo() {
	return modelo;
    }

    public void setModelo(String modelo) {
	this.modelo = modelo;
    }

    public int getNumAverias() {
	return numAverias;
    }

    public void setNumAverias(int numAverias) {
	this.numAverias = numAverias;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
		+ ((matricula == null) ? 0 : matricula.hashCode());
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
	Vehiculo other = (Vehiculo) obj;
	if (matricula == null) {
	    if (other.matricula != null)
		return false;
	} else if (!matricula.equals(other.matricula))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "Vehiculo [matricula=" + matricula + ", marca=" + marca
		+ ", modelo=" + modelo + ", numAverias=" + numAverias + "]";
    }

    void _setTipo(TipoVehiculo tipoVehiculo) {
	this.tipo = tipoVehiculo;
    }

    public TipoVehiculo getTipo() {
	return tipo;
    }

    public Set<Averia> getAverias() {
	return Collections.unmodifiableSet(averias);
    }

    public Long getId() {
	return id;
    }
}
