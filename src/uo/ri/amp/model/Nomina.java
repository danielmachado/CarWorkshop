package uo.ri.amp.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import uo.ri.model.Intervencion;
import alb.util.date.DateUtil;
import alb.util.math.Round;

/**
 * Nómina mensual de un mecánico
 * 
 * @author Daniel Machado Fernández
 * 
 */
@Entity
@Table(name = "TNOMINAS")
public class Nomina {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date fecha;
    private Double IRPF;
    private Double pagaExtra;
    private Double plus;
    private Double salarioBase;
    private Double segSocial;
    private Integer trienio;

    @ManyToOne
    private Contrato contrato;

    public Nomina() {

    }

    /**
     * Inicializa la clase Nómina según un contrato
     */
    public void setUp() {
	IRPF = 0.0;
	trienio = 0;
	plus = 0.0;
	fecha = DateUtil.today();
	pagaExtra = 0.0;
	salarioBase = 0.0;
	segSocial = 0.0;

	double bruto = contrato.getSalarioBruto();

	// calcula IRPF

	if (bruto < 12000)
	    IRPF = 0.07;
	else if (bruto < 15000)
	    IRPF = 0.1;
	else if (bruto < 20000)
	    IRPF = 0.13;
	else if (bruto < 25000)
	    IRPF = 0.17;
	else if (bruto < 30000)
	    IRPF = 0.2;

	// calcula trienios

	Date fechaIni = contrato.getFechaInicio();

	while (DateUtil.isAfter((DateUtil.subDays(DateUtil.today(), 365 * 3)),
		fechaIni)) {
	    trienio += 50;
	}

	// calcula plus intervenciones (se presupone que son las del mes), se toman como referencia 30 días (podría refinarse...)

	for (Intervencion i : contrato.getMecanico().getIntervenciones()) {
	    if(DateUtil.isDateInWindow(i.getAveria().getFecha(), DateUtil.subDays(DateUtil.today(), 30), DateUtil.today()))
	    	plus += Round.twoCents(i.getImporte() * 0.05);
	}

	// calcula paga extra y seguridad social

	if (DateUtil.month(fecha) == 6 || DateUtil.month(fecha) == 12) {
	    pagaExtra = Round.twoCents(bruto / 14);
	    segSocial = 0.1;
	} else
	    segSocial = 0.05;

	// calcula salario base

	salarioBase = Round.twoCents(bruto / 14);
    }

    public Long getId() {
	return id;
    }

    public Date getFecha() {
	return fecha;
    }

    public void setFecha(Date fecha) {
	this.fecha = fecha;
    }

    public Double getIRPF() {
	return IRPF;
    }

    public void setIRPF(Double iRPF) {
	IRPF = iRPF;
    }

    public Double getPagaExtra() {
	return pagaExtra;
    }

    public void setPagaExtra(Double pagaExtra) {
	this.pagaExtra = pagaExtra;
    }

    public Double getPlus() {
	return plus;
    }

    public void setPlus(Double plus) {
	this.plus = plus;
    }

    public Double getSalarioBase() {
	return salarioBase;
    }

    public void setSalarioBase(Double salarioBase) {
	this.salarioBase = salarioBase;
    }

    public Double getSegSocial() {
	return segSocial;
    }

    public void setSegSocial(Double segSocial) {
	this.segSocial = segSocial;
    }

    public Integer getTrienio() {
	return trienio;
    }

    public void setTrienio(Integer trienio) {
	this.trienio = trienio;
    }

    public Contrato getContrato() {
	return contrato;
    }

    public void setContrato(Contrato contrato) {
	this.contrato = contrato;
    }

    @Override
    public String toString() {
	setUp();
	return "Nomina [id=" + id + ", fecha=" + fecha + ", IRPF=" + IRPF
		+ ", pagaExtra=" + pagaExtra + ", plus=" + plus
		+ ", salarioBase=" + salarioBase + ", segSocial=" + segSocial
		+ ", trienio=" + trienio + ", total neto= " + calcularNeto()
		+ "]";
    }

    /*
     * toString para mostrar en el listado
     */
    public String shortString() {
	setUp();
	String res = "Nomina [id=" + id + ", fecha=" + fecha + ", total neto= "
		+ calcularNeto() + "]";

	return res;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result
		+ ((contrato == null) ? 0 : contrato.hashCode());
	result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
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
	Nomina other = (Nomina) obj;
	if (contrato == null) {
	    if (other.contrato != null)
		return false;
	} else if (!contrato.equals(other.contrato))
	    return false;
	if (fecha == null) {
	    if (other.fecha != null)
		return false;
	} else if (!fecha.equals(other.fecha))
	    return false;
	return true;
    }

    private Double calcularNeto() {

	Double total = salarioBase;

	total -= total * segSocial;

	total += pagaExtra;

	total += plus;

	total += trienio;

	total -= total * IRPF;

	return Round.twoCents(total);

    }
}
