package application.model;

public class Tracteur extends Machine {

	private String capacite;

	/**
	 * Constructeur tracteur
	 * @param id
	 * @param marque
	 * @param modele
	 * @param etat
	 * @param capacite
	 */
	public Tracteur(int id, String marque, String modele, int etat, String capacite) {
		super(id, marque, modele, etat);
		this.capacite = capacite;
	}

	/**
	 * retourne la capacite du tracteur
	 * @return
	 */
	public String getCapacite() {
		return this.capacite;
	}

	/**
	 * definie la capacite du tracteur
	 * @param newCapacite
	 */
	public void setCapacite(String newCapacite) {
		this.capacite = newCapacite;
	}

}
