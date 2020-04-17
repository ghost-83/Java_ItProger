package sample;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Controller {

    private DB db = new DB();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox vBox;

    @FXML
    private Button save;

    @FXML
    private TextField link;

    @FXML
    private TextField title;

    @FXML
    private Label info;

    @FXML
    void initialize() throws SQLException, ClassNotFoundException, IOException {

        ResultSet res = db.getLinks();

        while (res.next()){

            addLink(res.getString("title"), res.getString("link"));
        }

        title.textProperty().addListener(actionEvent -> {
            if(title.getText().length() > 2)
                title.setStyle("-fx-background-color: #cef3d6");
            else
                title.setStyle("-fx-background-color: #f4d3ea");
        });

        link.textProperty().addListener(actionEvent -> {
            if(link.getText().length() > 5)
                link.setStyle("-fx-background-color: #cef3d6");
            else
                link.setStyle("-fx-background-color: #f4d3ea");
        });

        save.setOnAction(actionEvent -> {
            if(title.getText().length() > 3 && link.getText().length() > 5){
                try {
                    if(db.addLink(title.getText(), link.getText())){
                        addLink(title.getText(), link.getText());
                        info.setText("Added!");
                        title.clear();
                        link.clear();
                    }
                    else
                        info.setText("Enter a different name!");

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else
                info.setText("Fill in the fields!");
        });
    }

    public void addLink(String title, String link) throws IOException {
        Node node = FXMLLoader.load(getClass().getResource("links.fxml"));
        Label label = (Label) node.lookup("#title");
        label.setText(title);
        URI uri = null;
        try {
            uri = new URI(link);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        node.setOnMouseEntered(mouseEvent -> {
            node.setStyle("-fx-background-color: dimgray");
        });
        node.setOnMouseExited(mouseEvent -> {
            node.setStyle("-fx-background-color: darkslategrey");
        });

        HBox hBox = new HBox();
        hBox.getChildren().add(node);
        hBox.setAlignment(Pos.BASELINE_CENTER);
        vBox.getChildren().add(hBox);
        vBox.setSpacing(10);

        final Node nodeSet = node;
        Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;

        URI finalUri = uri;
        node.setOnMouseClicked(mouseEvent -> {
            if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE) && finalUri != null) {
                try {
                    desktop.browse(finalUri);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });
    }
}
