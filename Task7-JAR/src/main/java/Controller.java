import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label labelTons;

    @FXML
    private Label labelKilo;

    @FXML
    private Label labelGrams;

    @FXML
    private TextField textField;

    @FXML
    private ChoiceBox<String> choiceBox;

    @FXML
    void initialize() {

        choiceBox.getItems().addAll("Тонны", "Киллограммы", "Граммы");
        choiceBox.setValue("Тонны");

        textField.textProperty().addListener(actionEvent -> {

            if(textField.getText().matches("^[.]+$")){
                labelTons.setText("Если вы используйте дробно число,");
                labelKilo.setText("начинайте ввод с 0 и");
                labelGrams.setText("используйте точку. ¯\\_(ツ)_/¯");
            }
            else if(textField.getText().matches("^\\d+(\\.\\d+)?") || textField.getText().matches("^\\d+\\.?"))
                guiMath();

            else {
                labelTons.setText("Вам нужно ввести число.");
                labelKilo.setText("Если вы используйте дробно число,");
                labelGrams.setText("используйте точку. ¯\\_(ツ)_/¯");
            }
        });

        choiceBox.setOnAction(actionEvent -> {
            guiMath();
        });
    }

    private void guiMath(){

        float intUser = Float.valueOf(Float.parseFloat(textField.getText()));

        switch (choiceBox.getValue()){

            case "Тонны":
                labelTons.setText(String.valueOf(intUser));
                labelKilo.setText(String.valueOf(intUser * 1000));
                labelGrams.setText(String.valueOf(intUser * 1000000));
                break;

            case "Киллограммы":
                labelTons.setText(String.valueOf(intUser / 1000));
                labelKilo.setText(String.valueOf(intUser));
                labelGrams.setText(String.valueOf(intUser * 1000));
                break;

            case "Граммы":
                labelTons.setText(String.valueOf(intUser / 1000000));
                labelKilo.setText(String.valueOf(intUser / 1000));
                labelGrams.setText(String.valueOf(intUser));
                break;
        }
    }
}