package sample;

import java.sql.*;

public class DB {

    private final String HOST = "127.0.0.1";
    private final String PORT = "3306";
    private final String DB_NAME = "task8";
    private final String LOGIN = "root";
    private final String PASS = "";

    private Connection DB_Connect = null;

    //Подключаемся к базе, грамозкую конструкцию пришлось добавить так как выскакивала ошибка связанная с часовым поясом.
    private Connection getDBConnection() throws ClassNotFoundException, SQLException {
        String strJDBC = "jdbc:mysql://" + HOST + ":" + PORT + "/" + DB_NAME + "?useUnicode=true & useJDBCCompliantTimezoneShift=true & useLegacyDatetimeCode=false & serverTimezone=Europe/Moscow";
        Class.forName("com.mysql.cj.jdbc.Driver");

        DB_Connect = DriverManager.getConnection(strJDBC, LOGIN, PASS);
        return DB_Connect;
    }

    //Добавляем нового пользователя
    public boolean insertUser(String login, String email, String password) throws ClassNotFoundException, SQLException {
        boolean res;
        String sql = "INSERT INTO `users` (login, email, password) VALUES (?,?,?);";

        Statement statement = getDBConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM `users` WHERE `login` = '" + login + "' LIMIT 1;");
        if (resultSet.next())
            res = false;
        else {
            PreparedStatement prSt = getDBConnection().prepareStatement(sql);
            prSt.setString(1, login);
            prSt.setString(2, email);
            prSt.setString(3, password);

            prSt.executeUpdate();
            res = true;
        }
        return res;
    }

    //Получаем данные пользователя
    public int regtUser(String login, String password) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM `users` WHERE `login` = '" + login + "' AND `password` = '" + password + "' LIMIT 1;";
        int res;

        Statement statement = getDBConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        if (resultSet.next())
            res = resultSet.getInt("id");
        else
            res = 0;
        return res;
    }

    //Получаем данные пользователя
    public String[] getUser(int id) throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM `users` WHERE `id` = '" + id + "' LIMIT 1;";
        String[] str = new String[2];
        int res;

        Statement statement = getDBConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        if (resultSet.next()){
            str[0] = resultSet.getString("login");
            str[1] = resultSet.getString("email");
        }
        return str;
    }

    //Обновляем данные о пользователе
    public boolean updateUser(String login, String email, String password, int id) throws ClassNotFoundException, SQLException {

        boolean res;
        String sql = "UPDATE `users` SET `login` = ?, `email` = ?, `password` = ? WHERE `id` = ?;";

        Statement statement = getDBConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM `users` WHERE `login` = '" + login + "' LIMIT 1;");
        if (resultSet.next())
            res = false;
        else {
            PreparedStatement prSt = getDBConnection().prepareStatement(sql);
            prSt.setString(1, login);
            prSt.setString(2, email);
            prSt.setString(3, password);
            prSt.setInt(4, id);

            prSt.executeUpdate();
            res = true;
        }
        return res;
    }
}
