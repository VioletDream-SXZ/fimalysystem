package com.ysq.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MySqlConnectionPool {
    List<Connection> connections = new ArrayList<>();
    int size;

    // TODO 使用xml配置mysql
    public static MySqlConnectionPool pool = new MySqlConnectionPool(10);
    public static MySqlConnectionPool getInstance() {
        return pool;
    }

    public MySqlConnectionPool(int size) {
        this.size = size;
        init();
    }

    public void init() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            for (int i = 0; i < size; ++i) {
                Connection c = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/family_system?characterEncoding=UTF-8", "root", "123456");
                this.connections.add(c);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        while (connections.isEmpty()) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return connections.remove(0);
    }

    public synchronized void recycleConncetion(Connection c) {
        connections.add(c);
        this.notifyAll();
    }
}
