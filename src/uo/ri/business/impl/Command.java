package uo.ri.business.impl;

import alb.util.BusinessException;

/**
 * Interface para implementar el patrón Command en la aplicación
 * 
 * @author Daniel Machado Fernández
 * 
 */
public interface Command {

    Object execute() throws BusinessException;

}
