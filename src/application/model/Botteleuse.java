package application.model;

public class Botteleuse extends Machine {
	
	private int id;
	private String marque = "";
	private String modele = "";
	private int etat ;
	private String type = "";


	public Botteleuse(int id, String marque, String modele, int etat, String type) {
		super(id, marque, modele, etat);
		this.type = type;
	}
	
	public String getType() {
		return this.type;
	}


	public void setType(String newType) {
		this.type = newType;
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