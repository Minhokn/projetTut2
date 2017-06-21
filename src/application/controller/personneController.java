package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import application.model.Client;
import application.model.database;

public class personneController implements Initializable {
	@FXML Label prenomLabel;
	@FXML Label nomLabel;
	@FXML Label addrLabel;
	@FXML Label telLabel;
	@FXML Label typeLabel;
	@FXML TableView personTable;
	
	
	private TableColumn<Client, String> nom = new TableColumn<>("Nom");
	private TableColumn<Client, String> pren = new TableColumn<>("Prénom");
	private ObservableList<Client> clients = FXCollections.observableArrayList();
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
        nom.setPrefWidth(50);
        nom.setCellValueFactory(new PropertyValueFactory<Client,String>("nom"));
        pren.setPrefWidth(50);
		pren.setCellValueFactory(new PropertyValueFactory<Client,String>("prenom"));
        
		List<Client> listClient = (new database()).recupererClients();
		clients.addAll(listClient);
		
		personTable.setItems(clients);
		personTable.getColumns().addAll(nom, pren);
		
		personTable.setOnMouseClicked(e -> {
			Client client = (Client) personTable.getSelectionModel().getSelectedItem();
			nomLabel.setText(client.getNom());
			prenomLabel.setText(client.getPrenom());
			addrLabel.setText(client.getAdresse());
			telLabel.setText(client.getTelephone());
			typeLabel.setText(client.getTypeCl());
		});
	}
	public void editClient(ActionEvent e) {
		Client client = (Client) personTable.getSelectionModel().getSelectedItem();
		newFenetre(e, "EditerPersonne.fxml", client);
		
	}
	public void addClient(ActionEvent e) {
		newFenetre(e, "EditerPersonne.fxml");
	}
	
	
	public void newFenetre(ActionEvent e, String layout) {
		Stage primaryStage = new Stage();
		try {
			
			FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/EditerPersonne.fxml"));
            Parent root = loader.load();
			primaryStage.setTitle("Edit Person");

			
			editController controller = loader.getController();
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	public void newFenetre(ActionEvent e, String layout, Client client) {
		
		Stage primaryStage = new Stage();
		try {
			
			FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/EditerPersonne.fxml"));
            Parent root = loader.load();
			primaryStage.setTitle("Edit Person");

			
			editController controller = loader.getController();
            controller.setClient(client);
			
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}

}