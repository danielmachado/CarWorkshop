package uo.ri.conf;

import uo.ri.amp.business.AdminService;
import uo.ri.amp.business.impl.AdminServiceImpl;
import uo.ri.business.CashService;
import uo.ri.business.ForemanService;
import uo.ri.business.MechanicService;
import uo.ri.business.impl.CashServiceImpl;

/**
 * Factoría de creación de fachadas
 * 
 * @author Daniel Machado Fernández
 * 
 */
public class ServicesFactory {

    public static AdminService getAdminService() {
	return new AdminServiceImpl();
    }

    public static CashService getCashService() {
	return new CashServiceImpl();
    }

    public static MechanicService getMechanicService() {
	return null;
    }

    public static ForemanService getForemanService() {
	return null;
    }
}
