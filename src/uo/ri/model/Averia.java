package uo.ri.model;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import uo.ri.amp.model.Mecanico;
import uo.ri.model.types.AveriaStatus;

/**
 * Avería
 * 
 * @author Daniel Machado Fernández
 * 
 */
@Entity
@Table(name = "TAVERIAS")
public class Averia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String descripcion;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    private Double importe;

    @Enumerated(EnumType.STRING)
    private AveriaStatus status;
    @ManyToOne
    private Factura factura;
    @ManyToOne
    private Mecanico mecanico;
    @OneToMany(mappedBy = "averia")
    private Set<Intervencion> intervenciones = new HashSet<Intervencion>();
    @ManyToOne
    private Vehiculo vehiculo;

    public Averia() {
    }

    public Averia(String descripcion, Date fecha, double importe,
	    AveriaStatus status) {
	super();
	this.descripcion = descripcion;
	this.fecha = fecha;
	this.importe = importe;
	this.status = status;
    }

    public Averia(String descripcion) {
	this.descripcion = descripcion;
	fecha = new Date();
    }

    public void addIntervencion(Intervencion i) {
	i._setAveria(this);
	intervenciones.add(i);
    }

    public void removeIntervencion(Intervencion i) {
	intervenciones.remove(i);
	i._setAveria(null);
    }

    @Override
    public String toString() {
	return "Averia [descripcion=" + descripcion + ", fecha=" + fecha
		+ ", importe=" + importe + ", status=" + status + "]";
    }

    public String getDescripcion() {
	return descripcion;
    }

    public void setDescripcion(String descripcion) {
	this.descripcion = descripcion;
    }

    public Date getFecha() {
	return fecha;
    }

    public void setFecha(Date fecha) {
	this.fecha = fecha;
    }

    public double getImporte() {
	double total = 0;
	for (Intervencion i : intervenciones) {
	    total += i.getImporte();
	}
	return total;
    }

    public void setImporte(double importe) {
	this.importe = importe;
    }

    public AveriaStatus getStatus() {
	return status;
    }

    public void setStatus(AveriaStatus status) {
	this.status = status;
    }

    public Factura getFactura() {
	return factura;
    }

    void _setFactura(Factura factura) {
	this.factura = factura;
    }

    public Long getId() {
	return id;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
		+ ((descripcion == null) ? 0 : descripcion.hashCode());
	result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
	result = prime * result
		+ ((vehiculo == null) ? 0 : vehiculo.hashCode());
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
	Averia other = (Averia) obj;
	if (descripcion == null) {
	    if (other.descripcion != null)
		return false;
	} else if (!descripcion.equals(other.descripcion))
	    return false;
	if (fecha == null) {
	    if (other.fecha != null)
		return false;
	} else if (!fecha.equals(other.fecha))
	    return false;
	if (vehiculo == null) {
	    if (other.vehiculo != null)
		return false;
	} else if (!vehiculo.equals(other.vehiculo))
	    return false;
	return true;
    }

    public void _setMecanico(Mecanico m) {
	this.mecanico = m;
    }

    public Mecanico getMecanico() {
	return mecanico;
    }

    void _setVehiculo(Vehiculo vehiculo) {
	this.vehiculo = vehiculo;
    }

    public Vehiculo getVehiculo() {
	return vehiculo;
    }

    public Set<Intervencion> getIntervenciones() {
	return Collections.unmodifiableSet(intervenciones);
    }

    public double calcularImporte() {
	importe = 0.0;
	for (Intervencion i : intervenciones) {
	    importe += i.getImporte() + i.calcularManoObra();
	}
	return importe;

    }

    Set<Intervencion> _getIntervenciones() {
	return intervenciones;
    }

}
