package com.ysq.dao;

import com.ysq.model.User;
import com.ysq.database.MySqlConnectionPool;
import com.ysq.model.UserBuilder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UserDao {
    public static User getUserById(int id) {
        String sql = "SELECT id, username, password, familyname FROM users WHERE id = ?;";

        Connection conn = MySqlConnectionPool.getInstance().getConnection();
        User u = null;
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                u = mapResultToUser(rs);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        MySqlConnectionPool.getInstance().recycleConncetion(conn);
        return u;
    }

    public static User getUserByName(String name) {
        String sql = "SELECT id, username, password, family_name FROM users WHERE username = ?;";

        Connection conn = MySqlConnectionPool.getInstance().getConnection();
        User u = null;
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, name);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                u = mapResultToUser(rs);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            MySqlConnectionPool.getInstance().recycleConncetion(conn);
        }
        return u;
    }

    public static boolean isUsernameExists(String username) {
        return UserDao.getUserByName(username) != null;
    }

    public static List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT id, username, password, family_name from users;";

        Connection conn = MySqlConnectionPool.getInstance().getConnection();
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            ResultSet rs = statement.executeQuery();
            while(rs.next()) {
                users.add(mapResultToUser(rs));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            MySqlConnectionPool.getInstance().recycleConncetion(conn);
        }
        return users;
    }

    public static boolean addUser(String name, String password, String familyName) {
        String sql = "INSERT INTO users (username, password, family_name) VALUES (?, ?, ?);";
        Connection conn = MySqlConnectionPool.getInstance().getConnection();

        boolean result = false;
        try (PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setString(1, password);
            statement.setString(1, familyName);
            result = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            MySqlConnectionPool.getInstance().recycleConncetion(conn);
        }
        return result;
    }

    public static boolean validateUser(String name, String password) {
        User u = UserDao.getUserByName(name);
        return u != null && Objects.equals(u.getPassword(), password);
    }

    public static User mapResultToUser(ResultSet rs) {
        UserBuilder builder = new UserBuilder();
        try {
            builder.setId(rs.getInt("id"));
            builder.setUsername(rs.getString("username"));
            builder.setPassword(rs.getString("password"));
            builder.setFamilyName(rs.getString("familyname"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return builder.build();
    }
}
