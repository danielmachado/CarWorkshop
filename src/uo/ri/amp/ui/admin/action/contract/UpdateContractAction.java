package uo.ri.amp.ui.admin.action.contract;

import java.util.Date;

import uo.ri.amp.business.AdminService;
import uo.ri.amp.model.Contrato;
import uo.ri.amp.model.types.TipoContrato;
import uo.ri.conf.ServicesFactory;
import alb.util.BusinessException;
import alb.util.console.Console;
import alb.util.date.DateUtil;
import alb.util.menu.Action;

/**
 * Presentación de una actualización de un contrato. No se considera que se
 * pueda cambiar el mecánico
 * 
 * @author Daniel Machado Fernández
 * 
 */
public class UpdateContractAction implements Action {

    @Override
    public void execute() throws BusinessException {

	Long id = Console.readLong("ID Contrato");
	String fechaTerminacion = null;
	Date fechaFin = null;

	String fechaInicio = Console.readString("Fecha Inicio(DD/MM/AAAA)");
	Double salarioBruto = Console.readDouble("Salario Bruto");
	int tipo = Console
		.readInt("Tipo de Contrato(1- Indefinido. 2- Obra. 3- Temporal)");
	tipo--;
	if (tipo == 2) {
	    fechaTerminacion = Console
		    .readString("Fecha Terminación(DD/MM/AAAA)");
	    fechaFin = DateUtil.fromString(fechaTerminacion);
	}
	TipoContrato[] tipos = TipoContrato.values();

	Date fechaIni = DateUtil.fromString(fechaInicio);

	AdminService as = ServicesFactory.getAdminService();

	Contrato con = as.findContractById(id);

	con.setFechaFin(fechaFin);
	con.setFechaInicio(fechaIni);
	con.setSalarioBruto(salarioBruto);
	con.setTipo(tipos[tipo]);

	as.updateContract(con);

	// Mostrar resultado
	Console.println("Contrato modificado");

    }

}
