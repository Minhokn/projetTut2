package application.model;
public class Tracteur extends Machine {
	
	private int id;
	private String marque;
	private String modele;
	private int etat;
	private String capacite;

	public Tracteur(int id, String marque, String modele, int etat, String capacite) {
		super(id, marque, modele, etat);
		this.capacite = capacite;
	}


	public String getCapacite() {
		return this.capacite;
	}

	
	public void setCapacite(String newCapacite) {
		this.capacite = newCapacite;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String getMarque() {
		return marque;
	}

	@Override
	public void setMarque(String marque) {
		this.marque = marque;
	}

	@Override
	public String getModele() {
		return modele;
	}

	@Override
	public void setModele(String modele) {
		this.modele = modele;
	}

	@Override
	public int getEtat() {
		return etat;
	}

	@Override
	public void setEtat(int etat) {
		this.etat = etat;
	}
}
