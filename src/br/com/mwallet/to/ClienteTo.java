package br.com.mwallet.to;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.mwallet.dao.ClienteDao;
import br.com.mwallet.model.Cliente;

@Component
public class ClienteTo {
	@Autowired
	private ClienteDao clienteDao;
	

	public Cliente consultarPorId(Long id) {
		Cliente cliente = clienteDao.consultarPorId(id);
		return cliente;
	}
	
	public void inserir(Cliente cliente) {
		
		clienteDao.inserir(cliente);
	}
	
	public List<Cliente> listar() {
		return clienteDao.listar();
	}
	
	public void excluir(Long idCliente) {
		clienteDao.excluir(idCliente);
	}
}
