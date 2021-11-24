package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserService user = new UserServiceImpl();
        user.createUsersTable();
        user.saveUser("Victor", "Potemkin", (byte) 24);
        System.out.println(String.format("User c именем - %s добавлен в базу данных", user.getAllUsers().get(0).getName()));
        user.saveUser("Aleksey", "Kuznetsov", (byte) 30);
        System.out.println(String.format("User c именем - %s добавлен в базу данных", user.getAllUsers().get(1).getName()));
        user.saveUser("Dmitriy", "Sergeev", (byte) 28);
        System.out.println(String.format("User c именем - %s добавлен в базу данных", user.getAllUsers().get(2).getName()));
        user.saveUser("Ivan", "Ivanov", (byte) 19);
        System.out.println(String.format("User c именем - %s добавлен в базу данных", user.getAllUsers().get(3).getName()));
        System.out.println(user.getAllUsers());
        user.cleanUsersTable();
        user.dropUsersTable();
    }
}
