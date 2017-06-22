package application.model;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;
/**
 * Created by Killian Lts on 22/06/2017.
 */

/**
 * Une classe permettant encoder et décoder au format JSON<br>
 * Soit en lecture a partir d'un chaine json vers un tableau de points (coordonnées GPS)<br>
 * exemple de chaine :"{\"type\":\"Polygon\",\"coordinates\":[[[47.9219289,-1.5161884],[47.9206383,-1.51658],[47.920854,-1.5113872],[47.9221086,-1.5114999]]]}"<br>
 * Soit en ecriture a partir d'un tableau de points vers une chaine JSON.
 *
 * @version 1.0
 */
public class JSONManager {
    /**
     * Méthode permettant de lire une chaine de caractère aux convention geojson et d'en extraire les coordonnées.
     *
     * @param s	Chaine de caractere respectant les conventions des fichiers JSON.
     *
     * @return	Le tableau de coordonnées.
     */
    public static Point[] read(String s) {
        Point[] points = null;
        JSONObject obj = new JSONObject(s);
        JSONArray coordinatesList = (JSONArray) obj.getJSONObject("geometry").getJSONArray("coordinates").get(0);
        points = new Point[coordinatesList.length()];
        for (int i = 0; i < coordinatesList.length(); i++)
        {
            JSONArray coordinates = (JSONArray) coordinatesList.get(i);
            points[i] = new Point(coordinates.get(0).toString(), coordinates.get(1).toString());
        }
        return points;
    }
    /**
     * Méthode permettant de mettre un tableau de coordonnées sous forme de chaine JSON.
     *
     * @param t	Tableau de coordonnées.
     *
     * @return	La chaine JSON.
     */
    public static String write(Point[] t) {
        JSONStringer stringer = new JSONStringer();
        stringer.object();
        stringer.key("type");
        stringer.value("Polygon");
        stringer.key("coordinates");
        stringer.array();
        stringer.array();
        for (int j = 0; j < t.length; j++) {
            stringer.array();
            stringer.value(t[j].getX());
            stringer.value(t[j].getY());
            stringer.endArray();
        }
        stringer.endArray();
        stringer.endArray();
        stringer.endObject();

        return stringer.toString();
    }
}