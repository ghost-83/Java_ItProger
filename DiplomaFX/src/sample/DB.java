package sample;

import java.sql.*;

public class DB {

    private final String HOST = "127.0.0.1";
    private final String PORT = "3306";
    private final String DB_NAME = "dblink";
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

    //Получаем все ссылки с таблици
    public ResultSet getLinks() throws SQLException, ClassNotFoundException {
        String sql = "SELECT `title`, `link` FROM `littlelinks`;";
        Statement statement = getDBConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        return resultSet;
    }

    //Добавление новой ссылки
    public boolean addLink(String title, String link) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO `littlelinks` (title, link) VALUES (?,?);";

        Statement statement = getDBConnection().createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM `littlelinks` WHERE `title` = '" + title + "' LIMIT 1;");
        if (resultSet.next())
            return false;
        else {
            PreparedStatement prSt = getDBConnection().prepareStatement(sql);
            prSt.setString(1, title);
            prSt.setString(2, link);

            prSt.executeUpdate();
            return true;
        }
    }
}
