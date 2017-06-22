package application.model;

public class Moissoneuse extends Machine {
	
	private int consoR = 0;
	private int consoF = 0;
	private int tremie = 0;
	private int lgCoupe = 0;
	private int lgRoute = 0;
	private int hauteur = 0;
	private int poids = 0;
	private int tailleReservoir = 0;


	/**
	 * Constructeur Moissonneuse
	 * @param id
	 * @param marque
	 * @param modele
	 * @param etat
	 * @param consoR
	 * @param consoF
	 * @param tremie
	 * @param lgCoupe
	 * @param lgRoute
	 * @param hauteur
	 * @param poids
	 * @param tailleReservoir
	 */
	public Moissoneuse(int id, String marque, String modele, int etat, int consoR, int consoF, int tremie,
			int lgCoupe, int lgRoute, int hauteur, int poids, int tailleReservoir) {
		super(id, marque, modele, etat);
		
		this.consoR = consoR; 
		this.consoF = consoF; 
		this.tremie = tremie; 
		this.lgCoupe = lgCoupe; 
		this.lgRoute = lgRoute; 
		this.hauteur = hauteur; 
		this.poids = poids;
		this.tailleReservoir=tailleReservoir;

	}


	/**
	 *
	 * @return	 consommation sur la route
	 */
	public int getConsoR() {
		return this.consoR;
	}

	/**
	 * Definie consommation sur la route
	 * @param newConsoR
	 */
	public void setConsoR(int newConsoR) {
		this.consoR = newConsoR;
	}

	/**
	 *
	 * @return consommation en fonctionnement
	 */
	public int getConsoF() {
		return this.consoF;
	}

	/**
	 * Definie consommation en fonctionnement
	 * @param newConsoF
	 */
	public void setConsoF(int newConsoF) {
		this.consoF = newConsoF;
	}

	/**
	 *
	 * @return taille de la tremie
	 */
	public int getTremie() {
		return this.tremie;
	}

	/**
	 * Definie taille de la tremie
	 * @param newTremie
	 */
	public void setTremie(int newTremie) {
		this.tremie = newTremie;
	}

	/**
	 *
	 * @return largeur de la coupe
	 */
	public int getLgCoupe() {
		return this.lgCoupe;
	}

	/**
	 * Definie largeur de la coupe
	 * @param newLgCoupe
	 */
	public void setLgCoupe(int newLgCoupe) {
		this.lgCoupe = newLgCoupe;
	}

	/**
	 *
	 * @return largeur de la moissoneuse
	 */
	public int getLgRoute() {
		return this.lgRoute;
	}

	/**
	 * Definie largeur de la moissonneuse
	 * @param newLgRoute
	 */
	public void setLgRoute(int newLgRoute) {
		this.lgRoute = newLgRoute;
	}

	/**
	 *
	 * @return hauteur de la moissonneuse
	 */
	public int getHauteur() {
		return this.hauteur;
	}

	/**
	 * Definie la hauteur de la moissonneuse
	 * @param newHauteur
	 */
	public void setHauteur(int newHauteur) {
		this.hauteur = newHauteur;
	}

	/**
	 *
	 * @return poid de la moissoneuse
	 */
	public int getPoids() {
		return this.poids;
	}

	/**
	 * Definie le poid de la moissoneuse
	 * @param newPoids
	 */
	public void setPoids(int newPoids) {
		this.poids = newPoids;
	}

	/**
	 *
	 * @return taille du reservoir
	 */
	public int getTailleReservoir() {
		return tailleReservoir;
	}

	/**
	 * Definie la taille du reservoir
	 * @param tailleReservoir
	 */
	public void setTailleReservoir(int tailleReservoir) {
		this.tailleReservoir = tailleReservoir;
	}
}