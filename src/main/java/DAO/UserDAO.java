package DAO;

import model.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.Base64.Decoder;

import static java.lang.Class.forName;

public class UserDAO extends DAO{

    private static final String INSERT_USER="INSERT INTO users"+" (userId, userRole, password) VALUES "
            +" (?, ?, ?);";
    private static final String SELECT_USER="SELECT * from users WHERE userId =? AND password = ?;";
    private static final String SELECT_ALL_USERS = "SELECT * FROM users";
    private static final String SELECT_USER_BY_ID="SELECT * FROM users WHERE userId = ?;";
    private static final String DELETE_USERS = "DELETE FROM users WHERE userId = ?;";
    // username,userId,userRole,email,password
    private static final String UPDATE_USERS = "UPDATE users SET username = ?,password= ?," +
            ",email = ?,userRole= ? WHERE userId = ?;";

    public class PasswordUtils {
        public String encode(String password) {
            Encoder encoder=Base64.getEncoder();
            String pass=encoder.encodeToString(password.getBytes());
            return pass;
        }
        public String decode(String pass) {
            Decoder decode=Base64.getDecoder();
            byte[] decPassowrd= decode.decode(pass);
            return new String(decPassowrd);
        }
    }

    public User userAuthentication(int id, String inputPassword) {
        PasswordUtils passwordUtils = new PasswordUtils();
        User user = null;
        String encodedPassword = passwordUtils.encode(inputPassword);

        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER); {
                preparedStatement.setInt(1, id);
                preparedStatement.setString(2, encodedPassword);
                System.out.println(preparedStatement);
                ResultSet rs= preparedStatement.executeQuery();
                while (rs.next()) {
                    int userId = rs.getInt("userId");
                    String userRole = rs.getString("userRole");
                    String password = rs.getString("password");
                    user = new User(userId,userRole,password);
                }
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    public void insertUser(User user) throws SQLException {
        System.out.println(INSERT_USER);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USER)) {
            preparedStatement.setInt(1, user.getUserId());
            preparedStatement.setString(2, user.getUserRole());
            preparedStatement.setString(3, user.getPassword());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public User selectUser(int id) {
        User user = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID)) {
                preparedStatement.setInt(1, id);
                System.out.println(preparedStatement);
                // Step 3: Execute the query or update query
                ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
                while (rs.next()) {
                    int userId = rs.getInt("userId");
                    String userRole = rs.getString("userRole");
                    String password = rs.getString("password");
                    user = new User(userId,userRole,password);
                }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    public List<User> selectAllUsers() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List<User> users = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
                System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
                ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
                while (rs.next()) {
                    int userId = rs.getInt("userId");
                    String username = rs.getString("username");
                    String userRole = rs.getString("userRole");
                    String email = rs.getString("email");
                    String password = rs.getString("password");
                    users.add(new User(userId,userRole,username,email,password));
                }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }

    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_USERS);) {
                statement.setInt(1, id);
                rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_USERS);) {
                System.out.println("updated User:"+statement);
                statement.setString(1, user.getUsername());
                statement.setString(2, user.getEmail());
                statement.setString(3, user.getUserRole());
                statement.setInt(4, user.getUserId());

                rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }


}
