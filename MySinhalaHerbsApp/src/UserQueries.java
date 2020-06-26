import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserQueries 
{
	
	
	public int registerAdmin(User Admin) throws ClassNotFoundException 
	{        
		
		/*String INSERT_ADMIN_USERS = "INSERT INTO users" +
            "  (FirstName, LastName, Email, Password) VALUES " +
            " (?, ?, ?, ?);";*/
		
		String INSERT_ADMIN_USERS = "INSERT INTO herbsshopdb.users VALUES  (?, ?, ?, ?);";
		
		int result = 0;

        try (
        	Connection connection = DataBaseConnection.getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ADMIN_USERS))
        	{
            	preparedStatement.setString(1, Admin.getFirstName());
            	preparedStatement.setString(2, Admin.getLastName());
            	preparedStatement.setString(3, Admin.getEmail());
            	preparedStatement.setString(4, Admin.getPassword());

            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            result = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            // process sql exception
            DataBaseConnection.printSQLException(e);
        }
        return result;
	}  
}
