package br.com.appvis.domain;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ProdutoService {
	
	private ProdutoDAO db = new ProdutoDAO();
	
	//Lista todos os produtos do banco de dados
	public List<Produto> getProdutos(){
		try{
			List<Produto> produtos = db.getProdutos();
			return produtos;
		}catch (SQLException e) {
			e.printStackTrace();
			return new ArrayList<Produto>();
		}
	}
	
	// Busca um produto pelo id
	public Produto getProduto(Long id){
		try{
			return db.getProdutoById(id);
		} catch (SQLException e) {
			return null;
		}
	}
	
	//Deleta o produto pelo id
	public boolean delete(Long id){
		try{
			return db.delete(id);
		} catch (SQLException e) {
			return false;
		}
	}
	
	// Salva ou atualiiza o produto
	public boolean save(Produto produto){
		try{
			db.save(produto);
			return true;
		}catch (SQLException e) {
			return false;
		}
	} 
	
	
	// Busca o produto pelo nome
	public List<Produto> findByName(String name){
		try{
			return db.findByName(name);
		} catch (SQLException e) {
			return null;
		}
	}
	
	
	public List<Produto> findByCategoria(String categoria){
		try{
			return db.findByCategoria(categoria);
		}catch (SQLException e) {
			return null;
		}
	}

}
