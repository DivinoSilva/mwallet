package br.com.mwallet.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uaihebert.factory.EasyCriteriaFactory;
import com.uaihebert.model.EasyCriteria;

import br.com.mwallet.model.CartaoCredito;

@Repository
public class CartaoCreditoDao {

	@PersistenceContext
	private EntityManager manager;
	
	@Transactional
	public void inserir(CartaoCredito cartaoCredito){
		manager.persist(cartaoCredito);
	}
	
	public List<CartaoCredito> listar(){
		EasyCriteria<CartaoCredito> easyCriteria = EasyCriteriaFactory.createQueryCriteria(manager, CartaoCredito.class);
		return easyCriteria.getResultList();
	}

	@Transactional
	public void excluir(Long idCartaoCredito){
		CartaoCredito cartaoCredito = manager.find(CartaoCredito.class, idCartaoCredito);
		manager.remove(cartaoCredito);
	}
	

	@Transactional
	public CartaoCredito consultarPorId(Long id) {
		EasyCriteria<CartaoCredito> easyCriteria = EasyCriteriaFactory.createQueryCriteria(manager, CartaoCredito.class);
		easyCriteria.andEquals("id", id);
		return easyCriteria.getSingleResult();
	}
	
}
