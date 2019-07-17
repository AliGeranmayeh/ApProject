package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;

import javax.xml.bind.JAXB;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;

public class Register implements Initializable {

   // static String sql = "insert into page(username,password)";

    @FXML
    public Button backButton;

    @FXML
    public Button createButton;

    @FXML
    public TextField textField;

    @FXML
    public PasswordField passField;

    @FXML
    public PasswordField confirmPassField;

    @FXML
    public void clickBack(javafx.event.ActionEvent event) throws IOException {
        Parent tableViewParent = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(tableViewScene);
        window.show();
    }


    public void clickCreate(ActionEvent event) {

        // String sql = "select * from page";

        //String sql = "insert into page(username,password)";
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        String user_name = textField.getText();
        String pass_word = passField.getText();
        String confirm_pass = confirmPassField.getText();
       if(user_name.isEmpty()) {
           showAlert(Alert.AlertType.ERROR, window,
                   "Form Error!", "Please enter your name");
           return;
       }
           if(pass_word.isEmpty()) {
               showAlert(Alert.AlertType.ERROR, window,
                       "Form Error!", "Please enter your password");
               return;
           }
           if(confirmPassField.getText().isEmpty()) {
               showAlert(Alert.AlertType.ERROR, window,
                       "Form Error!", "Please confirm your password");
               return;
           }else
           if (!confirm_pass.equals(pass_word)) {
               Alert alert = new Alert(Alert.AlertType.ERROR);
               alert.setTitle("Error Dialog");
               alert.setHeaderText("Look, an Error Dialog");
               alert.setContentText("please confirm your password !!!");
               alert.showAndWait();
           }else{
               showAlert(Alert.AlertType.CONFIRMATION, window,
                       "Registration Successful!", "Welcome " + textField.getText());

           return;
        }


        Storage s = new Storage(user_name, pass_word);
        // Manager m = new Manager();
        Manager.Insert(s);

       // Insert(s);

    }




    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
