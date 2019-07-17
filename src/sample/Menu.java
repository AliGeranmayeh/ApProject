package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import template.CustomControl;


import java.applet.AppletContext;
import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

public class Menu implements Initializable {


    @FXML
    void clickclickHere(ActionEvent event) throws IOException {
        Hyperlink hyperlink = new Hyperlink();
        hyperlink.setOnAction(e -> {
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().browse(new URI("http://www.chess.com"));
                } catch (IOException e1) {
                    e1.printStackTrace();
                } catch (URISyntaxException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    public void clickplayButton(ActionEvent event) throws IOException {

        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();

        StackPane sp_mainlayout = new StackPane();
        CustomControl cc_custom = new CustomControl();
        sp_mainlayout.getChildren().add(cc_custom);

        window.setScene(new Scene(sp_mainlayout, 600, 700));
        window.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
