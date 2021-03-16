package sample.presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.w3c.dom.events.EventException;
import sample.dataSource.LoginMapper;

import java.io.IOException;
import java.sql.SQLException;

public class Controller {
    @FXML
    private RadioButton admin;
    @FXML
    private RadioButton client;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;


    @FXML
    public void Validation(ActionEvent event) throws EventException, IOException, SQLException {
        if (client.isSelected()) {
            boolean ver = LoginMapper.getLoginAdmin(username.getText(), password.getText());
            if (ver) {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("client.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();

                    stage.setScene(new Scene(root1));
                    stage.show();
                }catch (Exception e){
                    System.err.println(e.getMessage());

                }

            }
        } else if (admin.isSelected()) {
            boolean ver = LoginMapper.getLoginAdmin(username.getText(), password.getText());
            if (ver) {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("administrator.fxml"));
                    Parent root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();

                    stage.setScene(new Scene(root1));
                    stage.show();
                }catch (Exception e){
                    System.err.println(e.getMessage());

                }


            }
        }

    }
}
