package ConnectionJavaSql;
import java.util.Scanner;
import java.sql.*;

public class ConnexionSql {
	
	public static void connect(){
		
//		TRY
		
		try
		{
			Class.forName("org.postgresql.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Beuvrages59");
			
			Statement stmt = connection.createStatement();
			
			ResultSet res = stmt.executeQuery("SELECT noemp, nom, prenom, emploi, sup, embauche, sal, comm, noserv FROM emp");
			
			System.out.println("EXERCICE 2");
			
			System.out.println();
			
//			WHILE
			

			while(res.next()) {
				
			 int noemp = res.getInt("noemp");
	         String nom = res.getString("nom");
	         String prenom = res.getString("prenom");
	         String emploi = res.getString("emploi");
	         int sup = res.getInt("sup");
	         String embauche = res.getString("embauche");
	         int sal = res.getInt("sal");
	         int comm = res.getInt("comm");
	         byte noserv = res.getByte("noserv");
	         
				
				System.out.println(noemp + " " + nom +" " + prenom + " " + emploi + " " + sup + " " + embauche + " " + sal + " "  + comm + " " + noserv);
				
			}
			
			connection.close();
		}
		catch(Exception e) {
			System.out.println(e);
			System.out.println("Sa marche pas");
		}
		
	}
		
		public static void Exo3(){
			
//			TRY
			
			try
			{
				Class.forName("org.postgresql.Driver");
				
				Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Beuvrages59");
				
				Statement stmt = connection.createStatement();
				
				ResultSet res = stmt.executeQuery("SELECT * FROM emp WHERE noserv = 5 ");
				
				System.out.println("__________________________________________________________");
				
				System.out.println("__________________________________________________________");
				
				System.out.println("EXERCICE 3");
				System.out.println();
				
//				WHILE

				while(res.next()) {
					
					
					int noemp = res.getInt("noemp");
		         String nom = res.getString("nom");
		         String prenom = res.getString("prenom");
		         String emploi = res.getString("emploi");
		         int sup = res.getInt("sup");
		         String embauche = res.getString("embauche");
		         int sal = res.getInt("sal");
		         int comm = res.getInt("comm");
		         byte noserv = res.getByte("noserv");
					
					System.out.println(noemp + " " + nom + " " + prenom + " " + emploi + " " + sup + " " + embauche + " " + sal + " " + comm + " " +noserv);
					
				}
				
				connection.close();
			}
			catch(Exception e) {
				System.out.println(e);
				System.out.println("Sa marche pas");
			}
			
		}
		
public static void Exo4(){
	
	//Exercice 4
	
//	TRY
	
	try
	{
		Class.forName("org.postgresql.Driver");
		
		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Beuvrages59");
		
		Statement stmt = connection.createStatement();
		
		ResultSet res = stmt.executeQuery("SELECT * FROM emp INNER JOIN serv on emp.noserv = serv.noserv where service = 'INFORMATIQUE'");
		
		System.out.println("__________________________________________________________");
		
		System.out.println("__________________________________________________________");
		
		System.out.println("EXERCICE 4");
		System.out.println();
		
//		WHILE

		while(res.next()) {
			
			
			
			int noemp = res.getInt("noemp");
         String nom = res.getString("nom");
         String prenom = res.getString("prenom");
         String emploi = res.getString("emploi");
         int sup = res.getInt("sup");
         String embauche = res.getString("embauche");
         int sal = res.getInt("sal");
         int comm = res.getInt("comm");
         byte noserv = res.getByte("noserv");
			
			System.out.println(noemp + " " + nom + " " + prenom + " " + emploi + " " + sup + " " + embauche + " " + sal + " " + comm + " " +noserv);
			
		}
		
		connection.close();
	}
	catch(Exception e) {
		System.out.println(e);
		System.out.println("Sa marche pas");
	}
	
}

public static void Exo5(){
	
	//Exercice 5
	
	
//	TRY
	
	try
	{
		Class.forName("org.postgresql.Driver");
		
		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Beuvrages59");
		
		Statement stmt = connection.createStatement();
		System.out.println();
		System.out.println("__________________________________________________________");
		
		System.out.println("__________________________________________________________");
		System.out.println("EXERCICE 5");
		System.out.println("tapez le nom de l'employé en majuscule");
		Scanner scan = new Scanner ( System.in);
		String nomperson = scan.next();
			
		ResultSet res = stmt.executeQuery("SELECT * FROM emp where nom = '" + nomperson + "'");
		System.out.println();
		
//		WHILE

		while(res.next()) {
			

			int noemp = res.getInt("noemp");
         String nom = res.getString("nom");
         String prenom = res.getString("prenom");
         String emploi = res.getString("emploi");
         int sup = res.getInt("sup");
         String embauche = res.getString("embauche");
         int sal = res.getInt("sal");
         int comm = res.getInt("comm");
         byte noserv = res.getByte("noserv");
			
			System.out.println(noemp + " " + nom + " " + prenom + " " + emploi + " " + sup + " " + embauche + " " + sal + " " + comm + " " +noserv);
			
		}
		
		connection.close();
	}
	catch(Exception e) {
		System.out.println(e);
		System.out.println("Sa marche pas");
	}
	}

public static void Exo6(){
	
	//Exercice 6
	
//	TRY
	
	try
	{
		Class.forName("org.postgresql.Driver");
		
		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Beuvrages59");
		
		Statement stmt = connection.createStatement();
		System.out.println("__________________________________________________________");
		
		System.out.println("__________________________________________________________");
		System.out.println("EXERCICE 6");
		System.out.println();
		System.out.println("tapez la date d'embauche de l'employé");
		Scanner scan = new Scanner ( System.in);
		int dateperson = scan.nextInt();
			
		ResultSet res = stmt.executeQuery("SELECT * FROM emp where EXTRACT(YEAR from  embauche) = '" + dateperson + "'");
		
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
			
			System.out.println(noemp + " " + nom + " " + prenom + " " + emploi + " " + sup + " " + embauche + " " + sal + " " + comm + " " +noserv);
			
		}
		
		connection.close();
	}
	catch(Exception e) {
		System.out.println(e);
		System.out.println("Sa marche pas");
	}
	}

public static void exo7 () {
	
	//Exercice 7
	
//	TRY
	
		try
		{
			Class.forName("org.postgresql.Driver");
			
			Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Beuvrages59");
			
			Statement stmt = connection.createStatement();
			
			System.out.println();
			
            System.out.println("__________________________________________________________");
			
			System.out.println("__________________________________________________________");
			
			
			System.out.println("EXERCICE 7");
			
			System.out.println("tapez une chaine de caractère en majuscule afin d'afficher les noms qui contiennent ce caractère");
			Scanner scan = new Scanner ( System.in);
			String nomL = scan.next();
				
			ResultSet res = stmt.executeQuery("SELECT * FROM emp where nom LIKE '%" + nomL + "%'");
			
			System.out.println("__________________________________________________________");
			
			System.out.println("__________________________________________________________");
			
			System.out.println("EXERCICE 7");
			System.out.println();
			
//			WHILE

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
				
				System.out.println(noemp + " " + nom + " " + prenom + " " + emploi + " " + sup + " " + embauche + " " + sal + " " + comm + " " +noserv);
				
			}
			
			connection.close();
		}
		catch(Exception e) {
			System.out.println(e);
			System.out.println("Sa marche pas");
		}
}

public static void Exo8(){
	
	//Exercice 8
	
//	TRY
	
	try
	{
		Class.forName("org.postgresql.Driver");
		
		Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Beuvrages59");
		
		Statement stmt = connection.createStatement();
		System.out.println("__________________________________________________________");
		
		System.out.println("__________________________________________________________");
		System.out.println("EXERCICE 8");
		System.out.println();
		System.out.println("veuillez saisir le service d'un employé en majuscule ainsi que le salaire que vous souhaitez afin de sélectionner les employés du service saisie et qui gagne plus du salaire saisie");
		Scanner scan = new Scanner ( System.in);
		String service = scan.next();
		int salaire = scan.nextInt();
			
		ResultSet res = stmt.executeQuery("SELECT * FROM emp INNER JOIN serv on emp.noserv = serv.noserv where service = '" + service + "' AND  sal >= " + salaire );
		
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

// Exercice 9 disponible dans la classe Exo9AjouterEmployé.java


}
	
		

		

