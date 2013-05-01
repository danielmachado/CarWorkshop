package uo.ri.business.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import uo.ri.persistence.util.Jpa;
import alb.util.BusinessException;

/**
 * Executor del patrón Command, permite separar el código repetido en diversas
 * clases demás de implementar el Command
 * 
 * @author Daniel Machado Fernández
 * 
 */
public class CommandExecutor {

    public Object execute(Command command) throws BusinessException {

	EntityManager em = Jpa.createEntityManager();
	EntityTransaction trx = em.getTransaction();
	trx.begin();

	Object res = null;

	try {

	    res = command.execute();
	    trx.commit();

	} catch (BusinessException be) {
	    trx.rollback();
	    throw be;
	} catch (PersistenceException pe) {
	    if (trx.isActive())
		trx.rollback();
	    throw pe;
	} finally {
	    if (em.isOpen())
		em.close();
	}

	return res;

    }

}
