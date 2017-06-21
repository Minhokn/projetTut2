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
		machineTableau.getColumns().setAll(marqueColonne,modeleColonne,etatColonne);
		
	
		
		
	
	}
	public void editMachine(ActionEvent e) {
		Machine machine = (Machine) machineTableau.getSelectionModel().getSelectedItem();
		newFenetre(e, "editerMachine.fxml", machine);
		
	}
	public void addMachine(ActionEvent e) {
		newFenetre(e, "editerMachine.fxml");
	}
	
	
	public void newFenetre(ActionEvent e, String layout) {
		Stage primaryStage = new Stage();
		try {
			
			FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/editerMachine.fxml"));
            Parent root = loader.load();
			primaryStage.setTitle("Edit Machine");

			
			editController controller = loader.getController();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	public void newFenetre(ActionEvent e, String layout, Machine machine) {
		
		Stage primaryStage = new Stage();
		try {
			
			FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/editerMachine.fxml"));
            Parent root = loader.load();
			primaryStage.setTitle("Edit machine");

			
			editController controller = loader.getController();
            controller.setMachine(machine);
			
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}

}
