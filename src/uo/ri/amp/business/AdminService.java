package uo.ri.amp.business;

import java.util.List;

import uo.ri.amp.model.Contrato;
import uo.ri.amp.model.Mecanico;
import uo.ri.amp.model.Nomina;
import alb.util.BusinessException;

/**
 * Interface de la fachada de administración
 * 
 * @author Daniel Machado Fernández
 * 
 */
public interface AdminService {

    void newMechanic(Mecanico mecanico) throws BusinessException;

    void deleteMechanic(Long idMecanico) throws BusinessException;

    void updateMechanic(Mecanico mecanico) throws BusinessException;

    Mecanico findMechanicById(Long id) throws BusinessException;

    List<Mecanico> findAllMechanics() throws BusinessException;

    List<Mecanico> findContratedMechanics() throws BusinessException;

    void newContract(Contrato contrato) throws BusinessException;

    Contrato findContractById(Long id) throws BusinessException;

    void updateContract(Contrato con) throws BusinessException;

    void deleteContract(Long idContrato) throws BusinessException;

    List<Contrato> findMechanicContracts(Long idMecanico)
	    throws BusinessException;

    void deletePaySheet(Long id) throws BusinessException;

    Nomina findPaySheetById(Long id) throws BusinessException;

    List<Nomina> findPaySheetsByMechanicId(Long idMecanico)
	    throws BusinessException;

    void generatePaySheets() throws BusinessException;

}
