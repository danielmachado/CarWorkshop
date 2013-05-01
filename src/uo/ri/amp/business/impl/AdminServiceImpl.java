package uo.ri.amp.business.impl;

import java.util.List;

import uo.ri.amp.business.AdminService;
import uo.ri.amp.business.impl.contract.AddContract;
import uo.ri.amp.business.impl.contract.DeleteContract;
import uo.ri.amp.business.impl.contract.FindContractById;
import uo.ri.amp.business.impl.contract.FindMechanicContracts;
import uo.ri.amp.business.impl.contract.UpdateContract;
import uo.ri.amp.business.impl.mechanic.DeleteMechanic;
import uo.ri.amp.business.impl.mechanic.FindContratedMechanics;
import uo.ri.amp.business.impl.paysheet.DeletePaySheet;
import uo.ri.amp.business.impl.paysheet.FindPaySheetById;
import uo.ri.amp.business.impl.paysheet.FindPaySheetsByMechanicId;
import uo.ri.amp.business.impl.paysheet.GeneratePaySheets;
import uo.ri.amp.model.Contrato;
import uo.ri.amp.model.Mecanico;
import uo.ri.amp.model.Nomina;
import uo.ri.business.impl.CommandExecutor;
import uo.ri.business.impl.admin.AddMechanic;
import uo.ri.business.impl.admin.FindAllMechanics;
import uo.ri.business.impl.admin.FindMechanicById;
import uo.ri.business.impl.admin.UpdateMechanic;
import alb.util.BusinessException;

/**
 * Implementación de la Fachada de Servicios de Administración
 * 
 * @author Daniel Machado Fernández
 * 
 */
public class AdminServiceImpl implements AdminService {

    private CommandExecutor executor = new CommandExecutor();

    @Override
    public void newMechanic(Mecanico mecanico) throws BusinessException {
	executor.execute(new AddMechanic(mecanico));
    }

    @Override
    public void updateMechanic(Mecanico mecanico) throws BusinessException {
	executor.execute(new UpdateMechanic(mecanico));
    }

    @Override
    public void deleteMechanic(Long idMecanico) throws BusinessException {
	executor.execute(new DeleteMechanic(idMecanico));
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Mecanico> findAllMechanics() throws BusinessException {
	return (List<Mecanico>) executor.execute(new FindAllMechanics());
    }

    @Override
    public Mecanico findMechanicById(Long id) throws BusinessException {
	return (Mecanico) executor.execute(new FindMechanicById(id));
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Mecanico> findContratedMechanics() throws BusinessException {
	return (List<Mecanico>) executor.execute(new FindContratedMechanics());
    }

    @Override
    public void newContract(Contrato contrato) throws BusinessException {
	executor.execute(new AddContract(contrato));
    }

    @Override
    public Contrato findContractById(Long id) throws BusinessException {
	return (Contrato) executor.execute(new FindContractById(id));
    }

    @Override
    public void updateContract(Contrato con) throws BusinessException {
	executor.execute(new UpdateContract(con));
    }

    @Override
    public void deleteContract(Long idContrato) throws BusinessException {
	executor.execute(new DeleteContract(idContrato));
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Contrato> findMechanicContracts(Long idMecanico)
	    throws BusinessException {
	return (List<Contrato>) executor.execute(new FindMechanicContracts(
		idMecanico));
    }

    @Override
    public void deletePaySheet(Long idMecanico) throws BusinessException {
	executor.execute(new DeletePaySheet(idMecanico));
    }

    @Override
    public Nomina findPaySheetById(Long idNomina) throws BusinessException {
	return (Nomina) executor.execute(new FindPaySheetById(idNomina));
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Nomina> findPaySheetsByMechanicId(Long idMecanico)
	    throws BusinessException {
	return (List<Nomina>) executor.execute(new FindPaySheetsByMechanicId(
		idMecanico));
    }

    @Override
    public void generatePaySheets() throws BusinessException {
	executor.execute(new GeneratePaySheets());
    }

}
