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
				
				PreparedStatement stmt = connection.prepareStatement("SELECT *from emp WHERE noserv = (?)");
				stmt.setInt(1,5);
				
				ResultSet res= stmt.executeQuery();
					
				System.out.println("__________________________________________________________");
				
				System.out.println("__________________________________________________________");
				
				System.out.println("EXERCICE 3");
				System.out.println();
				
//				WHILE
				
				while ( res.next()) {

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
		
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM emp INNER JOIN serv on emp.noserv = serv.noserv where service = (?)");
		stmt.setString(1, "INFORMATIQUE");
		
		ResultSet res = stmt.executeQuery();
		
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
		
		System.out.println();
		System.out.println("__________________________________________________________");
		
		System.out.println("__________________________________________________________");
		System.out.println("EXERCICE 5");
		System.out.println("tapez le nom de l'employé");
		System.out.println();
		
		Scanner scan = new Scanner ( System.in);
		String nomperson = scan.next().toUpperCase();
		
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM emp where nom = (?)");
		stmt.setString(1, nomperson);
		
		ResultSet res = stmt.executeQuery();
		
		
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
		
		System.out.println("__________________________________________________________");
		
		System.out.println("__________________________________________________________");
		System.out.println("EXERCICE 6");
		System.out.println();
		System.out.println("tapez l'année d'embauche de l'employé exemple: 1990");
		Scanner scan = new Scanner ( System.in);
		int dateperson = scan.nextInt();
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM emp where EXTRACT(YEAR from  embauche) = (?)");
		
		stmt.setInt(1, dateperson);
			
		ResultSet res = stmt.executeQuery();
		
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
			
			System.out.println("tapez une chaine de caractère afin d'afficher les noms qui contiennent ce caractère");
			Scanner scan = new Scanner ( System.in);
			String nomL = scan.next().toUpperCase();
				
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
		
		System.out.println("__________________________________________________________");
		
		System.out.println("__________________________________________________________");
		System.out.println("EXERCICE 8");
		System.out.println();
		System.out.println("veuillez saisir le service d'un employé ainsi que le salaire que vous souhaitez afin de sélectionner les employés du service saisie et qui gagne plus du salaire saisie");
		Scanner scan = new Scanner ( System.in);
		String service = scan.next().toUpperCase();
		int salaire = scan.nextInt();
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM emp INNER JOIN serv on emp.noserv = serv.noserv where service = (?) AND  sal >= (?)" );
		
		stmt.setString(1, service);
		stmt.setInt(2, salaire);
			
		ResultSet res = stmt.executeQuery();
		
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

// Exercice 9 disponible dans la classe Exo9.java


}
	
		

		

