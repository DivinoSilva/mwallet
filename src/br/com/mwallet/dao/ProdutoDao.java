package br.com.mwallet.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uaihebert.factory.EasyCriteriaFactory;
import com.uaihebert.model.EasyCriteria;

import br.com.mwallet.model.Produto;

@Repository
public class ProdutoDao {

	@PersistenceContext
	private EntityManager manager;
	
	@Transactional
	public void inserir(Produto produto){
		manager.persist(produto );
	}
	
	public List<Produto > listar(){
		EasyCriteria<Produto > easyCriteria = EasyCriteriaFactory.createQueryCriteria(manager, Produto .class);
		return easyCriteria.getResultList();
	}
	
	@Transactional
	public Produto  consultarPorId(Long id) {
		EasyCriteria<Produto > easyCriteria = EasyCriteriaFactory.createQueryCriteria(manager, Produto.class);
		easyCriteria.andEquals("id", id);
		return easyCriteria.getSingleResult();
	}
	
	@Transactional
	public void excluir(Long idProduto ){
		Produto  produto = manager.find(Produto .class, idProduto );
		manager.remove(produto );
	}
	

}
