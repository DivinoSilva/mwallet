package br.com.mwallet.to;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.mwallet.dao.VendedorDao;
import br.com.mwallet.model.Vendedor;


@Component
public class VendedorTo {
	@Autowired
	private VendedorDao vendedorDao;
	

	public Vendedor consultarPorId(Long id) {
		Vendedor vendedor = vendedorDao.consultarPorId(id);
		return vendedor;
	}
	
	public void inserir(Vendedor vendedor) {
		
		vendedorDao.inserir(vendedor);
	}
	
	public List<Vendedor> listar() {
		return vendedorDao.listar();
	}
	
	public void excluir(Long idVendedor) {
		vendedorDao.excluir(idVendedor);
	}
	
}
