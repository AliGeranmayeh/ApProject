package sample;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.image.ImageView;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    public Button registerButton;

    @FXML
    public TextField textField;

    @FXML
    public Button close;

    @FXML
    public PasswordField passField;

    @FXML
    void clickRegister(ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("samplesample.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();

    }


    @FXML
    public void clickSignin(ActionEvent event) throws IOException, SQLException {

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        String user_name = textField.getText();
        String pass_word = passField.getText();

        Storage s = new Storage(user_name, pass_word);
        Manager.Update(s);

        if (user_name.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, window,
                    "Form Error!", "Please enter your name");
            return;
        }
        if (pass_word.isEmpty()) {
            showAlert(Alert.AlertType.ERROR, window,
                    "Form Error!", "Please enter your password");
            return;
        }
        Manager.getAllStorage();

        if (Manager.isLogin(user_name, pass_word)) {
            Parent tableViewParent = FXMLLoader.load(getClass().getResource("samplesamplesample.fxml"));
            Scene tableViewScene = new Scene(tableViewParent);

            window.setScene(tableViewScene);
            window.show();

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Look, an Error Dialog");
            alert.setContentText("password or username is wrong or your account is not available !!!");
            alert.showAndWait();
        }

    }

    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    public void clickclose(ActionEvent event) {
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("EXIT");
        alert.setContentText("DO YOU WANT TO EXIT ?");

        alert.showAndWait();

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            System.exit(0);
        } else {
            window.show();
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


}
