package application.controller;

import application.Main;
import application.model.*;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.StackPane;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.MenuItem;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.List;


public class mapController implements APIGoogleMap {

   /* @FXML StackPane googleMaps;
    @FXML private ComboBox<Client> NdC;
    @FXML private ComboBox<Champ> AdC;
    @FXML private ComboBox<Champ> dc1;
    @FXML private ComboBox<Champ> dc2;*/


    @FXML StackPane googleMaps;
    @FXML private SplitMenuButton triClient;
    @FXML private ComboBox<Champ> AdC;


    private Maps map;
    private static final int ZOOM = 12;
    private List<Client> listAgriculeur;
    private List<Champ> listChamps;
    private List<Champ> listChampsClient;

    public void initialize() {
        map=new Maps("map");
        map.setParent(googleMaps);

        listChamps = new database().recupererChamps();
        listAgriculeur = new database().recupererAgriculteurs();

/*
        NdC.getItems().setAll(listClients);
        NdC.setValue(NdC.getItems().get(0));



        listChampsClient=new database().recupererChampsClient(NdC.getValue().getId());*/

        triClient.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println(listChamps.get(0).getClient());
               Main.getMeJson().afficherTousLesChamps();
               rafraichissementMap();
            }
        });

        for (Client clt:listAgriculeur) {
            MenuItem item=new MenuItem(clt.getNom());
            item.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Main.getMeJson().afficherTousLesChamps();
                    Main.getMeJson().trierParAgriculteur(clt.getNom(),clt.getPrenom());
                    System.out.println(clt.getNom()+" "+clt.getPrenom());
                    rafraichissementMap();
                }
            });

            triClient.getItems().add(item);
        }

/*
        AdC.getItems().setAll(listChampsClient);
        AdC.setValue(AdC.getItems().get(0));*/


    }


    public void rafraichissementMap(){
        System.out.println(Main.getMeJson().toString());

        if (map!= null){
            map.enleverParent(googleMaps);
            map = new Maps("map");
            map.setParent(googleMaps);


        }
    }


}