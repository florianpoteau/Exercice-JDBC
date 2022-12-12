package ConnectionJavaSql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Exo9 {
	
	Scanner scan = new Scanner ( System.in);
	
	public static void afficherliste () {
	
	try
	{
		
		Class.forName("org.postgresql.Driver");
		
		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Beuvrages59");
		
		Statement stmt = connection.createStatement();
		
//		String ajouter = "INSERT INTO emp " + "VALUES (1400, 'POTEAU', 'FLORIAN', 'PRESIDENT', 1500, to_date('23/05/97', 'dd/MM/yy'), 98000.00, null, 1) ";
//		stmt.executeUpdate(ajouter);
		System.out.println("__________________________________________________________");
		
		System.out.println("__________________________________________________________");
		System.out.println("EXERCICE 9");
		System.out.println();
		System.out.println("Liste des employés:");
		System.out.println();
		
//		1- RESULTSET AFFICHER LA LISTE DES EMPLOYEES
			
		ResultSet res = stmt.executeQuery("SELECT * FROM emp " );
		
		
//		WHILE

		while(res.next()) {

			int noemp = res.getInt("noemp");
         String nom = res.getString("nom");
         String prenom = res.getString("prenom");
         String emploi = res.getString("emploi");
         int sup = res.getInt("sup");
         Date embauche = res.getDate("embauche");
         int sal = res.getInt("sal");
         int comm = res.getInt("comm");
         byte noserv = res.getByte("noserv");
			
			System.out.println(nom + " " + emploi + " " + sal + " €  " + "numéro de service: " +noserv);
			
		}
		
		connection.close();
	}
	catch(Exception e) {
		System.out.println(e);
		System.out.println("Sa marche pas");
	}
	}
	


}

