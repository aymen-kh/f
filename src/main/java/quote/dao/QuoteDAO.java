package quote.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import quote.model.Quote;

/**

 
 *
 */
public class QuoteDAO {
	
	private static final String INSERT_QUOTES_SQL = "INSERT INTO quotes" + "  (contenu, auteur, source) VALUES "
			+ " (?, ?, ?);";

	private static final String SELECT_QUOTE_BY_ID = "select id,contenu,auteur,source from quotes where id =?";
	private static final String SELECT_ALL_QUOTES = "select * from quotes";
	private static final String DELETE_QUOTES_SQL = "delete from quotes where id = ?;";
	private static final String UPDATE_QUOTES_SQL = "update quotes set contenu =?,auteur=?, source =? where id =?;";

	public QuoteDAO() {
	}

	protected Connection getConnection() {
		String jdbcURL = "jdbc:mysql://localhost:3306/demo";
		String jdbcUsername = "root";
		String jdbcPassword = "";
		Connection connection= null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection= DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
			//System.out.println(connection);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public void insertQuote(Quote quote) throws SQLException {
		System.out.println(INSERT_QUOTES_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUOTES_SQL)) {
			preparedStatement.setString(1, quote.getContenu());
			preparedStatement.setString(2, quote.getAuteur());
			preparedStatement.setString(3, quote.getSource());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Quote selectQuote(int id) {
		Quote quote = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUOTE_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String contenu = rs.getString("contenu");
				String auteur = rs.getString("auteur");
				String source = rs.getString("source");
				quote = new Quote(id, contenu, auteur, source);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return quote;
	}

	public List<Quote> selectAllQuotes() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Quote> quotes = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_QUOTES);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String contenu = rs.getString("contenu");
				String auteur = rs.getString("auteur");
				String source = rs.getString("source");
				quotes.add(new Quote(id, contenu, auteur, source));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return quotes;
	}

	public boolean deleteQuote(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_QUOTES_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateQuote(Quote quote) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_QUOTES_SQL);) {
			statement.setString(1, quote.getContenu());
			statement.setString(2, quote.getAuteur());
			statement.setString(3, quote.getSource());
			statement.setInt(4, quote.getId());
			System.out.println(statement);
			
			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

	public List<Quote> sortbywriter() {
		// TODO Auto-generated method stub
		// using try-with-resources to avoid closing resources (boiler plate code)
				List<Quote> quotes = new ArrayList<>();
				// Step 1: Establishing a Connection
				try (Connection connection = getConnection();

						// Step 2:Create a statement using connection object
					PreparedStatement preparedStatement = connection.prepareStatement("select * from quotes order by auteur DESC");) {
					System.out.println(preparedStatement);
					// Step 3: Execute the query or update query
					ResultSet rs = preparedStatement.executeQuery();

					// Step 4: Process the ResultSet object.
					while (rs.next()) {
						int id = rs.getInt("id");
						String contenu = rs.getString("contenu");
						String auteur = rs.getString("auteur");
						String source = rs.getString("source");
						quotes.add(new Quote(id, contenu, auteur, source));
					}
				} catch (SQLException e) {
					printSQLException(e);
				}
				return quotes;
			}

	

}
