
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class DAOFilm {
	String strClassName ;
	String dbName;
	String login ;
	String motdepasse;
	String strUrl ;
	Connection conn ;
	Statement stAddUser;

  public DAOFilm() {
			try {
				String strClassName = "com.mysql.jdbc.Driver";
				String dbName= "cinema"; 
				String login= "root"; 
				String motdepasse= ""; 
				String strUrl = "jdbc:mysql://localhost:3308/" +  dbName +"?autoReconnect=true&useSSL=false";
				Class.forName(strClassName);
				Connection conn = DriverManager.getConnection(strUrl, login, motdepasse);
				Statement stAddUser = conn.createStatement(); 
			} 
			catch(ClassNotFoundException e) {  
				System.err.println("Driver non chargé !");  e.printStackTrace();
			} 
			catch(SQLException e) {
				System.err.println("Autre erreur !");  e.printStackTrace();
			}
  }
  public static void main(String[] args) {
		DAOFilm create =  new DAOFilm();
		create.add(1, "StarWars", 2001, 1, 123, 508);
		create.add(3, "StarWars", 2008, 3, 450, 850);
		create.lister();
		create.delete(3);
		create.lister();
		create.close();
	}

  public void close() {
	  try {
		this.conn.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}
  }
  	public void lister() {
	  try {
		  ResultSet rsUsers = this.stAddUser.executeQuery("select * from Film");  
		  while(rsUsers.next()) {
			System.out.print("Id = " + rsUsers.getInt("id")+"\n" 
			+ "Titre = " + rsUsers.getString("titre")+"\n"
			+ "Année de sortie = " +  rsUsers.getInt("sortie") +"\n"
			+ "Numéro du film = " + rsUsers.getInt("numero") +"\n"
			+ "Cout du film = " + rsUsers.getInt("cout")+"\n"
			+ "Recette du film = " + rsUsers.getInt("recette")+"\n"
			+"----------------------------\n" );
			}
		  }
		  catch (SQLException e) {
			e.printStackTrace();
		  }
	
	  }
  	public void add(int id,String titre,int sortie,int numero,int cout,int recette) {	
  		try { 

  			this.stAddUser.executeUpdate("insert into Film values (id,'StarWars',2004 ,2,350,470)");
 
		}
  		catch(SQLException e) {
			System.err.println("Autre erreur !");  e.printStackTrace();
		}

  	}
  	public void delete(int id) {	
  		try { 
  			this.stAddUser.executeUpdate("delete from Film where id =" + id);
		}
  		catch(SQLException e) {
			System.err.println("Autre erreur !");  e.printStackTrace();
		}

  	}
}
