package application.model;


public class Machine {
	
	private int id_Mach;
	private String marque;
	private String modele;
	private int etat;
	

	public Machine(int id_Mach, String marque, String modele, int etat) {

		super();
		this.id_Mach = id_Mach;
		this.marque = marque;
		this.modele = modele;
		this.etat = etat;
	}


	public int getId() {
		return id_Mach;
	}


	public void setId(int id_Mach) {
		this.id_Mach = id_Mach;
	}


	public String getMarque() {
		return marque;
	}


	public void setMarque(String marque) {
		this.marque = marque;
	}


	public String getModele() {
		return modele;
	}


	public void setModele(String modele) {
		this.modele = modele;
	}


	public int getEtat() {
		return etat;
	}


	public void setEtat(int etat) {
		this.etat = etat;
	}

	@Override
	public String toString() {
		return marque +"( "+ modele+" )";	}

}