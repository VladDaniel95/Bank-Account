package sample.presentation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.w3c.dom.events.EventException;
import sample.dataSource.AccountMapper;
import sample.domain.Account;

import java.sql.SQLException;

public class clientController {
    @FXML
    private TableColumn<Account,Integer> c_account;
    @FXML
    private TableColumn<Account,Integer> c_client;
    @FXML
    private TableColumn<Account,String> c_type;
    @FXML
    private TableColumn<Account,Double> c_amount;
    @FXML
    private TableView<Account> table;
    @FXML
    private TextField account_id;
    @FXML
    private TextField client_id;
    @FXML
    private TextField type;
    @FXML
    private TextField amount;
    @FXML
    public void Insert(ActionEvent event) throws EventException
    {
        try {
            AccountMapper.INSERT(Integer.parseInt(account_id.getText()), Integer.parseInt(client_id.getText()), type.getText(), Double.parseDouble(amount.getText()));
        }catch (EventException e){
            System.out.println("Error happened in the insertion process");
            e.printStackTrace();
            throw e;
        }
    }
    @FXML
    public void Delete(ActionEvent event) throws EventException
    {
        try {
            AccountMapper.DELETE(Integer.parseInt(account_id.getText()));
        }catch (EventException e){
            System.out.println("Error happened in the delete process");
            e.printStackTrace();
            throw e;
        }
    }
    @FXML
    public void Update(ActionEvent event) throws EventException
    {
        try {
            AccountMapper.UPDATE(Integer.parseInt(account_id.getText()), Integer.parseInt(client_id.getText()), type.getText(), Double.parseDouble(amount.getText()));
        }catch (EventException e){
            System.out.println("Error happened in the update process");
            e.printStackTrace();
            throw e;
        }
    }
    @FXML
    public void loadAccount() throws ClassNotFoundException, SQLException {
        c_account.setCellValueFactory(new PropertyValueFactory<>("acc_id"));
        c_client.setCellValueFactory(new PropertyValueFactory<>("client_id"));
        c_type.setCellValueFactory(new PropertyValueFactory<>("type"));
        c_amount.setCellValueFactory(new PropertyValueFactory<>("amount"));
        table.setItems(AccountMapper.getAllRows());
    }



}
