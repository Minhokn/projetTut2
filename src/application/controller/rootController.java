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
		loadFXML("maps.fxml", null);
		
		
		accueil.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				loadFXML("maps.fxml", arg0);	
			}
			
			
			
		});
		commande.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				loadFXML("passerCommande.fxml", arg0);	
			}	
		});
		
		champs.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				loadFXML("champVue.fxml", arg0);	
			}
			
			
			
		});
		
		clients.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				loadFXML("personneVue.fxml", arg0);	
			}
			
			
			
		});
		machines.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				loadFXML("machineVue.fxml", arg0);	
			}
			
			
			
		});
		stats.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				loadFXML("statistiqueVue.fxml", arg0);	
			}	
		});
		
		
		
		
	}
	
	
	public void loadFXML(String file, ActionEvent event) {
		Parent contenu;
		try {
			contenu = FXMLLoader.load(getClass().getResource("/application/view/"+file));
			borderpane.setCenter(contenu);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
