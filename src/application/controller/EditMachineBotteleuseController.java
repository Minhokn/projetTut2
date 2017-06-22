package application.controller;

import application.model.Machine;
import application.model.database;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EditMachineBotteleuseController {

    @FXML private VBox vbox;
    @FXML private TextField marqueField;
    @FXML private TextField modeleField;
    @FXML private ComboBox<Integer> etatField;
    @FXML private ComboBox<String> typeField;

    private Botteleuse botteleuseSelected;
    private botteleuseController bottleuseController;

    public void initialize() {
        etatField.getItems().setAll(0, 1);
        etatField.setValue(etatField.getItems().get(0));
    }

    public void handleOk() {
        if(botteleuseSelected != null) {
            botteleuseSelected.setMarque(marqueField.getText());
            botteleuseSelected.setModele(modeleField.getText());
            botteleuseSelected.setEtat(etatField.getValue());
            botteleuseSelected.setType(typeField.getValue());

            new database().editMachine(machineSelected);
        } else {
            new database().addMachine(marqueField.getText(), modeleField.getText(), etatField.getValue());
        }

        machineController.refreshData();

        ((Stage) vbox.getScene().getWindow()).close();
    }

    public void handleCancel() {
        ((Stage) vbox.getScene().getWindow()).close();
    }

    public void setMachineSelected(Machine machine) {
        this.machineSelected = machine;

        marqueField.setText(machine.getMarque());
        modeleField.setText(machine.getModele());
        etatField.setValue(machine.getEtat());
    }

    public void setMachineController(machineController machineController) {
        this.machineController = machineController;
    }
}
