package sample.controllers;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.DB;
import sample.User;

public class RegistrController {

    User user = new User();
    DB db = new DB();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnR;

    @FXML
    private PasswordField fieldPassword;

    @FXML
    private Label labelInfo;

    @FXML
    private TextField fieldLogin;

    @FXML
    private TextField fieldEmail;

    @FXML
    private Label labelRegist;

    @FXML
    private CheckBox checkBox;

    @FXML
    void initialize() {

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

        btnR.setOnAction(actionEvent -> {
            try {
                if (checkBox.isSelected() && user.getLogin() !=null && user.getEmail() != null && user.getPassword() != null && db.insertUser(user.getLogin(), user.getEmail(), user.getPassword())){
                    Stage regStage = (Stage)btnR.getScene().getWindow();
                    regStage.close();
                }
                else  if (user.getLogin() ==null)
                    labelInfo.setText("Введите правильный логин!");
                else  if (user.getEmail() == null)
                    labelInfo.setText("Введите правильный email!");
                else  if (!checkBox.isSelected())
                    labelInfo.setText("Поставте галочу о согласии!");
                else  if (user.getPassword() == null)
                    labelInfo.setText("Введите правильный пароль!");
                else
                    labelInfo.setText("Пользователь с таким логином уже существует!");

            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });

    }
}