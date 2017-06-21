package application.model;


public class Champ {
	
	private int id_ch=0;
	private int surf_ch=0;
	private String cdn_ch = "";
	private String adr_ch = "";
	private int id_cl= 0;
	private String cult_ch = "";
	private int etat=0;
	private String GPS_ch = "";



	public Champ(int id_ch, int id_cl, int surf_ch, String cdn_ch, String adr_ch, String cult_ch, int etat, String GPS_ch) {
		super();
		this.id_ch = id_ch;
		this.id_cl = id_cl;
		this.surf_ch = surf_ch;
		this.cdn_ch = cdn_ch;
		this.adr_ch = adr_ch;
		this.cult_ch = cult_ch;
		this.etat = etat;
		this.GPS_ch = GPS_ch;
		}



	public int getId_ch() {
		return id_ch;
	}



	public void setId_ch(int id_ch) {
		this.id_ch = id_ch;
	}



	public int getSurf_ch() {
		return surf_ch;
	}



	public void setSurf_ch(int surf_ch) {
		this.surf_ch = surf_ch;
	}



	public String getCdn_ch() {
		return cdn_ch;
	}



	public void setCdn_ch(String cdn_ch) {
		this.cdn_ch = cdn_ch;
	}



	public String getAdr_ch() {
		return adr_ch;
	}



	public void setAdr_ch(String adr_ch) {
		this.adr_ch = adr_ch;
	}



	public int getId_cl() {
		return id_cl;
	}



	public void setId_cl(int id_cl) {
		this.id_cl = id_cl;
	}



	public String getCult_ch() {
		return cult_ch;
	}



	public void setCult_ch(String cult_ch) {
		this.cult_ch = cult_ch;
	}



	public int getEtat() {
		return etat;
	}



	public void setEtat(int etat) {
		this.etat = etat;
	}



	public String getGPS_ch() {
		return GPS_ch;
	}



	public void setGPS_ch(String gPS_ch) {
		GPS_ch = gPS_ch;
	}



	@Override
	public String toString() {
		return "Champ [id_ch=" + id_ch + ", surf_ch=" + surf_ch + ", cdn_ch=" + cdn_ch + ", adr_ch=" + adr_ch
				+ ", id_cl=" + id_cl + ", cult_ch=" + cult_ch + ", etat=" + etat + ", GPS_ch=" + GPS_ch + "]";
	}


	

/*
	public Client getClients() {
		return this.clients;
	}

	
	public void setClients(Client newClients) {
		this.clients = newClients;
	}

	
	public int getId() {
		return this.id;
	}

	
	public void setId(int newId) {
		this.id = newId;
	}

	
	public String getType() {
		return this.type;
	}

	
	public void setType(String newType) {
		this.type = newType;
	}

	
	public String getCoordGps() {
		return this.coordGps;
	}
	
	public double getCenterLat() {
		return Double.parseDouble(this.coordGps.split(",")[0]);
	}
	public double getCenterLong() {
		return Double.parseDouble(this.coordGps.split(",")[1]);
	}
	
	public void setCoordGps(String newCoordGps) {
		this.coordGps = newCoordGps;
	}

	
	public int getSurface() {
		return this.surface;
	}

	
	public void setSurface(int newSurface) {
		this.surface = newSurface;
	}

	
	public String getPolygone() {
		return this.polygone;
	}

	
	public void setPolygone(String newPolygone) {
		this.polygone = newPolygone;
	}

	
	public String getAdresse() {
		return this.adresse;
	}

	
	public void setAdresse(String newAdresse) {
		this.adresse = newAdresse;
	}


	@Override
	public String toString() {
		return "Champ [clients=" + clients.toString() + ", id=" + id + ", type=" + type + ", coordGps=" + coordGps + ", surface="
				+ surface + ", polygone=" + polygone + ", adresse=" + adresse + "]";
	}
*/
}
