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

import br.com.mwallet.model.Vendedor;
import br.com.mwallet.to.VendedorTo;


@RestController
public class VendedorController {
	
	@Autowired
	private VendedorTo vendedorTo;
	
	@RequestMapping(value="/vendedor", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<Vendedor> inserir(@RequestBody Vendedor vendedor){
		try {
			vendedorTo.inserir(vendedor); //Insere a lista no banco de dados

			URI location = new URI("/vendedor/"+vendedor.getId()); //Cria o URI

			return ResponseEntity.created(location).body(vendedor);

		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/vendedor", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<Vendedor> listar(){
		return vendedorTo.listar();
	}
	
	@RequestMapping(value="/vendedor/{id}", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public Vendedor consultarPorId(@PathVariable("id") Long id){
		return vendedorTo.consultarPorId(id);
	}
	
	@RequestMapping(value="/vendedor/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> excluir(@PathVariable("id") long idVendedor){
		vendedorTo.excluir(idVendedor);
		return ResponseEntity.noContent().build();
	}
	

}
