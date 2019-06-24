package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.BeanClients;
import connection.SingleConnection;

public class DaoClients {

	private static Connection connection;

	public DaoClients() {
		connection = SingleConnection.getConnection();
	}
	
	public void insert(BeanClients clientes) {
		try {
			String sql = "INSERT INTO clients(nome, sobrenome, idade, email, telefone, cidade, bairro, rua) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setString(1, clientes.getNome());
			insert.setString(2, clientes.getSobrenome());
			insert.setInt(3, clientes.getIdade());
			insert.setString(4, clientes.getEmail());
			insert.setString(5, clientes.getTelefone());
			insert.setString(6, clientes.getCidade());
			insert.setString(7, clientes.getBairro());
			insert.setString(8, clientes.getRua());
			insert.execute();
			connection.commit();
		} catch(Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public List<BeanClients> listAll() throws Exception {
		List<BeanClients> listAll = new ArrayList<BeanClients>();
		String sql = "SELECT * FROM clients";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				BeanClients beanClients = new BeanClients();
				beanClients.setId(resultSet.getLong("id"));
				beanClients.setNome(resultSet.getString("nome"));
				beanClients.setSobrenome(resultSet.getString("sobrenome"));
				beanClients.setIdade(resultSet.getInt("idade"));
				beanClients.setEmail(resultSet.getString("email"));
				beanClients.setTelefone(resultSet.getString("telefone"));
				beanClients.setCidade(resultSet.getString("cidade"));
				beanClients.setBairro(resultSet.getString("bairro"));
				beanClients.setRua(resultSet.getString("rua"));
				listAll.add(beanClients);
			}
			return listAll;
	}
	
	public BeanClients edit(String id) throws Exception {
		String sql = "SELECT * FROM clients WHERE id = "+ id;
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				BeanClients beanClients = new BeanClients();
				beanClients.setId(resultSet.getLong("id"));
				beanClients.setNome(resultSet.getString("nome"));
				beanClients.setSobrenome(resultSet.getString("sobrenome"));
				beanClients.setIdade(resultSet.getInt("idade"));
				beanClients.setEmail(resultSet.getString("email"));
				beanClients.setTelefone(resultSet.getString("telefone"));
				beanClients.setCidade(resultSet.getString("cidade"));
				beanClients.setBairro(resultSet.getString("bairro"));
				beanClients.setRua(resultSet.getString("rua"));
				return beanClients;
			}
		return null;
	}
	
	public void delete(String id) {
		if (id != null && !id.isEmpty()) {
			try {
				String sql = "DELETE FROM clients WHERE id = "+ id;
				PreparedStatement preparedStatement = connection.prepareStatement(sql);
				preparedStatement.execute();
				connection.commit();
			} catch (SQLException e) {
				e.printStackTrace();
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	
	public void update(BeanClients clientes) {
		try {
			String sql = "UPDATE clients SET nome = ?, sobrenome = ?, idade = ?, email = "
					+ " ?, telefone = ?, cidade = ?, bairro = ?, rua = ? WHERE id = " + clientes.getId();
			
			PreparedStatement preparedStatement = connection.prepareStatement(sql);			
			preparedStatement.setString(1, clientes.getNome());
			preparedStatement.setString(2, clientes.getSobrenome());
			preparedStatement.setInt(3, clientes.getIdade());
			preparedStatement.setString(4, clientes.getEmail());
			preparedStatement.setString(5, clientes.getTelefone());
			preparedStatement.setString(6, clientes.getCidade());
			preparedStatement.setString(7, clientes.getBairro());
			preparedStatement.setString(8, clientes.getRua());
			preparedStatement.executeUpdate();
			connection.commit();
		} catch(Exception e) {
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
	
	public boolean verifyClient(String nome, String email) throws Exception {
		
		String sql = "SELECT nome FROM clients WHERE email = '"+ email +"'";
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		ResultSet resultSet = preparedStatement.executeQuery();
		
		if(resultSet.next()) {
			return true;
		} else {
			return false;	
		}
		
	}
}
