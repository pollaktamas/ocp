package com.pollaktamas.jdbc;

import java.sql.*;

public class JdbcMain {

    public static void main(String[] args) throws SQLException {
        Connection connection1 = getConnection1();
        Statement statement = connection1.createStatement();
        Statement stmt = connection1.createStatement(
                ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
    }

    private static Connection getConnection1() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:derby:zoo");
        System.out.println(conn);
        return conn;
    }

    private static void getConnection2() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/ocp-book",
                "username",
                "password");
    }
}
