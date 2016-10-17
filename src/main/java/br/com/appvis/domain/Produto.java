package br.com.appvis.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Produto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Long id;
	private String categoria;
	private String nome;
	private String codigoBarra;
	private String descricao;
	private String precoVenda;
	private String fornecedor;
	private String urlProduto;
	
	public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
	
	public String getCategoria(){
		return categoria;
	}
	
	public void setCategoria(String categoria){
		this.categoria = categoria;
	}
	
	public String getNome(){
		return nome;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public String getCodigoBarra(){
		return codigoBarra;
	}
	
	public void setCodigoBarra(String codigoBarra){
		this.codigoBarra = codigoBarra;
	}
	
	public String getDescricao(){
		return descricao;
	}
	
	public void setDescricao(String descricao){
		this.descricao = descricao;
	}
	
	public String getPrecoVenda(){
		return precoVenda;
	}
	
	public void setPrecoVenda(String precoVenda){
		this.precoVenda = precoVenda;
	}
	
	public String getFornecedor(){
		return fornecedor;
	}
	
	public void setFornecedor(String fornecedor){
		this.fornecedor = fornecedor;
	}
	
	public String getUrlProduto(){
		return urlProduto;
	}
	
	public void setUrlProduto(String urlProduto){
		this.urlProduto = urlProduto;
	}
	
	@Override
	public String toString(){
		return "Produto [id = " + id + ", categoria = " + categoria + ", nome = " + nome + ", desc = " + descricao + ", codigoBarra = "
				 + codigoBarra + ", precoVenda = " + precoVenda + ", fornecedor = " + fornecedor + ", url_foto = " + urlProduto + "]";
	}

}
