package uo.ri.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Medio de pago que representa una tarjeta de crédito
 * 
 * @author Daniel Machado Fernández
 * 
 */
@Entity
@DiscriminatorValue("TTarjetasCredito")
public class TarjetaCredito extends MedioPago {

    private String tipo;
    @Temporal(TemporalType.DATE)
    private Date validez;
    @Column(unique = true)
    private String numero;

    public TarjetaCredito() {
    }

    public TarjetaCredito(double acumulado, Cliente cliente, String tipo,
	    Date validez, String numero) {
	super(acumulado, cliente);
	this.tipo = tipo;
	this.validez = validez;
	this.numero = numero;
    }

    public String getTipo() {
	return tipo;
    }

    public void setTipo(String tipo) {
	this.tipo = tipo;
    }

    public Date getValidez() {
	return validez;
    }

    public void setValidez(Date validez) {
	this.validez = validez;
    }

    public String getNumero() {
	return numero;
    }

    public void setNumero(String numero) {
	this.numero = numero;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = super.hashCode();
	result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
	TarjetaCredito other = (TarjetaCredito) obj;
	if (numero == null) {
	    if (other.numero != null)
		return false;
	} else if (!numero.equals(other.numero))
	    return false;
	return true;
    }

    @Override
    public String toString() {
	return "TarjetaCredito [tipo=" + tipo + ", validez=" + validez
		+ ", numero=" + numero + "]";
    }
}
