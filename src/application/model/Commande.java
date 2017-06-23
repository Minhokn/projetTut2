package application.model;

/**
 * Created by Leo on 22/06/2017.
 */
public class Commande {

    /*
       Attributs
     */
    private int id_Com;
    private String date_Com;
    private String bott_Com;
    private String trans_Com;
    private float TailleMax_Com;
    private float Tonnes_Rec_Com;
    private float cout_Com;
    private Champ champ_Com;
    private String rav_Com;
    private String esc_Com;

    /*
    Constructeurs
     */
    public Commande(int id_Com, String date_Com, String bott_Com, String trans_Com, float tailleMax_Com, float tonnes_Rec_Com, float cout_Com, Champ champ_Com, String rav_Com, String esc_Com) {
        this.id_Com = id_Com;
        this.date_Com = date_Com;
        this.bott_Com = bott_Com;
        this.trans_Com = trans_Com;
        TailleMax_Com = tailleMax_Com;
        Tonnes_Rec_Com = tonnes_Rec_Com;
        this.cout_Com = cout_Com;
        this.champ_Com = champ_Com;
        this.rav_Com=rav_Com;
        this.esc_Com=esc_Com;
    }

    public Commande( String bott_Com, String trans_Com, Champ champ_Com, String rav_Com, String esc_Com) {
        this.bott_Com = bott_Com;
        this.trans_Com = trans_Com;
        this.champ_Com = champ_Com;
        this.rav_Com=rav_Com;
        this.esc_Com=esc_Com;
    }

    /*
        getters et setters
     */
    public String getRav_Com() {
        return rav_Com;
    }

    public void setRav_Com(String rav_Com) {
        this.rav_Com = rav_Com;
    }

    public String getEsc_Com() {
        return esc_Com;
    }

    public void setEsc_Com(String esc_Com) {
        this.esc_Com = esc_Com;
    }

    public int getId_Com() {
        return id_Com;
    }

    public void setId_Com(int id_Com) {
        this.id_Com = id_Com;
    }

    public String getDate_Com() {
        return date_Com;
    }

    public void setDate_Com(String date_Com) {
        this.date_Com = date_Com;
    }

    public String getBott_Com() {
        return bott_Com;
    }

    public void setBott_Com(String bott_Com) {
        this.bott_Com = bott_Com;
    }

    public String getTrans_Com() {
        return trans_Com;
    }

    public void setTrans_Com(String trans_Com) {
        this.trans_Com = trans_Com;
    }

    public float getTailleMax_Com() {
        return TailleMax_Com;
    }

    public void setTailleMax_Com(float tailleMax_Com) {
        TailleMax_Com = tailleMax_Com;
    }

    public float getTonnes_Rec_Com() {
        return Tonnes_Rec_Com;
    }

    public void setTonnes_Rec_Com(float tonnes_Rec_Com) {
        Tonnes_Rec_Com = tonnes_Rec_Com;
    }

    public float getCout_Com() {
        return cout_Com;
    }

    public void setCout_Com(float cout_Com) {
        this.cout_Com = cout_Com;
    }

    public Champ getChamp_Com() {
        return champ_Com;
    }

    public void setChamp_Com(Champ champ_Com) {
        this.champ_Com = champ_Com;
    }

    /*
    redéfinition du toString
     */
    @Override
    public String toString(){
        return "[ "+champ_Com.getClient()+" ] "+champ_Com+" ("+date_Com+")";
    }
}
