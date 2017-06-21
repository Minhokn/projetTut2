package application.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import application.model.Champ;
import application.model.Client;
import application.model.Machine;
import application.model.database;

public class editController {
	
	@FXML TextField idField;
	@FXML TextField prenomField;
	@FXML TextField nomField;
	@FXML TextField telField;
	@FXML TextField adresseField;
	@FXML TextField typeField;
	
	public void setClient(Client client) {
		
		idField.setText(String.valueOf(client.getId()));
		prenomField.setText(client.getPrenom());
		nomField.setText(client.getNom());
		telField.setText(client.getTelephone());
		adresseField.setText(client.getAdresse());
		typeField.setText(client.getTypeCl());
		
		
	}
	
	public void update(Client c) {
		database d = new database();
		d.editClient(c);
	}

	public void setChamp(Champ champ) {
		
	}

	public void setMachine(Machine machine) {
		// TODO Auto-generated method stub
		
	}

}
