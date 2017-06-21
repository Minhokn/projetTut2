package application.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class rootController implements Initializable {
	
	@FXML Button accueil;
	@FXML Button commande;
	@FXML Button champs;
	@FXML Button machines;
	@FXML Button clients;
	@FXML Button stats;
	
	@FXML BorderPane borderpane;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		/*
		 * Charger la page d'accuil
		 */
		loadFXML("maps.fxml");
		
		
		accueil.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				loadFXML("maps.fxml");
			}
			
			
			
		});
		commande.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				loadFXML("passerCommande.fxml");
			}	
		});
		
		champs.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				loadFXML("champVue.fxml");
			}
			
			
			
		});
		
		clients.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				loadFXML("personneVue.fxml");
			}



		});
		machines.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				loadFXML("machineVue.fxml");
			}
			
			
			
		});
		stats.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				loadFXML("statistiqueVue.fxml");
			}	
		});
		
		
		
		
	}
	
	
	public void loadFXML(String file) {
		Parent contenu;
		try {
			contenu = FXMLLoader.load(getClass().getResource("/application/view/"+file));
			borderpane.setCenter(contenu);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
