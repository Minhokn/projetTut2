package application.controller;

import application.model.*;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.StackPane;

import java.util.List;


public class mapController implements APIGoogleMap {
	
	@FXML StackPane googleMaps;
	@FXML private ComboBox<Client> NdC;
    @FXML private ComboBox<Champ> AdC;
    @FXML private ComboBox<Champ> dc1;
    @FXML private ComboBox<Champ> dc2;
	
	private Maps map;
	private static final int ZOOM = 12;
	private List<Client> listClients;
    private List<Champ> listChamps;
    private List<Champ> listChampsClient;
	
	public void initialize() {
		map=new Maps("map");
		map.setParent(googleMaps);

        listChamps = new database().recupererChamps();
		listClients = new database().recupererClients();


		NdC.getItems().setAll(listClients);
		NdC.setValue(NdC.getItems().get(0));


        listChampsClient=new database().recupererChampsClient(NdC.getValue().getId());


        AdC.getItems().setAll(listChampsClient);
        AdC.setValue(AdC.getItems().get(0));


        dc1.getItems().setAll(listChamps);
        dc1.setValue(dc1.getItems().get(0));


        dc2.getItems().setAll(listChamps);
        dc2.setValue(dc2.getItems().get(0));
	}


    public void askToLoadChamp(){
        System.out.println("ok");
        for(Champ champ:listChamps){
            map.addChamp(champ);
        }
    }
}
