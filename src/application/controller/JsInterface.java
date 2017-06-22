package application.controller;

import application.Main;
import application.model.JSON;

/**
 * Created by Killian Lts on 22/06/2017.
 */
public class JsInterface {

    public String getGeoJson(){
        return Main.getMeJson().toString();
    }
}
