package sample.controllers;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import sample.DB;

public class ArticleController {

    private  DB db = new DB();

    private int id = NewsController.id;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label title;

    @FXML
    private Button btnBack;

    @FXML
    private Label text;

    @FXML
    private Label data;

    @FXML
    void initialize() throws SQLException, ClassNotFoundException {

        ResultSet res = db.getArticle(id);
        if (res.next()){
            title.setText(res.getString("title"));
            text.setText(res.getString("text"));
            data.setText("Дата: " + res.getString("data"));
        }
        btnBack.setOnAction(actionEvent -> {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("../scenes/News.fxml"));
                Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                primaryStage.setTitle("Новости");
                primaryStage.setScene(new Scene(root, 1000, 600));
                primaryStage.setResizable(false);
                primaryStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
