package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        File file = new File("user.settings");
        if (file.exists()){
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            User user = (User) ois.readObject();
            if (!user.getLogin().equals("")){
                Parent root = FXMLLoader.load(getClass().getResource("scenes/News.fxml"));
                primaryStage.setTitle("Новости");
                primaryStage.setScene(new Scene(root, 1000, 600));
                primaryStage.setResizable(false);
                primaryStage.show();
            }
            ois.close();
        }else {
            Parent root = FXMLLoader.load(getClass().getResource("scenes/Login.fxml"));
            primaryStage.setTitle("Авторизация");
            primaryStage.setScene(new Scene(root, 400, 500));
            primaryStage.setResizable(false);
            primaryStage.show();
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
