package application.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;


import application.model.*;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class commandeController implements Initializable {

	@FXML TableView<Tracteur> viewTracteur;
	@FXML TableView<Moissoneuse> viewMoissonneuse;
    @FXML TableView<Commande> viewCommande;
	@FXML ComboBox<Champ> champSelector;
	@FXML ComboBox<Moissoneuse> moissonneuseSelector;
	@FXML ComboBox<Tracteur> tracteurSelector;
	@FXML RadioButton ouiR;
	@FXML RadioButton  nonR;
	@FXML RadioButton  ouiE;
	@FXML RadioButton  nonE;
	@FXML ComboBox<String> bottelageSelector;
	@FXML ComboBox<String> transportSelector;
	@FXML Button affecter;
	@FXML Button valider;
	@FXML
	private TableColumn<Moissoneuse, String> marqueColonne;
	@FXML
	private TableColumn<Moissoneuse, String> modeleColonne;
	@FXML
	private TableColumn<Moissoneuse, Integer> etatColonne;
	@FXML
	private TableColumn<Tracteur, String> marqueColonnet;
	@FXML
	private TableColumn<Tracteur, String> modeleColonnet;
	@FXML
	private TableColumn<Tracteur, Integer> etatColonnet;

	@FXML private TableColumn<Commande, Client> clientCom;
    @FXML private TableColumn<Commande, Champ> champCom;
    @FXML private TableColumn<Commande, String> ravitaillementCom;
    @FXML private TableColumn<Commande, String> escortCom;
    @FXML private TableColumn<Commande,String> transportCom;
    @FXML private TableColumn<Commande, String> bottelageCom;

	private ObservableList<Moissoneuse> moissonneuseList = FXCollections.observableArrayList();

	private List<Champ> listChamps;
	private List<Moissoneuse> listMoissonneuses;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	    //Radio buttons sur "Non" par défaut
		nonR.setSelected(true);
		nonE.setSelected(true);

		//ComboBox Champ
		listChamps = new database().recupererChamps();
		champSelector.getItems().setAll(listChamps);
		champSelector.setValue(champSelector.getItems().get(0));

		//ComboBox Tracteurs
		tracteurSelector.getItems().setAll(new database().recupererTracteur());
		tracteurSelector.setValue(tracteurSelector.getItems().get(0));

		//ComboBox Moissonneuses
		listMoissonneuses = new database().recupererMoissonneuse();
		moissonneuseSelector.getItems().setAll(listMoissonneuses);
		moissonneuseSelector.setValue(moissonneuseSelector.getItems().get(0));

		//TableColumn Moissonneuses
		marqueColonne.setPrefWidth(100);
		marqueColonne.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMarque()));
		modeleColonne.setPrefWidth(100);
		modeleColonne.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getModele()));
		etatColonne.setPrefWidth(100);
		etatColonne.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getEtat()));

		//TableColumn Commandes
        clientCom.setPrefWidth(100);
        clientCom.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getChamp_Com().getClient()));
        champCom.setPrefWidth(100);
        champCom.setCellValueFactory(cellData -> new SimpleObjectProperty(cellData.getValue().getChamp_Com().toString()));
        ravitaillementCom.setPrefWidth(100);
        ravitaillementCom.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getRav_Com()));
        escortCom.setPrefWidth(100);
        escortCom.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEsc_Com()));
        transportCom.setPrefWidth(100);
        transportCom.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTrans_Com()));
        bottelageCom.setPrefWidth(100);
        bottelageCom.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getBott_Com()));


        //ComboBox Bottelage
		bottelageSelector.getItems().setAll("Non","Rond","Carré");
		bottelageSelector.setValue(bottelageSelector.getItems().get(0));

		//ComboBox Transport
		transportSelector.getItems().setAll("Lui","ETA","Négociant");
		transportSelector.setValue(transportSelector.getItems().get(0));


		//TableColumn Tracteurs
		marqueColonnet.setPrefWidth(100);
		marqueColonnet.setCellValueFactory(cellData -> {
			return new SimpleStringProperty(cellData.getValue().getMarque());

		});
		modeleColonnet.setPrefWidth(100);
		modeleColonnet.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getModele()));
		etatColonnet.setPrefWidth(100);
		etatColonnet.setCellValueFactory(cellData -> new SimpleObjectProperty<>(cellData.getValue().getEtat()));

	}
	@FXML
	public void addUnTracteur(){
		viewTracteur.getItems().add(tracteurSelector.getValue());
	}

	@FXML
	public void adduneMoissonneuse(){
		viewMoissonneuse.getItems().add(moissonneuseSelector.getValue());
	}
	@FXML
	public void verifierOR(){
		if(nonR.isSelected()){
			nonR.setSelected(false);
		}
	}
	@FXML
	public void verifierNR(){
		if(ouiR.isSelected()){
			ouiR.setSelected(false);
		}
	}
	@FXML
	public void verifierOE(){
		if(nonE.isSelected()){
			nonE.setSelected(false);
		}
	}
	@FXML
	public void verifierNE(){
		if(ouiE.isSelected()){
			ouiE.setSelected(false);
		}
	}
	@FXML
    public void valider(){

    }

    @FXML
	public void affecter(){
		if(viewMoissonneuse.getItems().size()!=0 && viewTracteur.getItems().size()!=0){

		}
	}
}
