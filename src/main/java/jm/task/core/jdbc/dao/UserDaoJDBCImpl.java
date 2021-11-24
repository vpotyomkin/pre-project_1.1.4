package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    public void createUsersTable() {
        String sql = "CREATE TABLE IF NOT EXISTS users (\n"
                + "	id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT, \n"
                + "	name TEXT,\n"
                + "	lastName TEXT,\n"
                + "	age TINYINT\n"
                + ");";

        try (Connection connection = Util.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void dropUsersTable() {
        String sql = "DROP TABLE IF EXISTS users";

        try (Connection connection = Util.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String sql = "INSERT INTO users(name, lastName, age) VALUES (?, ?, ?);";
        //String sql = String.format("INSERT INTO users(name, lastName, age) VALUES (%s, %s, %s);", name, lastName, age);
        try (Connection connection = Util.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void removeUserById(long id) {
        String sql = String.format("DELETE FROM users WHERE id = %s;", id);

        try (Connection connection = Util.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        String sql = "SELECT * FROM users;";
        List<User> users = new ArrayList<>();

        try (Connection connection = Util.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet rs = preparedStatement.executeQuery(sql);
            while (rs.next()){
                long id = rs.getLong(1);
                String name = rs.getString(2);
                String lastName = rs.getString(3);
                byte age = rs.getByte(4);

                users.add(new User(id, name, lastName, age));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        users.toString();
        return users;

    }

    public void cleanUsersTable() {
        String sql = "TRUNCATE TABLE users;";
                /*+ " CREATE TABLE users (\n"
                + "	id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,\n"
                + "	name TEXT,\n"
                + "	lastName TEXT,\n"
                + "	age TINYINT\n"
                + ");";*/

        try (Connection connection = Util.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.executeUpdate(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
