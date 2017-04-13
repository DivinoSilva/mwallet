package br.com.mwallet.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uaihebert.factory.EasyCriteriaFactory;
import com.uaihebert.model.EasyCriteria;

import br.com.mwallet.model.Cliente;

@Repository
public class ClienteDao {

	@PersistenceContext
	private EntityManager manager;
	
	@Transactional
	public void inserir(Cliente cliente){
		manager.persist(cliente);
	}
	
	public List<Cliente> listar(){
		EasyCriteria<Cliente> easyCriteria = EasyCriteriaFactory.createQueryCriteria(manager, Cliente.class);
		return easyCriteria.getResultList();
	}

	@Transactional
	public void excluir(Long idCliente){
		Cliente cliente = manager.find(Cliente.class, idCliente);
		manager.remove(cliente);
	}
	
	@Transactional
	public Cliente consultarPorId(Long id) {
		EasyCriteria<Cliente> easyCriteria = EasyCriteriaFactory.createQueryCriteria(manager, Cliente.class);
		easyCriteria.andEquals("id", id);
		return easyCriteria.getSingleResult();
	}
}
