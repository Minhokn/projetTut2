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
    @FXML private TextField typeField;
    @FXML private TextField etatField;
    @FXML private ComboBox<Machine> machineField;

    private Machine machineSelected;

    private List<Machine> listMachine;

    public void initialize() {
        listMachine = new database().recupererMachine();
        machineField.getItems().setAll(listMachine);
        machineField.setValue(machineField.getItems().get(0));
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
        typeField.setText(machine.getType());
        etatField.setText(machine.getEtat());

/*
        for(Client client : listClients)
            if(client.equals(champ.getClient()))
                listClients.remove(client);

        clientField.setValue(champ.getClient());
        /*
        for(Machine machine : listMachine)
            if(machine.equals(machine.getMachine()))
                listMachine.remove(machine);

        machineField.setValue(machine.getMachine());*/
    }
}
