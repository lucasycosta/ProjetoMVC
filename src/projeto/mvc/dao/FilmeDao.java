package projeto.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import projeto.mvc.model.Filme;

public class FilmeDao {
	
	//METODO DE INCLUSAO
	public void cadastrarFilme(Filme filme) throws Exception {
		String sql = "INSERT INTO filme (nome, genero) values (?, ?)";
		PreparedStatement pstm = null;
		Connection conn = null;
		
		try {
			conn = ConexaoDao.createConnectionToPostgres();	
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, filme.getNome());
			pstm.setString(2, filme.getGenero());
			pstm.execute();
			System.out.println("Filme salvo com sucesso!!!");
			
		} catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	//METODO DE CONSULTA
	public List<Filme> getFilme(int id){
		String sql = "SELECT * FROM filme WHERE id = ?";
		List<Filme> filmes = new ArrayList<Filme>();
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConexaoDao.createConnectionToPostgres();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			ResultSet rset = pstm.executeQuery();
			
			while(rset.next()) {
				Filme filme = new Filme();
				
				filme.setId(rset.getInt("id"));
				filme.setNome(rset.getString("nome"));
				filme.setGenero(rset.getString("genero"));
				
				filmes.add(filme);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return filmes;
	}
	
	//METODO DE ATUALIZAÇÃO
	public void atualizar(Filme filme) {
		String sql = "UPDATE filme SET nome = ?, genero? WHERE id = ?";
		Connection conn;
		PreparedStatement pstm;
		
		try {
			conn = ConexaoDao.createConnectionToPostgres();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, filme.getNome());
			pstm.setString(2, filme.getGenero());
			pstm.setInt(3, filme.getId());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//METODO DE EXCLUSÃO
	public void deletarFilme(int id) {
		String sql = "DELETE FROM filme WHERE id = " + id;
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConexaoDao.createConnectionToPostgres();
			pstm = conn.prepareStatement(sql);
			pstm.execute();
			System.out.println("Filme deletado com sucesso!!!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
