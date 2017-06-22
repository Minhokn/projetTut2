package application.model;


import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONStringer;


/**
 * Une classe permettant encoder et decoder au format JSON<br>
 */
public class JSONManager {
	/**
	 * Methode permettant de lire une chaine de caractere aux convention geojson et d'en extraire les coordonnees.
	 * 
	 * @param s	Chaine de caractere respectant les conventions des fichiers JSON.
	 * 
	 * @return	Le tableau de coordonnees.
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

}
