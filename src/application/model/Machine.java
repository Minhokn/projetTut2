package application.model;


public class Machine {
	
	private int id_Mach;
	private String marque;
	private String modele;
	private int etat;

	/**
	 * Constructeur Machine
	 * @param id_Mach
	 * @param marque
	 * @param modele
	 * @param etat
	 */
	public Machine(int id_Mach, String marque, String modele, int etat) {

		super();
		this.id_Mach = id_Mach;
		this.marque = marque;
		this.modele = modele;
		this.etat = etat;
	}

	/**
	 *
	 * @return id de la machine
	 */
	public int getId() {
		return id_Mach;
	}

	/**
	 * Definie l'id de la machine
	 * @param id_Mach
	 */
	public void setId(int id_Mach) {
		this.id_Mach = id_Mach;
	}

	/**
	 *
	 * @return Marque de la machine
	 */
	public String getMarque() {
		return marque;
	}

	/**
	 * Definie la marque de la machine
	 * @param marque
	 */
	public void setMarque(String marque) {
		this.marque = marque;
	}

	/**
	 *
	 * @return le modele de la machine
	 */
	public String getModele() {
		return modele;
	}

	/**
	 * Definie le modele de la machine
	 * @param modele
	 */
	public void setModele(String modele) {
		this.modele = modele;
	}

	/**
	 *
	 * @return etat de la machine
	 */
	public int getEtat() {
		return etat;
	}

	/**
	 * Definie l'etat de la machine
	 * @param etat
	 */
	public void setEtat(int etat) {
		this.etat = etat;
	}

	/**
	 * Reféinition du toString()
	 * @return
	 */
	@Override
	public String toString() {
		return marque +"( "+ modele+" )";	}

}