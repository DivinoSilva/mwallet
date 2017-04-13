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

import br.com.mwallet.model.Transacao;
import br.com.mwallet.to.TransacaoTo;



@RestController
public class TransacaoController {
	
	@Autowired
	private TransacaoTo transacaoTo;
	
	@RequestMapping(value="/transacao", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Transacao> inserir(@RequestBody Transacao transacao ){
		try {
			System.out.println("Entrei aqui");
			transacaoTo.inserir(transacao); //Insere a lista no banco de dados
			URI location = new URI("/transacao/"+transacao.getId()); //Cria o URI
			return ResponseEntity.created(location).body(transacao);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/transacao", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Transacao> listar(){
		return transacaoTo.listar();
	}
	
	@RequestMapping(value="/transacao/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Transacao consultarPorId(@PathVariable("id") Long id){
		return transacaoTo.consultarPorId(id);
	}
	
	@RequestMapping(value="/transacao/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@PathVariable("id") long idTransacao){
		transacaoTo.excluir(idTransacao);
		return ResponseEntity.noContent().build();
	}
	
}
