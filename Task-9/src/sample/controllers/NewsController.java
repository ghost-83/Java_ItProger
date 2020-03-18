package sample.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.DB;
import sample.User;

public class NewsController {

    private DB db = new DB();

    public static int id;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnNew;

    @FXML
    private MenuItem btnMenu;

    @FXML
    private MenuItem btnExit;

    @FXML
    private VBox vBox;

    @FXML
    void initialize() throws SQLException, ClassNotFoundException, IOException {

        ResultSet res = db.getArticles();
        Node node = null;

        while (res.next()){
            node = FXMLLoader.load(getClass().getResource("../scenes/New.fxml"));

            Label title = (Label) node.lookup("#title");
            title.setText(res.getString("title"));
            Label intro = (Label) node.lookup("#intro");
            intro.setText(res.getString("intro"));
            Label data = (Label) node.lookup("#data");
            data.setText("Дата: " + res.getString("data"));
            int idArticle = res.getInt("id");

            final Node nodeSet = node;

            node.setOnMouseClicked(mouseEvent -> {
                id = idArticle;
                try {
                    FXMLLoader root = new FXMLLoader();
                    Parent newsView = root.load(getClass().getResource("../scenes/Article.fxml"));
                    Stage regGui = new Stage();
                    regGui.setTitle("Новости");
                    regGui.setScene(new Scene(newsView, 1000, 600));
                    regGui.setResizable(false);
                    Stage logStage = (Stage)btnNew.getScene().getWindow();
                    regGui.show();
                    logStage.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            node.setOnMouseEntered(mouseEvent -> {
                nodeSet.setStyle("-fx-background-color: dimgray");
            });
            node.setOnMouseExited(mouseEvent -> {
                nodeSet.setStyle("-fx-background-color: darkslategrey");
            });

            HBox hBox = new HBox();
            hBox.getChildren().add(node);
            hBox.setAlignment(Pos.BASELINE_CENTER);
            vBox.getChildren().add(hBox);
            vBox.setSpacing(10);
        }

        btnNew.setOnAction(actionEvent -> {
            try {
                Parent root = FXMLLoader.load(getClass().getResource("../scenes/AddNews.fxml"));
                Stage primaryStage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                primaryStage.setTitle("Новая статья");
                primaryStage.setScene(new Scene(root, 1000, 600));
                primaryStage.setResizable(false);
                primaryStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        btnExit.setOnAction(actionEvent -> {
            try {

                File file = new File("user.settings");
                file.delete();

                FXMLLoader loader = new FXMLLoader();
                Parent newsView = loader.load(getClass().getResource("../scenes/Login.fxml"));
                Stage regGui = new Stage();
                regGui.setTitle("Авторизация");
                regGui.setScene(new Scene(newsView, 400, 500));
                regGui.setResizable(false);
                Stage logStage = (Stage)vBox.getScene().getWindow();
                regGui.show();
                logStage.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        btnMenu.setOnAction(actionEvent -> {
            try {
                FXMLLoader loader = new FXMLLoader();
                Parent newView = loader.load(getClass().getResource("../scenes/Update.fxml"));
                Stage regGui = new Stage();
                regGui.setTitle("Личный кабинет");
                regGui.setScene(new Scene(newView, 400, 500));
                regGui.setResizable(false);
                Stage logStage = (Stage)vBox.getScene().getWindow();
                regGui.initOwner(logStage);
                regGui.initModality(Modality.WINDOW_MODAL);
                regGui.showAndWait();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });;
    }
}
