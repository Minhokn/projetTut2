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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import application.model.Champ;
import application.model.database;


public class champController implements Initializable {

	
	@FXML TableView<Champ> champsTableau;
	
	private TableColumn<Champ, String> surface;
	private TableColumn<Champ, String> adresse;
	private TableColumn<Champ, String> coordoneeGPS;
	private TableColumn<Champ, String> type;
	
	private ObservableList<Champ> champs = FXCollections.observableArrayList();
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		surface.setPrefWidth(100);
		surface.setCellValueFactory(new PropertyValueFactory<Champ,String>("surf_ch"));
		adresse.setPrefWidth(100);
		adresse.setCellValueFactory(new PropertyValueFactory<Champ,String>("adr_ch"));
		coordoneeGPS.setPrefWidth(100);
		coordoneeGPS.setCellValueFactory(new PropertyValueFactory<Champ,String>("GPS_ch"));
		type.setPrefWidth(100);
		type.setCellValueFactory(new PropertyValueFactory<Champ,String>("cult_ch"));

		champs.addAll(new database().recupererChamps());
		
		champsTableau.getItems().setAll(champs);
		champsTableau.getColumns().addAll(surface, adresse,coordoneeGPS,type);
		
	}
	
	public void editChamp(ActionEvent e) {
		Champ champ = (Champ) champsTableau.getSelectionModel().getSelectedItem();
		newFenetre(e, "EditerChamps.fxml", champ);
		
	}
	public void addChamp(ActionEvent e) {
		newFenetre(e, "EditerChamps.fxml");
	}
	
	
	public void newFenetre(ActionEvent e, String layout) {
		Stage primaryStage = new Stage();
		try {
			
			FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/EditerChamps.fxml"));
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
	
public void newFenetre(ActionEvent e, String layout, Champ champ) {
		
		Stage primaryStage = new Stage();
		try {
			
			FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/EditerChamps.fxml"));
            Parent root = loader.load();
			primaryStage.setTitle("Edit Person");

			
			editController controller = loader.getController();
            controller.setChamp(champ);
			
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
	}
}
