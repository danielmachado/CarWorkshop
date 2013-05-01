package uo.ri.ui.admin.action;

import uo.ri.amp.business.AdminService;
import uo.ri.amp.model.Mecanico;
import uo.ri.conf.ServicesFactory;
import alb.util.BusinessException;
import alb.util.console.Console;
import alb.util.menu.Action;

/**
 * Presentación de una agregación de un mecánico
 * 
 * @author Daniel Machado Fernández
 * 
 */
public class AddMechanicAction implements Action {

    @Override
    public void execute() throws BusinessException {

	// Pedir datos
	String nombre = Console.readString("Nombre");
	String apellidos = Console.readString("Apellidos");

	// Procesar
	AdminService as = ServicesFactory.getAdminService();
	as.newMechanic(new Mecanico(nombre, apellidos));

	// Mostrar resultado
	Console.println("Nuevo mecánico añadido");
    }

}
