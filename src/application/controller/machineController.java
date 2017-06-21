package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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

	@FXML TableView<Machine> machineTableau;
	
	
	private TableColumn<Machine, String> marque = new TableColumn<>("Marque");
	private TableColumn<Machine, String> modele = new TableColumn<>("Modele");
	private TableColumn<Machine, String> etat = new TableColumn<>("Etat");
	private ObservableList<Machine> machines = FXCollections.observableArrayList();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
	
        marque.setPrefWidth(50);
        marque.setCellValueFactory(new PropertyValueFactory<Machine,String>("marque"));
        modele.setPrefWidth(50);
        modele.setCellValueFactory(new PropertyValueFactory<Machine,String>("modele"));
        etat.setPrefWidth(50);
        etat.setCellValueFactory(new PropertyValueFactory<Machine,String>("etat"));
        
        

		machines.setAll(new database().recupererMachine());
		
		machineTableau.getItems().setAll(machines);
		machineTableau.getColumns().setAll(marque,modele,etat);
		
	
		
		
	
	}
	public void editMachine(ActionEvent e) {
		Machine machine = (Machine) machineTableau.getSelectionModel().getSelectedItem();
		newFenetre(e, "EditerMachine.fxml", machine);
		
	}
	public void addMachine(ActionEvent e) {
		newFenetre(e, "EditerMachine.fxml");
	}
	
	
	public void newFenetre(ActionEvent e, String layout) {
		Stage primaryStage = new Stage();
		try {
			
			FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/EditerMachine.fxml"));
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
            loader.setLocation(getClass().getResource("/view/EditerMachine.fxml"));
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
