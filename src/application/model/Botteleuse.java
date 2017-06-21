package application.model;

public class Botteleuse extends Machine {
	
	private String type = "";


	public Botteleuse(int id, String marque, String modele, int etat) {
		super(id, marque, modele, etat);
		this.type = type;
	}
	
	public String getType() {
		return this.type;
	}


	public void setType(String newType) {
		this.type = newType;
	}

}