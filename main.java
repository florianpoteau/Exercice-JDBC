package ConnectionJavaSql;

import java.util.Scanner;
public class main {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		
		ConnexionSql.connect();
		
		ConnexionSql.Exo3();
		
		ConnexionSql.Exo4();
		
		ConnexionSql.Exo5();
		
		ConnexionSql.Exo6();
		
		ConnexionSql.exo7();
		
		ConnexionSql.Exo8();
		
		Exo9();
	}
	public static void Exo9() {
		Scanner scan = new Scanner ( System.in);
		
		System.out.println("Tapez 1 pour afficher la liste d'un employé");	
		System.out.println("Tapez 2 pour afficher le détail d'un employé");
		System.out.println("Tapez 3 pour ajouter un employé");
		System.out.println("Tapez 4 pour modifier un employé");
		System.out.println("Tapez 5 pour supprimer un employé");
		int scann = scan.nextInt();
		
		
		
		if (scann == 1) {
			Exo9.afficherliste();
			System.out.println();
			Exo9();
		}
		else if (scann == 2) {
			ConnexionSql.Exo5();
			System.out.println();
			Exo9();
		}
		else if (scann == 3) {
			Exo9.ajouter();
			System.out.println();
			Exo9();
		}
		else if (scann == 4) {
			Exo9.modifier();
			System.out.println();
			Exo9();
		}
		else if ( scann == 5) {
			Exo9.supprimer();
			System.out.println();
			Exo9();
		}
	}
}


