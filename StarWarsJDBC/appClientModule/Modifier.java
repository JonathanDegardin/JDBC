
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Modifier {

	
	
	public static void main(String[] args) {
		
		try { 
			String strClassName = "com.mysql.jdbc.Driver";
			String dbName= "cinema"; 
			String login= "root"; 
			String motdepasse= ""; 
			String nouveauTitre;
			String strUrl = "jdbc:mysql://localhost:3308/" +  dbName +"?autoReconnect=true&useSSL=false";;
			int userChoice;
			Scanner sc = new Scanner(System.in);
			System.out.println("Veuillez saisir l'id du film dont vous souhaitez changer le titre : ");
			String choix = sc.nextLine();
			userChoice = Integer.parseInt(choix);
			System.out.println("Veuillez choisir le nouveau titre du film : ");
			nouveauTitre = sc.nextLine();
			Class.forName(strClassName);
			sc.close();
			Connection conn = DriverManager.getConnection(strUrl, login, motdepasse);
			Statement stAddUser = conn.createStatement();  
			stAddUser.executeUpdate("update film set titre = '"+ nouveauTitre + "' where id =" + userChoice);

			conn.close();
			}
			catch(ClassNotFoundException e) {  
				System.err.println("Driver non chargé !");  e.printStackTrace();
			} catch(SQLException e) {
				System.err.println("Autre erreur !");  e.printStackTrace();
			}

		
		
	}
}