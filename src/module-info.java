module Bank {
    requires javafx.fxml;
    requires javafx.controls;
    requires java.sql;
    opens sample;
    opens sample.domain;
    opens sample.presentation;

}
