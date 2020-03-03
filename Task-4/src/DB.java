import java.sql.*;

public class DB {

    private final String HOST = "127.0.0.1";
    private final String PORT = "3306";
    private final String DB_NAME = "task4";
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
    public void insertUser(String login, String pass) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO `users` (login, pass) VALUES (?,?);";

        PreparedStatement prSt = getDBConnection().prepareStatement(sql);
        prSt.setString(1, login);
        prSt.setString(2, pass);

        prSt.executeUpdate();
    }

    //Добавляем новый товар
    public void insertItems(String title, String price, String category) throws ClassNotFoundException, SQLException {
        String sql = "INSERT INTO `items` (title, price, category) VALUES (?,?,?);";

        PreparedStatement prSt = getDBConnection().prepareStatement(sql);
        prSt.setString(1, title);
        prSt.setString(2, price);
        prSt.setString(3, category);

        prSt.executeUpdate();
    }

    //Выводим список пользователей
    public void getUsers() throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM `users`;";

        Statement statement = getDBConnection().createStatement();
        ResultSet res = statement.executeQuery(sql);
        while(res.next()){
            System.out.print(res.getInt("id") + " ");
            System.out.println(res.getString("login"));
        }
        System.out.println("");
    }

    //Выводим список товата
    public void getItems() throws ClassNotFoundException, SQLException {
        String sql = "SELECT * FROM `items`;";

        Statement statement = getDBConnection().createStatement();
        ResultSet res = statement.executeQuery(sql);
        while(res.next()){
            System.out.print(res.getInt("id") + " ");
            System.out.print(res.getString("title") + " ");
            System.out.print(res.getString("price") + " ");
            System.out.println(res.getString("category"));
        }
        System.out.println("");
    }

    //Выводим список корзины с фильтрацией по каждому пользователь (в нашем случае это john)
    public void getOrders(int useID) throws ClassNotFoundException, SQLException {

        String sql = "SELECT * FROM `orders` WHERE `user_id` = '" + useID + "' ORDER BY `item_id` DESC";
        Statement statement = getDBConnection().createStatement();
        ResultSet res = statement.executeQuery(sql);

        while(res.next()){

            System.out.print(strUser(res.getInt("user_id")) + " - ");
            System.out.println(strItem(res.getInt("item_id")));
        }
    }

    //Делаем запись в таблицу id пользователя и id товара
    public void insertIntOrders(int user_id, int item_id) throws ClassNotFoundException, SQLException {

        String sql = "INSERT INTO `orders` (user_id, item_id) VALUES (?, ?)";

        PreparedStatement prStO = getDBConnection().prepareStatement(sql);
        prStO.setInt(1, user_id);
        prStO.setInt(2, item_id);

        prStO.executeUpdate();
    }

    //Получаем id пользователя по его логину
    public int idUser(String login) throws SQLException, ClassNotFoundException {
        Statement statement = getDBConnection().createStatement();
        String sql = "SELECT * FROM `users` WHERE `login` = '" + login + "'";
        ResultSet resS = statement.executeQuery(sql);
        resS.next();
        return resS.getInt("id");
    }

    //Получаем id товара по его названию
    public int idItems(String title) throws SQLException, ClassNotFoundException {
        Statement statement = getDBConnection().createStatement();
        String sql = "SELECT * FROM `items` WHERE `title` = '" + title + "'";
        ResultSet resS = statement.executeQuery(sql);
        resS.next();
        return  resS.getInt("id");
    }

    //Получаем имя пользователя по его id
    private String strUser(int user_id) throws SQLException, ClassNotFoundException {
        Statement statement = getDBConnection().createStatement();

        String sql = "SELECT * FROM `users` WHERE `id` = '" + user_id + "'";
        ResultSet resS = statement.executeQuery(sql);
        resS.next();
        return resS.getString("login");
    }

    //Получаем наименование товара по его id
    private String strItem(int item_id) throws SQLException, ClassNotFoundException {
        Statement statement = getDBConnection().createStatement();

        String sql = "SELECT * FROM `items` WHERE `id` = '" + item_id + "'";
        ResultSet resS = statement.executeQuery(sql);
        resS.next();
        return resS.getString("title");
    }
}
