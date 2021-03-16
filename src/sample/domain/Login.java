package sample.domain;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

public class Login {
    private IntegerProperty login_id;
    private StringProperty username;
    private StringProperty password;
    private StringProperty role;

    public Login(IntegerProperty login_id, StringProperty username, StringProperty password, StringProperty role) {
        this.login_id = login_id;
        this.username = username;
        this.password = password;
        this.role = role;
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

    public String getUsername() {
        return username.get();
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public String getRole() {
        return role.get();
    }

    public StringProperty roleProperty() {
        return role;
    }

    public void setRole(String role) {
        this.role.set(role);
    }
}
