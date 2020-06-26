import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginQuarries {

    public boolean validate(AllUserLogin allUserLogin) throws ClassNotFoundException {
        boolean status = false;

        Class.forName("com.mysql.jdbc.Driver");

        try (
        	Connection connection = DataBaseConnection.getConnection();
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection
            .prepareStatement("select * from users where Email = ? and Password = ? ")) {
            
        	preparedStatement.setString(1, allUserLogin.getEmail());
            preparedStatement.setString(2, allUserLogin.getPassword());

            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            status = rs.next();

        } catch (SQLException e) {
            // process sql exception
            DataBaseConnection.printSQLException(e);
        }
        return status;
    }

}
