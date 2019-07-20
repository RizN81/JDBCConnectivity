import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestConnection {
	private static final String	Driver		= "com.mysql.jdbc.Driver";
	private static final String	url			= "jdbc:mysql://localhost:3306/test";
	private static final String	username	= "root";
	private static final String	password	= "";
	private static Connection	connection;
	private static final String	insertQuery	= "insert into dt (datetime) values (?)";
	private static final String	getQuery	= "select * from dt";

	public static void main(String[] args) {
		initDB();
		if (connection != null)
		{
			//insert();
			insert2();
			get();
		}
	}

	private static void get() {
		try
		{
			Statement createStatement = connection.createStatement();
			ResultSet resultSet = createStatement.executeQuery(getQuery);
			while (resultSet.next())
			{
				Date date = resultSet.getTimestamp("datetime");
				String dateString = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss aa").format(date);
				System.out.println(dateString);
			}

		}
		catch (SQLException e)
		{

			e.printStackTrace();
		}
	}

	private static void insert2() {
		try
		{
			PreparedStatement prepareStatement = connection.prepareStatement(insertQuery);
			Date dateString = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss aa").parse("2017-04-23 11:22:58 AM");
			prepareStatement.setTimestamp(1, new Timestamp(dateString.getTime()));
			boolean execute = prepareStatement.execute();
			System.out.println("Is insert " + execute);

		}
		catch (SQLException e)
		{

			e.printStackTrace();
		}
		catch (ParseException e)
		{

			e.printStackTrace();
		}
	}

	private static void insert() {
		try
		{
			PreparedStatement prepareStatement = connection.prepareStatement(insertQuery);
			java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
			prepareStatement.setTimestamp(1, date);
			boolean execute = prepareStatement.execute();
			System.out.println("Is insert " + execute);

		}
		catch (SQLException e)
		{

			e.printStackTrace();
		}
	}

	private static void initDB() {
		try
		{
			Class.forName(Driver);
			connection = DriverManager.getConnection(url, username, password);

		}
		catch (ClassNotFoundException e)
		{

			e.printStackTrace();
		}
		catch (SQLException e)
		{

			e.printStackTrace();
		}
	}
}
