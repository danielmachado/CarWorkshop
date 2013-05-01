package uo.ri.amp.ui.admin.action.contract;

import java.util.Date;

import uo.ri.amp.business.AdminService;
import uo.ri.amp.model.Contrato;
import uo.ri.amp.model.Mecanico;
import uo.ri.amp.model.types.TipoContrato;
import uo.ri.conf.ServicesFactory;
import alb.util.BusinessException;
import alb.util.console.Console;
import alb.util.date.DateUtil;
import alb.util.menu.Action;

/**
 * Persentación de agregar un contrato
 * 
 * @author Daniel Machado Fernández
 * 
 */
public class AddContractAction implements Action {

    @Override
    public void execute() throws BusinessException {
	// Pedir datos
	String fechaTerminacion = null;
	Date fechaFin = new Date();

	Long id = Console.readLong("ID Mecánico");

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

	// Procesar
	AdminService as = ServicesFactory.getAdminService();
	Mecanico m = as.findMechanicById(id);

	Contrato con = new Contrato(fechaIni, fechaFin, tipos[tipo],
		salarioBruto);
	con._setMecanico(m);

	as.newContract(con);

	// Mostrar resultado
	Console.println("Nuevo contrato añadido");

    }

}
