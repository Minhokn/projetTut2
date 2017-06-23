package application.controller;

import application.Main;
import application.model.Champ;
import application.model.JSON;

/**
 * Created by Killian Lts on 22/06/2017.
 */
public class JsInterface {

    /**
     *
     * @return un geoJson
     */
    public String getGeoJson(){
        return Main.getMeJson().toString();
    }

    /**
     *
     * @param id
     * @return les champs pour le json
     */
    public Champ getChamp(int id){
        return Main.getMeJson().getChamp(id);
    }

    /**
     *
     * @param id
     * @return millieu du champ x
     */
    public double getMiddleChampX(int id){
        return Main.getMeJson().getChamp(id).getCentre().getX();
    }

    /**
     *
     * @param id
     * @return millieu du champ y
     */
    public double getMiddleChampY(int id){
        return Main.getMeJson().getChamp(id).getCentre().getY();
    }
}
