package ConnectionJavaSql;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Exo9 {
	
	Scanner scan = new Scanner ( System.in);
	
	public static void afficherliste () {
	
	try
	{
		
		Class.forName("org.postgresql.Driver");
		
		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Beuvrages59");
		
		Statement stmt = connection.createStatement();
		

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
	
	public static void ajouter () {
		
//		Pour ajouter un employé
		Scanner scan = new Scanner (System.in);
		
		try {
			
			
			Class.forName("org.postgresql.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Beuvrages59");
			
			Statement stmt = connection.createStatement();
			
			ResultSet res = stmt.executeQuery("SELECT * FROM emp " );
		
		System.out.println();
		System.out.println("pour ajouter un employé: ");
		System.out.println();
		
//		Numéro employé
		
		System.out.println("veuillez tapez le numéro unique de l'employé");
		int noemps = scan.nextInt();
		
//		Nom de l'employé
		
		System.out.println("veuillez tapez le nom de l'employé");
		String noms = scan.next().toUpperCase();
		
//		Prénom de l'employé
		
		System.out.println("Veuillez tapez le prénom de l'employé");
		String prenoms = scan.next().toUpperCase();
		
//		Emploi de l'employé
		
		System.out.println("Veuillez tapez l'emploi de l'employé") ;
		String emplois = scan.next().toUpperCase();
		
//		Supérieur de l'employé
		
		System.out.println("Veuillez tapez le supérieur de l'employé (numéro)");
		int sups = scan.nextInt();
		
//		Date d'embauche de l'employé
		
		System.out.println("Veuillez écrire la date d'embauche sous le format: dd/MM/yy");
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
		String dates = scan.next();
		
//		Salaire mensuel de l'employé
		
		System.out.println("Veuillez écrire le salaire mensuel de l'employé");
		int sals = scan.nextInt();
		
//		Commission de l'employé
		
		System.out.println("Veuillez écrire la commission de l'employé (en chiffre)");
		int comms = scan.nextInt();
		
//		Numéro de service
		
		System.out.println("Veuillez écrire le numéro de service de l'employé");
		byte noservs = scan.nextByte();
		

		
//		String ajouter = "INSERT INTO emp " + "VALUES (1400, 'POTEAU', 'FLORIAN', 'PRESIDENT', 1500, to_date('23/05/97', 'dd/MM/yy'), 98000.00, null, 1) ";
//		stmt.executeUpdate(ajouter);
		
		
//		WHILE pour ajouter un employer et afficher la liste des employés

		while(res.next()) {
			
			String ajouter = "INSERT INTO emp " + "VALUES (" + noemps + ",'" + noms + "'" + ",'" +prenoms +"'" + ",'" + emplois + "'" + ", " + sups + ", to_date('" + dates + "'" + ",'dd/MM/yy')" + "," + sals  + "," + comms + "," + noservs + ")";
			stmt.executeUpdate(ajouter);

			
			
			System.out.println("Numéro de service: " +noservs + " employé n° " + noemps + " " +  noms + " " + prenoms + " " + emplois + " " + sups + " embauché le"  + dates + " " + sals + " € (salaire) " + comms + " € (commission)");
			
			System.out.println("Votre employé a été ajouter");
			
		}
		connection.close();
	}
	catch(Exception e) {
		System.out.println(e);
	}
		}
	
public static void modifier () {
		
//		Pour modifier un employé
		Scanner scan = new Scanner (System.in);
		
		try {
			
			Class.forName("org.postgresql.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Beuvrages59");
			
			Statement stmt = connection.createStatement();
			
			ResultSet res1 = stmt.executeQuery("SELECT * FROM emp " );
			
			System.out.println("Pour modifier un employé: ");
		
//		Nouveau nom de l'employé
			
		System.out.println("Veuillez tapez le nouveau nom de l'employé");
		String newnoms = scan.next().toUpperCase();
		
//		Nom de l'employé
		
		System.out.println("veuillez tapez le nom actuel de l'employé");
		String noms = scan.next().toUpperCase();
		
		// Nouveau Prénom de l'employé
		
		System.out.println("Veuillez tapez le nouveau prénom de l'employé");
		String newprenom = scan.next().toUpperCase();
		
//		Prénom de l'employé
		
		System.out.println("Veuillez tapez le prénom actuel de l'employé");
		String prenom = scan.next().toUpperCase();
		
//		WHILE pour modifier un employé

		while(res1.next()) {
			
			String modifiern = "UPDATE emp SET nom = '" + newnoms + "' WHERE nom = '" + noms + "'" ;
			stmt.executeUpdate(modifiern);
			String modifierp = "UPDATE emp SET prenom = '" + newprenom + "' WHERE prenom = '" + prenom + "'";
			stmt.executeUpdate(modifierp);
			
			System.out.println("Votre employé a été modifier");
			
		}
		connection.close();
	}
	catch(Exception e) {
		System.out.println(e);
	}
		}

public static void supprimer () {
	
//	Pour supprimer un employé
	Scanner scan = new Scanner (System.in);
	
	try {
		
		Class.forName("org.postgresql.Driver");
		
		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Beuvrages59");
		
		Statement stmt = connection.createStatement();
		
		ResultSet res1 = stmt.executeQuery("SELECT * FROM emp " );
	
//		Nom de l'employé
		
		System.out.println("Pour supprimer un employé: ");
	System.out.println("veuillez tapez le nom actuel de l'employé");
	String noms = scan.next().toUpperCase();
	
//      Prénom de l'employé
	
	System.out.println("Veuillez tapez le prénom actuel de l'employé");
	String prenom = scan.next().toUpperCase();
	
//	WHILE pour supprimer un employé

	while(res1.next()) {
		
		String modifiern = "DELETE FROM EMP WHERE NOM = '" + noms + "' AND prenom = '" + prenom + "'" ;
		stmt.executeUpdate(modifiern);
		
		System.out.println("Votre employé a été supprimer");
		
	}
	connection.close();
}
catch(Exception e) {
	System.out.println(e);
}
	}
	
	
	}
