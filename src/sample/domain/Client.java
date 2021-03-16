package sample.domain;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Client {
    private StringProperty name;
    private IntegerProperty id_card;
    private StringProperty address;
    private IntegerProperty login_id;
    private StringProperty cnp;
    private IntegerProperty client_id;

    public Client() {
        this.name = new SimpleStringProperty();
        this.id_card = new SimpleIntegerProperty();
        this.address = new SimpleStringProperty();
        this.login_id = new SimpleIntegerProperty();
        this.cnp = new SimpleStringProperty();
        this.client_id = new SimpleIntegerProperty();
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public int getId_card() {
        return id_card.get();
    }

    public IntegerProperty id_cardProperty() {
        return id_card;
    }

    public void setId_card(int id_card) {
        this.id_card.set(id_card);
    }

    public String getAddress() {
        return address.get();
    }

    public StringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public int getLogin_id() {
        return login_id.get();
    }

    public IntegerProperty login_idProperty() {
        return login_id;
    }

    public void setLogin_id(int login_id) {
        this.login_id.set(login_id);
    }

    public String getCnp() {
        return cnp.get();
    }

    public StringProperty cnpProperty() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp.set(cnp);
    }

    public int getClient_id() {
        return client_id.get();
    }

    public IntegerProperty client_idProperty() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id.set(client_id);
    }
}
