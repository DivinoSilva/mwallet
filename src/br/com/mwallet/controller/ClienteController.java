package br.com.mwallet.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.mwallet.model.Cliente;
import br.com.mwallet.to.ClienteTo;



@RestController
public class ClienteController {
	
	@Autowired
	private ClienteTo clienteTo;
	
	@RequestMapping(value="/cliente", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Cliente> inserir(@RequestBody Cliente cliente){
		try {
			clienteTo.inserir(cliente); //Insere a lista no banco de dados

			URI location = new URI("/cliente/"+cliente.getId()); //Cria o URI

			return ResponseEntity.created(location).body(cliente);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/cliente", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Cliente> listar(){
		return clienteTo.listar();
	}
	
	@RequestMapping(value="/cliente/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Cliente consultarPorId(@PathVariable("id") Long id){
		return clienteTo.consultarPorId(id);
	}
	
	@RequestMapping(value="/cliente/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@PathVariable("id") long idCliente){
		clienteTo.excluir(idCliente);
		return ResponseEntity.noContent().build();
	}
	

}
