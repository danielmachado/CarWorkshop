package uo.ri.ui.admin.action;

import uo.ri.amp.business.AdminService;
import uo.ri.amp.model.Mecanico;
import uo.ri.conf.ServicesFactory;
import alb.util.BusinessException;
import alb.util.console.Console;
import alb.util.menu.Action;

/**
 * Presentación de un actualización de un mecánico
 * 
 * @author Daniel Machado Fernández
 * 
 */
public class UpdateMechanicAction implements Action {

    @Override
    public void execute() throws BusinessException {

	// Pedir datos
	Long id = Console.readLong("Id del mecánico");
	String nombre = Console.readString("Nombre");
	String apellidos = Console.readString("Apellidos");

	// Procesar
	AdminService as = ServicesFactory.getAdminService();

	Mecanico m = as.findMechanicById(id);
	m.setNombre(nombre);
	m.setApellidos(apellidos);

	as.updateMechanic(m);

	// Mostrar resultado
	Console.println("Mecánico actualizado");
    }

}
