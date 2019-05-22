package pl.sdacademy.hibernatesecond.jdbc;

import java.sql.*;

public class Jdbc {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/jdbc?allowPublicKeyRetrieval=true&useTimezone=true&serverTimezone=CET&useSSL=false";
    private static final String DB_USERNAME = "newUser";
    private static final String DB_PASSWORD = "newUserPass";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            //wywołania metod

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //zad 5
    private static void createTableUsers(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        String sql = "create table users (id int primary key auto_increment, email varchar(250), password varchar(50), credits double, premium boolean)";
        statement.executeUpdate(sql);
    }

    //zad 7
    private static void addUser(Connection connection, JdbcUser user) throws SQLException {
        String sql = "insert into users(email, password, credits, premium) values (?, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, user.getEmail());
        preparedStatement.setString(2, user.getPassword());
        preparedStatement.setDouble(3, user.getCredits());
        preparedStatement.setBoolean(4, user.getPremium());

        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    //zad 8
    private static void addUsers(Connection connection) throws SQLException {
        JdbcUser premiumUser = new JdbcUser("premium.user@mail.com", "pass1", 10.0, true);
        JdbcUser noCreditsUser = new JdbcUser("no.credits@mail.com", "pass1", 0.0, false);
        JdbcUser richUser = new JdbcUser("rich.user@mail.com", "pass1", 800.5, true);
        JdbcUser poorPremiumUser = new JdbcUser("poor.premium@mail.com", "pass1", 1.5, true);
        JdbcUser freshUser = new JdbcUser("fresh.user@mail.com", "pass1", 10.0, false);
        addUser(connection, premiumUser);
        addUser(connection, noCreditsUser);
        addUser(connection, richUser);
        addUser(connection, poorPremiumUser);
        addUser(connection, freshUser);
    }

    //zad 9
    private static void printUsers(ResultSet users) throws SQLException {
        while (users.next()) {
            System.out.print("Id: " + users.getInt("id") + " ");
            System.out.print("Email: " + users.getString("email") + " ");
            System.out.print("Password: " + users.getString("password") + " ");
            System.out.print("Credits: " + users.getDouble("credits") + " ");
            System.out.println("Premium: " + users.getBoolean("premium"));
        }
    }

    //zad 10
    private static ResultSet findAllUsers(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from users");
        return resultSet;
    }

    //zad 11
    private static ResultSet findPremiumUsers(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from users where premium = true");
        return resultSet;
    }

    //zad 12
    private static ResultSet findUsersWithCredits(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from users where credits > 0");
        return resultSet;
    }

    //zad 13
    private static ResultSet findUsersByRichest(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from users order by credits DESC ");
        statement.close();
        return resultSet;
    }

    //zad 14
    private static ResultSet findUserById(Connection connection, int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("select * from users where id = ?");
        preparedStatement.setInt(1, id);

        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    //zad 15
    private static ResultSet findUserByEmail(Connection connection, String email) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("select * from users where email = ?");
        preparedStatement.setString(1, email);

        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    //zad 16
    private static ResultSet findUserByCreditsValue(Connection connection, double credits) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("select * from users where credits = ?");
        preparedStatement.setDouble(1, credits);

        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet;
    }

    //zad 17
    private static int changeUserToPremium(Connection connection, int id) throws SQLException {
        String sql = "update users set premium = true where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, id);

        int rows = preparedStatement.executeUpdate();
        return rows;
    }

    //zad 18
    private static int addHundredCredits(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        int rows = statement.executeUpdate("UPDATE users set credits = credits + 100.0");

        return rows;
    }

    //zad 19
    private static int addTenCreditsToPremiumUsers(Connection connection) throws SQLException {
        Statement statement = connection.createStatement();
        int rows = statement.executeUpdate("UPDATE users set credits = credits + 10.0 where premium = true");

        return rows;
    }

    //zad 20
    private static int addCreditsToUser(Connection connection, int userId, double credits) throws SQLException {
        String sql = "update users set credits = credits + ? where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setDouble(1, credits);
        preparedStatement.setInt(2, userId);

        return preparedStatement.executeUpdate();
    }

    //zad 21
    private static void changeEmail(Connection connection, int userId, String newEmail) throws SQLException {
        String sql = "update users set email = ? where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, newEmail);
        preparedStatement.setInt(2, userId);

        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    //zad 22
    private static void changePassword(Connection connection, String userEmail, String newPassword) throws SQLException {
        String sql = "update users set password = ? where email = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, newPassword);
        preparedStatement.setString(2, userEmail);

        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    //zad 23
    private static void deleteUserById(Connection connection, int userId) throws SQLException {
        String sql = "delete from users where id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1, userId);

        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

    //zad 24
    private static int deleteUsersWithGreaterCredits(Connection connection, double credits) throws SQLException {
        String sql = "delete from users where credits > ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setDouble(1, credits);

        return preparedStatement.executeUpdate();
    }

    //zad 25
    private static void deleteNonPremiumUsers(Connection connection) throws SQLException {
        String sql = "delete from users where premium = false";
        Statement statement = connection.createStatement();

        statement.executeUpdate(sql);
        statement.close();
    }

}
