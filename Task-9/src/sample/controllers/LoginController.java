package sample.controllers;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.DB;
import sample.User;

public class LoginController {

    User user = new User();
    DB db = new DB();
    public static int idUser;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnEnter;

    @FXML
    private PasswordField fieldPassword;

    @FXML
    private Label labelInfo;

    @FXML
    private TextField fieldLogin;

    @FXML
    private Label labelRegist;

    @FXML
    void initialize() {
        labelRegist.setOnMouseClicked(mouseEvent -> {
            FXMLLoader loader = new FXMLLoader();
            Parent newView = null;
            try {
                newView = loader.load(getClass().getResource("../scenes/Registr.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            Stage regGui = new Stage();
            regGui.setTitle("Регистрация");
            regGui.setScene(new Scene(newView, 400, 500));
            regGui.setResizable(false);
            Stage logStage = (Stage)labelRegist.getScene().getWindow();
            regGui.initOwner(logStage);
            regGui.initModality(Modality.WINDOW_MODAL);
            regGui.showAndWait();
        });

        fieldLogin.textProperty().addListener(actionEvent -> {
            if(user.setLogin(fieldLogin.getText()))
                fieldLogin.setStyle("-fx-background-color: #cef3d6");
            else
                fieldLogin.setStyle("-fx-background-color: #f4d3ea");
        });
        fieldPassword.textProperty().addListener(actionEvent -> {
            if(user.setPassword(fieldPassword.getText()))
                fieldPassword.setStyle("-fx-background-color: #cef3d6");
            else
                fieldPassword.setStyle("-fx-background-color: #f4d3ea");
        });

        btnEnter.setOnAction(actionEvent -> {
            try {
                int id = db.regtUser(user.getLogin(), user.getPassword());
                if(id > 0){
                    idUser = id;

                    try {
                        FileOutputStream fos = new FileOutputStream("user.settings");
                        ObjectOutputStream oos = new ObjectOutputStream(fos);
                        oos.writeObject(user);
                        oos.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    FXMLLoader loader = new FXMLLoader();
                    Parent newsView = null;
                    try {
                        newsView = loader.load(getClass().getResource("../scenes/News.fxml"));
                        Stage regGui = new Stage();
                        regGui.setTitle("Новости");
                        regGui.setScene(new Scene(newsView, 1000, 600));
                        regGui.setResizable(false);
                        Stage logStage = (Stage)labelRegist.getScene().getWindow();
                        regGui.show();
                        logStage.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else
                    labelInfo.setText("Неверно введен логин или пароль!");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

    }
}
