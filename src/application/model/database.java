package application.model;

import application.Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class database {

    private final static String url = "jdbc:mysql://127.0.0.1/eta?autoReconnect=true&useSSL=false";
    private final static String user = "root";
    private final static String passwd = "";
    private static Connection connexion;

    public database() {
        super();
        defineConnexion();
    }

    private static void defineConnexion() {
        if (connexion == null) {
            try {
                connexion = DriverManager.getConnection(url, user, passwd);

            } catch (SQLException e) {
                System.out.println("Pas de connexion à la base donnée ");
                System.out.println(e);
                System.exit(0);
            }
        }
    }


    public List<Client> recupererClients() {

        List<Client> liste = new ArrayList<Client>();

        try {
            Statement stat = connexion.createStatement();
            Statement stat2 = connexion.createStatement();

            ResultSet resultat = stat.executeQuery("SELECT * FROM agriculteur");
            while (resultat.next()) {
                liste.add(new Client(resultat.getInt("ID_CL"), resultat.getString("Nom_Cl"), resultat.getString("Prénom_CL"), resultat.getString("Adr_Cl"), resultat.getString("Tel_Cl")));
            }

            resultat = stat2.executeQuery("SELECT * FROM coop");
            while (resultat.next()) {
                liste.add(new Client(resultat.getInt("ID_Co"), resultat.getString("Nom_Co"), resultat.getString("Adr_Co"), resultat.getString("Tel_Co")));
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return liste;


    }

    public List<Client> recupererAgriculteurs() {

        List<Client> liste = new ArrayList<Client>();

        try {
            Statement stat = connexion.createStatement();

            ResultSet resultat = stat.executeQuery("SELECT * FROM agriculteur");
            while (resultat.next()) {
                liste.add(new Client(resultat.getInt("ID_CL"), resultat.getString("Nom_Cl"), resultat.getString("Prénom_CL"), resultat.getString("Adr_Cl"), resultat.getString("Tel_Cl")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return liste;

    }


    public void addClient(String nom, String prenom, String tel, String adr, String type) {
        try {
            Statement stat = connexion.createStatement();
            if (type.equals("Agriculteur"))
                stat.executeUpdate("INSERT INTO agriculteur(nom_cl, prénom_cl, tel_cl, adr_cl) VALUES('" + nom + "', '" + prenom + "', '" + tel + "', '" + adr + "')");
            else
                stat.executeUpdate("INSERT INTO coop(nom_co, adr_co, tel_co) VALUES('" + nom + "', '" + tel + "', '" + adr + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editClient(Client c) {
        if (!c.getTypeCl().equals("Agriculteur")) {
            try {
                Statement stat = connexion.createStatement();
                stat.executeUpdate("UPDATE coop SET Nom_Co='" + c.getNom() + "',Adr_Co='" + c.getAdresse() + "',Tel_Co='" + c.getTelephone() + "' WHERE ID_Co='" + c.getId() + "' ");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            try {
                Statement stat2 = connexion.createStatement();
                stat2.executeUpdate("UPDATE agriculteur SET Nom_Cl='" + c.getNom() + "',Prénom_Cl='" + c.getPrenom() + "',Adr_Cl='" + c.getAdresse() + "',Tel_Cl='" + c.getTelephone() + "' WHERE ID_CL='" + c.getId() + "' ");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteClient(Client c) {
        if (!c.getTypeCl().equals("Agriculteur")) {
            try {
                Statement stat = connexion.createStatement();
                stat.executeUpdate("DELETE FROM coop WHERE ID_Co='" + c.getId() + "'");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            try {
                Statement stat2 = connexion.createStatement();
                stat2.executeUpdate("DELETE FROM agriculteur WHERE ID_CL='" + c.getId() + "'");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void editChamp(Champ c) {
        if (c != null) {
            try {
                Statement stat = connexion.createStatement();
                stat.executeUpdate("UPDATE champs SET id_cl='" + c.getClient().getId() + "',surf_ch='" + c.getSurf_ch() + "',cdn_ch='" + c.getCdn_ch() + "', adr_ch='" + c.getAdr_ch() + "', cult_ch='" + c.getCult_ch() + "', etat='" + c.getEtat() + "', gps_ch='" + c.getGPS_ch() + "' WHERE ID_Ch='" + c.getId_ch() + "' ");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void addChamp(int id_cl, int surf_ch, String cdn_ch, String adr_ch, String cult_ch, int etat, String gps_ch) {
        try {
            Statement stat = connexion.createStatement();
            stat.executeUpdate("INSERT INTO champs(id_cl, surf_ch, cdn_ch, adr_ch, cult_ch, etat, GPS_Ch) VALUES('" + id_cl + "', '" + surf_ch + "', '" + cdn_ch + "', '" + adr_ch + "',  '" + cult_ch + "', '" + etat + "', '" + gps_ch + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteChamp(int id_ch) {
        try {
            Statement stat = connexion.createStatement();
            stat.executeUpdate("DELETE FROM Champs WHERE id_ch='" + id_ch + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Champ> recupererChamps() {
        for (Champ c : recupererChampsClient(-1)) {
            Main.getMeJson().addChamp(c);
        }



        return recupererChampsClient(-1);
    }

    public List<Champ> recupererChampsClient(int id_cl) {

        List<Champ> liste = new ArrayList<>();
        try {
            Statement stat = connexion.createStatement();
            String request = "SELECT * FROM champs INNER JOIN agriculteur ON agriculteur.id_cl=champs.id_cl";
            if (id_cl >= 0)
                request += " WHERE agriculteur.id_cl='" + id_cl + "'";

            ResultSet resultat = stat.executeQuery(request);
            while (resultat.next()) {
                liste.add(new Champ(
                        resultat.getInt("ID_Ch"),
                        new Client(
                                resultat.getInt("ID_Cl"),
                                resultat.getString("Nom_Cl"),
                                resultat.getString("Prénom_Cl"),
                                resultat.getString("Tel_Cl"),
                                resultat.getString("Adr_Cl")
                        ),
                        resultat.getInt("Surf_ch"),
                        resultat.getString("Cdn_Ch"),
                        resultat.getString("Adr_Ch"),
                        resultat.getString("Cult_Ch"),
                        resultat.getInt("Etat"),
                        resultat.getString("GPS_Ch")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return liste;


    }

    public List<Commande> recupererCommande(int id_ch) {

        List<Commande> liste = new ArrayList<>();
        try {
            Statement stat = connexion.createStatement();
            String request = "SELECT * FROM champs INNER JOIN commande ON commande.id_ch=champs.id_ch";
            if (id_ch >= 0)
                request += " WHERE champs.ID_Ch='" + id_ch + "'";

            ResultSet resultat = stat.executeQuery(request);
            while (resultat.next()) {
                liste.add(new Commande(
                        resultat.getInt("ID_Com"),
                        resultat.getString("Date_Com"),
                        resultat.getString("Bott_Com"),
                        resultat.getString("Trans_Rec"),
                        resultat.getFloat("Taille_Max"),
                        resultat.getInt("Tonnes_Rec"),
                        resultat.getFloat("Cout_Com"),
                        new Champ(
                                resultat.getInt("ID_Ch"),
                                clientFromChamp(resultat.getInt("ID_CL")),
                                resultat.getInt("Surf_Ch"),
                                resultat.getString("Cdn_Ch"),
                                resultat.getString("Adr_Ch"),
                                resultat.getString("Cult_Ch"),
                                resultat.getInt("Etat"),
                                resultat.getString("GPS_Ch")
                        ),
                        resultat.getString("rav_Com"),
                        resultat.getString("esc_Com")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return liste;


    }

    public Client clientFromChamp(int id_cl) {
        Client cl = null;
        try {
            Statement stat = connexion.createStatement();

            ResultSet resultat = stat.executeQuery("SELECT * FROM agriculteur WHERE agriculteur.id_cl='" + id_cl + "'");
            while (resultat.next()) {
                cl = new Client(
                        resultat.getInt("ID_Cl"),
                        resultat.getString("Nom_Cl"),
                        resultat.getString("Prénom_Cl"),
                        resultat.getString("Tel_Cl"),
                        resultat.getString("Adr_Cl")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cl;
    }

    public List<Machine> recupererMachine() {
        List<Machine> liste = new ArrayList<>();
        Machine mach;

        try {
            Statement stat = connexion.createStatement();

            ResultSet resultat = stat.executeQuery("SELECT * FROM vehicule");
            while (resultat.next()) {
                mach = new Machine(resultat.getInt("ID_Mach"), resultat.getString("Marque"), resultat.getString("Modèle"), resultat.getInt("Etat"));
                liste.add(mach);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return liste;
    }

    public void editMachine(Machine m) {
        if (m != null) {
            try {
                Statement stat = connexion.createStatement();
                stat.executeUpdate("UPDATE vehicule SET marque='" + m.getMarque() + "', modèle='" + m.getModele() + "', etat='" + m.getEtat() + "' WHERE id_mach='" + m.getId() + "'");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void addMachine(String marque, String modele, int etat) {
        try {
            Statement stat = connexion.createStatement();
            stat.executeUpdate("INSERT INTO vehicule(marque, modèle, etat) VALUES('" + marque + "', '" + modele + "', '" + etat + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteMachine(int id_mach) {
        try {
            Statement stat = connexion.createStatement();
            stat.executeUpdate("DELETE FROM vehicule WHERE id_mach='" + id_mach + "'");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Moissoneuse> recupererMoissonneuse() {
        List<Moissoneuse> liste = new ArrayList<>();
        Moissoneuse mach;

        try {
            Statement stat = connexion.createStatement();

            ResultSet resultat = stat.executeQuery("SELECT DISTINCT * FROM moissonneuses JOIN vehicule WHERE Moissonneuses.Id_Mach=vehicule.Id_Mach");
            while (resultat.next()) {
                liste.add(new Moissoneuse(resultat.getInt("ID_Moi"), resultat.getString("Marque"), resultat.getString("Modèle"),
                        resultat.getInt("Etat"), resultat.getInt("Cons_R_Moi"), resultat.getInt("Cons_F_Moi"), resultat.getInt("Taille_T_Moi"),
                        resultat.getInt("Large_C_Moi"), resultat.getInt("Large_Moi"), resultat.getInt("Hauteur_Moi"), resultat.getInt("Poids_Moi"),
                        resultat.getInt("Taille_R_Moi")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return liste;
    }

    public List<Tracteur> recupererTracteur() {
        List<Tracteur> liste = new ArrayList<>();

        try {
            Statement stat = connexion.createStatement();

            ResultSet resultat = stat.executeQuery("SELECT * FROM tracteurs JOIN vehicule WHERE tracteurs.Id_Mach=vehicule.Id_Mach");
            while (resultat.next()) {
                liste.add(new Tracteur(resultat.getInt("ID_Trac"), resultat.getString("Marque"), resultat.getString("Modèle"), resultat.getInt("Etat")
                        , resultat.getString("Capacité_Trac")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return liste;
    }


    public void addBotteleuse(String type) {
        try {
            Statement stat = connexion.createStatement();
            stat.executeUpdate("INSERT INTO vehicule(type) VALUES('" + type + "')");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editBotteleuse(Botteleuse b) {
        if (b != null) {
            try {
                Statement stat = connexion.createStatement();
                stat.executeUpdate("UPDATE botteleuse SET ID_Bot='" + b.getId() + "',Type_Bot='" + b.getType());
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static int nbrDuréeMoisson() {

        int value = 0;
        try {
            Statement stat = connexion.createStatement();

            ResultSet resultat = stat.executeQuery("Select AVG(Duree) as DureeRecolte from CONTENIR");
            if (resultat.next()) {
                value = resultat.getInt("DureeRecolte");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return value;

    }

    public static int nbrDistanceKM() {

        int value = 0;
        try {
            Statement stat = connexion.createStatement();

            ResultSet resultat = stat.executeQuery("Select AVG(Dist) as DistanceParcourue FROM CONTENIR;");
            if (resultat.next()) {
                value = resultat.getInt("DistanceParcourue");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static int nbrTonneRecoltées() {

        int value = 0;
        try {
            Statement stat = connexion.createStatement();

            ResultSet resultat = stat.executeQuery("Select AVG(Tonnes_Rec) as TonneRecoltee from COMMANDE;");
            if (resultat.next()) {
                value = resultat.getInt("TonneRecoltee");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return value;
    }

    public static int nbrTonnesParHectar() {

        int value = 0;
        try {
            Statement stat = connexion.createStatement();

            ResultSet resultat = stat.executeQuery("Select AVG(Tonnes_Rec/Surf_Ch) as TonnesRecolteeSurface from COMMANDE join CHAMPS on CHAMPS.ID_Ch=COMMANDE.ID_Ch;");
            if (resultat.next()) {
                value = resultat.getInt("TonnesRecolteeSurface");

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return value;
    }
}
