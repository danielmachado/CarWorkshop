package uo.ri.amp.model;

import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import alb.util.date.DateUtil;
import alb.util.math.Round;

import uo.ri.amp.model.types.ContratoStatus;
import uo.ri.amp.model.types.TipoContrato;

/**
 * Contrato de un mecánico
 * 
 * @author Daniel Machado Fernández
 * 
 */
@Entity
@Table(name = "TCONTRATOS")
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Temporal(TemporalType.DATE)
    private Date fechaFin;
    private Double salarioBruto;
    @Enumerated(EnumType.STRING)
    private ContratoStatus status;
    @Enumerated(EnumType.STRING)
    private TipoContrato tipo;
    private Double pagaLiquidacion;
    @Temporal(TemporalType.DATE)
    private Date fechaLiquidacion;

    @ManyToOne
    private Mecanico mecanico;

    @OneToMany(mappedBy = "contrato", fetch = FetchType.EAGER)
    private Set<Nomina> nominas = new HashSet<Nomina>();

    public Contrato(Date fechaInicio, Date fechaFin, TipoContrato tipo,
	    Double salarioBruto) {
	if (tipo == TipoContrato.TEMPORAL)
	    this.fechaFin = fechaFin;
	this.fechaInicio = fechaInicio;
	this.tipo = tipo;

	status = ContratoStatus.ACTIVO;
	this.salarioBruto = salarioBruto;
    }

    public Contrato() {
    }

    public Long getId() {
	return id;
    }

    public Date getFechaInicio() {
	return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
	this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
	return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
	this.fechaFin = fechaFin;
    }

    public Double getSalarioBruto() {
	return salarioBruto;
    }

    public void setSalarioBruto(Double salarioBruto) {
	this.salarioBruto = salarioBruto;
    }

    public ContratoStatus getStatus() {
	return status;
    }

    public void setStatus(ContratoStatus status) {
	if (status == ContratoStatus.EXTINTO) {
	    fechaLiquidacion = fechaFin = DateUtil.today();
	    calcularLiquidacion();
	}
	this.status = status;
    }

    public TipoContrato getTipo() {
	return tipo;
    }

    public void setTipo(TipoContrato tipo) {
	this.tipo = tipo;
    }

    public Mecanico getMecanico() {
	return mecanico;
    }

    public void _setMecanico(Mecanico mecanico) {
	this.mecanico = mecanico;
    }

    public void setNominas(Set<Nomina> nominas) {
	this.nominas = nominas;
    }

    public Set<Nomina> getNominas() {
	return Collections.unmodifiableSet(nominas);
    }

    public Set<Nomina> _getNominas() {
	return nominas;
    }

    public Double getPagaLiquidacion() {
	return pagaLiquidacion;
    }

    /*
     * Se calcula el salario bruto por mes, luego lo que sería por día y se
     * multiplica por 20 días que percibiría por año trabajado (offset). No es
     * importante que el metodo getYear sea deprecated pues se comparan dos
     * puntos y se restan que te devuelven (la distancia será la misma aunque
     * devuelva años incorrectos, lo serán los dos)
     */
    @SuppressWarnings("deprecation")
    private void calcularLiquidacion() {
	int offset = fechaFin.getYear() - fechaInicio.getYear();
	pagaLiquidacion = Round.twoCents((((salarioBruto / 12) / 30) * 20)
		* offset);

    }

    public void setPagaLiquidacion(Double pagaLiquidacion) {
	this.pagaLiquidacion = pagaLiquidacion;
    }

    public Date getFechaLiquidacion() {
	return fechaLiquidacion;
    }

    public void setFechaLiquidacion(Date fechaLiquidacion) {
	this.fechaLiquidacion = fechaLiquidacion;
    }

    public void addNomina(Nomina n) {
	n.setContrato(this);
	nominas.add(n);

    }

    public void removeNomina(Nomina n) {
	nominas.remove(n);
	n.setContrato(null);
    }

    /*
     * Los asteriscos indican que es el contrato activo.
     */
    @Override
    public String toString() {
	String res = "Contrato [id=" + id + ", fechaInicio=" + fechaInicio
		+ ", fechaFin=" + fechaFin + ", salarioBruto=" + salarioBruto
		+ ", status=" + status + ", tipo=" + tipo + ", mecanico="
		+ mecanico + ", nominas=" + nominas.size();

	if (status == ContratoStatus.EXTINTO)
	    res += ", pagaLiquidacion=" + pagaLiquidacion;
	else
	    res += " ***** ";
	res += "]";

	return res;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
		+ ((fechaFin == null) ? 0 : fechaFin.hashCode());
	result = prime * result
		+ ((fechaInicio == null) ? 0 : fechaInicio.hashCode());
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
	Contrato other = (Contrato) obj;
	if (fechaFin == null) {
	    if (other.fechaFin != null)
		return false;
	} else if (!fechaFin.equals(other.fechaFin))
	    return false;
	if (fechaInicio == null) {
	    if (other.fechaInicio != null)
		return false;
	} else if (!fechaInicio.equals(other.fechaInicio))
	    return false;
	if (mecanico == null) {
	    if (other.mecanico != null)
		return false;
	} else if (!mecanico.equals(other.mecanico))
	    return false;
	return true;
    }

}
