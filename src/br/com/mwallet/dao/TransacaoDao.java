package br.com.mwallet.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.uaihebert.factory.EasyCriteriaFactory;
import com.uaihebert.model.EasyCriteria;

import br.com.mwallet.model.Transacao;

@Repository
public class TransacaoDao {

	@PersistenceContext
	private EntityManager manager;

	@Transactional
	public void inserir(Transacao transacao){
		manager.persist(transacao);
	}
	
	@Transactional
	public Transacao consultarPorId(Long id){
		EasyCriteria<Transacao> easyCriteria = EasyCriteriaFactory.createQueryCriteria(manager, Transacao.class);
		easyCriteria.andEquals("id", id);
		return easyCriteria.getSingleResult();
	}
	
	
	
	
	
	
	@Transactional
	public void excluir(Long idTransacao){
		Transacao transacao = manager.find(Transacao.class, idTransacao);
		manager.remove(transacao);
	}
	
	public List<Transacao> listar() {
		EasyCriteria<Transacao> easyCriteria = EasyCriteriaFactory.createQueryCriteria(manager,Transacao.class);
		return easyCriteria.getResultList();
	}
	
}
