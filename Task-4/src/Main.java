import java.sql.SQLException;
import java.util.Scanner;
//Код получился давольно грамостким, по этому я подписал функции
public class Main {

    private static boolean process  = true;

    public static void main(String[] args) {

        int option;
        Scanner scanner = new Scanner(System.in);
        //Добавляю второй сканер так как при использовании nextInt() а после nextLine()
        //пропускается один пункт ввода само по себе
        Scanner scannerStr = new Scanner(System.in);
        DB db = new DB();

        while (process){
            System.out.println("Введите цифру нужного варианта:");
            System.out.println("1 Вывести список пользователей");
            System.out.println("2 Добавить пользователя");
            System.out.println("3 Вывести список товаров");
            System.out.println("4 Добавить товаров");
            System.out.println("5 Домашнее задание");
            System.out.println("0 Выход");
            option = scanner.nextInt();
            if(option == 1){
                try {
                    db.getUsers();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            else if (option == 2){
                System.out.print("Введите логин: ");
                String log = scannerStr.nextLine();
                System.out.print("Введите пароль: ");
                String pass = scannerStr.nextLine();
                try {
                    db.insertUser(log, pass);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            else if (option == 3){
                try {
                    db.getItems();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            else if (option == 4){
                System.out.print("Введите название товара: ");
                String title = scannerStr.nextLine();
                System.out.print("Введите цену: ");
                String price = scannerStr.nextLine();
                System.out.print("Введите категорию: ");
                String category = scannerStr.nextLine();

                try {
                    db.insertItems(title, price, category);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            else if (option == 5){
                // Заполняем корзину и выводим результат
                try {
                    db.insertIntOrders(db.idUser("john"), db.idItems("Кепка синяя"));
                    db.insertIntOrders(db.idUser("john"), db.idItems("Кепка красная"));
                    db.insertIntOrders(db.idUser("alex"), db.idItems("Кружка мужская"));

                    db.getOrders(db.idUser("john"));

                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            else process = false;
        }
    }
}
