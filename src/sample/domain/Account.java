package sample.domain;

import javafx.beans.property.*;

public class Account {
    private IntegerProperty acc_id;
    private IntegerProperty client_id;
    private StringProperty type;
    private DoubleProperty amount;

    public Account() {
        this.acc_id = new SimpleIntegerProperty();
        this.client_id = new SimpleIntegerProperty();
        this.type = new SimpleStringProperty();
        this.amount = new SimpleDoubleProperty();
    }

    public int getAcc_id() {
        return acc_id.get();
    }

    public IntegerProperty acc_idProperty() {
        return acc_id;
    }

    public void setAcc_id(int acc_id) {
        this.acc_id.set(acc_id);
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

    public String getType() {
        return type.get();
    }

    public StringProperty typeProperty() {
        return type;
    }

    public void setType(String type) {
        this.type.set(type);
    }

    public double getAmount() {
        return amount.get();
    }

    public DoubleProperty amountProperty() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount.set(amount);
    }
}
