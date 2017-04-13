package br.com.mwallet.to;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.mwallet.dao.TransacaoDao;
import br.com.mwallet.model.Produto;
import br.com.mwallet.model.Transacao;

@Component
public class TransacaoTo {
	
	@Autowired
	private TransacaoDao transacaoDao;
	

	
	@Autowired
	private ProdutoTo produtoTo;
	

	public Transacao consultarPorId(Long id) {
		Transacao transacao = transacaoDao.consultarPorId(id);
		return transacao;
	}
	
	public void inserir(Transacao transacao) {
		Produto produto = new Produto();
		produto = produtoTo.consultarPorId(transacao.getProdutos().getId());
		transacao.setValor(produto.getPreco()) ; 
		transacao.setAprovada(true);
		transacaoDao.inserir(transacao);
	}
	
	public List<Transacao> listar() {
		return transacaoDao.listar();
	}
	
	public void excluir(Long idTransacao) {
		transacaoDao.excluir(idTransacao);
	}
	

}
