package projeto.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import projeto.mvc.model.Filme;

public class FilmeDao {
	
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
}
