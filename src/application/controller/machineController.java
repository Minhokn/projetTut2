package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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

public class machineController implements Initializable {

	@FXML
	TableView<Machine> machineTableau;

	@FXML
	private TableColumn<Machine, String> marqueColonne;
	@FXML
	private TableColumn<Machine, String> modeleColonne;
	@FXML
	private TableColumn<Machine, String> etatColonne;

	private ObservableList<Machine> machines = FXCollections.observableArrayList();


	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {



		marqueColonne.setPrefWidth(100);
		marqueColonne.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMarque()));
		modeleColonne.setPrefWidth(100);
		modeleColonne.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getModele()));
		etatColonne.setPrefWidth(100);
		etatColonne.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEtat()));

		machines.setAll(new database().recupererMachine());
		machineTableau.getItems().setAll(machines);
	
	}
	public void editMachine(ActionEvent e) {

		if (machineTableau.getSelectionModel().getSelectedItem() != null) {
			newFenetre(machineTableau.getSelectionModel().getSelectedItem());
		}
	}
	public void addMachine(ActionEvent e) {newFenetre(null);}
	
	
	public void newFenetre(Machine machine) {
		Stage primaryStage = new Stage();
		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/application/view/editerChamps.fxml"));
			Parent root = loader.load();
			primaryStage.setTitle("Edit Person");

			EditMachineController controller = loader.getController();
			if(machine == null) {

			} else {
				controller.setMachineSelected(machine);
			}


			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();


		} catch (IOException e1) {
			e1.printStackTrace();
		}



	}

}
