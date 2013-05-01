package uo.ri.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Medio de pago
 * 
 * @author Daniel Machado Fernández
 * 
 */
@Entity
@Table(name = "TMEDIOSPAGO")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class MedioPago {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double acumulado;

    @ManyToOne
    protected Cliente cliente;
    @OneToMany(mappedBy = "medioPago")
    protected Set<Cargo> cargos = new HashSet<Cargo>();

    public MedioPago() {
    }

    public MedioPago(Double acumulado, Cliente cliente) {
	super();
	this.acumulado = acumulado;
	this.cliente = cliente;
    }

    void _setCliente(Cliente c) {
	this.cliente = c;
    }

    public Cliente getCliente() {
	return cliente;
    }

    public Long getId() {
	return id;
    }

    public Double getAcumulado() {
	return acumulado;
    }

    public void setAcumulado(Double acumulado) {
	this.acumulado = acumulado;
    }

    @Override
    public String toString() {
	return "MedioPago [acumulado=" + acumulado + ", cliente=" + cliente
		+ "]";
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((cliente == null) ? 0 : cliente.hashCode());
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
	MedioPago other = (MedioPago) obj;
	if (cliente == null) {
	    if (other.cliente != null)
		return false;
	} else if (!cliente.equals(other.cliente))
	    return false;
	return true;
    }

    Set<Cargo> _getCargos() {
	return cargos;
    }

    public Set<Cargo> getCargos() {
	return Collections.unmodifiableSet(cargos);
    }

}
