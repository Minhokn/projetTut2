package application.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class database {
	
	private static String url = "jdbc:mysql://127.0.0.1/eta?autoReconnect=true&useSSL=false";
	private static String user = "root";
	private static String passwd = "";
	private static Connection connexion;
	
	public database() {
		super();
		getConnexion();
	}
	public static Connection getConnexion() {
		if (connexion == null) {
			try {
				connexion = DriverManager.getConnection(url, user, passwd);

			} catch (SQLException e) {
				System.out.println("Pas de connexion à la base donnée ");
				System.out.println(e);
				System.exit(0);
			}
		}
		
		return connexion;
	}
	
	
	public List<Client> recupererClients() {
		
		List<Client> liste = new ArrayList<Client>();
		Client agr = null;
		Client coop = null;
		try {
			Statement stat = connexion.createStatement();
			Statement stat2 = connexion.createStatement();

			ResultSet resultat = stat.executeQuery("SELECT * FROM agriculteur");
			while(resultat.next()) {
				agr = new Client(resultat.getInt("ID_CL"), resultat.getString("Nom_Cl"), resultat.getString("Prénom_CL"), resultat.getString("Adr_Cl"), resultat.getString("Tel_Cl"));
				liste.add(agr);
			}
			resultat = stat2.executeQuery("SELECT * FROM coop");
			while(resultat.next()) {
				coop = new Client(resultat.getInt("ID_Co"), resultat.getString("Nom_Co"), resultat.getString("Adr_Co"), resultat.getString("Tel_Co"));
				liste.add(coop);
			}
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return liste;
		
		
	}
	
	public void editClient(Client c) {
		if(c.getTypeCl() != "Agriculteur") {
			try {
				Statement stat = connexion.createStatement();
				stat.executeUpdate("UPDATE coop SET Nom_Co='"+c.getNom()+"',Adr_Co='"+c.getAdresse()+"',Tel_Co='"+c.getTelephone()+"' WHERE ID_Co='"+c.getId()+"' ");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			try {
				Statement stat2 = connexion.createStatement();
				stat2.executeUpdate("UPDATE client SET Nom_Cl='"+c.getNom()+"',Pr�nom_Cl='"+c.getPrenom()+"',Adr_Cl='"+c.getAdresse()+"',Tel_Cl='"+c.getTelephone()+"' WHERE ID_CL='"+c.getId()+"' ");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void deleteClient(Client c)
	{
		if(c.getTypeCl()!="Agriculteur") {
			try {
				Statement stat = connexion.createStatement();
				stat.executeUpdate("DELETE FROM coop WHERE WHERE ID_Co='"+c.getId()+"' ");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			try {
				Statement stat2 = connexion.createStatement();
				stat2.executeUpdate("DELETE FROM client WHERE ID_CL='"+c.getId()+"' ");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

    public void editChamp(Champ c) {
        if(c != null) {
            try {
                Statement stat = connexion.createStatement();
                stat.executeUpdate("UPDATE champs SET id_cl='"+c.getClient().getId()+"',surf_ch='"+c.getSurf_ch()+"',cdn_ch='"+c.getCdn_ch()+"', adr_ch='"+c.getAdr_ch()+"', cult_ch='"+c.getCult_ch()+"', etat='"+c.getEtat()+"', gps_ch='"+c.getGPS_ch()+"' WHERE ID_Ch='"+c.getId_ch()+"' ");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
	
	
public List<Champ> recupererChamps() {
		
		List<Champ> liste = new ArrayList<>();
		try {
			Statement stat = connexion.createStatement();

			ResultSet resultat = stat.executeQuery("SELECT * FROM champs INNER JOIN agriculteur ON agriculteur.id_cl=champs.id_cl");
			while(resultat.next()) {
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
public List<Machine> recupererMachine() {
	List<Machine> liste = new ArrayList<Machine>();
	Machine mach = null;

	try {
		Statement stat = connexion.createStatement();

		ResultSet resultat = stat.executeQuery("SELECT * FROM vehicule");
		while(resultat.next()) {
			mach = new Machine(resultat.getInt("ID_Mach"), resultat.getString("Marque"), resultat.getString("Mod�le"), String.valueOf( resultat.getInt("Etat")    )   );
			liste.add(mach);
		}
				
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return liste;
}



public static double nbrDuréeMoisson() {
	// TODO Auto-generated method stub
	return 8.74;
}

public static double nbrDistanceKM() {
	// TODO Auto-generated method stub
	return 2.8;
}

public static double nbrTonneRecoltées() {
	// TODO Auto-generated method stub
	return 15.4;
}

public static double nbrTonnesParHectar() {
	// TODO Auto-generated method stub
	return 3.5;
}



	
}
