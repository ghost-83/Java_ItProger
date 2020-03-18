package sample.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.DB;

public class AddNewsController {

    DB db = new DB();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField textField;

    @FXML
    private TextArea textMax;

    @FXML
    private Button btnSave;

    @FXML
    private TextArea textMini;

    @FXML
    private Label label;

    @FXML
    void initialize() {

        btnSave.setOnAction(actionEvent -> {

            if (textField.getCharacters().length() < 3){
                textField.setStyle("-fx-background-color: #f4d3ea");
                label.setText("Поле содержат мало символов!");
            } else if (textMini.getText().length() < 5){
                textMini.setStyle("-fx-background-color: #f4d3ea");
                label.setText("Поле содержат мало символов!");
            } else if (textMax.getText().length() < 10){
                textMax.setStyle("-fx-background-color: #f4d3ea");
                label.setText("Поле содержат мало символов!");
            }else {

                try {
                    db.addNews(textField.getCharacters().toString(), textMini.getText(), textMax.getText());
                    FXMLLoader loader = new FXMLLoader();
                    Parent newsView = loader.load(getClass().getResource("../scenes/News.fxml"));
                    Stage regGui = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                    regGui.setTitle("Новости");
                    regGui.setScene(new Scene(newsView, 1000, 600));
                    regGui.setResizable(false);
                    regGui.show();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}

