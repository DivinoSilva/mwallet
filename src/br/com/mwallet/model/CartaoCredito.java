package br.com.mwallet.model;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@DiscriminatorValue("CC")
public class CartaoCredito extends MeioPagamento {
	private Long numero;
	
	@Temporal(TemporalType.DATE)
	private Date validade;
	
	private int codSeg;

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
	}

	public int getCodSeg() {
		return codSeg;
	}

	public void setCodSeg(int codSeg) {
		this.codSeg = codSeg;
	}
	
	

}
