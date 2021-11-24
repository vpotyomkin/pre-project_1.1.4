package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.dropUsersTable();
        userService.createUsersTable();
        userService.saveUser("Victor", "Potemkin", (byte) 24);
        System.out.println(String.format("User c именем - %s добавлен в базу данных", userService.getAllUsers().get(0).getName()));
        userService.saveUser("Aleksey", "Kuznetsov", (byte) 30);
        System.out.println(String.format("User c именем - %s добавлен в базу данных", userService.getAllUsers().get(1).getName()));
        userService.saveUser("Dmitriy", "Sergeev", (byte) 28);
        System.out.println(String.format("User c именем - %s добавлен в базу данных", userService.getAllUsers().get(2).getName()));
        userService.saveUser("Ivan", "Ivanov", (byte) 19);
        System.out.println(String.format("User c именем - %s добавлен в базу данных", userService.getAllUsers().get(3).getName()));
        System.out.println(userService.getAllUsers());
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
