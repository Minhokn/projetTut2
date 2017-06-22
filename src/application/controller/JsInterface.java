package application.controller;

import application.Main;
import application.model.Champ;
import application.model.JSON;

/**
 * Created by Killian Lts on 22/06/2017.
 */
public class JsInterface {

    public String getGeoJson(){
        return Main.getMeJson().toString();
    }

    public Champ getChamp(int id){
        return Main.getMeJson().getChamp(id);
    }

    public double getMiddleChampX(int id){
        return Main.getMeJson().getChamp(id).getCentre().getX();
    }
    public double getMiddleChampY(int id){
        return Main.getMeJson().getChamp(id).getCentre().getY();
    }
}
