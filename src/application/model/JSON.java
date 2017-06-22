package application.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Classe permettat de cr�er un fichier json, qui a pour but de remplacer le fichier geojson contenant les champs a charger.
 * 
 * @author G8
 *
 */
public class JSON {
	/**
	 * Liste des champs a afficher sur la carte.
	 */
	private List<Champ> listChamps = new ArrayList<>();
	/**
	 * Constructeur permettant d'initialiser la liste de tous les champs.
	 *
	 * @see JSON#listChamps
	 */

	private List<Champ> allChamps = new ArrayList<>();

	public JSON() {
		super();
		allChamps=new ArrayList<>(listChamps);
	}
	/**
	 * M�thode permettant d'ajouter un champ au fichier json.
	 * 
	 * @param champ	Champ a ajouter.
	 * 
	 * @see JSON#listChamps
	 *
	 */
	public void addChamp(Champ champ) {

		listChamps.add(champ);
		allChamps=new ArrayList<>(listChamps);
	}
	/**
	 * M�thode permettant de supprimer un champ du fichier json.
	 * 
	 * @param ch	Champ a supprimer.
	 * 
	 * @see JSON#listChamps
	 *
	 */
	public void removeChamp(Champ ch) {
		listChamps.remove(ch);
		allChamps=new ArrayList<>(listChamps);
	}
	/**
	 * M�thode permettant de r�cuperer un champ dans le fichier json.
	 * 
	 * @param id	Index du champ a recuperer.
	 * 
	 * @return	Le champ recherch�.
	 * 
	 * @see	JSON#listChamps
	 */
	public Champ getChamp(int id) {
		Iterator<Champ> it = listChamps.iterator();
		while (it.hasNext()) {
			Champ current = it.next();
			if (current.getId_ch() == id) {
				return current;
			}
		}
		return null;
	}
	/**
	 * M�thode permettant de savoir combien de champ il y a dans le fichier JSON.
	 * 
	 * @return	Nombre de champ.
	 */
	public int nombreChamp() {
		return listChamps.size();
	}

	/**
	 * M�thode permettant de convertir le fichier JSON en chaine de caract�re, en respectant les conventions.
	 * 
	 * @return	Chaine de caract�re, en respectant les conventions.
	 * 
	 * @see	JSON#listChamps
	 */
	@Override
	public String toString() {
		String json = "", jsonStart = "{\"type\":\"FeatureCollection\",\"features\":[", jsonEnd = "]}";
		int nbField = 0;
		json += jsonStart;
		for (Champ ch : listChamps) {
			if (nbField >= 1) {
				json += ",";
			}
			json += ch.getJson();
			nbField++;
		}
		json += jsonEnd;
		return json;
	}


	public void trierParClient(String client){
		List<Champ> supprimee = new ArrayList<>();
		allChamps = new ArrayList<>(listChamps);
		for (Champ ch : listChamps) {
			if (ch.getClient() == null)
			supprimee.add(ch);
			else if (!ch.getClient().equals(client))
				supprimee.add(ch);
		}
		listChamps.removeAll(supprimee);
	}


	public void afficherTousLesChamps(){
		listChamps = new ArrayList<>(allChamps);
	}
}
