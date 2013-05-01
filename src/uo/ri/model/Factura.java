package uo.ri.model;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import uo.ri.model.types.AveriaStatus;
import uo.ri.model.types.FacturaStatus;
import alb.util.BusinessException;
import alb.util.math.Round;

/**
 * Factura de una serie de averias
 * 
 * @author Daniel Machado Fernández
 * 
 */
@Entity
@Table(name = "TFACTURAS")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private Long numero;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    private double iva;
    private double importe;
    @Enumerated(EnumType.STRING)
    private FacturaStatus status;

    @OneToMany(mappedBy = "factura")
    private Set<Cargo> cargos = new HashSet<Cargo>();
    @OneToMany(mappedBy = "factura")
    private Set<Averia> averias = new HashSet<Averia>();

    public Factura() {
    }

    public Factura(Date today) {
	fecha = today;
    }

    public Factura(List<Averia> averias) throws BusinessException {
	this.numero = 0L;
	assertAveriasTerminadas(averias);
	this.averias.addAll(averias);
	fecha = new java.util.Date();
	calcularImporte();
    }

    private void assertAveriasTerminadas(List<Averia> averias)
	    throws BusinessException {
	for (Averia averia : averias) {
	    if (averia.getStatus() != AveriaStatus.TERMINADA)
		throw new BusinessException("Hay averias no terminadas");
	}

    }

    public Factura(Date _15_6_2012, List<Averia> averias)
	    throws BusinessException {
	this.fecha = _15_6_2012;
	assertAveriasTerminadas(averias);
	this.averias.addAll(averias);
	calcularImporte();
    }

    @SuppressWarnings("deprecation")
    private void calcularImporte() {
	Date fIva = new Date(2012 - 1900, 6, 1);
	if (fecha.compareTo(fIva) < 0)
	    iva = 0.18;
	else
	    iva = 0.21;

	for (Averia a : averias) {
	    importe += a.getImporte();
	    a.setStatus(AveriaStatus.FACTURADA);
	}
	importe += importe * iva;
	importe = Round.twoCents(importe);
	this.status = FacturaStatus.SIN_ABONAR;
    }

    Set<Cargo> _getCargos() {
	return cargos;
    }

    public Set<Cargo> getCargos() {
	return Collections.unmodifiableSet(cargos);
    }

    public void addAveria(Averia a) {
	a._setFactura(this);
	averias.add(a);
    }

    public void removeAveria(Averia a) {
	averias.remove(a);
	a._setFactura(null);
    }

    public Long getId() {
	return id;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
	Factura other = (Factura) obj;
	if (numero == null) {
	    if (other.numero != null)
		return false;
	} else if (!numero.equals(other.numero))
	    return false;
	return true;
    }

    public Long getNumero() {
	return numero;
    }

    public void setNumero(long l) {
	this.numero = l;
    }

    public Date getFecha() {
	return fecha;
    }

    public void setFecha(Date fecha) {
	this.fecha = fecha;
    }

    public double getIva() {
	return iva;
    }

    public void setIva(double iva) {
	this.iva = iva;
    }

    public double getImporte() {
	return importe;
    }

    public void setImporte(double importe) {
	this.importe = importe;
    }

    public FacturaStatus getStatus() {
	return status;
    }

    public void setStatus(FacturaStatus status) {
	this.status = status;
    }

    public void setCargos(Set<Cargo> cargos) {
	this.cargos = cargos;
    }

    @Override
    public String toString() {
	return "Factura [numero=" + numero + ", fecha=" + fecha + ", iva="
		+ iva + ", importe=" + importe + ", status=" + status + "]";
    }

    public Set<Averia> getAverias() {
	return averias;
    }

}
