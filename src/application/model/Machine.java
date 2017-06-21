package application.model;


public class Machine {
	
	private int id_Mach = 0;
	private String marque = "";
	private String modele = "";
	private String etat = "";

	

	public Machine(int id_Mach, String marque, String modele, String etat) {

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


	public String getEtat() {
		return etat;
	}


	public void setEtat(String etat) {
		this.etat = etat;
	}




	@Override
	public String toString() {
		return "Machine [id_Mach=" + id_Mach + ", marque=" + marque + ", modele=" + modele + ", etat=" + etat + "]";	}
	
	
	

}