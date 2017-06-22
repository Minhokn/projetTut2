package application.model;

/**
 * Created by Leo on 22/06/2017.
 */
public class Commande {

    private int id_Com;
    private String date_Com;
    private String bott_Com;
    private String trans_Com;
    private float TailleMax_Com;
    private float Tonnes_Rec_Com;
    private float cout_Com;
    private Champ champ_Com;

    public Commande(int id_Com, String date_Com, String bott_Com, String trans_Com, float tailleMax_Com, float tonnes_Rec_Com, float cout_Com, Champ champ_Com) {
        this.id_Com = id_Com;
        this.date_Com = date_Com;
        this.bott_Com = bott_Com;
        this.trans_Com = trans_Com;
        TailleMax_Com = tailleMax_Com;
        Tonnes_Rec_Com = tonnes_Rec_Com;
        this.cout_Com = cout_Com;
        this.champ_Com = champ_Com;
    }

    public int getId_Com() {
        return id_Com;
    }

    public void setId_Com(int id_Com) {
        this.id_Com = id_Com;
    }

    @Override
    public String toString(){
        return "[ "+champ_Com.getClient()+" ] "+champ_Com+" ("+date_Com+")";
    }
}
