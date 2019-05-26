package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.BeanLogin;
import connection.SingleConnection;

public class DaoLogin {

	private Connection connection;

	public DaoLogin() {
		connection = SingleConnection.getConnection();
	}

	public boolean validarLogin(String email, String senha) throws Exception {

		String sql = "SELECT * FROM login WHERE email = '" + email + "' and senha = '" + senha + "'";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();

		if (resultSet.next()) {
			return true;
		} else {
			return false;
		}

	}

	public void SaveLogin(String addCookie, int count_log, String email) throws Exception {

		try {
			String sql = "update login set addCookie = ?, count_log = ?  where email = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, addCookie);
			preparedStatement.setLong(2, count_log);
			preparedStatement.setString(3, email);
			preparedStatement.executeUpdate();
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}

	}

	public String getHash(String email) throws Exception {
		String sql = "select addCookie from login  where email = '" + email + "'";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {
			BeanLogin beanlogin = new BeanLogin();
			return beanlogin.getAddCookie_Session(resultSet.getString("addCookie"));
		}
		return "";

	}

	public int StatusLog(String email) throws Exception {
		String sql = "select count_log from login where email = '" + email + "'";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {
			BeanLogin beanlogin = new BeanLogin();
			return beanlogin.setCount_log(resultSet.getInt("count_log"));
		}
		return 0;

	}

	public String getLogin(String addCookie) throws Exception {
		String sql = "select email from login where addCookie = '" + addCookie + "'";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {
			BeanLogin beanlogin = new BeanLogin();
			return beanlogin.getEmail(resultSet.getString("email"));
		}
		return "";

	}

	public String lastCookie() throws Exception {
		String sql = "SELECT max(addCookie) as addCookie FROM login ";

		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {
			BeanLogin beanlogin = new BeanLogin();
			return beanlogin.getAddCookie_Session(resultSet.getString("addCookie"));
		}
		return "";
	}
}
