package login;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;

public class DBConnection {

    private Connection connection;
    private String user="user";

    public boolean getUser(String user) {
        if (this.user.equals(user)) return true;
        return true;
    }

    private DBConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            InitialContext initContext = new InitialContext();
            DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/users");
            connection = ds.getConnection();
        } catch (ClassNotFoundException | SQLException | NamingException e) {
            e.printStackTrace();
        }

    }

    public static boolean check(String name, String passw) throws SQLException {
        DBConnection dbConnection = new DBConnection();
        String query = "SELECT*FROM users.users";
        Statement statement = dbConnection.connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()) {
            if (name.equals(resultSet.getString(2)) && passw.equals(resultSet.getString(3))) {
                dbConnection.connection.close();
                return true;
            }
        }
        dbConnection.connection.close();
        return false;
    }
}
