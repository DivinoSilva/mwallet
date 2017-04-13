package br.com.mwallet.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uaihebert.factory.EasyCriteriaFactory;
import com.uaihebert.model.EasyCriteria;

import br.com.mwallet.model.Vendedor;

@Repository
public class VendedorDao {


	@PersistenceContext
	private EntityManager manager;
	
	@Transactional
	public void inserir(Vendedor vendedor){
		manager.persist(vendedor);
	}
	
	public List<Vendedor> listar(){
		EasyCriteria<Vendedor> easyCriteria = EasyCriteriaFactory.createQueryCriteria(manager, Vendedor.class);
		return easyCriteria.getResultList();
	}

	@Transactional
	public void excluir(Long idVendedor){
		Vendedor vendedor = manager.find(Vendedor.class, idVendedor);
		manager.remove(vendedor);
	}
	
	@Transactional
	public Vendedor consultarPorId(Long id) {
		EasyCriteria<Vendedor> easyCriteria = EasyCriteriaFactory.createQueryCriteria(manager, Vendedor.class);
		easyCriteria.andEquals("id", id);
		return easyCriteria.getSingleResult();
	}
	
}
