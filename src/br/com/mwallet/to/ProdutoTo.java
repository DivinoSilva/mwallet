package br.com.mwallet.to;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.mwallet.dao.ProdutoDao;
import br.com.mwallet.model.Produto;


@Component
public class ProdutoTo {
	@Autowired
	private ProdutoDao produtoDao;
	
	public Produto consultarPorId(Long id) {
		Produto produto = produtoDao.consultarPorId(id);
		return produto;
	}
	
	public void inserir(Produto produto) {
		produtoDao.inserir(produto);
	}
	
	public List<Produto> listar() {
		return produtoDao.listar();
	}
	
	public void excluir(Long idProduto) {
		produtoDao.excluir(idProduto);
	}
	


}
