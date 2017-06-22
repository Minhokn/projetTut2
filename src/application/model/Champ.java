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

    /**
     * Constructeur champ
     * @param id_ch
     * @param client
     * @param surf_ch
     * @param cdn_ch
     * @param adr_ch
     * @param cult_ch
     * @param etat
     * @param GPS_ch
     */
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

    /**
     *
     * @return id du champ
     */
    public int getId_ch() {
        return id_ch;
    }

    /**
     * Definie l'id du champ
     * @param id_ch
     */
    public void setId_ch(int id_ch) {
        this.id_ch = id_ch;
    }

    /**
     *
     * @return surface du champ
     */
    public int getSurf_ch() {
        return surf_ch;
    }

    /**
     * Definie la surface d'un champ
     * @param surf_ch
     */
    public void setSurf_ch(int surf_ch) {
        this.surf_ch = surf_ch;
    }

    /**
     *
     * @return centre du champ
     */
    public String getCdn_ch() {
        return cdn_ch;
    }

    /**
     * Defenie le centre du champ
     * @param cdn_ch
     */
    public void setCdn_ch(String cdn_ch) {
        this.cdn_ch = cdn_ch;
    }

    /**
     *
     * @return adresse du champ
     */
    public String getAdr_ch() {
        return adr_ch;
    }

    /**
     * Defnie l'adresse du champ
     * @param adr_ch
     */
    public void setAdr_ch(String adr_ch) {
        this.adr_ch = adr_ch;
    }

    /**
     *
     * @return le client du champs
     */
    public Client getClient() {
        return client;
    }

    /**
     * Definie le client du champs
     * @param client
     */
    public void setClient(Client client) {
        this.client = client;
    }

    /**
     *
     * @return culture du champ
     */
    public String getCult_ch() {
        return cult_ch;
    }

    /**
     *
     * @param cult_ch
     */
    public void setCult_ch(String cult_ch) {
        this.cult_ch = cult_ch;
    }

    /**
     *
     * @return l'etat du champ
     */
    public int getEtat() {
        return etat;
    }

    /**
     * Definie l'etat du champ
     * @param etat
     */
    public void setEtat(int etat) {
        this.etat = etat;
    }

    /**
     *
     * @return les coordonnees GPS
     */
    public String getGPS_ch() {
        return GPS_ch;
    }

    /**
     * Defeinie les coordonnees GPS
     * @param gPS_ch
     */
    public void setGPS_ch(String gPS_ch) {
        GPS_ch = gPS_ch;
    }

    /**
     *
     * @return un Json pour les infos du champ
     */
    public String getJson(){
       /* return "{\"type\":\"Feature\",\"properties\":{\"NUM_ILOT\": \"" + id_ch + "\",\"culture\": \""
                + cult_ch + "\",\"proprio\": \"" + client + "\",\"bottelage\": \""
                + "-type de la botte-" + "\",\"transport\": \"" + "-transport(o/n)-" + "\"},\"geometry\":"
                + GPS_ch + "}";*/


        return "{\"type\":\"Feature\",\"properties\":{\"NUM_ILOT\": \"" + id_ch + "\",\"culture\": \""
                + cult_ch + "\",\"proprio\": \"" + client + "\",\"bottelage\": \""
                + etat + "\",\"transport\": \"" + "-transport(o/n)-" + "\"},\"geometry\":"
                + GPS_ch + "}";







        /*return "{\"type\":\"Feature\",\"properties\":{\"NUM_ILOT\": \"" + id_ch + "\",\"Culture\": \""
                + cult_ch + "\",\"Client\": \"" + client + "\",\"etat\": \""
                + etat + "\",\"Surface\": \"" + surf_ch + "\"},\"geometry\":"
                + GPS_ch + "}";*/
        }

    /**
     * Calcule du centre du champs
     * @return
     */
    public Point getCentre() {
        Point[] points = JSONManager.read(this.getJson());
        float lat = 0, longi = 0;
        for (int i = 0; i < points.length; i++) {
            longi += points[i].getX();
            lat += points[i].getY();
        }
        return new Point(lat / points.length, longi / points.length);
    }

    /**
     * Redefinition du toString
     * @return
     */
    @Override
    public String toString() {
        return adr_ch+" ("+client+") ["+cult_ch+"]";
    }
}
