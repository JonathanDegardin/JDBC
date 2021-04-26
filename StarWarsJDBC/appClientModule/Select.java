import java.sql.*;


public class Select {

	
	
	public static void main(String[] args) {
		
		try { 
			String strClassName = "com.mysql.jdbc.Driver";
			String dbName= "cinema"; 
			String login= "root"; 
			String motdepasse= ""; 
			String strUrl = "jdbc:mysql://localhost:3308/" +  dbName+"?autoReconnect=true&useSSL=false";;

			Class.forName(strClassName);
			Connection conn = DriverManager.getConnection(strUrl, login, motdepasse);
			Statement stUsers = conn.createStatement();  

			ResultSet rsUsers = stUsers.executeQuery("select * from Film");  
			while(rsUsers.next()) {
				System.out.print("Id = " + rsUsers.getInt("id")+"\n" 
				+ "Titre = " + rsUsers.getString("titre")+"\n"
				+ "Année de sortie = " +  rsUsers.getInt("sortie") +"\n"
				+ "Numéro du film = " + rsUsers.getInt("numero") +"\n"
				+ "Cout du film = " + rsUsers.getInt("cout")+"\n"
				+ "Recette du film = " + rsUsers.getInt("recette")+"\n"
				+"----------------------------\n" );
				}

			conn.close();
			}
			catch(ClassNotFoundException e) {  
				System.err.println("Driver non chargé !");  e.printStackTrace();
			} catch(SQLException e) {
				System.err.println("Autre erreur !");  e.printStackTrace();
			}

		
		
	}
}
