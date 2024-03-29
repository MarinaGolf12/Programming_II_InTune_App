/**
 * @author Marina_Gkolfinopoulou
 */
package application;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

/**Declare Entrance class.*/
class Entrance {

	private static final long serialVersionUID = 7526472295622776147L;

 	 /**Creates the Entrance Page.*/
 	public static void main(String[] args) throws Exception {

            Entrancepage p = new Entrancepage();
 	        Connection conn = null;
			try {

				Class.forName("org.sqlite.JDBC");
				conn = DriverManager.
				getConnection("jdbc:sqlite:C:\\SQLITE//InTune.db");

				String sqlinsert = "CREATE TABLE User"
				+ "(name     TEXT (100)  NOT NULL ,"
				+ "username  TEXT (25)"
				+ " PRIMARY KEY NOT NULL UNIQUE ,"
				+ "password  TEXT (25) NOT NULL UNIQUE ,"
				+ "passcheck TEXT (25) NOT NULL ,"
				+ "gender    TEXT (6)  NOT NULL ,"
				+ "age       INTEGER (2) NOT NULL)";


				PreparedStatement pstmt1 =
				conn.prepareStatement(sqlinsert);
				pstmt1.executeUpdate();
                pstmt1.close();

                sqlinsert = " CREATE TABLE Post (postext  TEXT (5000) ,"
                + "username  REFERENCES User (username) "
                + "MATCH SIMPLE , postno    INTEGER     PRIMARY KEY)";

                PreparedStatement pstmt2 =
				conn.prepareStatement(sqlinsert);
				pstmt2.executeUpdate();
				pstmt2.close();

				sqlinsert = " CREATE TABLE Messages"
				+ "(textmessage TEXT NOT NULL ,"
				+ "textfrom TEXT REFERENCES "
				+ "User (username) NOT NULL ,"
				+ "texto TEXT  REFERENCES "
				+ "User (username) NOT NULL ,"
				+ "status INTEGER (1) NOT NULL ,"
				+ "textno INTEGER PRIMARY KEY NOT NULL)";


				PreparedStatement pstmt3 =
				conn.prepareStatement(sqlinsert);
				pstmt3.executeUpdate();
				pstmt3.close();

				sqlinsert = " CREATE TABLE Friends"
				+ "(fusername TEXT REFERENCES"
				+ " User (username) NOT NULL,"
				+ "friendusername TEXT REFERENCES "
				+ "User (username))";


				PreparedStatement pstmt4 =
				conn.prepareStatement(sqlinsert);
				pstmt4.executeUpdate();
				pstmt4.close();

				} catch (Exception ex) {

			    } finally {
			    	if (conn != null) {
			    		try {
			    			conn.close();
			            } catch (SQLException exc) {
			            }
			         }

			    }
 	}

}
