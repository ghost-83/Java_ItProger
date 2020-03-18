package sample.controllers;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.DB;
import sample.User;

public class UpdateController {

    User user = new User();
    DB db = new DB();
    public int idUser = LoginController.idUser;
    private String[] userDB;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnUpdate;

    @FXML
    private PasswordField fieldPassword;

    @FXML
    private Label labelInfo;

    @FXML
    private TextField fieldLogin;

    @FXML
    private TextField fieldEmail;

    @FXML
    void initialize() {

        try {
            userDB = db.getUser(idUser);
            user.setLogin(userDB[0]);
            user.setEmail(userDB[1]);
            fieldLogin.setText(userDB[0]);
            fieldEmail.setText(userDB[1]);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        fieldLogin.textProperty().addListener(actionEvent -> {
            if(user.setLogin(fieldLogin.getText()))
                fieldLogin.setStyle("-fx-background-color: #cef3d6");
            else
                fieldLogin.setStyle("-fx-background-color: #f4d3ea");
        });

        fieldEmail.textProperty().addListener(actionEvent -> {
            if(user.setEmail(fieldEmail.getText()))
                fieldEmail.setStyle("-fx-background-color: #cef3d6");
            else
                fieldEmail.setStyle("-fx-background-color: #f4d3ea");
        });

        fieldPassword.textProperty().addListener(actionEvent -> {
            if(user.setPassword(fieldPassword.getText()))
                fieldPassword.setStyle("-fx-background-color: #cef3d6");
            else
                fieldPassword.setStyle("-fx-background-color: #f4d3ea");
        });

        btnUpdate.setOnAction(actionEvent -> {
            try {
                if (user.getPassword() != null && fieldPassword.getText().length() > 4 && db.updateUser(user.getLogin(), user.getEmail(), user.getPassword(), idUser)){
                    btnUpdate.setText("Готово!");
                    labelInfo.setText("");;
                    fieldLogin.clear();
                    fieldEmail.clear();
                    fieldPassword.clear();
                }
                else if (fieldLogin.getText().length() < 4 )
                    labelInfo.setText("Введите правельный логин!");
                else if (user.getPassword() == null)
                labelInfo.setText("Введите правельный пароль!");
                else
                    labelInfo.setText("Пользователь с таким логином существует!");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

    }



}
