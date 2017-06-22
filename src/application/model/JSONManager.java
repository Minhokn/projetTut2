package application.model;


import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;

/**
 * Une classe permettant encoder et d�coder au format JSON<br>
 * Soit en lecture a partir d'un chaine json vers un tableau de points (coordonn�es GPS)<br>
 * exemple de chaine :"{\"type\":\"Polygon\",\"coordinates\":[[[47.9219289,-1.5161884],[47.9206383,-1.51658],[47.920854,-1.5113872],[47.9221086,-1.5114999]]]}"<br>
 * Soit en ecriture a partir d'un tableau de points vers une chaine JSON.
 * 
 * @version 1.0
 */
public class JSONManager {
	/**
	 * M�thode permettant de lire une chaine de caract�re aux convention geojson et d'en extraire les coordonn�es.
	 * 
	 * @param s	Chaine de caractere respectant les conventions des fichiers JSON.
	 * 
	 * @return	Le tableau de coordonn�es.
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
	 * M�thode permettant de mettre un tableau de coordonn�es sous forme de chaine JSON.
	 * 
	 * @param t	Tableau de coordonn�es.
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
