package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import application.model.Machine;
import application.model.database;

public class machineController {

	@FXML
	private TableView<Machine> machineTableau;

	@FXML
	private TableColumn<Machine, String> marqueColonne;
	@FXML
	private TableColumn<Machine, String> modeleColonne;
	@FXML
	private TableColumn<Machine, Integer> etatColonne;

	private ObservableList<Machine> machineList = FXCollections.observableArrayList();

	public void initialize() {
		//prépare les colonnes de la TableView
		marqueColonne.setPrefWidth(100);
		marqueColonne.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMarque()));
		modeleColonne.setPrefWidth(100);
		modeleColonne.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getModele()));
		etatColonne.setPrefWidth(100);
		etatColonne.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getEtat()));

		refreshData();
	
	}
	public void editMachine() {
		if (machineTableau.getSelectionModel().getSelectedItem() != null) {
			newFenetre(machineTableau.getSelectionModel().getSelectedItem());
		}
	}
	//ouvre une fenetre pour ouvrir une machine
	public void addMachine() {
		newFenetre(null);
	}
	//supprime une machine
	public void deleteMachine() {
		if (machineTableau.getSelectionModel().getSelectedItem() != null) {
			new database().deleteMachine(machineTableau.getSelectionModel().getSelectedItem().getId());
			refreshData();
		}
	}

	//ouvre la fenêtre de modification/d'ajout
	public void newFenetre(Machine machine) {
		Stage primaryStage = new Stage();
		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/application/view/editerMachine.fxml"));
			Parent root = loader.load();
			primaryStage.setTitle("Editer Machine");

			EditMachineController controller = loader.getController();
			controller.setMachineController(this);
			if(machine != null) {
				controller.setMachineSelected(machine);
			}

			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	//rafraichi les deonnées de la TableView
	public void refreshData() {
		machineList.setAll(new database().recupererMachine());
		machineTableau.getItems().setAll(machineList);
	}

}