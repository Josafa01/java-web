package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {

	private static String banco = "jdbc:mysql://localhost:3306/hortifruti?autoReconnect=true";
	private static String password = "";
	private static String user = "root";
	private static Connection connection = null;

	static {
		conectar();
	}

	public SingleConnection() {
		conectar();
	}

	private static void conectar() {
		try {

			if (connection == null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection(banco, user, password);
				connection.setAutoCommit(false);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao conectar com o banco de dados");
		}
	}

	public static Connection getConnection() {
		return connection;
	}

}