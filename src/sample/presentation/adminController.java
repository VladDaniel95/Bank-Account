package sample.presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.w3c.dom.events.EventException;
import sample.dataSource.AccountMapper;
import sample.dataSource.ClientMapper;
import sample.domain.Client;

import java.sql.SQLException;

public class adminController {
    @FXML
    private TableView<Client> table;
    @FXML
    private TableColumn<Client,String> c_name;
    @FXML
    private TableColumn<Client,Integer> c_card;
    @FXML
    private TableColumn<Client,String> c_address;
    @FXML
    private TableColumn<Client,Integer> c_login;
    @FXML
    private TableColumn<Client,String> c_cnp;
    @FXML
    private TableColumn<Client,Integer> c_client;

    @FXML
    private TextField name;
    @FXML
    private TextField id_card;
    @FXML
    private TextField address;
    @FXML
    private TextField login_id;
    @FXML
    private TextField cnp;
    @FXML
    private TextField client_id;
    @FXML
    public void Insert(ActionEvent event) throws EventException{
        try{
            ClientMapper.INSERT(name.getText(),Integer.parseInt(id_card.getText()),address.getText(),Integer.parseInt(login_id.getText()),cnp.getText(),Integer.parseInt(client_id.getText()));

        }catch (EventException e){
            System.out.println("Something went wrong in the insertion process ");
            e.printStackTrace();
            throw e;

        }
    }
    @FXML
    public void Delete(ActionEvent event) throws EventException{
        try{
            ClientMapper.DELETE(Integer.parseInt(client_id.getText()));

        }catch (EventException e){
            System.out.println("Something went wrong in the delete process ");
            e.printStackTrace();
            throw e;

        }
    }
    @FXML
    public void Update(ActionEvent event) throws EventException{
        try{
            ClientMapper.UPDATE(name.getText(),Integer.parseInt(id_card.getText()),address.getText(),Integer.parseInt(login_id.getText()),cnp.getText(),Integer.parseInt(client_id.getText()));

        }catch (EventException e){
            System.out.println("Something went wrong in the update process ");
            e.printStackTrace();
            throw e;

        }
    }
    @FXML
    public void loadClients() throws ClassNotFoundException, SQLException {
        c_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        c_card.setCellValueFactory(new PropertyValueFactory<>("id_card"));
        c_address.setCellValueFactory(new PropertyValueFactory<>("address"));
        c_login.setCellValueFactory(new PropertyValueFactory<>("login_id"));
        c_cnp.setCellValueFactory(new PropertyValueFactory<>("cnp"));
        c_client.setCellValueFactory(new PropertyValueFactory<>("client_id"));
        table.setItems(ClientMapper.getAllRows());
    }


}
