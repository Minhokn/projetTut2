package application.model;


public class Champ {

    private int id_ch;
    private int surf_ch;
    private String cdn_ch;
    private String adr_ch;
    private Client client;
    private String cult_ch;
    private int etat;
    private String GPS_ch;


    public Champ(int id_ch, Client client, int surf_ch, String cdn_ch, String adr_ch, String cult_ch, int etat, String GPS_ch) {
        super();
        this.id_ch = id_ch;
        this.client = client;
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


    public Client getClient() {
        return client;
    }


    public void setClient(Client client) {
        this.client = client;
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

    public String getJson(){
        return "{\"type\":\"Feature\",\"properties\":{\"NUM_ILOT\": \"" + id_ch + "\",\"culture\": \""
                + cult_ch + "\",\"proprio\": \"" + client + "\",\"bottelage\": \""
                + "-type de la botte-" + "\",\"transport\": \"" + "-transport(o/n)-" + "\"},\"geometry\":"
                + GPS_ch + "}";
        }

    public Point getCentre() {
        Point[] points = JSONManager.read(this.getJson());
        float lat = 0, longi = 0;
        for (int i = 0; i < points.length; i++) {
            longi += points[i].getX();
            lat += points[i].getY();
        }
        System.out.println(lat / points.length +"                   " + longi / points.length);
        return new Point(lat / points.length, longi / points.length);
    }


    @Override
    public String toString() {
        return "Champ{" +
                "id_ch=" + id_ch +
                ", surf_ch=" + surf_ch +
                ", cdn_ch='" + cdn_ch + '\'' +
                ", adr_ch='" + adr_ch + '\'' +
                ", client=" + client +
                ", cult_ch='" + cult_ch + '\'' +
                ", etat=" + etat +
                ", GPS_ch='" + GPS_ch + '\'' +
                '}';
    }
}
