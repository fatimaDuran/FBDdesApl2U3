/**
 * 
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Disco;


/**
 * @author Fatima
 *
 */
public class DiscoDAOImpl implements DiscoDAO {
	private Connection connection;
	private PreparedStatement prepareStatement;
	private ResultSet resultSet;

	public DiscoDAOImpl() {
		getConnection();
	}

	public Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/discos", "utng", "mexico");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	@Override
	public void createDisco(Disco disco) {
		if (connection != null) {
			try {
				prepareStatement = connection
						.prepareStatement("INSERT INTO disco (titulo,fecha,tipograbacion,canciones) values(?,?,?,?);");
				prepareStatement.setString(1, disco.getTitulo());
				prepareStatement.setString(2, disco.getFecha());
				prepareStatement.setString(3, disco.getTipoGrabacion());
				prepareStatement.setInt(4, disco.getCanciones());
			
				prepareStatement.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Disco readDisco(int id) {
		Disco disco = null;
		if (connection != null) {
			try {
				prepareStatement = connection.prepareStatement("SELECT * FROM disco WHERE id=?;");
				prepareStatement.setInt(1, id);
				resultSet = prepareStatement.executeQuery();
				if (resultSet.next()) {
					disco = new Disco(resultSet.getInt(1), resultSet.getString(2),resultSet.getString(3), resultSet.getString(4),
							 resultSet.getInt(5));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return disco;
	}

	@Override
	public List<Disco> readAllDiscs() {
		List<Disco> discos = new ArrayList<Disco>();
		if (connection != null) {
			try {
				prepareStatement = connection.prepareStatement("SELECT * FROM disco;");
				resultSet = prepareStatement.executeQuery();
				while (resultSet.next()) {
					Disco disco = new Disco(resultSet.getInt(1), resultSet.getString(2),resultSet.getString(3), resultSet.getString(4),
							 resultSet.getInt(5));
					discos.add(disco);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return discos;
	}

	@Override
	public void updateDisco(Disco disco) {
		if (connection != null) {
			try {
				prepareStatement = connection
						.prepareStatement("UPDATE disco  SET titulo = ?, fecha=?, tipograbacion=?," + " canciones=?  WHERE id=?;");
				prepareStatement.setString(1, disco.getTitulo());
				prepareStatement.setString(2, disco.getFecha());
				prepareStatement.setString(3, disco.getTipoGrabacion());
				prepareStatement.setInt(4, disco.getCanciones());
				prepareStatement.setInt(5, disco.getId());
				prepareStatement.execute();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deleteDisco(int id) {
		if (connection != null) {
			try {
				prepareStatement = connection.prepareStatement("DELETE FROM disco  WHERE id=?;");
				prepareStatement.setInt(1, id);
				prepareStatement.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}



	

}
