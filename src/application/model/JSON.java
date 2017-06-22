package application.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * /**
 * Classe permettat de creer un fichier json, qui a pour but de remplacer le fichier geojson contenant les champs a charger.
 *
 * @author KillianLts
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
	 * Methode permettant d'ajouter un champ au fichier json.
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
	 * Methode permettant de recuperer un champ dans le fichier json.
	 * 
	 * @param id	Index du champ a recuperer.
	 * 
	 * @return	Le champ recherche.
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
	 * Methode permettant de convertir le fichier JSON en chaine de caractere, en respectant les conventions.
	 * 
	 * @return	Chaine de caractere, en respectant les conventions.
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


	public void trierParAgriculteur(String nom, String prenom){
		List<Champ> supprimee = new ArrayList<>();
		allChamps = new ArrayList<>(listChamps);
		for (Champ ch : listChamps) {
			if (ch.getClient() == null || ch.getClient().getPrenom()==null || ch.getClient().getNom()==null)
			supprimee.add(ch);
			else if (!ch.getClient().getNom().equalsIgnoreCase(nom)&&!ch.getClient().getPrenom().equalsIgnoreCase(prenom))
				supprimee.add(ch);
		}
		listChamps.removeAll(supprimee);
	}


	public void afficherTousLesChamps(){
		listChamps = new ArrayList<>(allChamps);
	}
}
