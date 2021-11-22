package projeto.mvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoDao {
	private static final String USERNAME = "postgres";
	private static final String PASSWORD = "14062000";
	private static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/filme";
	
	public static Connection createConnectionToPostgres() throws Exception {
		Class.forName("org.postgresql.Driver");
		Connection conexao = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
		return conexao;
	}
	
	public static void main(String[] args) throws Exception {
		Connection con = createConnectionToPostgres();
		
			System.out.println("CONEXÃO BEM SUCEDIDA");
	}
}
