package com.itProger;

import java.sql.*;

public class DB {

    private final String HOST = "localhost";
    private final String PORT = "8889";
    private final String DB_NAME = "java_db";
    private final String LOGIN = "root";
    private final String PASS = "root";

    private Connection dbConn = null;

    private Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connStr = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME;
        Class.forName("com.mysql.cj.jdbc.Driver");

        dbConn = DriverManager.getConnection(connStr, LOGIN, PASS);
        return dbConn;
    }

    public void isConnected() throws SQLException, ClassNotFoundException {
        dbConn = getDbConnection();
        System.out.println(dbConn.isValid(1000));
    }

    public void createTable(String tableName) throws SQLException, ClassNotFoundException {
        String sql = "CREATE TABLE IF NOT EXISTS " + tableName
                + " (id INT AUTO_INCREMENT PRIMARY KEY, name VARCHAR(50), password VARCHAR(100))"
                + " ENGINE=MYISAM;";

        Statement statement = getDbConnection().createStatement();
        statement.executeUpdate(sql);
    }

    public void insertArticle(String title, String text, String date, String avtor) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO `articles` (title, text, date, avtor) VALUES (?, ?, ?, ?)";

        PreparedStatement prSt = getDbConnection().prepareStatement(sql);
        prSt.setString(1, title);
        prSt.setString(2, text);
        prSt.setString(3, date);
        prSt.setString(4, avtor);

        prSt.executeUpdate();
    }

    public void getArticles(String table) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM " + table + " WHERE `title` LIKE '%Post%' OR `id` = 4 ORDER BY `date` ASC LIMIT 1 OFFSET 2";

        Statement statement = getDbConnection().createStatement();
        ResultSet res = statement.executeQuery(sql);
        while(res.next()) {
            System.out.println(res.getString("id")); // -> "1", -> 1
            //System.out.println(res.getString("text"));
        }
    }

}
