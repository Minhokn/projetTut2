package application.model;


public class Client {
	
	private int id;
	private String adresse;
	private String telephone;
	private String typeCl;
	private String nom;
	private String prenom = null;

	/**
	 * Constructeur Client
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param telephone
	 */
	public Client(int id, String nom, String prenom, String adresse, String telephone) {
		super();
		this.id = id;
		this.adresse = adresse;
		this.telephone = telephone;
		this.prenom = prenom;
		this.nom = nom;
		this.typeCl = "Agriculteur";
	}

	/**
	 * Redéfinition du constructeur cliet
	 * @param id
	 * @param nom
	 * @param adresse
	 * @param telephone
	 */
	public Client(int id, String nom, String adresse, String telephone) {
		super();
		this.id = id;
		this.adresse = adresse;
		this.telephone = telephone;
		this.nom = nom;
		this.typeCl = "Coopérative";
	}

	/**
	 *
	 * @return l'id du client
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Definie l'id du client
	 * @param newId
	 */
	public void setId(int newId) {
		this.id =newId;
	}

	/**
	 *
	 * @return l'adresse du client
	 */
	public String getAdresse() {
		return this.adresse;
	}

	/**
	 * Definie l'adresse  du client
	 * @param newAdresse
	 */
	public void setAdresse(String newAdresse) {
		this.adresse = newAdresse;
	}

	/**
	 *
	 * @return le telephone du client
	 */
	public String getTelephone() {
		return this.telephone;
	}


	/**
	 * Definie le telephone du client
	 * @param newTelephone
	 */
	public void setTelephone(String newTelephone) {
		this.telephone = newTelephone;
	}

	/**
	 *
	 * @return le type de client
	 */
	public String getTypeCl() {
		return typeCl;
	}

	/**
	 * Definie le type de client
	 * @param typeCl
	 */
	public void setTypeCl(String typeCl) {
		this.typeCl = typeCl;
	}

	/**
	 *
	 * @return le nom du client
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Definie le prenom du client
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 *
	 * @return le prenom du client
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Definie le prenom du client
	 * @param prenom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Redefinition du toString
	 * @return nom et prenom
	 */
	@Override
	public String toString() {
		return nom + " " +prenom ;
	}
	
	
	


}
