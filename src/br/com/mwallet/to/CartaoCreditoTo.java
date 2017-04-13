package br.com.mwallet.to;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.mwallet.dao.CartaoCreditoDao;
import br.com.mwallet.model.CartaoCredito;



@Component
public class CartaoCreditoTo {
	@Autowired
	private CartaoCreditoDao cartaoCreditoDao;
	

	public CartaoCredito consultarPorId(Long id) {
		CartaoCredito cartaoCredito = cartaoCreditoDao.consultarPorId(id);
		return cartaoCredito;
	}
	
	public void inserir(CartaoCredito cartaoCredito) {
		cartaoCreditoDao.inserir(cartaoCredito);
	}
		
	
	public List<CartaoCredito> listar() {
		return cartaoCreditoDao.listar();
	}
	
	public void excluir(Long idCartaoCredito) {
		cartaoCreditoDao.excluir(idCartaoCredito);
	}
}
