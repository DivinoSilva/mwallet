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

import br.com.mwallet.model.CartaoCredito;
import br.com.mwallet.to.CartaoCreditoTo;

@RestController
public class CartaoCerditoController {

	
	@Autowired
	private CartaoCreditoTo cartaoCreditoTo;
	
	@RequestMapping(value="/cartaocredito", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<CartaoCredito> inserir(@RequestBody CartaoCredito cartaoCredito){
		try {
			cartaoCreditoTo.inserir(cartaoCredito); //Insere a lista no banco de dados

			URI location = new URI("/cartaocredito/"+cartaoCredito.getId()); //Cria o URI

			return ResponseEntity.created(location).body(cartaoCredito);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/cartaocredito", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<CartaoCredito> listar(){
		return cartaoCreditoTo.listar();
	}
	
	@RequestMapping(value="/cartaocredito/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public CartaoCredito consultarPorId(@PathVariable("id") Long id){
		return cartaoCreditoTo.consultarPorId(id);
	}
	
	@RequestMapping(value="/cartaocredito/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@PathVariable("id") long idCartaoCredito){
		cartaoCreditoTo.excluir(idCartaoCredito);
		return ResponseEntity.noContent().build();
	}
	
}
