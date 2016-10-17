package br.com.appvis.domain;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;


import java.sql.PreparedStatement;


public class ProdutoDAO extends BaseDAO {
	
	
	public Produto getProdutoById(Long id) throws SQLException{
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = getConnection();
			stmt = conn.prepareStatement("select * from produto where id=?");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				Produto p = createProduto(rs);
				rs.close();
				return p;
			}
		}finally {
			if(stmt != null){
				stmt.close();
			}
			if(conn != null){
				conn.close();
			}
		}
		return null;
	}

	
	
	public List<Produto> findByName(String name) throws SQLException{
		List<Produto> produtos = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = getConnection();
			stmt = conn.prepareStatement("select * from produto where lower(nome) like ?");
			stmt.setString(1, "%" + name.toLowerCase() + "%");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Produto p = createProduto(rs);
				produtos.add(p);
			}
			rs.close();
		}finally {
			if(stmt != null){
				stmt.close();
			}
			if(conn != null){
				conn.close();
			}
		}
		
		return produtos;
	}
	
	
	
	public List<Produto> findByCategoria(String categoria) throws SQLException{
		List<Produto> produtos = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = getConnection();
			stmt = conn.prepareStatement("select * from produto where categoria = ?");
			stmt.setString(1, categoria);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Produto p = createProduto(rs);
				produtos.add(p);
			}
			rs.close();
		}finally {
			if(stmt != null){
				stmt.close();
			}
			if(conn != null){
				conn.close();
			}
		}
		
		return produtos;
		
	}
	
	
	
	public List<Produto> getProdutos() throws SQLException{
		List<Produto> produtos = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = getConnection();
			stmt = conn.prepareStatement("select * from produto");
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				Produto p = createProduto(rs);
				produtos.add(p);
			}
			rs.close();
		} finally {
			if(stmt != null){
				stmt.close();
			}
			if(conn != null){
				conn.close();
			}
		}
		
		return produtos;
	}
	
	
	
	public Produto createProduto(ResultSet rs) throws SQLException{
		Produto p = new Produto();
		p.setId(rs.getLong("id"));
		p.setNome(rs.getString("nome"));
		p.setCategoria(rs.getString("categoria"));
		p.setCodigoBarra(rs.getString("codigoBarra"));
		p.setDescricao(rs.getString("descricao"));
		p.setPrecoVenda(rs.getString("precoVenda"));
		p.setFornecedor(rs.getString("fornecedor"));
		p.setUrlProduto(rs.getString("urlProduto"));
		return p;
	}
	
	
	
	public void save(Produto p) throws SQLException{
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = getConnection();
			if(p.getId() == null){
				stmt = conn.prepareStatement("insert into produto (nome, categoria, codigoBarra, descricao, precoVenda,"
						+ " fornecedor, urlProduto) VALUES(?, ?, ?, ?, ?, ? , ?)",
						Statement.RETURN_GENERATED_KEYS);
			} else {
				stmt = conn.prepareStatement("update produto set nome=?, categoria=?, codigoBarra=?, descricao=?, precoVenda=?,"
						+ " fornecedor=?, urlProduto=? where id=?");
			}
			stmt.setString(1, p.getNome());
			stmt.setString(2, p.getCategoria());
			stmt.setString(3, p.getCodigoBarra());
			stmt.setString(4, p.getDescricao());
			stmt.setString(5, p.getPrecoVenda());
			stmt.setString(6, p.getFornecedor());
			stmt.setString(7, p.getUrlProduto());
			if(p.getId() != null){
				stmt.setLong(8, p.getId());
			}
			int count = stmt.executeUpdate();
			if(count == 0){
				throw new SQLException("Erro ao inserir o produto");
			}
			// Se inseriu, ler o id auto incremento
			if(p.getId() == null){
				Long id = getGeneratedId(stmt);
				p.setId(id);
			}
		}finally {
			if(stmt != null){
				stmt.close();
			}
			if(conn != null){
				conn.close();
			}
		}
	}
	
	
	
	// Id gerado com o campo auto incremento
	public static Long getGeneratedId(Statement stmt) throws SQLException{
		ResultSet rs = stmt.getGeneratedKeys();
		if(rs.next()){
			Long id = rs.getLong(1);
			return id;
		}
		return 0L;
	}
	
	
	
	public boolean delete(Long id) throws SQLException{
		Connection conn = null;
		PreparedStatement stmt = null;
		try{
			conn = getConnection();
			stmt = conn.prepareStatement("delete from produto where id=?");
			stmt.setLong(1, id);
			int count = stmt.executeUpdate();
			boolean ok = count > 0;
			return ok;
		}finally {
			if(stmt != null){
				stmt.close();
			}
			if(conn != null){
				conn.close();
			}
		}
	}
	
	
	
	
}
