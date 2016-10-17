package br.com.appvis.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDAO {
	
	public BaseDAO(){
		try{
			// Driver JDBC
			Class.forName("com.mysql.jdbc.Driver");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	protected Connection getConnection()throws SQLException{
		//URL de conexão com o banco
		String url = "jdbc:mysql://localhost/appvis?autoReconnect=true&useSSL=false";
		//Conecta utilizando a URL
		Connection conn = DriverManager.getConnection(url, "appvis", "appvis123");
		return conn;
	}
	
	public static void main(String[] args) throws SQLException{
		BaseDAO db = new BaseDAO();
		// Testa a conexao
		Connection conn = db.getConnection();
		System.out.println(conn);
	}

}
