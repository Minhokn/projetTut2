package application.model;


import java.util.List;

public class test {

	public static void main(String[] args) {
		
		database db = new database();
		List<Champ> cl = db.recupererChamps();
		for(Champ c : cl) {
			System.out.println(c);
		}
	}

}
