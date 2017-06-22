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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import application.model.Client;
import application.model.database;

public class personneController implements Initializable {
	@FXML private Label prenomLabel;
	@FXML private Label nomLabel;
	@FXML private Label addrLabel;
	@FXML private Label telLabel;
	@FXML private Label typeLabel;
	@FXML private TableView<Client> personTable;

	@FXML private TableColumn<Client, String> nomColonne;
	@FXML private TableColumn<Client, String> prenomColonne;

	private ObservableList<Client> clients = FXCollections.observableArrayList();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		nomColonne.setPrefWidth(100);
		nomColonne.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNom()));
		prenomColonne.setPrefWidth(100);
		prenomColonne.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPrenom()));

		clients.addAll(new database().recupererClients());
		personTable.getItems().setAll(clients);

		personTable.setOnMouseClicked(e -> {
			Client client = personTable.getSelectionModel().getSelectedItem();
			nomLabel.setText(client.getNom());
			prenomLabel.setText(client.getPrenom());
			addrLabel.setText(client.getAdresse());
			telLabel.setText(client.getTelephone());
			typeLabel.setText(client.getTypeCl());
		});

		refreshData();
	}


	public void editClient() {
		if (personTable.getSelectionModel().getSelectedItem() != null) {
			newFenetre(personTable.getSelectionModel().getSelectedItem());
		}
	}

	public void addClient() {
		newFenetre(null);
	}

	public void deleteClient() {
		if (personTable.getSelectionModel().getSelectedItem() != null) {
			new database().deleteClient(personTable.getSelectionModel().getSelectedItem());
			refreshData();
		}
	}


	public void newFenetre(Client client) {

		Stage primaryStage = new Stage();
		try {

			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/application/view/editerPersonne.fxml"));
			Parent root = loader.load();
			primaryStage.setTitle("Edit Person");

			EditPersonneController controller = loader.getController();

			controller.setClientController(this);
			if(client != null) {
				controller.setClientSelected(client);
			}

			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();


		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void refreshData() {

        clients.setAll(new database().recupererClients());
        personTable.getItems().setAll(clients);
	}

}