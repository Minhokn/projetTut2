package application.controller;

import application.model.Champ;
import application.model.Client;
import application.model.Machine;
import application.model.database;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;


public class EditMachineController {

    @FXML private VBox vbox;
    @FXML private TextField marqueField;
    @FXML private TextField modeleField;
    @FXML private TextField etatField;

    private Machine machineSelected;

    public void initialize() {
    }

    public void handleOk() {



    }


    public void handleCancel() {

        ((Stage) vbox.getScene().getWindow()).close();
    }

    public void setMachineSelected(Machine machine) {
        this.machineSelected = machine;

        marqueField.setText(machine.getMarque());
        modeleField.setText(machine.getModele());
        etatField.setText(machine.getEtat());
    }
}
