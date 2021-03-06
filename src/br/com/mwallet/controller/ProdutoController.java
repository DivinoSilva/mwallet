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

import br.com.mwallet.model.Produto;
import br.com.mwallet.to.ProdutoTo;


@RestController
public class ProdutoController {

	
	@Autowired
	private ProdutoTo produtoTo;
	
	@RequestMapping(value="/produto", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Produto> inserir(@RequestBody Produto produto){
		try {
			produtoTo.inserir(produto); //Insere a lista no banco de dados

			URI location = new URI("/produto/"+produto.getId()); //Cria o URI

			return ResponseEntity.created(location).body(produto);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/produto", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Produto> listar(){
		return produtoTo.listar();
	}
	
	@RequestMapping(value="/produto/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Produto consultarPorId(@PathVariable("id") Long id){
		return produtoTo.consultarPorId(id);
	}
	
	@RequestMapping(value="/produto/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@PathVariable("id") long idProduto){
		produtoTo.excluir(idProduto);
		return ResponseEntity.noContent().build();
	}
	

	
}
